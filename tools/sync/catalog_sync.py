"""Bounded-memory SMIS catalog replication. Dry-run unless --apply is supplied."""
from __future__ import annotations

import argparse
from contextlib import contextmanager, closing, suppress
import hashlib
import json
import logging
from logging.handlers import RotatingFileHandler
import os
from pathlib import Path
import re
import signal
import sqlite3
import tempfile
import threading
import time
import sys

import pymysql
from sync_report import write_report

ROOT = Path(__file__).resolve().parents[2]
LOG = logging.getLogger("catalog_sync")
STOP = threading.Event()
CATALOG = "description generic_name category category_id classification classification_id sub_classification sub_classification_id unit conversion selling_price item_type supplier fixed_price cost supplier_id multi_level_pricing vatable reorder_level markup barcodes brand brand_id model model_id selling_type allow_negative_inventory auto_order show_to_sales".split()
ASSEMBLY = "main_barcode description generic_name category category_id classification classification_id sub_classification sub_classification_id product_qty unit conversion selling_price item_type supplier fixed_price cost supplier_id multi_level_pricing vatable reorder_level markup barcodes brand brand_id model model_id selling_type".split()
KEYS = {"inventory": ["barcode"], "inventory_assembly": ["main_item_code", "item_code"]}
# Master active/inactive state is edited by Inventory.edit_inventory.
CATALOG.append("status")
# Unit strings embed prices, e.g. [pc:25.0/1.0^1]. Keep the unit definition
# and conversion together when preserving existing branch prices.
PRICE_FIELDS = {"selling_price", "unit", "conversion"}
BARCODE_UPDATE = "description generic_name category category_id classification classification_id sub_classification sub_classification_id unit conversion selling_price cost supplier vatable reorder_level markup brand brand_id model model_id selling_type item_type allow_negative_inventory auto_order show_to_sales".split()


def sync_columns(columns, prices):
    return [c for c in columns if prices or c not in PRICE_FIELDS]


class SyncError(Exception):
    """Messages must contain no credentials or business record contents."""


def properties(path):
    """Java-properties escapes, continuations and separators (ISO-8859-1)."""
    def unescape(s):
        return re.sub(r"\\u([0-9a-fA-F]{4})|\\(.)", lambda m: chr(int(m[1], 16)) if m[1] else {"t": "\t", "r": "\r", "n": "\n", "f": "\f"}.get(m[2], m[2]), s)
    result, pending = {}, ""
    for line in Path(path).read_text(encoding="iso-8859-1").splitlines():
        line = pending + line.lstrip()
        if (len(line) - len(line.rstrip("\\"))) % 2:
            pending = line[:-1]
            continue
        pending = ""
        if not line or line.startswith(("#", "!")):
            continue
        match = re.match(r"((?:\\.|[^\s=:])+)(?:\s*[=:]\s*|\s+)?(.*)$", line)
        if match:
            result[unescape(match[1])] = unescape(match[2])
    if pending:
        raise SyncError("Unfinished properties continuation")
    return result


def load_config(path, overlay):
    config = {}
    # Use the application's actual startup defaults without copying secrets.
    main = ROOT / "src/POS/main/MyMain.java"
    if main.exists():
        config.update(re.findall(r'prop\.getProperty\("(pool_[^"]+)",\s*"([^"]*)"\)', main.read_text(encoding="utf-8")))
    config.update(properties(path))
    if overlay:
        config.update(properties(overlay))
    for name in ("pool_host", "pool_db", "pool_user", "pool_password"):
        if name not in config:
            raise SyncError("Missing connection property: " + name)
    return config


def boolean(config, key, default=False):
    value = str(config.get(key, str(default))).lower()
    if value not in ("true", "false"):
        raise SyncError("Expected true/false for " + key)
    return value == "true"


def number(config, key, default, minimum=1, maximum=3600):
    try:
        value = int(config.get(key, default))
    except (TypeError, ValueError):
        raise SyncError("Invalid integer for " + key) from None
    if not minimum <= value <= maximum:
        raise SyncError("Out-of-range setting: " + key)
    return value


