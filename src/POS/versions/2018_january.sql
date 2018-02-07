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


drop table if exists item_replacements;
create table item_replacements(
id int auto_increment primary key
,item_replacement_no varchar(255)
,sales_no varchar(255)
,customer_name varchar(255)
,customer_id varchar(255)
,date_added datetime
,user_screen_name varchar(255)
,user_id varchar(255)
,reason varchar(255)
,amount_due double
,replacement_amount double
,discount double
,status int
,branch varchar(255)
,branch_id varchar(255)
,location varchar(255)
,location_id varchar(255)
);

drop table if exists item_replacement_details;
create table item_replacement_details(
id int auto_increment primary key
,item_replacement_no varchar(255)
,sales_no varchar(255)
,customer_name varchar(255)
,customer_id varchar(255)
,date_added datetime
,user_screen_name varchar(255)
,user_id varchar(255)
,item_code varchar(255)
,barcode varchar(255)
,generic_name varchar(255)
,description text
,item_type varchar(255)
,serial_no varchar(255)
,product_qty double
,unit varchar(255)
,conversion double
,selling_price double
,is_vatable int
,selling_type int
,discount_name varchar(255)
,discount_amount double
,discount_customer_name varchar(255)
,discount_customer_id varchar(255)
,category varchar(255)
,category_id varchar(255)
,classification varchar(255)
,classification_id varchar(255)
,sub_classification varchar(255)
,sub_classification_id varchar(255)
,brand varchar(255)
,brand_id varchar(255)
,model varchar(255)
,model_id varchar(255)
,is_replacement int
,reason varchar(255)
,status int
,branch varchar(255)
,branch_id varchar(255)
,location varchar(255)
,location_id varchar(255)
);

/*124.6.168.169*/
GRANT ALL ON *.* to smis@'124.6.168.169' IDENTIFIED BY 'synapse246';
GRANT ALL ON *.* to root@'124.6.168.169' IDENTIFIED BY 'synapse246';
flush privileges;


