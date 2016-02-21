
alter table stock_transfers_items add to_branch varchar(100);
alter table stock_transfers_items add to_branch_id varchar(100);
alter table stock_transfers_items add to_location varchar(100);
alter table stock_transfers_items add to_location_id varchar(100);

update stock_transfers_items i set
i.to_branch=(select s.to_branch from stock_transfers s where s.transaction_no=i.stock_transfer_id)
,i.to_branch_id=(select s.to_branch_id from stock_transfers s where s.transaction_no=i.stock_transfer_id)
,i.to_location=(select s.to_location from stock_transfers s where s.transaction_no=i.stock_transfer_id)
,i.to_location_id=(select s.to_location_id from stock_transfers s where s.transaction_no=i.stock_transfer_id)
;


create table adjustments(
id int auto_increment primary key
,item_code varchar(100)
,barcode varchar(100)
,description varchar(100)
,qty double
,new_qty double
,is_add int
,date_added datetime
,status int
,user_id varchar(100)
,user_screen_name varchar(100)
);