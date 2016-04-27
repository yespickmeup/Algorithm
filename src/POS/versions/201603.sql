

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
,receipt_printing_enabled  int
,receipt_printer_show_dialog int
,kitchen_printing_enable int
,allow_negative_inventory int
,is_server int
,location varchar(255)
,receipt_printing_enabled2  int
,drawer varchar(255)
,developer varchar(255)
,developer_address varchar(255)
,developer_tin_no varchar(255)
,developer_accreditation_no varchar(255)
,developer_accreditation_date varchar(255)
,developer_contact_no varchar(255)
,module_software_type varchar(255)
,module_accounts_payable int
,module_accounts_receivable int
,module_services int
,module_prepayments int
,module_requisition_slip int
,module_charge_in_advance int
);

insert into settings(company_name,company_address,company_operated_by,company_slogan,company_contact_no,company_fax_no,company_email_address
,bir_serial_no,bir_permit_no,bir_accreditation_no,bir_tin,bir_machine_no,bir_min_no,bir_business_type,bir_vat_percent,bir_receipt_footer
,bir_invoice_footer,receipt_printing_enabled,receipt_printer_show_dialog,kitchen_printing_enable,allow_negative_inventory,is_server,location
,receipt_printing_enabled2,drawer,developer,developer_address,developer_tin_no,developer_accreditation_no,developer_accreditation_date,developer_contact_no
,module_software_type,module_accounts_payable,module_accounts_receivable,module_services,module_prepayments,module_requisition_slip,module_charge_in_advance)
values(
'','','','','','',''
,'','','','','','','','',''
,'',0,0,0,0,0,'',0,'','','','','','','',0,0,0,0,0,0,0);
/* 

*/
drop table if exists user_logs;
create table user_logs(
id int auto_increment primary key
,user_id varchar(255)
,user_screen_name varchar(255)
,ip_address varchar(255)
,created_at datetime
,updated_at datetime
,created_by varchar(255)
,updated_by varchar(255)
);

