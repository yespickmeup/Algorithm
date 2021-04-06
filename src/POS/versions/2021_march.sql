/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  User
 * Created: 03 19, 21
 */


drop table if exists receipt_privileges;
create table receipt_privileges(
id int auto_increment primary key
,user_id int
,user_screen_name varchar(255)
,branch_id int
,branch varchar(255)
,location_id int
,location varchar(255)
,created_at datetime
,updated_at datetime
,created_by int
,updated_by int
,status int
);

