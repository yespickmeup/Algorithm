/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  Guinness
 * Created: May 4, 2017
 */


drop table if exists notifications;
create table notifications(
id int auto_increment primary key
,user_id varchar(255)
,user_screen_name varchar(255)
,created_at datetime
,status int
,remarks text
,module varchar(255)
,branch varchar(255)
,branch_id varchar(255)
,location varchar(255)
,location_id varchar(255)
);




alter table suppliers add branch varchar(255) default '';
alter table suppliers add branch_id varchar(255) default '' ;
alter table suppliers add location_id varchar(255) default '';

update suppliers set branch='Dumaguete';
update suppliers set branch_id='1';
update suppliers set location='Selling Area';
update suppliers set location_id='1';

update suppliers set customer_no=concat('1|',customer_no);
update receipts set supllier_id=concat('1|',supllier_id);

alter table accounts_payable add user_id varchar(255) default '' after reference_no;
alter table accounts_payable add user_screen_name varchar(255) default '' after user_id;


drop table if exists stock_takes;
create table stock_takes(
id int auto_increment primary key
,stock_take_no varchar(255)
,user_id varchar(255)
,user_screen_name varchar(255)
,date_added datetime
,remarks varchar(255)
,status int
,branch varchar(255)
,branch_id varchar(255)
,location varchar(255)
,location_id varchar(255)
);

drop table if exists stock_take_items;
create table stock_take_items(
id int auto_increment primary key
,stock_take_no varchar(255)
,user_id varchar(255)
,user_screen_name varchar(255)
,date_added datetime
,remarks varchar(255)
,barcode varchar(255)
,description text
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
,unit text
,barcodes varchar(255)
,main_barcode varchar(255)
,qty double
,cost double
,selling_price double
,branch varchar(255)
,branch_id varchar(255)
,location varchar(255)
,location_id varchar(255)
);
