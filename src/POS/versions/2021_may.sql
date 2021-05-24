/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  User
 * Created: 05 18, 21
 */


drop table if exists receipt_service_centers;
create table receipt_service_centers(
id int auto_increment primary key
,receipt_no varchar(255)
,user_name varchar(255)
,session_no varchar(255)
,date_added datetime
,supplier varchar(255)
,supplier_id varchar(255)
,remarks varchar(255)
,date_delivered date
,date_received date
,receipt_type varchar(255)
,reference_no varchar(255)
,branch varchar(255)
,branch_id varchar(255)
,gross_total double
,net_total double
,batch_no varchar(255)
,discount double
,status int
,receipt_type_id varchar(255)
);


drop table if exists receipts_service_center_items;
create table receipts_service_center_items(
id int auto_increment primary key
,receipt_no varchar(255)
,user_name  varchar(255)
,session_no varchar(255)
,date_added datetime
,supplier varchar(255)
,supplier_id varchar(255)
,remarks varchar(255)
,barcode varchar(255)
,description text
,qty double
,cost double
,category varchar(255)
,category_id varchar(255)
,classification varchar(255)
,classification_id varchar(255)
,sub_class varchar(255)
,sub_class_id varchar(255)
,conversion double
,unit varchar(255)
,date_delivered date
,date_received date
,barcodes varchar(255)
,batch_no varchar(255)
,serial_no text
,main_barcode varchar(255)
,brand varchar(255)
,brand_id varchar(255)
,model varchar(255)
,model_id varchar(255)
,status int
,previous_cost double
,receipt_type_id varchar(255)
,branch varchar(255)
,branch_id varchar(255)
,location varchar(255)
,location_id varchar(255)
);


insert into user_default_previleges(account,name)
values('Transactions','Receipts Service');
insert into user_default_previleges(account,name)
values('Transactions','Warranty Service');


drop table if exists warranties;
create table warranties(
id int auto_increment primary key
,transaction_no varchar(255)
,slip_no  varchar(255)
,remarks  varchar(255)
,supplier varchar(255)
,supplier_id varchar(255)
,status int
,created_at datetime
,created_by varchar(255)
,branch varchar(255)
,branch_id varchar(255)
,location varchar(255)
,location_id varchar(255)
);


drop table if exists warranty_items;
create table warranty_items(
id int auto_increment primary key
,transaction_no varchar(255)
,remarks  varchar(255)
,trans_type varchar(255)
,supplier varchar(255)
,supplier_id varchar(255)
,barcode varchar(255)
,description text
,qty double
,cost double
,selling_price double
,category varchar(255)
,category_id varchar(255)
,classification varchar(255)
,classification_id varchar(255)
,sub_class varchar(255)
,sub_class_id varchar(255)
,conversion double
,unit varchar(255)
,warranty_date date
,serial_no text
,main_barcode varchar(255)
,brand varchar(255)
,brand_id varchar(255)
,model varchar(255)
,model_id varchar(255)
,status int
,created_at datetime
,created_by varchar(255)
,branch varchar(255)
,branch_id varchar(255)
,location varchar(255)
,location_id varchar(255)
);

delete from inventory where location_id='32';
delete from inventory_barcodes where location_id='32';

update inventory_barcodes ib set ib.main_barcode=(select i.barcode from inventory i where i.description=ib.description) where ib.main_barcode like '90';

alter table warranty_items add slip_no varchar(255);
