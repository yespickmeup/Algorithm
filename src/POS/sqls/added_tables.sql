
/* 02/06/2015 */
drop table if exists adjustments;
create table adjustments(
id int auto_increment primary key
,item_code varchar(100)
,barcode varchar(100)
,description varchar(100)
,qty double
,new_qty double
,is_add int
,date_added datetime
,status int
,user_id varchar(100)
,user_screen_name varchar(100)
,branch varchar(100)
,branch_id varchar(100)
,location varchar(100)
,location_id varchar(100)
);
/* */
