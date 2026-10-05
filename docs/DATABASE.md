# Database structure — inspected 2026-09-29

Live metadata was queried successfully from local `db_algorithm_kabankalan` and configured cloud `db_algorithm`. See `database-inspection-status.txt` for server versions and counts. All 290 tables across the two schemas report InnoDB. Neither schema declares foreign keys; relationships inferred from names/code must be checked against application logic.

## Metadata files

Each `local-` / `cloud-` prefix has:

- `tables.tsv`: table names/types, engines, estimated row counts, collations. InnoDB TABLE_ROWS is an estimate, not a counted total.
- `columns.tsv`: ordered columns, SQL types, nullability, key marker, and extra flags.
- `indexes.tsv`: index names, uniqueness, column order, and prefix lengths. Counts are index-column records, not distinct indexes.
- `foreign-keys.tsv`: declared foreign-key columns (headers only for these databases).

`schema-differences.tsv` compares column presence, type, and nullability in shared tables. It does not compare defaults, column order, indexes, routines, triggers, events, views, grants, or all server options. These snapshots are not full DDL or backups and cannot reconstruct either database alone. No customer, sales, user, or other business rows were exported.

## Application domains

| Domain | Representative local tables |
| --- | --- |
| Setup and access | settings, users, user_logs, user_previleges, user_default_previleges, branches, branch_locations, terminals |
| Inventory/catalog | inventory, inventory_barcodes, inventory_assembly, inventory_uom, inventory_multi_level_pricing, inventory_price_updates |
| Sales | sales, sale_items, sales_orders, sales_order_items, sales_on_account, voids, void_items |
| Procurement/receiving | suppliers, purchase_orders, purchase_order_items, receipts, receipt_items, receipt_barcodes |
| Stock movements | stock_transfers, stock_transfers_items, inventory_replenishments, inventory_replenishment_items, adjustments, other_adjustments |
| Returns/service | return_from_customers, return_from_customer_items, return_to_suppliers, rmas, rma_items, my_services |
| Finance | accounts_payable, accounts_payable_payments, accounts_receivable, accounts_receivable_payments, cash_drawer, charge_payments, prepaid_payments |
| Synchronization | local_branch_query_uploads, main_branch_query_uploads, synch_locations, synch_upload_locations |

There are similarly named legacy tables: `sales_item` / `sale_items`, `stock_transfer` / `stock_transfers`, and `stock_transfer_items` / `stock_transfers_items`. Follow the actual SQL in the feature being changed rather than guessing the canonical table.

## Differences

134 tables are shared. Within them: 73 columns only local, 41 only cloud, 30 differing in SQL type and/or nullability. See `schema-differences.tsv` for every compared difference. Differences do not by themselves prove a defect: the local and cloud schemas serve different roles.

16 tables only local:

`receipt_endorsements`, `receipt_endorsement_items`, `rmas`, `rma_items`, `sale_item_consumptions`, `sale_item_consumption_details`, `sale_slip_nos`, `stock_takes`, `stock_take_items`, `supplier_departments`, `user_default_previlege_others`, `user_previlege_others`, `user_price_change_requests`, `user_price_change_request_logs`, `warranties`, `warranty_items`.

6 tables only cloud:

`bank_accounts`, `bank_account_deposits`, `households`, `maintenances`, `sale_tips`, `synch_stock_transfers`.

The inspection reached the endpoint configured by the local settings row, identified by the user as DigitalOcean. Hosting-account identity, backup health, firewall rules, and other cloud databases remain unverified.
