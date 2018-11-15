/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  Ronescape
 * Created: Nov 7, 2018
 */



insert into user_default_previlege_others(account,account_name,name)values('Transactions','Stock Transfer','Stock Transfer - Show Cost');
insert into user_default_previlege_others(account,account_name,name)values('Reports','Item Ledger','Item Ledger - Show Cost');


select transaction_no,count(*) as cnt from stock_transfers where  is_uploaded=0  group by transaction_no having(cnt>1) ;

select id,transaction_no,concat(from_branch,'-',from_location) as floc,concat(to_branch,'-',to_location) as tloc,status,is_uploaded from stock_transfers where transaction_no='9|10115';
select id,barcode,description,product_qty from stock_transfers_items where stock_transfer_id='9|10121';


update stock_transfers set status=1,is_uploaded=1 where transaction_no='9|10120';


/* Change Kabankalan Office Use branch id*/

update branch_locations set branch_id=10 where branch='Office use - Kabankalan' and location='Kabankalan City';
update inventory_barcodes set branch_code=10 where branch='Office use - Kabankalan' and location='Kabankalan City';
update stock_transfers set to_branch_id=10 where to_branch='Office use - Kabankalan';
update stock_transfers_items set to_branch_id=10 where to_branch='Office use - Kabankalan';

alter table prepaid_payments add refund int default 0;