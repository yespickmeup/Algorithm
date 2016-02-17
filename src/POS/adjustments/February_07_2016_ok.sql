




select transaction_no,count(*) from stock_transfers group by transaction_no having count(*) > 1;
select stock_transfer_id,count(*) from stock_transfers_items group by stock_transfer_id limit 100,200;
select stock_transfer_id,count(*) from stock_transfers_items where stock_transfer_id='9|1450';
select stock_transfer_id,count(*) from stock_transfers_items group by stock_transfer_id;
having count(*) > 1;


update stock_transfers set transaction_no='9|1510' where transaction_no='9|1520' ;
update stock_transfers_items set stock_transfer_id='9|1510' where stock_transfer_id='9|1520';

update stock_transfers set transaction_no='9|1511' where transaction_no='9|1521' ;
update stock_transfers_items set stock_transfer_id='9|1511' where stock_transfer_id='9|1521';

update stock_transfers set transaction_no='9|1512' where transaction_no='9|1522' ;
update stock_transfers_items set stock_transfer_id='9|1512' where stock_transfer_id='9|1522';

update stock_transfers set transaction_no='9|1513' where transaction_no='9|1523' ;
update stock_transfers_items set stock_transfer_id='9|1513' where stock_transfer_id='9|1523';

update stock_transfers set transaction_no='9|1514' where transaction_no='9|1524' ;
update stock_transfers_items set stock_transfer_id='9|1514' where stock_transfer_id='9|1524';



update stock_transfers_items set stock_transfer_id='9|1503' where stock_transfer_id='9|1329';
update stock_transfers_items set stock_transfer_id='9|1504' where stock_transfer_id='9|1330';
update stock_transfers_items set stock_transfer_id='9|1505' where stock_transfer_id='9|1331';
update stock_transfers_items set stock_transfer_id='9|1506' where stock_transfer_id='9|1332';
update stock_transfers_items set stock_transfer_id='9|1507' where stock_transfer_id='9|1333';
update stock_transfers_items set stock_transfer_id='9|1508' where stock_transfer_id='9|1334';

update stock_transfers_items set stock_transfer_id='9|1509' where stock_transfer_id='9|1335';

update stock_transfers_items set stock_transfer_id='9|1510' where stock_transfer_id='9|1336';
update stock_transfers_items set stock_transfer_id='9|1511' where stock_transfer_id='9|1337';
update stock_transfers_items set stock_transfer_id='9|1512' where stock_transfer_id='9|1338';
update stock_transfers_items set stock_transfer_id='9|1513' where stock_transfer_id='9|1339';
update stock_transfers_items set stock_transfer_id='9|1514' where stock_transfer_id='9|1340';
update stock_transfers_items set stock_transfer_id='9|1515' where stock_transfer_id='9|1341';
update stock_transfers_items set stock_transfer_id='9|1516' where stock_transfer_id='9|1342';
update stock_transfers_items set stock_transfer_id='9|1517' where stock_transfer_id='9|1343';
update stock_transfers_items set stock_transfer_id='9|1518' where stock_transfer_id='9|1345';