def qi(name):
    if not re.fullmatch(r"[a-zA-Z_][a-zA-Z_0-9]*", name):
        raise SyncError("Invalid SQL identifier")
    return "`" + name + "`"


@contextmanager
def connection(config, prefix):
    opts = dict(host=config[prefix+"host"], port=int(config.get(prefix+"port") or 3306), user=config[prefix+"user"], password=config[prefix+"password"], database=config[prefix+"db"], charset="utf8", autocommit=True, cursorclass=pymysql.cursors.DictCursor,
                connect_timeout=number(config, "sync_connect_timeout", 10), read_timeout=number(config, "sync_read_timeout", 30), write_timeout=number(config, "sync_write_timeout", 30))
    if prefix == "cloud_" and config.get("sync_ssl_ca"):
        opts.update(ssl_ca=config["sync_ssl_ca"], ssl_verify_cert=True, ssl_verify_identity=True)
    conn = pymysql.connect(**opts)
    try:
        yield conn
    finally:
        with suppress(Exception):
            conn.rollback()
        conn.close()


def query(conn, sql, args=()):
    with conn.cursor() as cur:
        cur.execute(sql, args)
        return cur.fetchall()


def execute(conn, sql, args=()):
    with conn.cursor() as cur:
        return cur.execute(sql, args)


def fields(conn, table):
    rows = query(conn, "SELECT COLUMN_NAME FROM information_schema.COLUMNS WHERE TABLE_SCHEMA=DATABASE() AND TABLE_NAME=%s", (table,))
    return {r["COLUMN_NAME"] for r in rows}


def payload(row, columns):
    return {name: row[name] for name in columns}


def encode(row):
    return json.dumps(row, sort_keys=True, ensure_ascii=False, separators=(",", ":"), allow_nan=False)


def where_key(table, row):
    return " AND ".join(qi(k)+"=%s" for k in KEYS[table]), tuple(row[k] for k in KEYS[table])


def snapshot(conn, disk, side, table, columns, page_size, duplicate_policy="skip"):
    keys = KEYS[table]
    names = ["id"] + keys + columns
    # SQL uses the server's own collation for duplicate detection.
    key_sql = ",".join(map(qi, keys))
    bad = " OR ".join(qi(k)+" IS NULL OR TRIM("+qi(k)+")=''" for k in keys)
    if query(conn, f"SELECT id FROM {qi(table)} WHERE {bad} LIMIT 1"):
        total=query(conn,f"SELECT COUNT(*) AS n FROM {qi(table)}")[0]['n']
        disk.execute('INSERT OR REPLACE INTO totals VALUES (?,?,?)',(side,table,total))
        LOG.error("side=%s table=%s has null/empty keys; entire table excluded from writes",side,table)
        disk.execute("INSERT OR IGNORE INTO disabled VALUES (?)",(table,))
        if table == "inventory":
            disk.execute("INSERT OR IGNORE INTO disabled VALUES ('inventory_assembly')")
        return
    duplicate_query = f"SELECT {','.join('t.'+qi(k) for k in keys)} FROM {qi(table)} t JOIN (SELECT {key_sql} FROM {qi(table)} GROUP BY {key_sql} HAVING COUNT(*)>1) d ON "+" AND ".join('t.'+qi(k)+'=d.'+qi(k) for k in keys)
    duplicates = 0
    with conn.cursor(pymysql.cursors.SSDictCursor) as cur:
        cur.execute(duplicate_query)
        while True:
            rows = cur.fetchmany(page_size)
            if not rows:
                break
            for row in rows:
                disk.execute("INSERT OR IGNORE INTO blocked VALUES (?,?)",(table,encode([row[k] for k in keys])))
                duplicates += 1
    if duplicates:
        LOG.warning("ambiguous side=%s table=%s rows=%s policy=%s",side,table,duplicates,duplicate_policy)
        if duplicate_policy == "stop":
            raise SyncError(f"{side} {table}: duplicate identity; repair before sync")
    last, count = -1, 0
    while not STOP.is_set():
        rows = query(conn, f"SELECT {','.join(map(qi,names))} FROM {qi(table)} WHERE id>%s ORDER BY id LIMIT %s", (last, page_size))
        if not rows:
            break
        for row in rows:
            key = encode([row[k] for k in keys])
            data = encode(payload(row, keys+columns))
            # Duplicate keys are excluded by plan() regardless of which row is stored here.
            disk.execute("INSERT OR IGNORE INTO snapshot VALUES (?,?,?,?,?)", (side, table, key, row["id"], data))
        last = rows[-1]["id"]
        count += len(rows)
        disk.commit()
    if STOP.is_set():
        raise SyncError("Stopped during snapshot; no incomplete plan applied")
    LOG.info("snapshot side=%s table=%s rows=%s", side, table, count)
    disk.execute('INSERT OR REPLACE INTO totals VALUES (?,?,?)',(side,table,count))
    disk.commit()


