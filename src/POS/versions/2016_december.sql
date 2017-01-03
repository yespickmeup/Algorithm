/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  synsoftech
 * Created: 12 27, 16
 */

alter table purchase_order_items add branch varchar(255);
alter table purchase_order_items add branch_id varchar(255);
alter table purchase_order_items add location varchar(255);
alter table purchase_order_items add location_id varchar(255);
