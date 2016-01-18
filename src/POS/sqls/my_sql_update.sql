
/* 03/05/2015 */


insert into user_default_previleges(account,name)values('Accounting','Charge in Advance');

drop table if exists charge_in_advance;
create table charge_in_advance(
id int auto_increment primary key
,customer_id varchar(100)
,customer_name varchar(100)
,ar_id varchar(100)
,ar_no varchar(100)
,date_applied date
,reference_no varchar(100)
,soa_type varchar(100)
,soa_type_id varchar(100)
,remarks text
,status int
,user_id varchar(100)
,user_screen_name varchar(100)
,branch varchar(100)
,branch_id varchar(100)
,location varchar(100)
,location_id varchar(100)
);

drop table if exists charge_in_advance_items;
create table charge_in_advance_items(
id int auto_increment primary key
,customer_id varchar(100)
,customer_name varchar(100)
,ar_id varchar(100)
,ar_no varchar(100)
,date_applied date
,reference_no varchar(100)
,soa_type varchar(100)
,soa_type_id varchar(1000)
,user_screen_name varchar(100)
,user_id varchar(100)
,remarks varchar(100)
,item_code varchar(100)
,barcode varchar(100)
,description varchar(100)
,generic_name varchar(100)
,item_type varchar(100)
,supplier_name varchar(100)
,supplier_id varchar(100)
,serial_no varchar(100)
,product_qty double
,unit varchar(100)
,conversion double
,selling_price double
,date_added datetime
,status int
,is_vatable int
,selling_type int
,discount_name varchar(100)
,discount_rate double
,discount_amount double
,discount_customer_name varchar(100)
,discount_customer_id varchar(100)
,branch varchar(100)
,branch_code varchar(100)
,location varchar(100)
,location_id varchar(100)
,category varchar(100)
,category_id varchar(100)
,classification varchar(100)
,classification_id varchar(100)
,sub_classification varchar(100)
,sub_classification_id varchar(100)
,brand varchar(100)
,brand_id varchar(100)
,model varchar(100)
,model_id varchar(100)
,addtl_amount double
,wtax double
);


drop table if exists charge_in_advance_cancelled_items;
create table charge_in_advance_cancelled_items(
id int auto_increment primary key
,customer_id varchar(100)
,customer_name varchar(100)
,ar_id varchar(100)
,ar_no varchar(100)
,date_applied date
,reference_no varchar(100)
,soa_type varchar(100)
,soa_type_id varchar(1000)
,user_screen_name varchar(100)
,user_id varchar(100)
,remarks varchar(100)
,item_code varchar(100)
,barcode varchar(100)
,description varchar(100)
,generic_name varchar(100)
,item_type varchar(100)
,supplier_name varchar(100)
,supplier_id varchar(100)
,serial_no varchar(100)
,product_qty double
,unit varchar(100)
,conversion double
,selling_price double
,date_added datetime
,status int
,is_vatable int
,selling_type int
,discount_name varchar(100)
,discount_rate double
,discount_amount double
,discount_customer_name varchar(100)
,discount_customer_id varchar(100)
,branch varchar(100)
,branch_code varchar(100)
,location varchar(100)
,location_id varchar(100)
,category varchar(100)
,category_id varchar(100)
,classification varchar(100)
,classification_id varchar(100)
,sub_classification varchar(100)
,sub_classification_id varchar(100)
,brand varchar(100)
,brand_id varchar(100)
,model varchar(100)
,model_id varchar(100)
,addtl_amount double
,wtax double
);



alter table customers add unique(customer_no);
alter table accounts_receivable add unique(ar_no);
 
/* 02/25/2015 */
insert into user_default_previleges(account,name)values
('Administrator','Update CashDrawer');



/* 02/20/2015*/
drop table if exists orders;
create table orders(
id int auto_increment primary key
,sales_no varchar(100)
,date_added datetime
,user_screen_name varchar(100)
,user_id varchar(100)
,session_no varchar(100)
,remarks varchar(100)
,gross_amount double
,amount_due double
,status int
,sales_type int
,line_discount double 
,customer_id varchar(100)
,customer_name varchar(100)
,discount_name varchar(100)
,discount_rate double
,discount_amount double
,discount_customer_name varchar(100)
,discount_customer_id varchar(100)
,charge_type varchar(100)
,charge_type_id varchar(100)
,charge_reference_no varchar(100)
,charge_customer_name varchar(100)
,charge_customer_id varchar(100)
,charge_amount double
,check_bank varchar(100)
,check_no varchar(100)
,check_amount double
,check_holder varchar(100)
,check_date date
,credit_card_type varchar(100)
,credit_card_rate double
,credit_card_amount double
,credit_card_no varchar(100)
,credit_card_holder varchar(100)
,credit_card_approval_code varchar(100)
,gift_certificate_from varchar(100)
,gift_certificate_description varchar(100)
,gift_certificate_no varchar(100)
,gift_certificate_amount double
,prepaid_customer_name varchar(100)
,prepaid_customer_id varchar(100)
,prepaid_amount double
,addtl_amount double
,wtax double
,branch varchar(100)
,branch_id varchar(100)
,location varchar(100)
,location_id varchar(100)
);


drop table if exists order_items;
create table order_items(
id int auto_increment primary key
,sales_no varchar(100)
,item_code varchar(100)
,barcode varchar(100)
,description varchar(100)
,generic_name varchar(100)
,item_type varchar(100)
,supplier_name varchar(100)
,supplier_id varchar(100)
,serial_no varchar(100)
,product_qty double
,unit varchar(100)
,conversion double
,selling_price double
,date_added datetime
,user_id varchar(100)
,user_screen_name varchar(100)
,status int
,is_vatable int
,selling_type int
,discount_name varchar(100)
,discount_rate double
,discount_amount double
,discount_customer_name varchar(100)
,discount_customer_id varchar(100)
,branch varchar(100)
,branch_code varchar(100)
,location varchar(100)
,location_id varchar(100)
,category varchar(100)
,category_id varchar(100)
,classification varchar(100)
,classification_id varchar(100)
,sub_classification varchar(100)
,sub_classification_id varchar(100)
,brand varchar(100)
,brand_id varchar(100)
,model varchar(100)
,model_id varchar(100)
,addtl_amount double
,wtax double
);


alter table orders ADD UNIQUE(sales_no);
/**/




/* 02/19/2015*/

create table cash_drawer_last_remittances(
id int auto_increment primary key
,user_id varchar(100)
,user_screen_name varchar(100)
,date_added datetime
,status int
,amount double
,branch varchar(100)
,branch_id varchar(100)
,location varchar(100)
,location_id varchar(100)
);

/* */

alter table cash_drawer add user_id varchar(100);
alter table cash_drawer add user_screen_name varchar(100);

update cash_drawer cd set
cd.user_id=(select u.id from users u where cd.user_name=u.user_name)
,cd.user_screen_name=(select u.screen_name from users u where cd.user_name=u.user_name)
;

update cash_drawer set
branch='Algorithm - Dgte'
,branch_id='9'
,location='Selling Area'
,location_id='14'
;
/* */
