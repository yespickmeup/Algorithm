/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  Ronescape
 * Created: Jan 2, 2019
 */

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


GRANT SUPER ON *.* TO 'smis2'@'%' IDENTIFIED BY PASSWORD
GRANT SUPER ON *.* TO 'smis2'@'%' IDENTIFIED BY 'nopassword101';
FLUSH PRIVILEGES;


CREATE USER 'smis5'@'%' IDENTIFIED BY 'nopassword101';
GRANT ALL PRIVILEGES ON *.* TO 'smis5'@'%'  ;
flush privileges;



/* Refreshments Updates */

update inventory i set i.category_id=(select ic.id from inventory_category ic where ic.name=i.category);
update inventory_barcodes i set i.category_id=(select ic.id from inventory_category ic where ic.name=i.category);
update inventory set is_uploaded=1;


alter table accounts_receivable_payments add actual_amount double default 0;
update accounts_receivable_payments set actual_amount=(amount+check_amount+prepaid_amount+credit_card_amount+gift_certificate_amount+online_amount-discount_amount);


alter table inventory add allow_negative_inventory int default 0;
alter table inventory add auto_order int default 1;

alter table inventory_barcodes add allow_negative_inventory int default 0;
alter table inventory_barcodes add auto_order int default 1;

          