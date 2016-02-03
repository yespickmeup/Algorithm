





update stock_transfers set

drop table if exists local_updates;



update accounts_receivable set ar_no= CONCAT(branch_id,'|',ar_no);
update charge_in_advance_items set ar_no= CONCAT(branch_code,'|',ar_no);
update accounts_receivable_payments set ar_no= CONCAT(branch_id,'|',ar_no);

update stock_transfers_items set at_branch='Algorithm - Kabankalan',at_branch_id='10',at_location='Selling Area',at_location_id='18' where stock_transfer_id='10|1328';
