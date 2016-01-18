
alter table my_services add branch varchar(255);
alter table my_services add branch_id varchar(255);
alter table my_services add location varchar(255);
alter table my_services add location_id varchar(255);
update my_services set branch='Algorithm - Dgte', branch_id='9', location='Selling Area', location_id='14';

alter table my_services_crews add branch varchar(255);
alter table my_services_crews add branch_id varchar(255);
alter table my_services_crews add location varchar(255);
alter table my_services_crews add location_id varchar(255);
update my_services_crews set branch='Algorithm - Dgte', branch_id='9', location='Selling Area', location_id='14';

alter table my_services_customers add branch varchar(255);
alter table my_services_customers add branch_id varchar(255);
alter table my_services_customers add location varchar(255);
alter table my_services_customers add location_id varchar(255);
update my_services_customers set branch='Algorithm - Dgte', branch_id='9', location='Selling Area', location_id='14';


alter table my_services_departments add branch varchar(255);
alter table my_services_departments add branch_id varchar(255);
alter table my_services_departments add location varchar(255);
alter table my_services_departments add location_id varchar(255);
update my_services_departments set branch='Algorithm - Dgte', branch_id='9', location='Selling Area', location_id='14';

alter table my_services_description_customers add branch varchar(255);
alter table my_services_description_customers add branch_id varchar(255);
alter table my_services_description_customers add location varchar(255);
alter table my_services_description_customers add location_id varchar(255);
update my_services_description_customers set branch='Algorithm - Dgte', branch_id='9', location='Selling Area', location_id='14';


alter table my_services_others_customers add branch varchar(255);
alter table my_services_others_customers add branch_id varchar(255);
alter table my_services_others_customers add location varchar(255);
alter table my_services_others_customers add location_id varchar(255);
update my_services_others_customers set branch='Algorithm - Dgte', branch_id='9', location='Selling Area', location_id='14';

alter table my_services_problems_customers add branch varchar(255);
alter table my_services_problems_customers add branch_id varchar(255);
alter table my_services_problems_customers add location varchar(255);
alter table my_services_problems_customers add location_id varchar(255);
update my_services_problems_customers set branch='Algorithm - Dgte', branch_id='9', location='Selling Area', location_id='14';

alter table my_service_type add branch varchar(255);
alter table my_service_type add branch_id varchar(255);
alter table my_service_type add location varchar(255);
alter table my_service_type add location_id varchar(255);
update my_service_type set branch='Algorithm - Dgte', branch_id='9', location='Selling Area', location_id='14';



alter table users add branch varchar(255);
alter table users add branch_id varchar(255);
alter table users add location varchar(255);
alter table users add location_id varchar(255);
update users set branch='Algorithm - Dgte', branch_id='9', location='Selling Area', location_id='14';



UPDATE sales SET sales_no = CONCAT('14|', sales_no);
UPDATE sale_items SET sales_no = CONCAT('14|', sales_no);


drop table if exists return_merchandise_authorizations;
create table return_merchandise_authorizations(
id int auto_increment primary key
,rma_no varchar(255)
,reference_no varchar(255)
,client_id varchar(255)
,client_name varchar(255)
,date_added datetime
,date_sent date
,date_of_purchase date
,supplier varchar(255)
,supplier_id varchar(255)
,status int
,user_id varchar(255)
,user_screen_name varchar(255)
,branch varchar(255)
,branch_id varchar(255)
,location varchar(255)
,location_id varchar(255)
);




drop table if exists return_merchandise_authorization_items;
create table return_merchandise_authorization_items(
id int auto_increment primary key
,item_code varchar(255)
,barcode varchar(255)
,description varchar(255)
,qty double
,unit text
,cost double
,selling_price double
,serial_no text
,reference_no varchar(255)
,client_id varchar(255)
,client_name varchar(255)
,warranty_date date
,is_stock_unit int
,date_added datetime
,date_sent date
,date_of_purchase date
,supplier varchar(255)
,supplier_id varchar(255)
,is_out_of_warranty int
,is_defective int
,status int
,user_id varchar(255)
,user_screen_name varchar(255)
,branch varchar(255)
,branch_id varchar(255)
,location varchar(255)
,location_id varchar(255)
);



insert into user_default_previleges(account,name)values('Administrator','Upload to Cloud');
insert into user_default_previleges(account,name)values('Administrator','Download from Cloud');

update branch_locations set status=0;
update branch_locations set status=1 where id=14;


insert into  user_default_previleges (account,name) values ('Inventory','Update Item Pricing per Branch');
insert into  user_default_previleges (account,name) values ('Inventory','Update Item Pricing any Branches');


// start of maintenance
drop table if exists synch_maintenance_uploads;
create table synch_maintenance_uploads(
id int auto_increment primary key
,stmt longblob
,status int
,user_id varchar(255)
,user_screen_name varchar(255)
,branch varchar(255)
,branch_id varchar(255)
,location varchar(255)
,location_id varchar(255)
);

drop table if exists synch_maintenance_downloads;
create table synch_maintenance_uploads(
id int auto_increment primary key
,stmt longblob
,status int
,user_id varchar(255)
,user_screen_name varchar(255)
,branch varchar(255)
,branch_id varchar(255)
,location varchar(255)
,location_id varchar(255)
);

drop table if exists logs_maintenances;
create table logs_maintenances(
id int auto_increment primary key
,stmt text
,status int
,user_id varchar(255)
,user_screen_name varchar(255)
,branch varchar(255)
,branch_id varchar(255)
,location varchar(255)
,location_id varchar(255)
);

// end of maintenance






