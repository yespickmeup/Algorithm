/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  Guinness
 * Created: Oct 16, 2018
 */

alter table accounts_payable add is_uploaded int default 0;
alter table accounts_payable_payments add is_uploaded int default 0;

alter table accounts_receivable add is_uploaded int default 0;
alter table accounts_receivable_payments add is_uploaded int default 0;

alter table adjustments add is_uploaded int default 0;

alter table borrower_slips add is_uploaded int default 0;
alter table borrower_slip_items add is_uploaded int default 0;

alter table cash_drawer add is_uploaded int default 0;
alter table cash_drawer_remittances add is_uploaded int default 0;

alter table charge_in_advance add is_uploaded int default 0;
alter table charge_in_advance_items add is_uploaded int default 0;
alter table charge_in_advance_cancelled_items add is_uploaded int default 0;

alter table conversions add is_uploaded int default 0;
alter table conversion_items add is_uploaded int default 0;

alter table customers add department varchar(255) default '';
alter table customers add department_id  varchar(255) default '';
drop table if exists customer_departments;

create table customer_departments(
id int auto_increment primary key
,department varchar(255)
,created_at datetime
,updated_at datetime
,created_by varchar(255)
,updated_by varchar(255)
);

alter table disbursements add is_uploaded int default 0;

alter table encoding_inventory add remarks varchar(255) default '';
alter table encoding_inventory add is_uploaded int default 0;

alter table inventory add updated_at datetime;
alter table inventory add cloud_added int default 0;
alter table inventory add cloud_added_at datetime ;
alter table inventory add cloud_updated int default 0;
alter table inventory add cloud_updated_at datetime ;
alter table inventory add is_uploaded int default 0;

alter table inventory_barcodes add updated_at datetime;
alter table inventory_barcodes add cloud_added int default 0;
alter table inventory_barcodes add cloud_added_at datetime ;
alter table inventory_barcodes add cloud_updated int default 0;
alter table inventory_barcodes add cloud_updated_at datetime ;
alter table inventory_barcodes add is_uploaded int default 0;

alter table inventory_price_updates add is_uploaded int default 0 after location_id;
alter table inventory_price_updates add ipu_no varchar(255);
alter table inventory_price_updates add at_branch varchar(255);
alter table inventory_price_updates add at_branch_id varchar(255);
alter table inventory_price_updates add at_location varchar(255);
alter table inventory_price_updates add at_location_id varchar(255);

alter table inventory_replenishments add is_uploaded int default 0;
alter table inventory_replenishment_items add is_uploaded int default 0;

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

alter table item_replacement_details add addtl_amount double;
alter table item_replacement_details add wtax double;

alter table my_services add is_uploaded int default 0;
alter table my_services_barcodes_customers add is_uploaded int default 0;
alter table my_services_description_customers add is_uploaded int default 0;
alter table my_services_item_replacements_customers add is_uploaded int default 0;
alter table my_services_others_customers add is_uploaded int default 0;
alter table my_services_problems_customers add is_uploaded int default 0;

alter table other_adjustments add is_uploaded int default 0;

alter table prepaid_payments add remarks varchar(500) default '';
alter table prepaid_payments add is_uploaded int default 0;

alter table purchase_orders add is_uploaded int default 0;
alter table purchase_order_items add is_uploaded int default 0;

alter table receipts add is_uploaded int default 0;
alter table receipt_items add is_uploaded int default 0;

alter table requisition_slips add is_uploaded int default 0;
alter table requisition_slip_items add is_uploaded int default 0;


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

alter table return_from_customers add is_uploaded int default 0;
alter table return_from_customer_items add is_uploaded int default 0;
alter table return_to_suppliers add is_uploaded int default 0;
alter table return_to_supplier_items add is_uploaded int default 0;

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

alter table sales add is_uploaded int default 0;
alter table sale_items add is_uploaded int default 0;


alter table stock_transfers add is_uploaded int default 0;
alter table stock_transfers add finalized_by_id varchar(255);
alter table stock_transfers add finalized_by varchar(255);

alter table stock_transfers_items add is_uploaded int default 0;
alter table stock_transfers_items add finalized_by_id varchar(255);
alter table stock_transfers_items add finalized_by varchar(255);

/* User Default Privileges */
delete from user_default_previleges;
/* Get Data user_default previleges.sql*/

drop table if exists user_default_previlege_others;
create table user_default_previlege_others(
id int auto_increment primary key
,account varchar(255)
,account_name varchar(255)
,name varchar(255)
);
/* Insert user default previleges others */

drop table if exists user_previlege_others;
create table user_previlege_others(
id int auto_increment primary key
,account varchar(255)
,account_name varchar(255)
,name varchar(255)
,user_id varchar(255)
,user_name varchar(255)
);
/* Insert user  previleges others */