



drop table if exists synch_locations;
create table synch_locations(
id int auto_increment primary key
,inventory_counts longblob
,receipts longblob
,sales longblob
,transfers longblob
,adjustments longblob
,returned_items longblob
,charges longblob
,rmas longblob
,item_maintenances longblob
,cash_drawers longblob
,status int
,date_added datetime
,user_id varchar(255)
,user_screen_name varchar(255)
,branch varchar(255)
,branch_id varchar(255)
,location varchar(255)
,location_id varchar(255)
);

drop table if exists synch_upload_locations;
create table synch_upload_locations(
id int auto_increment primary key
,inventory_counts longblob
,receipts longblob
,sales longblob
,transfers longblob
,adjustments longblob
,returned_items longblob
,charges longblob
,rmas longblob
,item_maintenances longblob
,cash_drawers longblob
,status int
,date_added datetime
,user_id varchar(255)
,user_screen_name varchar(255)
,branch varchar(255)
,branch_id varchar(255)
,location varchar(255)
,location_id varchar(255)
);
