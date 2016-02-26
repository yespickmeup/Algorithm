


/* uploaded to local,server,cloud, */
drop table if exists requisition_slips;
create table requisition_slips(
id int auto_increment primary key
,requisition_slip_no varchar(255)
,requisition_date date
,requisition_type varchar(255)
,requisition_department varchar(255)
,requisition_department_id varchar(255)
,requested_by varchar(255)
,branch varchar(255)
,branch_id varchar(255)
,location varchar(255)
,location_id varchar(255)
,date_added datetime
,status int
);

drop table if exists requisition_slip_items;
create table requisition_slip_items(
id int auto_increment primary key
,requisition_slip_no varchar(255)
,requisition_date date
,requisition_type varchar(255)
,requisition_department varchar(255)
,requisition_department_id varchar(255)
,requested_by varchar(255)
,item_code varchar(255)
,barcode varchar(255)
,description varchar(255)
,product_qty double
,unit text
,cost double
,selling_price double
,branch varchar(255)
,branch_id varchar(255)
,location varchar(255)
,location_id varchar(255)
,date_added datetime
,status int
);

