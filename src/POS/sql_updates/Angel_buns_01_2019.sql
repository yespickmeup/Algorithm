/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  Ronescape
 * Created: Jan 22, 2019
 */


drop table if exists user_price_change_requests;
create table user_price_change_requests(
id int auto_increment primary key
,user_id varchar(255)
,user_name varchar(255)
,created_at datetime
,updated_at datetime
,item_code varchar(255)
,description varchar(255)
,unit varchar(255)
,selling_price double
,status int
);


drop table if exists user_price_change_request_logs;
create table user_price_change_request_logs(
id int auto_increment primary key
,user_id varchar(255)
,user_name varchar(255)
,created_at datetime
,updated_at datetime
,item_code varchar(255)
,description varchar(255)
,old_unit varchar(255)
,new_unit varchar(255)
,old_price double
,new_price double
,status int
);



alter table sales add online_bank varchar(255) default '';
alter table sales add online_reference_no varchar(255) default '';
alter table sales add online_amount double default 0;
alter table sales add online_holder varchar(255) default '';
alter table sales add online_date date default '2000-01-01';


alter table settings add version varchar(255) default '';
alter table settings add cloud_host varchar(255) default '';
alter table settings add cloud_port varchar(255) default '';
alter table settings add cloud_user varchar(255) default '';
alter table settings add cloud_password varchar(255) default '';
alter table settings add cloud_db varchar(255) default '';
alter table settings add ar_footer varchar(255) default '';

alter table prepaid_payments add refund int default 0;



drop table if exists rmas;
create table rmas(
transaction_no varchar(255)
,date_returned datetime
,reference_no varchar(255)
,remarks varchar(255)
,courier_reference_no varchar(255)
,courier_details varchar(255)
,courier_date_received datetime
,status int
,is_complete int
,supplier_id varchar(255)
,supplier_name varchar(255)
,created_at datetime
,created_by varchar(255)
,updated_at datetime
,updated_by varchar(255)
,branch varchar(255)
,branch_id varchar(255)
,location varchar(255)
,location_id varchar(255)
);

drop table if exists rma_items;
create table rma_items(
transaction_no varchar(255)
,date_returned datetime
,reference_no varchar(255)
,remarks varchar(255)
,courier_reference_no varchar(255)
,courier_details varchar(255)
,courier_date_received datetime
,status int
,supplier_id varchar(255)
,supplier_name varchar(255)
,created_at datetime
,created_by varchar(255)
,updated_at datetime
,updated_by varchar(255)
,item_code varchar(255)
,barcode varchar(255)
,description varchar(255)
,product_qty double
,cost double
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
,unit varchar(255)
,selling_price double
,conversion double
,old_serial_no varchar(255)
,new_serial_no varchar(255)
,item_type int /* 0-customer 1-stock unit */
,item_transaction_reference_no varchar(255)
,customer_id varchar(255)
,customer_name varchar(255)
,branch varchar(255)
,branch_id varchar(255)
,location varchar(255)
,location_id varchar(255)
);


alter table settings add is_main_branch int default 0;


alter table accounts_receivable_payments add prepaid_customer_name varchar(255);
alter table accounts_receivable_payments add prepaid_customer_id varchar(255);
alter table accounts_receivable_payments add prepaid_amount double;

alter table accounts_receivable_payments add credit_card_type varchar(255);
alter table accounts_receivable_payments add credit_card_rate double;
alter table accounts_receivable_payments add credit_card_no varchar(255);
alter table accounts_receivable_payments add credit_card_holder varchar(255);
alter table accounts_receivable_payments add credit_card_amount double;

alter table accounts_receivable_payments add gift_certificate_from varchar(255);
alter table accounts_receivable_payments add gift_certificate_description varchar(255);
alter table accounts_receivable_payments add gift_certificate_no varchar(255);
alter table accounts_receivable_payments add gift_certificate_amount double;

alter table accounts_receivable_payments add online_bank varchar(255);
alter table accounts_receivable_payments add online_reference_no varchar(255);
alter table accounts_receivable_payments add online_holder varchar(255);
alter table accounts_receivable_payments add online_date date;
alter table accounts_receivable_payments add online_amount double;



alter table accounts_receivable_payments add actual_amount double default 0;
update accounts_receivable_payments set actual_amount=(amount+check_amount+prepaid_amount+credit_card_amount+gift_certificate_amount+online_amount-discount_amount);


alter table inventory add allow_negative_inventory int default 1;
alter table inventory add auto_order int default 1;

alter table inventory_barcodes add allow_negative_inventory int default 1;
alter table inventory_barcodes add auto_order int default 1;

 
update inventory set auto_order=0;     
update inventory_barcodes set auto_order=0;          


