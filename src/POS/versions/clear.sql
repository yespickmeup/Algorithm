/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  Guinness
 * Created: Apr 19, 2017
 */

delete from accounts_payable;
delete from accounts_payable_payments;
delete from accounts_receivable;
delete from accounts_receivable_payments;
delete from adjustments;
delete from borrower_slips;
delete from borrower_slip_items;
delete from cash_drawer;
delete from cash_drawer_checks;
delete from cash_drawer_cheques;
delete from cash_drawer_credit_cards;
delete from cash_drawer_expenses;
delete from cash_drawer_gift_certificates;
delete from cash_drawer_last_remittances;
delete from cash_drawer_prepaids;
delete from cash_drawer_remittances;
delete from cash_drawer_tips;
delete from charge_in_advance;
delete from charge_in_advance_cancelled_items;
delete from charge_in_advance_items;
delete from charge_payments;
delete from charge_payment_items;
delete from conversions;
delete from conversion_items;
delete from disbursements;
delete from encoding_inventory;
delete from orders;
delete from order_items;
delete from prepaid_payments;
delete from purchase_orders;
delete from purchase_order_items;
delete from receipts;
delete from receipt_items;
delete from sales;
delete from sale_items;
delete from sale_item_replacements;
delete from stock_transfers;
delete from stock_transfers_items;
delete from user_logs;
delete from voids;
delete from void_items;
update customers set balance=0,prepaid=0;
update inventory_barcodes set product_qty=0;


