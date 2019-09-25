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



drop table if exists inventory_category_user_privileges;
create table inventory_category_user_privileges(
id int auto_increment primary key
,created_by varchar(255)
,created_at varchar(255)
,category varchar(255)
,category_id varchar(255)
,category_all int
,classification varchar(255)
,classification_id varchar(255)
,classification_all int
,sub_classification varchar(255)
,sub_classification_id varchar(255)
,sub_classification_all int
,brand varchar(255)
,brand_id varchar(255)
,brand_all int
,model varchar(255)
,model_id varchar(255)
,model_all int
,user_id varchar(255)
,user_name varchar(255)
);


insert into user_default_previleges(account,name)values('Maintenance','Item Maintenance per Location');
update inventory set location_id ='';


drop table if exists inventory_location_privileges;
create table inventory_location_privileges(
id int auto_increment primary key
,user_id varchar(255)
,user_name varchar(255)
,created_at datetime
,created_by varchar(255)
,updated_at datetime
,updated_by varchar(255)
,branch varchar(255)
,branch_id varchar(255)
,location varchar(255)
,location_id varchar(255)
,status int
);
