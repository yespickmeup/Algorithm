/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  Ronescape
 * Created: Jun 14, 2019
 */



alter table item_replacements add cash_amount double default 0;

alter table item_replacements add check_holder varchar(255) default '';
alter table item_replacements add check_bank varchar(255) default '';
alter table item_replacements add check_no varchar(255) default '';
alter table item_replacements add check_date date;
alter table item_replacements add check_amount double default 0;


alter table item_replacements add card_type varchar(255) default '';
alter table item_replacements add credit_card_rate double default 0;
alter table item_replacements add credit_card_amount double default 0;
alter table item_replacements add credit_card_amount_to_pay double default 0;
alter table item_replacements add credit_card_no varchar(255) default '';
alter table item_replacements add credit_card_holder varchar(255) default '';
alter table item_replacements add credit_card_approval_code varchar(255) default '';
alter table item_replacements add prepaid_customer_name varchar(255) default '';
alter table item_replacements add prepaid_customer_id varchar(255) default '';
alter table item_replacements add prepaid_amount double default 0;
alter table item_replacements add charge_reference_no varchar(255) default '';
alter table item_replacements add charge_ar_no varchar(255) default '';
alter table item_replacements add charge_type varchar(255) default '';
alter table item_replacements add charge_customer_name varchar(255) default '';
alter table item_replacements add charge_customer_id varchar(255) default '';
alter table item_replacements add charge_amount double default 0;
alter table item_replacements add charge_days int default 0;
alter table item_replacements add gc_from varchar(255) default '';
alter table item_replacements add gc_description varchar(255) default '';
alter table item_replacements add gc_no varchar(255) default '';
alter table item_replacements add gc_amount double default 0;
alter table item_replacements add online_holder varchar(255) default '';
alter table item_replacements add online_bank varchar(255) default '';
alter table item_replacements add online_reference_no varchar(255) default '';
alter table item_replacements add online_date date;
alter table item_replacements add online_amount double default 0;
update item_replacements set cash_amount=(amount_due-discount) - replacement_amount;
alter table accounts_receivable_payments add salary_deduction double default 0;
select stock_transfer_id,date_added,barcode from stock_transfers_items where location_id=to_location_id;
alter table item_replacements add online_amount double default 0;
















