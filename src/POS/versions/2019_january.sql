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





