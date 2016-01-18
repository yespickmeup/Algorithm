
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



UPDATE stock_transfers SET transaction_no = CONCAT(to_location_id,'|', transaction_no);
UPDATE stock_transfers_items SET stock_transfer_id = CONCAT(location_id,'|', stock_transfer_id);

UPDATE stock_transfers SET transaction_no = CONCAT('9|', transaction_no);
UPDATE stock_transfers_items SET stock_transfer_id = CONCAT('9|', stock_transfer_id);