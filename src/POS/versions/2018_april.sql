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