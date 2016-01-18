




alter table customers add branch varchar(255);
alter table customers add branch_id varchar(255);
alter table customers add location varchar(255);
alter table customers add location_id varchar(255);
update customers set branch='Algorithm - Dgte', branch_id='9', location='Selling Area', location_id='14';


update customers set customer_no= CONCAT(branch_id,'|',customer_no);
update accounts_receivable set customer_id= CONCAT(branch_id,'|',customer_id);
update accounts_receivable_payments set customer_id= CONCAT(branch_id,'|',customer_id);
update charge_in_advance_cancelled_items set customer_id= CONCAT(branch_code,'|',customer_id);
update charge_in_advance_items set customer_id= CONCAT(branch_code,'|',customer_id);

update my_services_customers set customer_no= CONCAT(branch_id,'|',customer_no);



alter table stock_transfers add at_branch varchar(255);
alter table stock_transfers add at_branch_id varchar(255);
alter table stock_transfers add at_location varchar(255);
alter table stock_transfers add at_location_id varchar(255);
update stock_transfers set at_branch='Algorithm - Dgte', at_branch_id='9', at_location='Selling Area', at_location_id='14';
update stock_transfers set transaction_no= CONCAT(at_branch_id,'|',transaction_no);


alter table stock_transfers_items add at_branch varchar(255);
alter table stock_transfers_items add at_branch_id varchar(255);
alter table stock_transfers_items add at_location varchar(255);
alter table stock_transfers_items add at_location_id varchar(255);
update stock_transfers_items set at_branch='Algorithm - Dgte', at_branch_id='9', at_location='Selling Area', at_location_id='14';
update stock_transfers_items set stock_transfer_id= CONCAT(at_branch_id,'|',stock_transfer_id);

drop table if exists branch_local_uploads;
create table branch_local_uploads(
id int auto_increment primary key
,replenishments longblob
,inventory_counts longblob
,adjustments longblob
,stock_transfers longblob
,receipts longblob
,sales longblob
,returned_items longblob
,charged_items longblob
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









