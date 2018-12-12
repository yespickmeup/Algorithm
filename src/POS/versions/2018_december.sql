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


