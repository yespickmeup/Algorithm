# POS.inventory CRUD contract — 2026-09-29

Reviewed Inventory, Dlg_inventory, Dlg_inventory_branch, Inventory_barcodes, uom and the cloud dialogs. No Java changes or production database writes were made.

## Identity

| Field | Meaning |
| --- | --- |
| inventory.id | Database row ID, not cross-server identity |
| inventory.barcode | Internal item code |
| inventory.barcodes | User-entered scan barcode |
| inventory_barcodes.main_barcode | Internal item code linking to the master |
| inventory_barcodes.barcode | Scan barcode copied from inventory.barcodes |
| inventory_barcodes.location_id | branch_locations.id as a string |
| inventory_barcodes.branch_code | branch_locations.branch_id |
| inventory_barcodes.product_qty | Stock at that location |

Multiple inventory_barcodes rows per master are expected. The duplicate groups reported by the earlier probe were in the master inventory table, not those expected location rows. Their cause remains unproven; do not assume all duplicates came from retries.

## Add

Dlg_inventory.add_inventory checks add privilege, generates the internal code, reads the scan barcode, starts quantity at zero and asks for confirmation. Inventory.add_inventory (line 134) inserts one master and a child for every row returned by Branch_locations.ret_all_locations. Children carry target branch/location identity. Insert SQL forces status=1, executes a batch, commits and closes the local connection. Immediate cloud insertion in the ordinary dialog is commented out.

Inventory.increment_id (line 3564) reads the last main-origin row, then increments its code. increment_id_special (line 3594) uses a location-prefixed sequence. Neither reserves the new code atomically. Concurrent creation can select the same code, and live inventory.barcode has no unique constraint. This is a possible duplicate path, not proof of the existing duplicates' cause.

Dlg_inventory_branch can add location-origin items with a populated location_id. Automatic absence-based deletion assumes the main catalog is authoritative; legitimate branch-origin items must reach that catalog first.

## Edit

Dlg_inventory.edit_inventory retains the internal code and asks whether child changes apply to All or one branch. The master is updated in either case. Child predicates use main_barcode alone or main_barcode plus branch_code (around line 2616).

Inventory.edit_inventory (line 1276) updates master catalog fields including status and marks is_uploaded=2. Its child UPDATE changes selected catalog fields including unit, conversion, price, cost and scan barcode, but not quantity, location ownership, serial numbers or child status. These writes share a transaction.

Inventory_barcodes.edit_inventory_barcodes_price (line 463) independently changes unit and selling_price for one child by ID. This does not change the master. General edit_inventory_barcodes (line 364) also writes quantity; it is not a safe template for copying quantities across branches.

## Prices inside units

POS.inventory.uom encodes units as `[pc:25.0/1.0^1],[box:250.0/10.0^0]`: unit name, price, conversion and default flag. Replacing unit can overwrite branch prices even if selling_price is preserved.

The Python worker now preserves existing unit, conversion and selling_price together when branch price synchronization is off. This also defers source unit-definition changes at existing branches. New rows receive source values; main-to-cloud copies all three.

## Delete

The dialog uses deletion privilege/confirmation, with inventory_item_delete controlling button availability. Inventory.delete_inventory (line 2488) hard-deletes the master by barcode, children by main_barcode, and assembly rows by main_item_code (deleted parent). It does not remove other assemblies merely because they reference the item as a component, or remove transaction history. It commits locally. No durable deletion marker is recorded. Immediate cloud deletion in the ordinary dialog is commented out.

## Sync flags

The application's convention is 0 pending insert, 2 pending update, 1 acknowledged upload. Java cloud add/edit acknowledges local flags after cloud writes. The Python worker compares catalogs and leaves source flags untouched to avoid acknowledging concurrent edits. Do not run legacy cloud sync concurrently or treat its pending counters as the Python worker's status.

## Python corrections made during this review

- Compare and replicate master active/inactive status.
- Restrict existing child updates to Java's catalog-edit field subset; do not incidentally change child status, fixed-price, supplier-ID or multi-level-price fields. Initialize those fields on insertion.
- Preserve embedded unit prices as described above.
- Delete only parent assembly rows, matching Java; removed the earlier broader component-reference deletion.
- Initialize new master ownership strings and carry source date/user metadata; new children carry source date/user metadata plus target location identity. New stock quantities remain zero.

## Remaining differences

The worker currently applies master changes to all destination locations. It does not reproduce the user's selected-branch edit scope or independently edited location prices. That requires a separate location-aware replication policy, not flattening inventory_barcodes into inventory.

Legacy S1_inventory_assembly uses a barcode field absent from the inspected live schema, while POS.inventory_assembly uses main_item_code/item_code. This suggests mixed schema generations; it does not establish why 20 assembly rows per server have invalid keys. These rows remain excluded pending deliberate mapping/repair.

Tier-pricing tables and category/brand/UOM maintenance tables have separate CRUD methods and are outside the current three-table worker.

18 unit tests pass after corrections. No production write run was performed. Previous dry-run counts predate the added status comparison and must be refreshed before applying.
