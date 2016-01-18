



/*  02/18/2015*/
alter table sale_item_replacements add reason text;
/* */







/*  02/07/2015 */
alter table adjustments add remarks text;
alter table adjustments add transaction_no varchar(100);
/*  */




alter table sales add addtl_amount double;
alter table sales add wtax double;

alter table sale_items add addtl_amount double;
alter table sale_items add wtax double;

alter table accounts_receivable_payments add tax_rate double;
alter table accounts_receivable_payments add tax_amount double;
update accounts_receivable_payments set tax_rate=0;
update accounts_receivable_payments set tax_amount=amount;


alter table sales add branch varchar(100);
alter table sales add branch_id varchar(100);
alter table sales add location varchar(100);
alter table sales add location_id varchar(100);
update sales set branch='Algorithm - Dgte',branch_id='9',location='Selling Area',location_id='14';


alter table disbursements add branch varchar(100);
alter table disbursements add branch_id varchar(100);
alter table disbursements add location varchar(100);
alter table disbursements add location_id varchar(100);
update disbursements set branch='Algorithm - Dgte',branch_id='9',location='Selling Area',location_id='14';


alter table prepaid_payments add branch varchar(100);
alter table prepaid_payments add branch_id varchar(100);
alter table prepaid_payments add location varchar(100);
alter table prepaid_payments add location_id varchar(100);
update prepaid_payments set branch='Algorithm - Dgte',branch_id='9',location='Selling Area',location_id='14';

alter table accounts_receivable_payments add branch varchar(100);
alter table accounts_receivable_payments add branch_id varchar(100);
alter table accounts_receivable_payments add location varchar(100);
alter table accounts_receivable_payments add location_id varchar(100);
update accounts_receivable_payments set branch='Algorithm - Dgte',branch_id='9',location='Selling Area',location_id='14';

alter table accounts_receivable add branch varchar(100);
alter table accounts_receivable add branch_id varchar(100);
alter table accounts_receivable add location varchar(100);
alter table accounts_receivable add location_id varchar(100);
update accounts_receivable set branch='Algorithm - Dgte',branch_id='9',location='Selling Area',location_id='14';

alter table cash_drawer add branch varchar(100);
alter table cash_drawer add branch_id varchar(100);
alter table cash_drawer add location varchar(100);
alter table cash_drawer add location_id varchar(100);
update cash_drawer set branch='Algorithm - Dgte',branch_id='9',location='Selling Area',location_id='14';

alter table cash_drawer_remittances add branch varchar(100);
alter table cash_drawer_remittances add branch_id varchar(100);
alter table cash_drawer_remittances add location varchar(100);
alter table cash_drawer_remittances add location_id varchar(100);
update cash_drawer_remittances set branch='Algorithm - Dgte',branch_id='9',location='Selling Area',location_id='14';

