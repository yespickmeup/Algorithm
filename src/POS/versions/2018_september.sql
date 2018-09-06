/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  Guinness
 * Created: Sep 5, 2018
 */

drop table if exists stock_transfer_privileges;
create table stock_transfer_privileges(
id int auto_increment primary key
,user_id varchar(255)
,user_screen_name varchar(255)
,branch varchar(255)
,branch_id varchar(255)
,location varchar(255)
,location_id varchar(255)
,add_transfer int
,edit_transfer int
,delete_transfer int
,finalize_transfer int
);




