/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  Ronescape
 * Created: Aug 30, 2019
 */

alter table inventory add show_to_sales int default 1;
alter table inventory_barcodes add show_to_sales int default 1;

drop table if exists sale_item_consumptions;
create table sale_item_consumptions(
id int auto_increment primary key
,sales_item_id varchar(255)
,sales_no varchar(255)
,ar_no varchar(255)
,ar_reference_no varchar(255)
,ar_customer_id varchar(255)
,ar_customer_name varchar(255)
,created_at datetime
,updated_at datetime
,created_by varchar(255)
,updated_by varchar(255)
,item_code varchar(255)
,barcode varchar(255)
,description varchar(255)
,product_qty double
,unit varchar(255)
,conversion double
,selling_price double
,branch varchar(255)
,branch_id varchar(255)
,location varchar(255)
,location_id varchar(255)
,consumed double
,status int
);


drop table if exists sale_item_consumption_details;
create table sale_item_consumption_details(
id int auto_increment primary key
,consumption_id varchar(255)
,sales_item_id varchar(255)
,sales_no varchar(255)
,ar_no varchar(255)
,ar_reference_no varchar(255)
,ar_customer_id varchar(255)
,ar_customer_name varchar(255)
,created_at datetime
,updated_at datetime
,created_by varchar(255)
,updated_by varchar(255)
,item_code varchar(255)
,barcode varchar(255)
,description varchar(255)
,product_qty double
,unit varchar(255)
,conversion double
,selling_price double
,branch varchar(255)
,branch_id varchar(255)
,location varchar(255)
,location_id varchar(255)
,consumed double
,status int
);


insert into user_default_previlege_others(account,account_name,name)values('Reports','Cashier Report','Logout - Show Report');