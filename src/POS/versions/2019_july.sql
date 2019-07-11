/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  Ronescape
 * Created: Jul 10, 2019
 */

drop table if exists sale_tips;
create table sale_tips(
id int auto_increment primary key
,sales_no varchar(255)
,date_added datetime
,user_screen_name varchar(255)
,user_id varchar(255)
,tip double
,prepaid_customer_name varchar(255) 
,prepaid_customer_id varchar(255) 
,prepaid_amount double
,charge_reference_no varchar(255)
,charge_ar_no varchar(255)
,charge_type varchar(255)
,charge_customer_name varchar(255)
,charge_customer_id varchar(255)
,charge_amount double
,charge_days int
,branch varchar(255)
,branch_id varchar(255)
,location varchar(255)
,location_id varchar(255)
);