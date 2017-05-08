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
