/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  Guinness
 * Created: Feb 5, 2018
 */

/* for droplet database  128.199.80.53 */

drop table if exists synch_stock_transfers;
create table synch_stock_transfers(
id int auto_increment  primary key
,stock_transfer_no varchar(255)
,created_at datetime
,updated_at datetime
,created_by varchar(255)
,updated_by varchar(255)
,at_branch varchar(255)
,at_branch_id varchar(255)
,at_location varchar(255)
,at_location_id varchar(255)
,from_branch varchar(255)
,from_branch_id varchar(255)
,from_location varchar(255)
,from_location_id varchar(255)
,to_branch varchar(255)
,to_branch_id varchar(255)
,to_location varchar(255)
,to_location_id varchar(255)
,status int
);

-- db_smis_kabankalan_01_03_2017
alter table stock_transfers add is_uploaded int default 0;
alter table stock_transfers_items add is_uploaded int default 0;

CREATE USER 'smis2'@'%' IDENTIFIED BY 'nopassword101';
CREATE USER 'smis'@'%' IDENTIFIED BY 'nopassword101';

GRANT ALL PRIVILEGES ON * . * TO 'smis'@'%';
GRANT ALL PRIVILEGES ON * . * TO 'smis2'@'%';
flush privileges;


DROP USER 'smis'@'localhost';