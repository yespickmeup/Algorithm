/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  Ronescape
 * Created: Dec 12, 2018
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

update settings set version='V.1.20170206';
update settings set cloud_host='128.199.80.53';
update settings set cloud_port='3306';
update settings set cloud_user='smis2';
update settings set cloud_password='nopassword101';
update settings set cloud_db='db_smis_dumaguete_angel_buns';
update settings set ar_footer='Should you have any inquiries concerning this statement, please contact the Accounting Department';









