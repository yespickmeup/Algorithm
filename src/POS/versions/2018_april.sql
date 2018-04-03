/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  Guinness
 * Created: Apr 2, 2018
 */


alter table prepaid_payments add remarks varchar(500);

insert into user_default_previlege_others(account,account_name,name)values('Transactions','Prepaid Payments','Adjustment');