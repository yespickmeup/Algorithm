/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  Ronescape
 * Created: Apr 3, 2019
 */


alter table accounts_receivable_payments add retention double default 0;
alter table accounts_receivable_payments add business_tax double default 0;