def plan(disk, table):
    if disk.execute("SELECT 1 FROM disabled WHERE tbl=?",(table,)).fetchone():
        return
    candidates = disk.execute("""SELECT 'upsert',s.data,d.data FROM snapshot s LEFT JOIN snapshot d
        ON d.side='destination' AND d.tbl=s.tbl AND d.k=s.k
        WHERE s.side='source' AND s.tbl=? AND (d.k IS NULL OR s.data<>d.data)
        AND NOT EXISTS (SELECT 1 FROM blocked b WHERE b.tbl=s.tbl AND b.k=s.k)
        UNION ALL SELECT 'delete',NULL,d.data FROM snapshot d LEFT JOIN snapshot s
        ON s.side='source' AND s.tbl=d.tbl AND s.k=d.k
        WHERE d.side='destination' AND d.tbl=? AND s.k IS NULL
        AND NOT EXISTS (SELECT 1 FROM blocked b WHERE b.tbl=d.tbl AND b.k=d.k)""", (table, table))
    for op, desired, before in candidates:
        if table == "inventory_assembly":
            row=json.loads(desired or before)
            if any(disk.execute("SELECT 1 FROM blocked WHERE tbl='inventory' AND k=?",(encode([row[k]]),)).fetchone() for k in KEYS[table]):
                continue
        yield op, desired, before


def deletion_guard(source_count, destination_count, count, config, table):
    if count and (not source_count or count > number(config,"sync_max_deletes",10) or count*100/max(destination_count,1) > number(config,"sync_delete_percent",5,1,100)):
        raise SyncError("Deletion guard stopped cycle: "+table)


def insert(conn, table, row):
    execute(conn, f"INSERT INTO {qi(table)} ({','.join(map(qi,row))}) VALUES ({','.join(['%s']*len(row))})", tuple(row.values()))


def update(conn, table, row, predicate, args):
    execute(conn, f"UPDATE {qi(table)} SET "+",".join(qi(k)+"=%s" for k in row)+" WHERE "+predicate, tuple(row.values())+args)


def barcode_rows(conn, item, columns, main, sync_prices):
    """Update catalog fields only; quantities and location ownership stay local."""
    shared = {k: item[k] for k in BARCODE_UPDATE if k in columns}
    shared["barcode"] = item["barcodes"]
    if not main and not sync_prices:
        for name in PRICE_FIELDS:
            shared.pop(name, None)
    update(conn, "inventory_barcodes", shared, "main_barcode=%s", (item["barcode"],))
    # New entries get zero stock, never the source branch's quantity.
    locations = query(conn, "SELECT id,branch,branch_id,location FROM branch_locations")
    if not locations:
        raise SyncError("Destination has no branch locations")
    for loc in locations:
        if query(conn, "SELECT id FROM inventory_barcodes WHERE main_barcode=%s AND location_id=%s LIMIT 1", (item["barcode"], str(loc["id"]))):
            continue
        row = dict(shared, main_barcode=item["barcode"], product_qty=0, status=1, is_uploaded=1,
                   selling_price=item.get("selling_price", 0), unit=item.get("unit"), conversion=item.get("conversion"), branch=loc["branch"], branch_code=loc["branch_id"], location=loc["location"], location_id=str(loc["id"]), serial_no="")
        for name in ("fixed_price", "supplier_id", "multi_level_pricing"):
            row[name]=item[name]
        row.update(date_added=item.get("date_added"),user_name=item.get("user_name") or "")
        insert(conn, "inventory_barcodes", row)


