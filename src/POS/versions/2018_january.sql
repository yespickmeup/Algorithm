/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  Guinness
 * Created: Jan 9, 2018
 */



alter table inventory add cloud_added int default 0;
alter table inventory add cloud_added_at datetime default null;
alter table inventory add cloud_updated int default 0;
alter table inventory add cloud_updated_at datetime default null;


alter table inventory_barcodes add cloud_added int default 0;
alter table inventory_barcodes add cloud_added_at datetime default null;
alter table inventory_barcodes add cloud_updated int default 0;
alter table inventory_barcodes add cloud_updated_at datetime default null;

update inventory set cloud_added = 1;
update inventory set cloud_added_at = date_added;
update inventory set cloud_updated = 1;
update inventory set cloud_updated_at = updated_at;

update inventory_barcodes set cloud_added = 1;
update inventory_barcodes set cloud_added_at = date_added;
update inventory_barcodes set cloud_updated = 1;
update inventory_barcodes set cloud_updated_at = updated_at;




