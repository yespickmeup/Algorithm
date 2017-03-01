/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  Guinness
 * Created: Feb 25, 2017
 */

insert into user_default_previleges(account,name)values('Sales','Cashier Report - Sales Summary');
insert into user_default_previleges(account,name)values('Sales','Cashier Report - Cash Count');
insert into user_default_previleges(account,name)values('Sales','Cashier Report - Sales Ledger');
insert into user_default_previleges(account,name)values('Sales','Cashier Report - Sales by Item');
insert into user_default_previleges(account,name)values('Sales','Cashier Report - Void/Replacement');
insert into user_default_previleges(account,name)values('Sales','Cashier Report - Remittance');
insert into user_default_previleges(account,name)values('Sales','Cashier Report - AR Payments');
insert into user_default_previleges(account,name)values('Sales','Cashier Report - Prepaid Payments');

insert into user_default_previleges(account,name)values('Inventory','Conversion');
insert into user_default_previleges(account,name)values('Inventory','Conversions - Finalize');



drop table if exists conversions;
create table conversions(
id int auto_increment primary key
,conversion_no varchar(255)
,user_name varchar(255)
,session_no varchar(255)
,date_added datetime
,reference_no varchar(255)
,remarks varchar(255)
,status int
,from_branch varchar(255)
,from_branch_id varchar(255)
,from_location varchar(255)
,from_location_id varchar(255)
,to_branch varchar(255)
,to_branch_id varchar(255)
,to_location varchar(255)
,to_location_id varchar(255)
);



drop table if exists conversion_items;
create table conversion_items(
id int auto_increment primary key
,conversion_no varchar(255)
,user_name varchar(255)
,session_no varchar(255)
,date_added datetime
,reference_no varchar(255)
,remarks varchar(255)
,barcode varchar(255)
,description varchar(255)
,category varchar(255)
,category_id varchar(255)
,classification varchar(255)
,classification_id varchar(255)
,sub_class varchar(255)
,sub_class_id varchar(255)
,brand varchar(255)
,brand_id varchar(255)
,model varchar(255)
,model_id varchar(255)
,conversion double
,unit varchar(255)
,barcodes varchar(255)
,batch_no varchar(255)
,serial_no varchar(255)
,main_barcode varchar(255)
,qty double
,cost double
,status int
,from_branch varchar(255)
,from_branch_id varchar(255)
,from_location varchar(255)
,from_location_id varchar(255)
,to_branch varchar(255)
,to_branch_id varchar(255)
,to_location varchar(255)
,to_location_id varchar(255)
);

