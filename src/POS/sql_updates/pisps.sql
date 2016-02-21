drop schema db_pisps_test;


create schema db_pisps_test;
use db_pisps_test;
create table items(
 id int auto_increment primary key
,item_code varchar(100)
,barcode varchar(100)
,description varchar(1000)
,category varchar(100)
,classification varchar(100)
,sub_classification varchar(100)
,brand varchar(100)
,model varchar(100)
,uom varchar(100)
,cost double
,selling_price double
);



