/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  Guinness
 * Created: Mar 5, 2018
 */







delete from user_default_previleges;


/* Transactions  */
insert into user_default_previleges(account,name)values('Transactions','Accounts Payable');
insert into user_default_previleges(account,name)values('Transactions','Accounts Payable Payments');
insert into user_default_previleges(account,name)values('Transactions','Accounts Receivable');
insert into user_default_previleges(account,name)values('Transactions','Accounts Receivable Payments');
insert into user_default_previleges(account,name)values('Transactions','Borrower Slip');
insert into user_default_previleges(account,name)values('Transactions','Charge In Advance');
insert into user_default_previleges(account,name)values('Transactions','Conversion');
insert into user_default_previleges(account,name)values('Transactions','Disbursements');
insert into user_default_previleges(account,name)values('Transactions','Inventory Adjuster');
insert into user_default_previleges(account,name)values('Transactions','Inventory Encoding');
insert into user_default_previleges(account,name)values('Transactions','Inventory Replenishment');
insert into user_default_previleges(account,name)values('Transactions','Other Adjustments');
insert into user_default_previleges(account,name)values('Transactions','Prepaid Payments');
insert into user_default_previleges(account,name)values('Transactions','Price Inquiry');
insert into user_default_previleges(account,name)values('Transactions','Purchase Order');
insert into user_default_previleges(account,name)values('Transactions','Receipts');
insert into user_default_previleges(account,name)values('Transactions','Requisition Slip');
insert into user_default_previleges(account,name)values('Transactions','Return from Customer');
insert into user_default_previleges(account,name)values('Transactions','Return Exchange');
insert into user_default_previleges(account,name)values('Transactions','Return to Supplier');
insert into user_default_previleges(account,name)values('Transactions','RMA');
insert into user_default_previleges(account,name)values('Transactions','Sales');
insert into user_default_previleges(account,name)values('Transactions','Services');
insert into user_default_previleges(account,name)values('Transactions','Stock Transfer');


insert into user_default_previleges(account,name)values('Maintenance','Backup');/**/
insert into user_default_previleges(account,name)values('Maintenance','Banks');
insert into user_default_previleges(account,name)values('Maintenance','Branches');
insert into user_default_previleges(account,name)values('Maintenance','Branch Locations');
insert into user_default_previleges(account,name)values('Maintenance','Categories');
insert into user_default_previleges(account,name)values('Maintenance','Credit Cards');
insert into user_default_previleges(account,name)values('Maintenance','Customers');
insert into user_default_previleges(account,name)values('Maintenance','Disbursements');
insert into user_default_previleges(account,name)values('Maintenance','Discounts');
insert into user_default_previleges(account,name)values('Maintenance','Item Barcodes');
insert into user_default_previleges(account,name)values('Maintenance','Item Maintenance');
insert into user_default_previleges(account,name)values('Maintenance','Preferences');
insert into user_default_previleges(account,name)values('Maintenance','Price Update');
insert into user_default_previleges(account,name)values('Maintenance','Services');
insert into user_default_previleges(account,name)values('Maintenance','Suppliers');
insert into user_default_previleges(account,name)values('Maintenance','Unit of Measure');
insert into user_default_previleges(account,name)values('Maintenance','Users');


insert into user_default_previleges(account,name)values('Reports','AR Items');
insert into user_default_previleges(account,name)values('Reports','Barcodes');
insert into user_default_previleges(account,name)values('Reports','BIR');
insert into user_default_previleges(account,name)values('Reports','Cashier Report');
insert into user_default_previleges(account,name)values('Reports','Customers');
insert into user_default_previleges(account,name)values('Reports','Inventory Count');
insert into user_default_previleges(account,name)values('Reports','Item Ledger');
insert into user_default_previleges(account,name)values('Reports','Re-Order Level');
insert into user_default_previleges(account,name)values('Reports','Services');
insert into user_default_previleges(account,name)values('Reports','Suppliers');
insert into user_default_previleges(account,name)values('Reports','Stock Take');



drop table if exists user_default_previlege_others;
create table user_default_previlege_others(
id int auto_increment primary key
,account varchar(255)
,account_name varchar(255)
,name varchar(255)
);

drop table if exists user_previlege_others;
create table user_previlege_others(
id int auto_increment primary key
,account varchar(255)
,account_name varchar(255)
,name varchar(255)
,user_id varchar(255)
,user_name varchar(255)
);

insert into user_default_previlege_others(account,account_name,name)values('Transactions','Sales','Cashcount');
insert into user_default_previlege_others(account,account_name,name)values('Transactions','Sales','Choose Location');
insert into user_default_previlege_others(account,account_name,name)values('Transactions','Sales','Discount-Item');
insert into user_default_previlege_others(account,account_name,name)values('Transactions','Sales','Discount-Amount');
insert into user_default_previlege_others(account,account_name,name)values('Transactions','Sales','Sales by Item');
insert into user_default_previlege_others(account,account_name,name)values('Transactions','Sales','Return Exchange');
insert into user_default_previlege_others(account,account_name,name)values('Transactions','Sales','Remittance');
insert into user_default_previlege_others(account,account_name,name)values('Transactions','Sales','Sales Ledger');
insert into user_default_previlege_others(account,account_name,name)values('Transactions','Sales','Sales Summary');
insert into user_default_previlege_others(account,account_name,name)values('Transactions','Sales','Sales Transactions');
insert into user_default_previlege_others(account,account_name,name)values('Transactions','Sales','Void');

insert into user_default_previlege_others(account,account_name,name)values('Maintenance','Sales','Customers AR');
insert into user_default_previlege_others(account,account_name,name)values('Maintenance','Sales','Disbursement Categories');



delete from user_previleges;




--         String wheree = " where user_id='" + MyUser.getUser_id() + "' and previledge like '" + "Accounts Payable - (Add)" + "' limit 1";
--         List<S1_user_previleges.to_user_previleges> privileges = S1_user_previleges.ret_data(wheree);
--         if (privileges.isEmpty()) {
--             Alert.set(0, "Privilege not added!");
--             return;
--         }
--
--
--
--         String wheree = " where user_id='" + MyUser.getUser_id() + "' and name like '" + "Choose Location - (View)" + "' limit 1";
--         List<User_previlege_others.to_user_previlege_others> datas = User_previlege_others.ret_data(wheree);
--         if (privileges.isEmpty()) {
--             Alert.set(0, "Privilege not added!");
--             return;
--         }








