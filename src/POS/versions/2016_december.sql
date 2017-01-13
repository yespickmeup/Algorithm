/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  synsoftech
 * Created: 12 27, 16
 */

alter table purchase_order_items add branch varchar(255);
alter table purchase_order_items add branch_id varchar(255);
alter table purchase_order_items add location varchar(255);
alter table purchase_order_items add location_id varchar(255);

insert into user_default_previleges(account,name)values('Inventory','Re-Order Level');


drop table if exists purchase_orders;
create table purchase_orders(
id int auto_increment primary key
,puchase_order_no varchar(255)
,user_name varchar(255)
,session_no varchar(255)
,date_added datetime
,supplier varchar(255)
,supplier_id varchar(255)
,remarks varchar(255)
,status int
,date_delivered date
,date_received date
,branch varchar(255)
,branch_id varchar(255)
,location varchar(255)
,location_id varchar(255)
,reference_no varchar(255)
,gross_total double
,discount varchar(255)
,discount_amount double
,discount_rate double
,receipt_no varchar(255)
,receipt_type varchar(255)
,receipt_type_id varchar(255)
,total_qty_ordered double
,total_qty_received double
);



drop table if exists purchase_order_items;
create table purchase_order_items(
id int auto_increment primary key
,po_no varchar(255)
,user_name varchar(255)
,session_no varchar(255)
,date_added datetime
,supplier varchar(255)
,supplier_id varchar(255)
,remarks varchar(255)
,barcode varchar(255)
,description varchar(255)
,category varchar(255)
,category_id varchar(255)
,classification varchar(255)
,classification_id varchar(255)
,sub_class varchar(255)
,sub_class_id varchar(255)
,brand varchar(255)
,brand_id varchar(255)
,model varchar(255)
,model_id varchar(255)
,conversion double
,unit varchar(255)
,barcodes varchar(255)
,batch_no varchar(255)
,serial_no varchar(255)
,main_barcode varchar(255)
,qty_ordered double
,qty_received double
,previous_cost double
,new_cost double
,status int
,date_delivered date
,date_received date
,reference_no varchar(255)
,receipt_type varchar(255)
,receipt_type_id varchar(255)
,branch varchar(255)
,branch_id varchar(255)
,location varchar(255)
,location_id varchar(255)
);

