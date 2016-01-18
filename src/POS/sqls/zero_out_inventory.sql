




create table inventory_replenishments(
id int auto_increment primary key
,inventory_replenishment_no varchar(100)
,date_added datetime
,user_id varchar(100)
,user_screen_name varchar(100)
,remarks varchar(100)
,status int
,branch varchar(100)
,branch_id varchar(100)
,location varchar(100)
,location_id varchar(100)
);

create table inventory_replenishment_items(
id int auto_increment primary key
,inventory_replenishment_no varchar(100)
,item_code varchar(100)
,barcode varchar(100)
,description varchar(100)
,product_qty double
,unit varchar(100)
,conversion double
,selling_price double
,date_added datetime
,user_id varchar(100)
,user_screen_name varchar(100)
,status int
,branch varchar(100)
,branch_id varchar(100)
,location varchar(100)
,location_id varchar(100)
);

alter table inventory_replenishments add UNIQUE(inventory_replenishment_no);