def apply_change(source, dest, table, operation, desired, before, columns, main, prices):
    keyrow = desired or before
    predicate, args = where_key(table, keyrow)
    # Recheck source immediately before the write; polling is eventually consistent.
    current_source = query(source, f"SELECT * FROM {qi(table)} WHERE {predicate} LIMIT 2", args)
    if len(current_source)>1:
        raise SyncError("Source identity became ambiguous")
    if operation == "delete":
        if current_source:
            return False
    elif not current_source or payload(current_source[0], KEYS[table]+columns) != desired:
        return False
    dest.begin()
    try:
        current = query(dest, f"SELECT * FROM {qi(table)} WHERE {predicate} LIMIT 2 FOR UPDATE", args)
        if len(current)>1:
            raise SyncError("Destination identity became ambiguous")
        now = payload(current[0], KEYS[table]+columns) if current else None
        if now != before:
            # Includes a commit that succeeded before the client lost its response.
            dest.rollback()
            return False
        if operation == "delete":
            if table == "inventory":
                execute(dest, "DELETE FROM inventory_barcodes WHERE main_barcode=%s", args)
                execute(dest, "DELETE FROM inventory_assembly WHERE main_item_code=%s", args)
            execute(dest, f"DELETE FROM {qi(table)} WHERE {predicate}", args)
        else:
            values = {k: desired[k] for k in columns}
            if current:
                update(dest, table, values, predicate, args)
            else:
                values.update({k: desired[k] for k in KEYS[table]})
                if table == "inventory":
                    values.update(product_qty=0, status=current_source[0].get("status",1), is_uploaded=1)
                    values.update(date_added=current_source[0].get("date_added"),user_name=current_source[0].get("user_name") or "",branch="",branch_code="",location="",location_id="")
                for name in PRICE_FIELDS:
                    if name in current_source[0]:
                        values[name]=current_source[0][name]
                insert(dest, table, values)
            if table == "inventory":
                # Source price is needed for new location records even when existing prices are preserved.
                barcode_rows(dest, current_source[0], CATALOG, main, prices)
        dest.commit()
        return True
    except BaseException:
        with suppress(Exception):
            dest.rollback()
        raise


