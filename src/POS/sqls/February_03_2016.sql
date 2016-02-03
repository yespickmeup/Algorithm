





update stock_transfers set

drop table if exists local_updates;



update accounts_receivable set ar_no= CONCAT(branch_id,'|',ar_no);
update charge_in_advance_items set ar_no= CONCAT(branch_code,'|',ar_no);
update accounts_receivable_payments set ar_no= CONCAT(branch_id,'|',ar_no);



