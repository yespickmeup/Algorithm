/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  Guinness
 * Created: Dec 18, 2017



 */


// For droplet

alter table inventory add updated_at datetime;
update inventory set updated_at=date_added;


alter table inventory_barcodes add updated_at datetime;
update inventory_barcodes set updated_at=date_added;



alter table inventory add is_added int default 0;
alter table inventory add is_added_at datetime default current_timestamp;

alter table inventory_barcodes add is_added int default 0;
alter table inventory_barcodes add is_added_at datetime default current_timestamp;


alter table stock_transfers add synch int default 0;
update stock_transfers set synch = 1;

alter table stock_transfers_items add synch int default 0;
update stock_transfers_items set synch = 1;