def cycle(config, apply, state_dir):
    with connection(config, "pool_") as local:
        settings = query(local, "SELECT is_main_branch,cloud_host,cloud_port,cloud_user,cloud_password,cloud_db FROM settings LIMIT 2")
        if len(settings) != 1:
            raise SyncError("Expected exactly one local settings row")
        runtime = dict(config)
        runtime.update({k: v for k, v in settings[0].items() if k.startswith("cloud_")})
        main = boolean(config, "main_branch", settings[0]["is_main_branch"] == 1)
        prices = main or boolean(config, "sync_prices")
        deletes = boolean(config, "sync_deletes", True)
        if not all(runtime.get("cloud_"+k) for k in ("host", "user", "db")):
            raise SyncError("Cloud settings incomplete")
        with connection(runtime, "cloud_") as cloud:
            source, dest = (local, cloud) if main else (cloud, local)
            LOG.info("direction=%s mode=%s prices=%s deletes=%s", "main-to-cloud" if main else "cloud-to-branch", "apply" if apply else "dry-run", prices, deletes)
            # One writer per destination among instances of this script, even on different machines.
            lock = "smis_catalog_" + hashlib.sha256(str(dest.db).encode()).hexdigest()[:32]
            if apply and query(dest, "SELECT GET_LOCK(%s,0) AS acquired", (lock,))[0]["acquired"] != 1:
                raise SyncError("Another sync worker owns the destination lock")
            try:
                with tempfile.TemporaryDirectory(prefix="snapshot-", dir=state_dir) as tmp:
                    with closing(sqlite3.connect(str(Path(tmp)/"catalog.sqlite"))) as disk:
                        disk.execute("PRAGMA cache_size=-2048")
                        disk.execute("PRAGMA temp_store=FILE")
                        disk.execute("CREATE TABLE snapshot(side TEXT,tbl TEXT,k TEXT,id INTEGER,data TEXT,PRIMARY KEY(side,tbl,k))")
                        disk.execute("CREATE TABLE blocked(tbl TEXT,k TEXT,PRIMARY KEY(tbl,k))")
                        disk.execute("CREATE TABLE disabled(tbl TEXT PRIMARY KEY)")
                        disk.execute("CREATE TABLE totals(side TEXT,tbl TEXT,n INTEGER,PRIMARY KEY(side,tbl))")
                        duplicate_policy=config.get("sync_duplicates","skip")
                        if duplicate_policy not in ("skip","stop"):
                            raise SyncError("sync_duplicates must be skip or stop")
                        policies = {"inventory": sync_columns(CATALOG,prices), "inventory_assembly": sync_columns(ASSEMBLY,prices)}
                        for conn in (source, dest):
                            for table, cols in policies.items():
                                if not set(["id"]+KEYS[table]+cols) <= fields(conn, table):
                                    raise SyncError("Required columns missing: "+table)
                                engine = query(conn, "SELECT ENGINE FROM information_schema.TABLES WHERE TABLE_SCHEMA=DATABASE() AND TABLE_NAME=%s", (table,))
                                if not engine or engine[0]["ENGINE"] != "InnoDB":
                                    raise SyncError("Transactional InnoDB table required: "+table)
                        if not set(CATALOG)-{"barcodes"} <= fields(dest, "inventory_barcodes"):
                            raise SyncError("Required barcode columns missing")
                        if query(dest,"SELECT ENGINE FROM information_schema.TABLES WHERE TABLE_SCHEMA=DATABASE() AND TABLE_NAME='inventory_barcodes'")[0]["ENGINE"] != "InnoDB":
                            raise SyncError("Transactional InnoDB required: inventory_barcodes")
                        for side, conn in (("source", source), ("destination", dest)):
                            execute(conn, "SET SESSION TRANSACTION ISOLATION LEVEL REPEATABLE READ")
                            execute(conn, "START TRANSACTION WITH CONSISTENT SNAPSHOT")
                            try:
                                for table, cols in policies.items():
                                    snapshot(conn, disk, side, table, cols, number(config,"sync_page_size",200,1,1000),duplicate_policy)
                            finally:
                                conn.rollback()
                        summary=write_report(disk,state_dir,main,policies['inventory'])
                        LOG.info('inventory report new=%s updated=%s destination_only=%s already_synced=%s ambiguous=%s',summary['source_only'],summary['different'],summary['destination_only'],summary['synced'],summary['ambiguous'])
                        # Preflight every deletion budget before writing any table.
                        guard_errors=[]
                        report_path=state_dir/"last-plan.jsonl"
                        with report_path.open("w",encoding="utf-8") as report:
                            report.write(encode({"kind":"metadata","created_unix":int(time.time()),"direction":"main-to-cloud" if main else "cloud-to-branch","status":"proposed, not applied"})+"\n")
                            for table in policies:
                                for op,desired,before in plan(disk,table):
                                    row=json.loads(desired or before)
                                    old=json.loads(before) if before else {}
                                    changes=[k for k in row if op != "delete" and row[k] != old.get(k)]
                                    report.write(encode({"table":table,"operation":op,"key":payload(row,KEYS[table]),"changed_fields":changes})+"\n")
                        LOG.info("proposed plan saved to last-plan.jsonl (private state directory)")
                        for table in policies:
                            counts = {"upsert":0,"delete":0}
                            for op, _, _ in plan(disk, table):
                                counts[op] += 1
                            LOG.info("plan table=%s upserts=%s deletion_candidates=%s",table,counts["upsert"],counts["delete"])
                            if deletes and counts["delete"]:
                                total = disk.execute("SELECT COUNT(*) FROM snapshot WHERE side='destination' AND tbl=?",(table,)).fetchone()[0]
                                source_count = disk.execute("SELECT COUNT(*) FROM snapshot WHERE side='source' AND tbl=?",(table,)).fetchone()[0]
                                try:
                                    deletion_guard(source_count,total,counts["delete"],config,table)
                                except SyncError as exc:
                                    guard_errors.append(str(exc))
                                    LOG.warning("%s",exc)
                        changed = 0
                        if apply:
                            if guard_errors:
                                raise SyncError("Apply blocked by deletion budget; review dry-run before changing limits")
                            execute(dest, "SET SESSION innodb_lock_wait_timeout=10")
                            execute(dest, "SET SESSION sql_mode='STRICT_ALL_TABLES,NO_ENGINE_SUBSTITUTION'")
                            for table, cols in policies.items():
                                for op, desired, before in plan(disk, table):
                                    if STOP.is_set() or changed >= number(config,"sync_max_changes",100,1,10000):
                                        break
                                    if op == "delete" and not deletes:
                                        continue
                                    changed += apply_change(source,dest,table,op,json.loads(desired) if desired else None,json.loads(before) if before else None,cols,main,prices)
                        LOG.info("cycle complete committed_items=%s",changed)
            finally:
                if apply:
                    with suppress(Exception):
                        query(dest,"SELECT RELEASE_LOCK(%s)",(lock,))


