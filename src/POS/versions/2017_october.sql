/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  Guinness
 * Created: Oct 10, 2017
 */

drop table if exists customer_departments;
create table customer_departments(
id int auto_increment primary key
,department varchar(255)
,created_at datetime
,updated_at datetime
,created_by varchar(255)
,updated_by varchar(255)
);

alter table customers add department varchar(255) default '';
alter table customers add department_id  varchar(255) default '';

update customers set department='Customers';
update customers set department_id='1';


drop table if exists supplier_departments;
create table supplier_departments(
id int auto_increment primary key
,department varchar(255)
,created_at datetime
,updated_at datetime
,created_by varchar(255)
,updated_by varchar(255)
);


alter table suppliers add department varchar(255) default '';
alter table suppliers add department_id  varchar(255) default '';

update suppliers set department='Suppliers';
update suppliers set department_id='1';























select transaction_no,date_added,from_location_id,to_location_id,at_location_id from stock_transfers where from_location_id=to_location_id and YEAR(date_added)='2017';
9|3734
9|4229

select date_received,date_added,from_location_id,to_location_id,at_location_id from stock_transfers where from_location_id=to_location_id and YEAR(date_added)='2017';





select r.receipt_no,r.date_received,r.branch_id from receipts r
join receipt_items ri on
r.branch_id=ri.location_id
 where
r.branch_id<>ri.location_id
and YEAR(r.date_received)='2017'
group by r.receipt_no;


select r.receipt_no,r.date_added,r.date_received,ri.date_received,r.branch_id from receipts r
right join receipt_items ri on
r.receipt_no=ri.receipt_no
 where
Date(r.date_received)<>Date(ri.date_received)
group by r.receipt_no;

update receipt_items ri set ri.date_received=(select r.date_received from receipts r where r.receipt_no=ri.receipt_no) where ri.receipt_no='20|0000001454';
update receipt_items ri set ri.date_received=(select r.date_received from receipts r where r.receipt_no=ri.receipt_no) where ri.receipt_no='14|0000001787';
update receipt_items ri set ri.date_received=(select r.date_received from receipts r where r.receipt_no=ri.receipt_no) where ri.receipt_no='14|0000001788';
update receipt_items ri set ri.date_received=(select r.date_received from receipts r where r.receipt_no=ri.receipt_no) where ri.receipt_no='14|0000001789';
update receipt_items ri set ri.date_received=(select r.date_received from receipts r where r.receipt_no=ri.receipt_no) where ri.receipt_no='14|0000001790';
update receipt_items ri set ri.date_received=(select r.date_received from receipts r where r.receipt_no=ri.receipt_no) where ri.receipt_no='14|0000001791';
update receipt_items ri set ri.date_received=(select r.date_received from receipts r where r.receipt_no=ri.receipt_no) where ri.receipt_no='14|0000001792';
update receipt_items ri set ri.date_received=(select r.date_received from receipts r where r.receipt_no=ri.receipt_no) where ri.receipt_no='14|0000001797';
update receipt_items ri set ri.date_received=(select r.date_received from receipts r where r.receipt_no=ri.receipt_no) where ri.receipt_no='14|0000001798';
update receipt_items ri set ri.date_received=(select r.date_received from receipts r where r.receipt_no=ri.receipt_no) where ri.receipt_no='14|0000001799';
update receipt_items ri set ri.date_received=(select r.date_received from receipts r where r.receipt_no=ri.receipt_no) where ri.receipt_no='14|0000001803';
update receipt_items ri set ri.date_received=(select r.date_received from receipts r where r.receipt_no=ri.receipt_no) where ri.receipt_no='14|0000001804';
update receipt_items ri set ri.date_received=(select r.date_received from receipts r where r.receipt_no=ri.receipt_no) where ri.receipt_no='14|0000001805';
update receipt_items ri set ri.date_received=(select r.date_received from receipts r where r.receipt_no=ri.receipt_no) where ri.receipt_no='14|0000001806';
update receipt_items ri set ri.date_received=(select r.date_received from receipts r where r.receipt_no=ri.receipt_no) where ri.receipt_no='16|0000001428';
update receipt_items ri set ri.date_received=(select r.date_received from receipts r where r.receipt_no=ri.receipt_no) where ri.receipt_no='23|0000001505';
update receipt_items ri set ri.date_received=(select r.date_received from receipts r where r.receipt_no=ri.receipt_no) where ri.receipt_no='23|0000001506';
update receipt_items ri set ri.date_received=(select r.date_received from receipts r where r.receipt_no=ri.receipt_no) where ri.receipt_no='23|0000001507';
update receipt_items ri set ri.date_received=(select r.date_received from receipts r where r.receipt_no=ri.receipt_no) where ri.receipt_no='23|0000001508';
update receipt_items ri set ri.date_received=(select r.date_received from receipts r where r.receipt_no=ri.receipt_no) where ri.receipt_no='23|0000001509';
update receipt_items ri set ri.date_received=(select r.date_received from receipts r where r.receipt_no=ri.receipt_no) where ri.receipt_no='23|0000001510';

