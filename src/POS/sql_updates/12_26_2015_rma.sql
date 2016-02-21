









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


