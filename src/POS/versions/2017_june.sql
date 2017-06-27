/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  Guinness
 * Created: Jun 3, 2017
 */


select s.customer_no,s.customer_name,ifnull((select sum(r.gross_total-r.discount)
from receipts r where r.supllier_id=s.customer_no),0) as amount
from suppliers s;


update stock_transfers_items set date_added='2017-05-01 00:00:01' where date_added='2017-05-01 00:00:00';

delete from accounts_payable;
update suppliers set balance=0;

update encoding_inventory set date_added='2017-05-01 00:00:01' where date_added='2017-05-01 00:00:00';

update sales set date_added='2017-05-01 00:00:01' where date_added='2017-05-01 00:00:00';
update sale_items set date_added='2017-05-01 00:00:01' where date_added='2017-05-01 00:00:00';


drop table if exists other_adjustments;
create table other_adjustments(
id int auto_increment primary key
,user_id varchar(255)
,user_screen_name varchar(255)
,date_added datetime
,adjustment_date datetime
,adjustment_type int
,remarks varchar(255)
,status int
,barcode varchar(255)
,description text
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
,unit text
,barcodes varchar(255)
,main_barcode varchar(255)
,previous_qty double
,qty double
,cost double
,selling_price double
,branch varchar(255)
,branch_id varchar(255)
,location varchar(255)
,location_id varchar(255)
);

insert into user_default_previleges(account,name)values('Administrator','Other Adjustments');