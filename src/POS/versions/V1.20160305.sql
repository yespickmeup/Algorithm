
update db_zamboanguita_quisil.inventory set selling_type=0;
update db_zamboanguita_quisil.inventory_barcodes set selling_type=0;

delete from  db_zamboanguita_quisil.sales;
delete from  db_zamboanguita_quisil.sale_items;
delete from  db_zamboanguita_quisil.sale_item_replacements;
update db_zamboanguita_quisil.inventory_barcodes set product_qty=0 where main_barcode='1000';
update db_zamboanguita_quisil.inventory_barcodes set product_qty=0 where main_barcode='1006';






