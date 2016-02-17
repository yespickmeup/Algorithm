

drop table if exists inventory_price_updates;
create table inventory_price_updates(
id int auto_increment primary key
,item_code varchar(255)
,barcode varchar(255)
,description varchar(255)
,old_unit text
,unit text
,conversion double
,old_selling_price double
,selling_price double
,update_all_branch int
,status int
,date_added datetime
,user_id varchar(255)
,user_screen_name varchar(255)
,branch varchar(255)
,branch_id varchar(255)
,location varchar(255)
,location_id varchar(255)
);

insert into user_default_previleges(account,name)values('Inventory','Finalize Price Updates');