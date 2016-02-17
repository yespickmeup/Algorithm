


/* a */
update inventory_replenishment_items set inventory_replenishment_no='14|000000000004' where inventory_replenishment_no='14|14|000000000004';
update inventory_replenishment_items set inventory_replenishment_no='14|000000000005' where inventory_replenishment_no='14|14|000000000005';
update inventory_replenishment_items set inventory_replenishment_no='15|000000000001' where inventory_replenishment_no='15|15|000000000001';
update inventory_replenishment_items set inventory_replenishment_no='16|000000000002' where inventory_replenishment_no='16|16|000000000002';
update inventory_replenishment_items set inventory_replenishment_no='20|000000000003' where inventory_replenishment_no='20|20|000000000003';
update inventory_replenishment_items set inventory_replenishment_no='22|000000000007' where inventory_replenishment_no='22|22|000000000007';
update inventory_replenishment_items set inventory_replenishment_no='23|000000000006' where inventory_replenishment_no='23|23|000000000006';
delete from inventory_replenishments where inventory_replenishment_no='000000000008';

delete from inventory_replenishment_items;
delete from inventory_replenishments where inventory_replenishment_no='14|000000000005';