def main():
    parser=argparse.ArgumentParser(description=__doc__)
    parser.add_argument("--config", type=Path, default=Path.home()/"my_config.conf")
    parser.add_argument("--options", type=Path, default=ROOT/'sync.local.conf' if (ROOT/'sync.local.conf').exists() else None)
    parser.add_argument("--state-dir",type=Path,default=ROOT/".sync-state")
    parser.add_argument("--apply",action="store_true",help="Write differences; default only reports counts")
    parser.add_argument("--watch",action="store_true",help="Poll repeatedly; otherwise run one cycle")
    parser.add_argument("--once",action="store_true",help="Run a single check without the interactive menu")
    parser.add_argument("--menu",action="store_true",help="Open the menu (the default without --once, --watch or --apply)")
    args=parser.parse_args()
    if args.menu and (args.apply or args.watch or args.once):
        parser.error('--menu cannot be combined with --apply, --watch or --once')
    if args.once and args.watch:
        parser.error('--once cannot be combined with --watch')
    args.state_dir.mkdir(parents=True,exist_ok=True)
    LOG.setLevel(logging.INFO)
    fmt=logging.Formatter("%(asctime)s %(levelname)s %(message)s")
    for handler in (logging.StreamHandler(),RotatingFileHandler(args.state_dir/"sync.log",maxBytes=1_000_000,backupCount=3)):
        handler.setFormatter(fmt)
        LOG.addHandler(handler)
    if args.menu or not (args.once or args.watch or args.apply):
        from sync_menu import run_menu
        return run_menu(sys.modules[__name__],args)
    for sig in (signal.SIGINT, signal.SIGTERM):
        signal.signal(sig,lambda *_: STOP.set())
    failures=0
    while not STOP.is_set():
        started=time.monotonic()
        config={}
        try:
            config=load_config(args.config,args.options)
            interval=number(config,"sync_interval",300,10,86400)
            cycle(config,args.apply,args.state_dir)
            failures=0
        except Exception as exc:
            failures+=1
            # Driver errors may contain SQL values or credentials: never log raw messages.
            if isinstance(exc,SyncError):
                LOG.error("%s",exc)
            else:
                code=exc.args[0] if exc.args and isinstance(exc.args[0],int) else "n/a"
                LOG.error("cycle failed type=%s code=%s; connections closed, next cycle retries",type(exc).__name__,code)
            interval=min(300,10*2**min(failures-1,5))
        LOG.info("cycle elapsed_seconds=%.2f",time.monotonic()-started)
        if not args.watch:
            return 1 if failures else 0
        STOP.wait(interval)
    return 0


if __name__ == "__main__":
    raise SystemExit(main())
