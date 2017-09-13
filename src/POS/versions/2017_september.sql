/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  Guinness
 * Created: Sep 13, 2017
 */

select remarks from stock_transfers where to_location_id=10 group by remarks order by remarks asc;

update stock_transfers set remarks = concat('Snacks: ',remarks) where remarks = '' and to_location_id=10;
update stock_transfers set remarks = concat('Donation: ',remarks) where remarks = '' and to_location_id=10;

update stock_transfers set remarks = 'Snacks: to R.M.V. and to the farm.' where remarks like '%Snacks to R.M.V. and to the farm.%' and to_location_id=10;
update stock_transfers set remarks = 'Snacks: 1 gallon to sir Raul.' where remarks like '%1 gallon to sir Raul.%' and to_location_id=10;

update stock_transfers set remarks = 'Donation: Basura' where remarks like 'Basura' and to_location_id=10;
update stock_transfers set remarks = 'Donation: Bian Yek' where remarks like '%Bian Yek%' and to_location_id=10;
update stock_transfers set remarks = 'Donation: Columbia' where remarks like 'Columbia' and to_location_id=10;
update stock_transfers set remarks = 'Donation: Customers' where remarks like 'Customer\'s donation.' and to_location_id=10;
update stock_transfers set remarks = 'Donation: for garbage man' where remarks like 'Doantion for garbage man.' and to_location_id=10;
update stock_transfers set remarks = 'Donation: Others' where remarks like 'donate others' and to_location_id=10;
update stock_transfers set remarks = 'Donation: ' where remarks like 'Donation' and to_location_id=10;
update stock_transfers set remarks = 'Donation: for Customer.' where remarks like 'Donation for the customer.' and to_location_id=10;
update stock_transfers set remarks = 'Snacks: Drinking water in the farm.' where remarks like 'Drinking water in the farm.' and to_location_id=10;
update stock_transfers set remarks = 'Snacks: Drinking water to the farm.' where remarks like 'Drinking water to the farm.' and to_location_id=10;
update stock_transfers set remarks = 'Snacks: Farm' where remarks like 'farm' and to_location_id=10;
update stock_transfers set remarks = 'Donation: For 96.7 Bai  Radio DYEM-FM-donation' where remarks like 'For 96.7 Bai  Radio DYEM-FM' and to_location_id=10;
update stock_transfers set remarks = 'Donation: For 96.7 Bai Radio DYEM-FM' where remarks like 'For 96.7 Bai Radio DYEM-FM' and to_location_id=10;
update stock_transfers set remarks = 'Donation: For Basurero' where remarks like 'For Basurero' and to_location_id=10;
update stock_transfers set remarks = 'Donation: ' where remarks like 'For donation.' and to_location_id=10;
update stock_transfers set remarks = 'Snacks: Farm' where remarks like 'For Farm' and to_location_id=10;
update stock_transfers set remarks = 'Snacks: Farm' where remarks like 'for farm' and to_location_id=10;
update stock_transfers set remarks = 'Snacks: For sir Raul snacks.' where remarks like 'For sir Raul snacks.' and to_location_id=10;
update stock_transfers set remarks = 'Snacks: Farm' where remarks like 'For snacks in the farm' and to_location_id=10;
update stock_transfers set remarks = 'Snacks: softdrinks requested by sir Raul.' where remarks like 'softdrinks requested by sir Raul.' and to_location_id=10;

update stock_transfers set remarks = 'Donation: For Matiao and Payalin' where remarks like 'For Matiao and Payalin' and to_location_id=10;
update stock_transfers set remarks = 'Donation: For homeless person begging for food.' where remarks like 'For homeless person begging for food.' and to_location_id=10;
update stock_transfers set remarks = 'Donation: For the garbage men.' where remarks like 'For the garbage men.' and to_location_id=10;
update stock_transfers set remarks = 'Donation: For the homeless person.' where remarks like '%For the homeless person.%' and to_location_id=10;
update stock_transfers set remarks = 'Donation: For Traffic Snacks' where remarks like 'For Traffic Snacks' and to_location_id=10;
update stock_transfers set remarks = 'Donation: For Garbage man' where remarks like '%to the garbage man.%' and to_location_id=10;
update stock_transfers set remarks = 'Donation: For traffic aid' where remarks like '%For traffic aid%' and to_location_id=10;
update stock_transfers set remarks = 'Donation: For Traffic Dumaguete City' where remarks like '%For Traffic Dumaguete City%' and to_location_id=10;
'
update stock_transfers set remarks = 'Snacks: For Sir Raul in the farm' where remarks like 'Snack to Sir Raul in the farm' and to_location_id=10;
update stock_transfers set remarks = 'Snacks: For EPV' where remarks like 'snack-epv' and to_location_id=10;
update stock_transfers set remarks = 'Snacks: ' where remarks like 'snacks' and to_location_id=10;

update stock_transfers set remarks = 'Snacks: Farm' where remarks like 'farm' and to_location_id=10;
update stock_transfers set remarks = 'Snacks: Farm' where remarks like 'For Farm' and to_location_id=10;

update stock_transfers set remarks = 'Snacks: Customers' where remarks like 'to the customer\'s snacks.' and to_location_id=10;'
update stock_transfers set remarks = 'Snacks: ' where remarks like '' and to_location_id=10;


