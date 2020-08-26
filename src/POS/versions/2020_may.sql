/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  User
 * Created: 05 19, 20
 */

drop table if exists receipt_endorsements;
create table receipt_endorsements(
id int auto_increment primary key
,endorsement_type varchar(255)
,endorsed_user_id int
,endorsed_user_screen_name varchar(255)
,receipt_from varchar(255)
,receipt_to varchar(255)
,created_at datetime
,updated_at datetime
,created_by varchar(255)
,updated_by varchar(255)
,status int
);

drop table if exists receipt_endorsement_items;
create table receipt_endorsement_items(
id int auto_increment primary key
,receipt_endorsement_id int
,endorsement_type varchar(255)
,receipt_no varchar(255)
,created_at datetime
,updated_at datetime
,created_by varchar(255)
,updated_by varchar(255)
,status int
);

insert into user_default_previleges(account,name)
values('Transactions','Receipt Endorsement');


