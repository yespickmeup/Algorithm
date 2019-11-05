/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  Ronescape
 * Created: Oct 7, 2019
 */




alter table sales add ref_or_no varchar(255) default '';
alter table sales add ref_si_no varchar(255) default '';
alter table sales add ref_cr_no varchar(255) default '';


select transaction_no,date_added,status,is_uploaded from stock_transfers
where transaction_no IN('9|12825','9|12818','9|12802','9|12790','9|12788','9|12785','9|12784','9|12758'
,'9|12757','9|12733','9|12732','9|12731','9|12727','9|12726','9|12725','9|12712','9|12711','9|12710','9|12708','9|12616');


update stock_transfers set date_added='2019-10-09 18:28:16' where 
transaction_no='9|12825' or 
transaction_no='9|12818' or 
transaction_no='9|12802' or 
transaction_no='9|12790' or 
transaction_no='9|12788' or 
transaction_no='9|12785' or 
transaction_no='9|12784' or 
transaction_no='9|12758' or 
transaction_no='9|12757' or 
transaction_no='9|12733' or 
transaction_no='9|12732' or 
transaction_no='9|12731' or 
transaction_no='9|12727' or 
transaction_no='9|12726' or 
transaction_no='9|12725' or 
transaction_no='9|12712' or 
transaction_no='9|12711' or 
transaction_no='9|12710' or 
transaction_no='9|12708' or 
transaction_no='9|12616' 
;

update stock_transfers_items set date_added='2019-10-09 18:28:16' where 
stock_transfer_id='9|12825' or 
stock_transfer_id='9|12818' or 
stock_transfer_id='9|12802' or 
stock_transfer_id='9|12790' or 
stock_transfer_id='9|12788' or 
stock_transfer_id='9|12785' or 
stock_transfer_id='9|12784' or 
stock_transfer_id='9|12758' or 
stock_transfer_id='9|12757' or 
stock_transfer_id='9|12733' or 
stock_transfer_id='9|12732' or 
stock_transfer_id='9|12731' or 
stock_transfer_id='9|12727' or 
stock_transfer_id='9|12726' or 
stock_transfer_id='9|12725' or 
stock_transfer_id='9|12712' or 
stock_transfer_id='9|12711' or 
stock_transfer_id='9|12710' or 
stock_transfer_id='9|12708' or 
stock_transfer_id='9|12616' 
;






