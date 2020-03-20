/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  Ronescape
 * Created: Mar 4, 2020
 */



/*  update refreshment items */



mysqldump -u user -h localhost --no-data -p database > database.sql

/* Abiera */
update inventory set allow_negative_inventory=1,auto_order=0,show_to_sales=1;
update inventory_barcodes set allow_negative_inventory=1,auto_order=0,show_to_sales=1;

alter table sale_items add cost double default 0;




alter table return_from_customer_items add cash double default 0;
update return_from_customer_items set cash=(qty*cost);

alter table return_from_customer_items add prepaid_customer_name varchar(255);
alter table return_from_customer_items add prepaid_customer_id varchar(255);
alter table return_from_customer_items add prepaid_amount double;
alter table return_from_customer_items add charge_reference_no varchar(255);
alter table return_from_customer_items add charge_ar_no varchar(255);
alter table return_from_customer_items add charge_type varchar(255);
alter table return_from_customer_items add charge_customer_name varchar(255);
alter table return_from_customer_items add charge_customer_id varchar(255);
alter table return_from_customer_items add charge_amount double ;
alter table return_from_customer_items add charge_days int;


alter table return_from_customers add cash double;
alter table return_from_customers add prepaid_customer_name varchar(255);
alter table return_from_customers add prepaid_customer_id varchar(255);
alter table return_from_customers add prepaid_amount double;
alter table return_from_customers add charge_reference_no varchar(255);
alter table return_from_customers add charge_ar_no varchar(255);
alter table return_from_customers add charge_type varchar(255);
alter table return_from_customers add charge_customer_name varchar(255);
alter table return_from_customers add charge_customer_id varchar(255);
alter table return_from_customers add charge_amount double ;
alter table return_from_customers add charge_days int;


alter table return_from_customer_items add selling_price double default 0;
update return_from_customer_items set selling_price=cost;





