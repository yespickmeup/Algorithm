/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  User
 * Created: 09 1, 21
 */

alter table stock_transfers add service_id int;
alter table stock_transfers add service_trans_no varchar(255);
alter table stock_transfers add service_slip_no varchar(255);
alter table stock_transfers add service_by_id int;
alter table stock_transfers add service_by_name varchar(255);

alter table stock_transfers_items add service_id int;
alter table stock_transfers_items add service_trans_no varchar(255);
alter table stock_transfers_items add service_slip_no varchar(255);
alter table stock_transfers_items add service_by_id int;
alter table stock_transfers_items add service_by_name varchar(255);

alter table my_services_item_replacements_customers change description description varchar(500);






