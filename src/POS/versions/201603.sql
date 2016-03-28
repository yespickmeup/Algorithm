

/* 03/28/2016 */

insert into user_default_previleges(account,name)
values
('Administrator','BIR');

drop table if exists terminals;
create table terminals(
id int auto_increment primary key
,terminal varchar(255)
,ip_address varchar(255)
,branch varchar(255)
,branch_id varchar(255)
,location varchar(255)
,location_id varchar(255)
,created_at datetime
,updated_at datetime
,created_by varchar(255)
,updated_by varchar(255)
,status int
);