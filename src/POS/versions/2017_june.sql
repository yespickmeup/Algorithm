/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  Guinness
 * Created: Jun 3, 2017
 */


select s.customer_no,s.customer_name,ifnull((select sum(r.gross_total-r.discount)
from receipts r where r.supllier_id=s.customer_no),0) as amount
from suppliers s;


update stock_transfers_items set date_added='2017-05-01 00:00:01' where date_added='2017-05-01 00:00:00';

delete from accounts_payable;
update suppliers set balance=0;

update encoding_inventory set date_added='2017-05-01 00:00:01' where date_added='2017-05-01 00:00:00';

