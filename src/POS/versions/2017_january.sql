/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  Guinness
 * Created: Jan 16, 2017
 */

insert into user_default_previleges(account,name)values('Inventory','Suppliers - Report');



alter table accounts_payable add branch varchar(255);
alter table accounts_payable add branch_id varchar(255);
alter table accounts_payable add location varchar(255);
alter table accounts_payable add location_id varchar(255);




drop table if exists return_to_suppliers;
create table return_to_suppliers(
id int auto_increment primary key
,return_to_supplier_no varchar(255)
,user_name varchar(255)
,session_no varchar(255)
,date_added datetime
,supplier varchar(255)
,supplier_id varchar(255)
,reference_no varchar(255)
,remarks varchar(255)
,status int
,branch varchar(255)
,branch_id varchar(255)
,location varchar(255)
,location_id varchar(255)
,gross_total double
,discount varchar(255)
,discount_amount double
,discount_rate double
);



drop table if exists return_to_supplier_items;
create table return_to_supplier_items(
id int auto_increment primary key
,return_to_supplier_no varchar(255)
,user_name varchar(255)
,session_no varchar(255)
,date_added datetime
,supplier varchar(255)
,supplier_id varchar(255)
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
,branch varchar(255)
,branch_id varchar(255)
,location varchar(255)
,location_id varchar(255)
);



drop table if exists return_from_customers;
create table return_from_customers(
id int auto_increment primary key
,return_from_customer_no varchar(255)
,user_name varchar(255)
,session_no varchar(255)
,date_added datetime
,supplier varchar(255)
,supplier_id varchar(255)
,reference_no varchar(255)
,remarks varchar(255)
,status int
,branch varchar(255)
,branch_id varchar(255)
,location varchar(255)
,location_id varchar(255)
,gross_total double
,discount varchar(255)
,discount_amount double
,discount_rate double
);



drop table if exists return_from_customer_items;
create table return_from_customer_items(
id int auto_increment primary key
,return_from_customer_no varchar(255)
,user_name varchar(255)
,session_no varchar(255)
,date_added datetime
,supplier varchar(255)
,supplier_id varchar(255)
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
,branch varchar(255)
,branch_id varchar(255)
,location varchar(255)
,location_id varchar(255)
);

insert into user_default_previleges(account,name)values('Inventory','Return/s from Customer');