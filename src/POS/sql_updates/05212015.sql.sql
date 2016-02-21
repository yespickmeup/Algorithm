select main_barcode,count(*) as total from inventory_barcodes where location_id=14  group by main_barcode,barcode HAVING COUNT(*) > 1;
update charge_in_advance_items set status=0;
update charge_in_advance_items_cancelled set status=0;
update sale_items si set si.status=(select s.status from sales s where s.sales_no=si.sales_no);





select id,main_barcode,count(*) as total from inventory_barcodes   where location_id=20 group by main_barcode,barcode HAVING COUNT(*) = 2;

delete from inventory_barcodes where location_id=25  group by main_barcode,barcode HAVING COUNT(*) = 2;  


delete from inventory_barcodes  where id IN (select i.id from  inventory_barcodes i where i.location_id=20  group by i.main_barcode,i.barcode HAVING COUNT(*) > 11);    

select main_barcode,count(*) as total from inventory_barcodes    group by main_barcode HAVING COUNT(*) = 10 ;

select count(id) from inventory_barcodes where location_id=25;

select (select msc.customer_no from my_services_customers msc where ms.customer_name = msc.customer_name limit 1) as id
,ms.customer_name,count(*) from my_services ms where ms.customer_name not like ''
 group by ms.customer_name order by count(*) desc limit 100;


select id,ms.customer_name,count(*) from my_services ms where ms.customer_name not like ''
 group by ms.customer_name order by count(*) desc limit 100;


