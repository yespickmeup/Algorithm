

update receipts set receipt_no= CONCAT(branch_id,'|',receipt_no);
update receipt_items set receipt_no= CONCAT(location_id,'|',receipt_no);