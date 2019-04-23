/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  Ronescape
 * Created: Apr 3, 2019
 */


alter table accounts_receivable_payments add retention double default 0;
alter table accounts_receivable_payments add business_tax double default 0;


drop table if exists cashier_shifts;
create table cashier_shifts(
id int auto_increment primary key
,created_at datetime
,created_by varchar(255)
,updated_at datetime
,updated_by varchar(255)
,description varchar(255)
,shift varchar(255)
,status int
,is_uploaded int
);

drop table if exists cashier_shift_schedules;
create table cashier_shift_schedules(
id int auto_increment primary key
,created_at datetime
,created_by varchar(255)
,updated_at datetime
,updated_by varchar(255)
,cashier_id varchar(255)
,cashier_name varchar(255)
,cashier_shift_id int
,cashier_shift varchar(255)
,status int
,is_uploaded int
);


alter table sales add shift varchar(255) default "";
alter table sales add shift_id varchar(255) default "";
alter table sale_items add shift varchar(255) default "";
alter table sale_items add shift_id varchar(255) default "";



