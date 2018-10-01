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
,from_branch varchar(255)
,from_branch_id varchar(255)
,from_location varchar(255)
,from_location_id varchar(255)
,to_branch varchar(255)
,to_branch_id varchar(255)
,to_location varchar(255)
,to_location_id varchar(255)
,add_transfer int
,edit_transfer int
,delete_transfer int
,finalize_transfer int
,report_transfer int
);


insert into user_default_previleges(account,name)values('Maintenance','Stock Transfer Privileges');

alter table stock_transfers  add finalized_by_id varchar(255);
alter table stock_transfers  add finalized_by varchar(255);

alter table stock_transfers_items add finalized_by_id varchar(255) after is_uploaded;
alter table stock_transfers_items add finalized_by varchar(255);

alter table settings add is_main_branch int default 0;


