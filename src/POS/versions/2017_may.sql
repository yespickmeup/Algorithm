/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  Guinness
 * Created: May 4, 2017
 */


drop table if exists notifications;
create table notifications(
id int auto_increment primary key
,user_id varchar(255)
,user_screen_name varchar(255)
,created_at datetime
,status int
,remarks text
,module varchar(255)
,branch varchar(255)
,branch_id varchar(255)
,location varchar(255)
,location_id varchar(255)
);




alter table suppliers add branch varchar(255) default '';
alter table suppliers add branch_id varchar(255) default '' ;
alter table suppliers add location_id varchar(255) default '';

update suppliers set branch='Guihulngan';
update suppliers set branch_id='1';
update suppliers set location='Selling Area';
update suppliers set location_id='1';

update suppliers set customer_no=concat('1|',customer_no);
update receipts set supllier_id=concat('1|',supllier_id);

alter table accounts_payable add user_id varchar(255) default '' after reference_no;
alter table accounts_payable add user_screen_name varchar(255) default '' after user_id;