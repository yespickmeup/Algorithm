drop table if exists inventory_assembly;
create table inventory_assembly(
id int auto_increment primary key
,main_item_code varchar(100)
,item_code varchar(100)
,description varchar(100)
,generic_name varchar(100)
,category varchar(100)
,category_id varchar(100)
,classification varchar(100)
,classification_id varchar(100)
,sub_classification varchar(100)
,sub_classification_id varchar(100)
,product_qty double
,unit varchar(1000)
,conversion double
,selling_price double
,date_added datetime
,user_name varchar(100)
,item_type varchar(100)
,status int
,supplier varchar(100)
,fixed_price int
,cost double
,supplier_id varchar(100)
,multi_level_pricing int
,vatable int
,reorder_level double
,markup double
,barcodes varchar(100)
,brand varchar(100)
,brand_id varchar(100)
,model varchar(100)
,model_id varchar(100)
,selling_type int
,branch varchar(100)
,branch_code varchar(100)
,location varchar(100)
,location_id varchar(100)
);



