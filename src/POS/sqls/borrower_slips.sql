drop table if exists borrower_slips;
create table borrower_slips(
 id int auto_increment primary key
,user_id varchar(100)
,user_screen_name varchar(100)
,date_added datetime
,bs_no varchar(100)
,reference_no varchar(100)
,items_borrowed double
,items_returned double
,borrowed_by varchar(100)
,borrowed_by_id varchar(100)
,borrowed_by_department varchar(100)
,borrowed_by_department_id varchar(100)
,status int
,from_branch varchar(100)
,from_branch_id varchar(100)
,from_location varchar(100)
,from_location_id varchar(100)
,to_branch varchar(100)
,to_branch_id varchar(100)
,to_location varchar(100)
,to_location_id varchar(100)
,remarks text
);

drop table if exists borrower_slip_items;
create table borrower_slip_items(
 id int auto_increment primary key
,user_id varchar(100)
,user_screen_name varchar(100)
,date_added datetime
,bs_no varchar(100)
,reference_no varchar(100)
,borrowed_by varchar(100)
,borrowed_by_id varchar(100)
,borrowed_by_department varchar(100)
,borrowed_by_department_id varchar(100)
,status int
,from_branch varchar(100)
,from_branch_id varchar(100)
,from_location varchar(100)
,from_location_id varchar(100)
,to_branch varchar(100)
,to_branch_id varchar(100)
,to_location varchar(100)
,to_location_id varchar(100)
,remarks text
,barcode varchar(100)
,description varchar(100)
,generic_name varchar(100)
,category varchar(100)
,category_id varchar(100)
,classification varchar(100)
,classification_id varchar(100)
,sub_classification varchar(100)
,sub_classification_id varchar(100)
,product_qty double
,unit varchar(100)
,conversion double
,selling_price double 
,item_type varchar(100)
,supplier varchar(100)
,fixed_price int
,cost double
,supplier_id varchar(100)
,multi_level_pricing int
,vatable int
,reorder_level double
,markup double
,main_barcode varchar(100)
,brand varchar(100)
,brand_id varchar(100)
,model varchar(100)
,model_id varchar(100)
,selling_type varchar(100)
,serial_no varchar(100)
,qty_borrowed double
,qty_returned double
);
