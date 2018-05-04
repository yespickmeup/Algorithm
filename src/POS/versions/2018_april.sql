/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  Guinness
 * Created: Apr 2, 2018
 */


alter table prepaid_payments add remarks varchar(500);

insert into user_default_previlege_others(account,account_name,name)values('Transactions','Prepaid Payments','Adjustment');


--update stock_transfers set is_uploaded=1;
--update stock_transfers_items set is_uploaded=1;


alter table inventory add is_uploaded int default 0;
alter table inventory_barcodes add is_uploaded int default 1;

alter table inventory add updated_at datetime after location_id;
update inventory set updated_at=date_added;


alter table inventory_barcodes add updated_at datetime after serial_no;
update inventory_barcodes set updated_at=date_added;

-- 0-new item, 1-downloaded, 2-new updates, 3-deleted

alter table inventory_price_updates add is_uploaded int default 0 after location_id;
alter table inventory_price_updates add ipu_no varchar(255);
alter table inventory_price_updates add at_branch varchar(255);
alter table inventory_price_updates add at_branch_id varchar(255);
alter table inventory_price_updates add at_location varchar(255);
alter table inventory_price_updates add at_location_id varchar(255);



alter table sales add is_uploaded int default 0;
alter table sale_items add is_uploaded int default 0;

alter table prepaid_payments add is_uploaded int default 0;

alter table accounts_payable add is_uploaded int default 0;
alter table accounts_payable_payments add is_uploaded int default 0;

alter table accounts_receivable add is_uploaded int default 0;
alter table accounts_receivable_payments add is_uploaded int default 0;

alter table borrower_slips add is_uploaded int default 0;
alter table borrower_slip_items add is_uploaded int default 0;

alter table cash_drawer add is_uploaded int default 0;
alter table cash_drawer_remittances add is_uploaded int default 0;

alter table charge_in_advance add is_uploaded int default 0;
alter table charge_in_advance_items add is_uploaded int default 0;
alter table charge_in_advance_cancelled_items add is_uploaded int default 0;

alter table conversions add is_uploaded int default 0;
alter table conversion_items add is_uploaded int default 0;

alter table disbursements add is_uploaded int default 0;

alter table adjustments add is_uploaded int default 0;

alter table encoding_inventory add is_uploaded int default 0;

alter table inventory_replenishments add is_uploaded int default 0;
alter table inventory_replenishment_items add is_uploaded int default 0;

alter table other_adjustments add is_uploaded int default 0;

alter table purchase_orders add is_uploaded int default 0;
alter table purchase_order_items add is_uploaded int default 0;

alter table receipts add is_uploaded int default 0;
alter table receipt_items add is_uploaded int default 0;

alter table requisition_slips add is_uploaded int default 0;
alter table requisition_slip_items add is_uploaded int default 0;

alter table return_to_suppliers add is_uploaded int default 0;
alter table return_to_supplier_items add is_uploaded int default 0;
alter table return_from_customers add is_uploaded int default 0;
alter table return_from_customer_items add is_uploaded int default 0;


alter table my_services add is_uploaded int default 0;
alter table my_services_barcodes_customers add is_uploaded int default 0;
alter table my_services_description_customers add is_uploaded int default 0;
alter table my_services_item_replacements_customers add is_uploaded int default 0;
alter table my_services_others_customers add is_uploaded int default 0;
alter table my_services_problems_customers add is_uploaded int default 0;



