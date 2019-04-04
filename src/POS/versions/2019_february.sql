/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  Ronescape
 * Created: Feb 8, 2019
 */







update user_default_previleges set name='Disbursement Categories' where account='Maintenance' and name='Disbursements';


update inventory_replenishments set date_added='2019-02-10 00:00:00' where date_added='2019-02-09 00:00:00';
update inventory_replenishment_items set date_added='2019-02-10 00:00:00' where date_added='2019-02-09 00:00:00';
update encoding_inventory set date_added='2019-02-10 00:00:01' where date_added='2019-02-09 00:00:01';


alter table prepaid_payments add credit_card_type varchar(255) default '';
alter table prepaid_payments add credit_card_rate double default 0;
alter table prepaid_payments add credit_card_no varchar(255)  default '';
alter table prepaid_payments add credit_card_holder varchar(255)  default '';
alter table prepaid_payments add credit_card_amount double default 0;

alter table prepaid_payments add gift_certificate_from varchar(255)  default '';
alter table prepaid_payments add gift_certificate_description varchar(255)  default '';
alter table prepaid_payments add gift_certificate_no varchar(255)  default '';
alter table prepaid_payments add gift_certificate_amount double default 0;

alter table prepaid_payments add online_bank varchar(255)  default '';
alter table prepaid_payments add online_reference_no varchar(255)  default '';
alter table prepaid_payments add online_holder varchar(255)  default '';
alter table prepaid_payments add online_date date default null;
alter table prepaid_payments add online_amount double default 0;


alter table accounts_receivable_payments add actual_amount double default 0;


















