/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  Guinness
 * Created: Mar 13, 2017
 */

alter table accounts_payable  change ar_no ap_no varchar(255);
alter table accounts_payable  change or_no reference_no varchar(255);
alter table accounts_payable add user_id varchar(255) after or_no;
alter table accounts_payable add user_screen_name varchar(255) after user_id;

delete from accounts_payable_payments;
alter table accounts_payable_payments  change ar_no ap_no varchar(255);
alter table accounts_payable_payments add reference_no varchar(255);
alter table accounts_payable_payments add check_amount double;
alter table accounts_payable_payments add check_holder varchar(255);
alter table accounts_payable_payments add check_bank varchar(255);
alter table accounts_payable_payments add check_no varchar(255);
alter table accounts_payable_payments add check_date date;
alter table accounts_payable_payments add user_id varchar(255);
alter table accounts_payable_payments add user_screen_name varchar(255);
alter table accounts_payable_payments add wtax double;
alter table accounts_payable_payments add tax_rate double;
alter table accounts_payable_payments add tax_amount double;
alter table accounts_payable_payments add branch varchar(255);
alter table accounts_payable_payments add branch_id varchar(255);
alter table accounts_payable_payments add location varchar(255);
alter table accounts_payable_payments add location_id varchar(255);



