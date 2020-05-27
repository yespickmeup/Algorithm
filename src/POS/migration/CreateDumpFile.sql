/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  User
 * Created: 05 14, 20
 */

backup
mysqldump -u root -p --databases db_smis_santillan > db_smis_santillan.sql

Restore
mysql -u root -p db_smis_jeric_autoparts < db_smis_jeric.sql


create table migration_invoices (
id int auto_increment primary key
,invoice_no varchar(255)
,description varchar(255)
,price double
,cose double
);

create table migration_inventory (
,id int auto_increment primary key
,barcode varchar(255)
,inv_no varchar(255)
,description varchar(255)
);
