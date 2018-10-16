/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  Guinness
 * Created: Oct 3, 2018
 */


select
i.barcode,i.description,i.selling_price,ib.selling_price
from
inventory i
join inventory_barcodes ib on
i.barcode=ib.main_barcode
where i.barcode=ib.main_barcode and i.selling_price<>ib.selling_price  and ib.location_id=29;



update inventory_barcodes ib
join inventory i on
i.barcode=ib.main_barcode
set ib.selling_price=i.selling_price, ib.unit=i.unit
where i.barcode=ib.main_barcode and i.selling_price<>ib.selling_price and ib.location_id=29;

update inventory_barcodes ib
set ib.selling_price=(select i.selling_price from inventory i where i.barcode=ib.main_barcode)
, ib.unit=(select i.unit from inventory i where i.barcode=ib.main_barcode)
where ib.location_id=29;



drop table if exists rmas;
create table rmas(
transaction_no varchar(255)
,date_returned datetime
,reference_no varchar(255)
,remarks varchar(255)
,courier_reference_no varchar(255)
,courier_details varchar(255)
,courier_date_received datetime
,status int
,is_complete int
,supplier_id varchar(255)
,supplier_name varchar(255)
,created_at datetime
,created_by varchar(255)
,updated_at datetime
,updated_by varchar(255)
,branch varchar(255)
,branch_id varchar(255)
,location varchar(255)
,location_id varchar(255)
);

drop table if exists rma_items;
create table rma_items(
transaction_no varchar(255)
,date_returned datetime
,reference_no varchar(255)
,remarks varchar(255)
,courier_reference_no varchar(255)
,courier_details varchar(255)
,courier_date_received datetime
,status int
,supplier_id varchar(255)
,supplier_name varchar(255)
,created_at datetime
,created_by varchar(255)
,updated_at datetime
,updated_by varchar(255)
,item_code varchar(255)
,barcode varchar(255)
,description varchar(255)
,product_qty double
,cost double
,category varchar(255)
,category_id varchar(255)
,classification varchar(255)
,classification_id varchar(255)
,sub_classification varchar(255)
,sub_classification_id varchar(255)
,brand varchar(255)
,brand_id varchar(255)
,model varchar(255)
,model_id varchar(255)
,unit varchar(255)
,selling_price double
,conversion double
,old_serial_no varchar(255)
,new_serial_no varchar(255)
,item_type int /* 0-customer 1-stock unit */
,item_transaction_reference_no varchar(255)
,customer_id varchar(255)
,customer_name varchar(255)
,branch varchar(255)
,branch_id varchar(255)
,location varchar(255)
,location_id varchar(255)
);
