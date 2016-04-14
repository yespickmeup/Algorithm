

/* 03/28/2016 */

insert into user_default_previleges(account,name)
values
('Administrator','BIR');

drop table if exists terminals;
create table terminals(
id int auto_increment primary key
,terminal varchar(255)
,ip_address varchar(255)
,branch varchar(255)
,branch_id varchar(255)
,location varchar(255)
,location_id varchar(255)
,created_at datetime
,updated_at datetime
,created_by varchar(255)
,updated_by varchar(255)
,status int
);

insert into user_default_previleges(account,name)
values
('Administrator','Terminals');

drop table if exists settings;
create table settings(
id int auto_increment primary key
,company_name varchar(255)
,company_address varchar(255)
,company_operated_by varchar(255)
,company_slogan varchar(255)
,company_contact_no varchar(255)
,company_fax_no varchar(255)
,company_email_address varchar(255)
,bir_serial_no varchar(255)
,bir_permit_no varchar(255)
,bir_accreditation_no varchar(255)
,bir_tin varchar(255)
,bir_machine_no varchar(255)
,bir_min_no varchar(255)
,bir_business_type varchar(255)
,bir_vat_percent varchar(255)
,bir_receipt_footer varchar(255)
,bir_invoice_footer varchar(255)
,receipt_printing_enabled  varchar(255)
,receipt_printer_show_dialog varchar(255)
,kitchen_printing_enable varchar(255)
,allow_negative_inventory varchar(255)
,is_server varchar(255)
,location varchar(255)

);


/* 

*/