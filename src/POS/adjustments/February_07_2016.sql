




select transaction_no,count(*) from stock_transfers group by transaction_no having count(*) > 1;


select stock_transfer_id,count(*) from stock_transfers_items group by stock_transfer_id limit 100,200;

select stock_transfer_id,count(*) from stock_transfers_items where stock_transfer_id='9|1450';




select stock_transfer_id,count(*) from stock_transfers_items group by stock_transfer_id;

having count(*) > 1;




