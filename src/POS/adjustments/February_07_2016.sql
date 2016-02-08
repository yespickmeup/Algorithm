
select transaction_no,count(*) from stock_transfers group by transaction_no having count(*) > 1;

