/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  Ronescape
 * Created: Mar 4, 2020
 */



/*  update refreshment items */



mysqldump -u user -h localhost --no-data -p database > database.sql

/* Abiera */
update inventory set allow_negative_inventory=1,auto_order=0,show_to_sales=1;
update inventory_barcodes set allow_negative_inventory=1,auto_order=0,show_to_sales=1;

