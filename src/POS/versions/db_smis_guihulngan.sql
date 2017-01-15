-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.5.15


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema db_smis_siaton
--

CREATE DATABASE IF NOT EXISTS db_smis_siaton;
USE db_smis_siaton;

--
-- Definition of table `accounts_payable`
--

DROP TABLE IF EXISTS `accounts_payable`;
CREATE TABLE `accounts_payable` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `customer_id` varchar(500) DEFAULT NULL,
  `customer_name` varchar(500) DEFAULT NULL,
  `ar_no` varchar(500) DEFAULT NULL,
  `date_added` datetime DEFAULT NULL,
  `user_name` varchar(500) DEFAULT NULL,
  `amount` double DEFAULT NULL,
  `discount_amount` double DEFAULT NULL,
  `discount_rate` double DEFAULT NULL,
  `discount` varchar(500) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `term` double DEFAULT NULL,
  `date_applied` date DEFAULT NULL,
  `paid` double DEFAULT NULL,
  `date_paid` date DEFAULT NULL,
  `remarks` varchar(500) DEFAULT NULL,
  `type` varchar(500) DEFAULT NULL,
  `or_no` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `accounts_payable`
--

/*!40000 ALTER TABLE `accounts_payable` DISABLE KEYS */;
/*!40000 ALTER TABLE `accounts_payable` ENABLE KEYS */;


--
-- Definition of table `accounts_payable_payments`
--

DROP TABLE IF EXISTS `accounts_payable_payments`;
CREATE TABLE `accounts_payable_payments` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `customer_id` varchar(500) DEFAULT NULL,
  `customer_name` varchar(500) DEFAULT NULL,
  `ar_no` varchar(500) DEFAULT NULL,
  `date_added` datetime DEFAULT NULL,
  `user_name` varchar(500) DEFAULT NULL,
  `amount` double DEFAULT NULL,
  `discount_amount` double DEFAULT NULL,
  `discount_rate` double DEFAULT NULL,
  `discount` varchar(500) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `term` double DEFAULT NULL,
  `date_applied` date DEFAULT NULL,
  `paid` double DEFAULT NULL,
  `date_paid` date DEFAULT NULL,
  `remarks` varchar(500) DEFAULT NULL,
  `type` varchar(500) DEFAULT NULL,
  `or_no` varchar(500) DEFAULT NULL,
  `prev_balance` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `accounts_payable_payments`
--

/*!40000 ALTER TABLE `accounts_payable_payments` DISABLE KEYS */;
/*!40000 ALTER TABLE `accounts_payable_payments` ENABLE KEYS */;


--
-- Definition of table `accounts_receivable`
--

DROP TABLE IF EXISTS `accounts_receivable`;
CREATE TABLE `accounts_receivable` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `customer_id` varchar(100) DEFAULT NULL,
  `customer_name` varchar(100) DEFAULT NULL,
  `ar_no` varchar(100) DEFAULT NULL,
  `date_added` datetime DEFAULT NULL,
  `user_name` varchar(100) DEFAULT NULL,
  `amount` double DEFAULT NULL,
  `discount_amount` double DEFAULT NULL,
  `discount_rate` double DEFAULT NULL,
  `discount` varchar(100) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `term` double DEFAULT NULL,
  `date_applied` date DEFAULT NULL,
  `paid` double DEFAULT NULL,
  `date_paid` date DEFAULT NULL,
  `remarks` varchar(100) DEFAULT NULL,
  `type` varchar(100) DEFAULT NULL,
  `or_no` varchar(100) DEFAULT NULL,
  `ci_no` varchar(100) DEFAULT NULL,
  `trust_receipt` varchar(100) DEFAULT NULL,
  `soa_id` varchar(100) DEFAULT NULL,
  `soa_type` varchar(100) DEFAULT NULL,
  `soa_type_id` varchar(100) DEFAULT NULL,
  `reference_no` varchar(100) DEFAULT NULL,
  `user_id` varchar(1000) DEFAULT NULL,
  `user_screen_name` varchar(1000) DEFAULT NULL,
  `branch` varchar(100) DEFAULT NULL,
  `branch_id` varchar(100) DEFAULT NULL,
  `location` varchar(100) DEFAULT NULL,
  `location_id` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `ar_no` (`ar_no`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `accounts_receivable`
--

/*!40000 ALTER TABLE `accounts_receivable` DISABLE KEYS */;
/*!40000 ALTER TABLE `accounts_receivable` ENABLE KEYS */;


--
-- Definition of table `accounts_receivable_payments`
--

DROP TABLE IF EXISTS `accounts_receivable_payments`;
CREATE TABLE `accounts_receivable_payments` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `customer_id` varchar(500) DEFAULT NULL,
  `customer_name` varchar(500) DEFAULT NULL,
  `ar_no` varchar(500) DEFAULT NULL,
  `date_added` datetime DEFAULT NULL,
  `user_name` varchar(500) DEFAULT NULL,
  `amount` double DEFAULT NULL,
  `discount_amount` double DEFAULT NULL,
  `discount_rate` double DEFAULT NULL,
  `discount` varchar(500) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `term` double DEFAULT NULL,
  `date_applied` date DEFAULT NULL,
  `paid` double DEFAULT NULL,
  `date_paid` date DEFAULT NULL,
  `remarks` varchar(500) DEFAULT NULL,
  `type` varchar(500) DEFAULT NULL,
  `or_no` varchar(500) DEFAULT NULL,
  `prev_balance` double DEFAULT NULL,
  `check_amount` double DEFAULT NULL,
  `check_holder` varchar(100) DEFAULT NULL,
  `check_bank` varchar(100) DEFAULT NULL,
  `check_no` varchar(100) DEFAULT NULL,
  `ci_no` varchar(100) DEFAULT NULL,
  `trust_receipt` varchar(100) DEFAULT NULL,
  `or_payment_no` varchar(100) DEFAULT NULL,
  `soa_id` varchar(100) DEFAULT NULL,
  `soa_type` varchar(100) DEFAULT NULL,
  `soa_type_id` varchar(100) DEFAULT NULL,
  `reference_no` varchar(100) DEFAULT NULL,
  `check_date` date DEFAULT NULL,
  `user_id` varchar(1000) DEFAULT NULL,
  `user_screen_name` varchar(1000) DEFAULT NULL,
  `wtax` double DEFAULT NULL,
  `tax_rate` double DEFAULT NULL,
  `tax_amount` double DEFAULT NULL,
  `branch` varchar(100) DEFAULT NULL,
  `branch_id` varchar(100) DEFAULT NULL,
  `location` varchar(100) DEFAULT NULL,
  `location_id` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `accounts_receivable_payments`
--

/*!40000 ALTER TABLE `accounts_receivable_payments` DISABLE KEYS */;
/*!40000 ALTER TABLE `accounts_receivable_payments` ENABLE KEYS */;


--
-- Definition of table `accounts_receivable_series_nos`
--

DROP TABLE IF EXISTS `accounts_receivable_series_nos`;
CREATE TABLE `accounts_receivable_series_nos` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `series_no` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `accounts_receivable_series_nos`
--

/*!40000 ALTER TABLE `accounts_receivable_series_nos` DISABLE KEYS */;
/*!40000 ALTER TABLE `accounts_receivable_series_nos` ENABLE KEYS */;


--
-- Definition of table `accounts_receivable_types`
--

DROP TABLE IF EXISTS `accounts_receivable_types`;
CREATE TABLE `accounts_receivable_types` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type_name` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `accounts_receivable_types`
--

/*!40000 ALTER TABLE `accounts_receivable_types` DISABLE KEYS */;
INSERT INTO `accounts_receivable_types` (`id`,`type_name`) VALUES 
 (1,'BILLING STATEMENT'),
 (2,'TRUST RECEIPT AGREEMENT'),
 (3,'DES - TR DGTE'),
 (4,'DES - TR KAB'),
 (5,'DES - TR CBU'),
 (7,'SALES INVOICE'),
 (8,'TR - NENA');
/*!40000 ALTER TABLE `accounts_receivable_types` ENABLE KEYS */;


--
-- Definition of table `adjustments`
--

DROP TABLE IF EXISTS `adjustments`;
CREATE TABLE `adjustments` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `item_code` varchar(100) DEFAULT NULL,
  `barcode` varchar(100) DEFAULT NULL,
  `description` varchar(100) DEFAULT NULL,
  `qty` double DEFAULT NULL,
  `new_qty` double DEFAULT NULL,
  `is_add` int(11) DEFAULT NULL,
  `date_added` datetime DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `user_id` varchar(100) DEFAULT NULL,
  `user_screen_name` varchar(100) DEFAULT NULL,
  `branch` varchar(100) DEFAULT NULL,
  `branch_id` varchar(100) DEFAULT NULL,
  `location` varchar(100) DEFAULT NULL,
  `location_id` varchar(100) DEFAULT NULL,
  `remarks` text,
  `transaction_no` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `adjustments`
--

/*!40000 ALTER TABLE `adjustments` DISABLE KEYS */;
/*!40000 ALTER TABLE `adjustments` ENABLE KEYS */;


--
-- Definition of table `ar_ledger`
--

DROP TABLE IF EXISTS `ar_ledger`;
CREATE TABLE `ar_ledger` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `date` varchar(100) DEFAULT NULL,
  `transaction_no` varchar(100) DEFAULT NULL,
  `or_no` varchar(100) DEFAULT NULL,
  `amount` double DEFAULT NULL,
  `payment` double DEFAULT NULL,
  `balance` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `ar_ledger`
--

/*!40000 ALTER TABLE `ar_ledger` DISABLE KEYS */;
/*!40000 ALTER TABLE `ar_ledger` ENABLE KEYS */;


--
-- Definition of table `banks`
--

DROP TABLE IF EXISTS `banks`;
CREATE TABLE `banks` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `bank_name` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `banks`
--

/*!40000 ALTER TABLE `banks` DISABLE KEYS */;
INSERT INTO `banks` (`id`,`bank_name`) VALUES 
 (1,'BANK OF THE PHILIPPINE ISLAND'),
 (2,'BANKO PILIPINO'),
 (3,'CHINA BANK'),
 (4,'METROBANK'),
 (5,'VETERANS BANK'),
 (6,'ALLIED BANK'),
 (7,'PPA CHIT');
/*!40000 ALTER TABLE `banks` ENABLE KEYS */;


--
-- Definition of table `barcodes`
--

DROP TABLE IF EXISTS `barcodes`;
CREATE TABLE `barcodes` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `barcode` varchar(100) DEFAULT NULL,
  `serial_no` varchar(1000) DEFAULT NULL,
  `batch_no` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `barcodes`
--

/*!40000 ALTER TABLE `barcodes` DISABLE KEYS */;
/*!40000 ALTER TABLE `barcodes` ENABLE KEYS */;


--
-- Definition of table `borrower_slip_items`
--

DROP TABLE IF EXISTS `borrower_slip_items`;
CREATE TABLE `borrower_slip_items` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` varchar(100) DEFAULT NULL,
  `user_screen_name` varchar(100) DEFAULT NULL,
  `date_added` datetime DEFAULT NULL,
  `bs_no` varchar(100) DEFAULT NULL,
  `reference_no` varchar(100) DEFAULT NULL,
  `borrowed_by` varchar(100) DEFAULT NULL,
  `borrowed_by_id` varchar(100) DEFAULT NULL,
  `borrowed_by_department` varchar(100) DEFAULT NULL,
  `borrowed_by_department_id` varchar(100) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `from_branch` varchar(100) DEFAULT NULL,
  `from_branch_id` varchar(100) DEFAULT NULL,
  `from_location` varchar(100) DEFAULT NULL,
  `from_location_id` varchar(100) DEFAULT NULL,
  `to_branch` varchar(100) DEFAULT NULL,
  `to_branch_id` varchar(100) DEFAULT NULL,
  `to_location` varchar(100) DEFAULT NULL,
  `to_location_id` varchar(100) DEFAULT NULL,
  `remarks` text,
  `barcode` varchar(100) DEFAULT NULL,
  `description` varchar(100) DEFAULT NULL,
  `generic_name` varchar(100) DEFAULT NULL,
  `category` varchar(100) DEFAULT NULL,
  `category_id` varchar(100) DEFAULT NULL,
  `classification` varchar(100) DEFAULT NULL,
  `classification_id` varchar(100) DEFAULT NULL,
  `sub_classification` varchar(100) DEFAULT NULL,
  `sub_classification_id` varchar(100) DEFAULT NULL,
  `product_qty` double DEFAULT NULL,
  `unit` varchar(100) DEFAULT NULL,
  `conversion` double DEFAULT NULL,
  `selling_price` double DEFAULT NULL,
  `item_type` varchar(100) DEFAULT NULL,
  `supplier` varchar(100) DEFAULT NULL,
  `fixed_price` int(11) DEFAULT NULL,
  `cost` double DEFAULT NULL,
  `supplier_id` varchar(100) DEFAULT NULL,
  `multi_level_pricing` int(11) DEFAULT NULL,
  `vatable` int(11) DEFAULT NULL,
  `reorder_level` double DEFAULT NULL,
  `markup` double DEFAULT NULL,
  `main_barcode` varchar(100) DEFAULT NULL,
  `brand` varchar(100) DEFAULT NULL,
  `brand_id` varchar(100) DEFAULT NULL,
  `model` varchar(100) DEFAULT NULL,
  `model_id` varchar(100) DEFAULT NULL,
  `selling_type` varchar(100) DEFAULT NULL,
  `serial_no` varchar(100) DEFAULT NULL,
  `qty_borrowed` double DEFAULT NULL,
  `qty_returned` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `borrower_slip_items`
--

/*!40000 ALTER TABLE `borrower_slip_items` DISABLE KEYS */;
/*!40000 ALTER TABLE `borrower_slip_items` ENABLE KEYS */;


--
-- Definition of table `borrower_slips`
--

DROP TABLE IF EXISTS `borrower_slips`;
CREATE TABLE `borrower_slips` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` varchar(100) DEFAULT NULL,
  `user_screen_name` varchar(100) DEFAULT NULL,
  `date_added` datetime DEFAULT NULL,
  `bs_no` varchar(100) DEFAULT NULL,
  `reference_no` varchar(100) DEFAULT NULL,
  `items_borrowed` double DEFAULT NULL,
  `items_returned` double DEFAULT NULL,
  `borrowed_by` varchar(100) DEFAULT NULL,
  `borrowed_by_id` varchar(100) DEFAULT NULL,
  `borrowed_by_department` varchar(100) DEFAULT NULL,
  `borrowed_by_department_id` varchar(100) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `from_branch` varchar(100) DEFAULT NULL,
  `from_branch_id` varchar(100) DEFAULT NULL,
  `from_location` varchar(100) DEFAULT NULL,
  `from_location_id` varchar(100) DEFAULT NULL,
  `to_branch` varchar(100) DEFAULT NULL,
  `to_branch_id` varchar(100) DEFAULT NULL,
  `to_location` varchar(100) DEFAULT NULL,
  `to_location_id` varchar(100) DEFAULT NULL,
  `remarks` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `borrower_slips`
--

/*!40000 ALTER TABLE `borrower_slips` DISABLE KEYS */;
/*!40000 ALTER TABLE `borrower_slips` ENABLE KEYS */;


--
-- Definition of table `branch_locations`
--

DROP TABLE IF EXISTS `branch_locations`;
CREATE TABLE `branch_locations` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `branch` varchar(100) DEFAULT NULL,
  `branch_id` varchar(100) DEFAULT NULL,
  `code` varchar(100) DEFAULT NULL,
  `location` varchar(100) DEFAULT NULL,
  `type` varchar(100) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `branch_locations`
--

/*!40000 ALTER TABLE `branch_locations` DISABLE KEYS */;
INSERT INTO `branch_locations` (`id`,`branch`,`branch_id`,`code`,`location`,`type`,`status`) VALUES 
 (1,'Dumaguete City','1','Dgte','Selling Area',NULL,1);
/*!40000 ALTER TABLE `branch_locations` ENABLE KEYS */;


--
-- Definition of table `branches`
--

DROP TABLE IF EXISTS `branches`;
CREATE TABLE `branches` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(100) DEFAULT NULL,
  `branch` varchar(100) DEFAULT NULL,
  `address` varchar(100) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `branches`
--

/*!40000 ALTER TABLE `branches` DISABLE KEYS */;
INSERT INTO `branches` (`id`,`code`,`branch`,`address`,`status`) VALUES 
 (1,'DGT','Dumaguete City','',0);
/*!40000 ALTER TABLE `branches` ENABLE KEYS */;


--
-- Definition of table `cash_drawer`
--

DROP TABLE IF EXISTS `cash_drawer`;
CREATE TABLE `cash_drawer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `session_no` varchar(100) DEFAULT NULL,
  `user_name` varchar(100) DEFAULT NULL,
  `screen_name` varchar(100) DEFAULT NULL,
  `time_in` datetime DEFAULT NULL,
  `time_out` datetime DEFAULT NULL,
  `amount` double DEFAULT NULL,
  `cash_out` double DEFAULT NULL,
  `thousand` double DEFAULT NULL,
  `five_hundred` double DEFAULT NULL,
  `two_hundred` double DEFAULT NULL,
  `fifty` double DEFAULT NULL,
  `twenty` double DEFAULT NULL,
  `coins` double DEFAULT NULL,
  `one_hundred` double DEFAULT NULL,
  `expenses` double DEFAULT NULL,
  `ten` double DEFAULT NULL,
  `five` double DEFAULT NULL,
  `one` double DEFAULT NULL,
  `point_five` double DEFAULT NULL,
  `point_two_five` double DEFAULT NULL,
  `point_ten` double DEFAULT NULL,
  `point_zero_five` double DEFAULT NULL,
  `branch` varchar(100) DEFAULT NULL,
  `branch_id` varchar(100) DEFAULT NULL,
  `location` varchar(100) DEFAULT NULL,
  `location_id` varchar(100) DEFAULT NULL,
  `user_id` varchar(100) DEFAULT NULL,
  `user_screen_name` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2198 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `cash_drawer`
--

/*!40000 ALTER TABLE `cash_drawer` DISABLE KEYS */;
INSERT INTO `cash_drawer` (`id`,`session_no`,`user_name`,`screen_name`,`time_in`,`time_out`,`amount`,`cash_out`,`thousand`,`five_hundred`,`two_hundred`,`fifty`,`twenty`,`coins`,`one_hundred`,`expenses`,`ten`,`five`,`one`,`point_five`,`point_two_five`,`point_ten`,`point_zero_five`,`branch`,`branch_id`,`location`,`location_id`,`user_id`,`user_screen_name`) VALUES 
 (2197,'1','admin','administrator','2017-01-13 11:15:34',NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'Dumaguete City','1','Selling Area','1','1','administrator');
/*!40000 ALTER TABLE `cash_drawer` ENABLE KEYS */;


--
-- Definition of table `cash_drawer_accounts_receivables`
--

DROP TABLE IF EXISTS `cash_drawer_accounts_receivables`;
CREATE TABLE `cash_drawer_accounts_receivables` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` varchar(1000) DEFAULT NULL,
  `user_screen_name` varchar(1000) DEFAULT NULL,
  `date_added` datetime DEFAULT NULL,
  `charge_type_id` varchar(1000) DEFAULT NULL,
  `charge_type` varchar(1000) DEFAULT NULL,
  `reference_no` varchar(1000) DEFAULT NULL,
  `customer_id` varchar(1000) DEFAULT NULL,
  `customer_name` varchar(1000) DEFAULT NULL,
  `cash_amount` double DEFAULT NULL,
  `cheque_amount` double DEFAULT NULL,
  `check_holder` varchar(1000) DEFAULT NULL,
  `cheque_bank` varchar(1000) DEFAULT NULL,
  `cheque_no` varchar(1000) DEFAULT NULL,
  `cheque_date` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `cash_drawer_accounts_receivables`
--

/*!40000 ALTER TABLE `cash_drawer_accounts_receivables` DISABLE KEYS */;
/*!40000 ALTER TABLE `cash_drawer_accounts_receivables` ENABLE KEYS */;


--
-- Definition of table `cash_drawer_checks`
--

DROP TABLE IF EXISTS `cash_drawer_checks`;
CREATE TABLE `cash_drawer_checks` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `session_no` varchar(100) DEFAULT NULL,
  `user_name` varchar(100) DEFAULT NULL,
  `screen_name` varchar(100) DEFAULT NULL,
  `time_in` datetime DEFAULT NULL,
  `time_out` datetime DEFAULT NULL,
  `bank` varchar(100) DEFAULT NULL,
  `check_no` varchar(100) DEFAULT NULL,
  `check_holder` varchar(100) DEFAULT NULL,
  `amount` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `cash_drawer_checks`
--

/*!40000 ALTER TABLE `cash_drawer_checks` DISABLE KEYS */;
/*!40000 ALTER TABLE `cash_drawer_checks` ENABLE KEYS */;


--
-- Definition of table `cash_drawer_cheques`
--

DROP TABLE IF EXISTS `cash_drawer_cheques`;
CREATE TABLE `cash_drawer_cheques` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` varchar(1000) DEFAULT NULL,
  `user_screen_name` varchar(1000) DEFAULT NULL,
  `date_added` datetime DEFAULT NULL,
  `cheque_holder` varchar(1000) DEFAULT NULL,
  `cheque_bank` varchar(1000) DEFAULT NULL,
  `cheque_no` varchar(1000) DEFAULT NULL,
  `cheque_amount` double DEFAULT NULL,
  `cheque_date` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `cash_drawer_cheques`
--

/*!40000 ALTER TABLE `cash_drawer_cheques` DISABLE KEYS */;
/*!40000 ALTER TABLE `cash_drawer_cheques` ENABLE KEYS */;


--
-- Definition of table `cash_drawer_credit_cards`
--

DROP TABLE IF EXISTS `cash_drawer_credit_cards`;
CREATE TABLE `cash_drawer_credit_cards` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` varchar(1000) DEFAULT NULL,
  `user_screen_name` varchar(1000) DEFAULT NULL,
  `date_added` datetime DEFAULT NULL,
  `credit_card_type` varchar(1000) DEFAULT NULL,
  `credit_card_rate` double DEFAULT NULL,
  `credit_card_amount` double DEFAULT NULL,
  `credit_card_no` varchar(1000) DEFAULT NULL,
  `credit_card_holder` varchar(1000) DEFAULT NULL,
  `credit_card_approval_code` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `cash_drawer_credit_cards`
--

/*!40000 ALTER TABLE `cash_drawer_credit_cards` DISABLE KEYS */;
/*!40000 ALTER TABLE `cash_drawer_credit_cards` ENABLE KEYS */;


--
-- Definition of table `cash_drawer_expenses`
--

DROP TABLE IF EXISTS `cash_drawer_expenses`;
CREATE TABLE `cash_drawer_expenses` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `session_no` varchar(500) DEFAULT NULL,
  `user_name` varchar(500) DEFAULT NULL,
  `screen_name` varchar(500) DEFAULT NULL,
  `time_in` datetime DEFAULT NULL,
  `time_out` datetime DEFAULT NULL,
  `bank` varchar(500) DEFAULT NULL,
  `check_no` varchar(500) DEFAULT NULL,
  `check_holder` varchar(500) DEFAULT NULL,
  `amount` double DEFAULT NULL,
  `date_added` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `cash_drawer_expenses`
--

/*!40000 ALTER TABLE `cash_drawer_expenses` DISABLE KEYS */;
/*!40000 ALTER TABLE `cash_drawer_expenses` ENABLE KEYS */;


--
-- Definition of table `cash_drawer_gift_certificates`
--

DROP TABLE IF EXISTS `cash_drawer_gift_certificates`;
CREATE TABLE `cash_drawer_gift_certificates` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` varchar(1000) DEFAULT NULL,
  `user_screen_name` varchar(1000) DEFAULT NULL,
  `date_added` datetime DEFAULT NULL,
  `gc_from` varchar(1000) DEFAULT NULL,
  `gc_description` varchar(1000) DEFAULT NULL,
  `gc_no` varchar(1000) DEFAULT NULL,
  `amount` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `cash_drawer_gift_certificates`
--

/*!40000 ALTER TABLE `cash_drawer_gift_certificates` DISABLE KEYS */;
/*!40000 ALTER TABLE `cash_drawer_gift_certificates` ENABLE KEYS */;


--
-- Definition of table `cash_drawer_last_remittances`
--

DROP TABLE IF EXISTS `cash_drawer_last_remittances`;
CREATE TABLE `cash_drawer_last_remittances` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` varchar(100) DEFAULT NULL,
  `user_screen_name` varchar(100) DEFAULT NULL,
  `date_added` datetime DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `amount` double DEFAULT NULL,
  `branch` varchar(100) DEFAULT NULL,
  `branch_id` varchar(100) DEFAULT NULL,
  `location` varchar(100) DEFAULT NULL,
  `location_id` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `cash_drawer_last_remittances`
--

/*!40000 ALTER TABLE `cash_drawer_last_remittances` DISABLE KEYS */;
/*!40000 ALTER TABLE `cash_drawer_last_remittances` ENABLE KEYS */;


--
-- Definition of table `cash_drawer_prepaids`
--

DROP TABLE IF EXISTS `cash_drawer_prepaids`;
CREATE TABLE `cash_drawer_prepaids` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` varchar(1000) DEFAULT NULL,
  `user_screen_name` varchar(1000) DEFAULT NULL,
  `date_added` datetime DEFAULT NULL,
  `customer_name` varchar(1000) DEFAULT NULL,
  `customer_id` varchar(1000) DEFAULT NULL,
  `cash_amount` double DEFAULT NULL,
  `cheque_amount` double DEFAULT NULL,
  `cheque_holder` varchar(1000) DEFAULT NULL,
  `cheque_bank` varchar(1000) DEFAULT NULL,
  `cheque_no` varchar(1000) DEFAULT NULL,
  `cheque_date` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `cash_drawer_prepaids`
--

/*!40000 ALTER TABLE `cash_drawer_prepaids` DISABLE KEYS */;
/*!40000 ALTER TABLE `cash_drawer_prepaids` ENABLE KEYS */;


--
-- Definition of table `cash_drawer_remittances`
--

DROP TABLE IF EXISTS `cash_drawer_remittances`;
CREATE TABLE `cash_drawer_remittances` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` varchar(1000) DEFAULT NULL,
  `user_screen_name` varchar(1000) DEFAULT NULL,
  `date_added` datetime DEFAULT NULL,
  `cash_amount` double DEFAULT NULL,
  `cheque_amount` double DEFAULT NULL,
  `cheque_holder` varchar(1000) DEFAULT NULL,
  `cheque_bank` varchar(1000) DEFAULT NULL,
  `cheque_no` varchar(1000) DEFAULT NULL,
  `cheque_date` date DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `branch` varchar(100) DEFAULT NULL,
  `branch_id` varchar(100) DEFAULT NULL,
  `location` varchar(100) DEFAULT NULL,
  `location_id` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `cash_drawer_remittances`
--

/*!40000 ALTER TABLE `cash_drawer_remittances` DISABLE KEYS */;
/*!40000 ALTER TABLE `cash_drawer_remittances` ENABLE KEYS */;


--
-- Definition of table `cash_drawer_tips`
--

DROP TABLE IF EXISTS `cash_drawer_tips`;
CREATE TABLE `cash_drawer_tips` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` varchar(100) DEFAULT NULL,
  `user_screen_name` varchar(100) DEFAULT NULL,
  `date_added` datetime DEFAULT NULL,
  `cash_amount` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `cash_drawer_tips`
--

/*!40000 ALTER TABLE `cash_drawer_tips` DISABLE KEYS */;
/*!40000 ALTER TABLE `cash_drawer_tips` ENABLE KEYS */;


--
-- Definition of table `categories`
--

DROP TABLE IF EXISTS `categories`;
CREATE TABLE `categories` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(100) DEFAULT NULL,
  `name` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `categories`
--

/*!40000 ALTER TABLE `categories` DISABLE KEYS */;
/*!40000 ALTER TABLE `categories` ENABLE KEYS */;


--
-- Definition of table `charge_in_advance`
--

DROP TABLE IF EXISTS `charge_in_advance`;
CREATE TABLE `charge_in_advance` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `customer_id` varchar(100) DEFAULT NULL,
  `customer_name` varchar(100) DEFAULT NULL,
  `ar_id` varchar(100) DEFAULT NULL,
  `ar_no` varchar(100) DEFAULT NULL,
  `date_applied` date DEFAULT NULL,
  `reference_no` varchar(100) DEFAULT NULL,
  `soa_type` varchar(100) DEFAULT NULL,
  `soa_type_id` varchar(100) DEFAULT NULL,
  `remarks` text,
  `status` int(11) DEFAULT NULL,
  `user_id` varchar(100) DEFAULT NULL,
  `user_screen_name` varchar(100) DEFAULT NULL,
  `branch` varchar(100) DEFAULT NULL,
  `branch_id` varchar(100) DEFAULT NULL,
  `location` varchar(100) DEFAULT NULL,
  `location_id` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `charge_in_advance`
--

/*!40000 ALTER TABLE `charge_in_advance` DISABLE KEYS */;
/*!40000 ALTER TABLE `charge_in_advance` ENABLE KEYS */;


--
-- Definition of table `charge_in_advance_cancelled_items`
--

DROP TABLE IF EXISTS `charge_in_advance_cancelled_items`;
CREATE TABLE `charge_in_advance_cancelled_items` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `customer_id` varchar(100) DEFAULT NULL,
  `customer_name` varchar(100) DEFAULT NULL,
  `ar_id` varchar(100) DEFAULT NULL,
  `ar_no` varchar(100) DEFAULT NULL,
  `date_applied` date DEFAULT NULL,
  `reference_no` varchar(100) DEFAULT NULL,
  `soa_type` varchar(100) DEFAULT NULL,
  `soa_type_id` varchar(1000) DEFAULT NULL,
  `user_screen_name` varchar(100) DEFAULT NULL,
  `user_id` varchar(100) DEFAULT NULL,
  `remarks` varchar(100) DEFAULT NULL,
  `item_code` varchar(100) DEFAULT NULL,
  `barcode` varchar(100) DEFAULT NULL,
  `description` varchar(100) DEFAULT NULL,
  `generic_name` varchar(100) DEFAULT NULL,
  `item_type` varchar(100) DEFAULT NULL,
  `supplier_name` varchar(100) DEFAULT NULL,
  `supplier_id` varchar(100) DEFAULT NULL,
  `serial_no` varchar(100) DEFAULT NULL,
  `product_qty` double DEFAULT NULL,
  `unit` varchar(100) DEFAULT NULL,
  `conversion` double DEFAULT NULL,
  `selling_price` double DEFAULT NULL,
  `date_added` datetime DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `is_vatable` int(11) DEFAULT NULL,
  `selling_type` int(11) DEFAULT NULL,
  `discount_name` varchar(100) DEFAULT NULL,
  `discount_rate` double DEFAULT NULL,
  `discount_amount` double DEFAULT NULL,
  `discount_customer_name` varchar(100) DEFAULT NULL,
  `discount_customer_id` varchar(100) DEFAULT NULL,
  `branch` varchar(100) DEFAULT NULL,
  `branch_code` varchar(100) DEFAULT NULL,
  `location` varchar(100) DEFAULT NULL,
  `location_id` varchar(100) DEFAULT NULL,
  `category` varchar(100) DEFAULT NULL,
  `category_id` varchar(100) DEFAULT NULL,
  `classification` varchar(100) DEFAULT NULL,
  `classification_id` varchar(100) DEFAULT NULL,
  `sub_classification` varchar(100) DEFAULT NULL,
  `sub_classification_id` varchar(100) DEFAULT NULL,
  `brand` varchar(100) DEFAULT NULL,
  `brand_id` varchar(100) DEFAULT NULL,
  `model` varchar(100) DEFAULT NULL,
  `model_id` varchar(100) DEFAULT NULL,
  `addtl_amount` double DEFAULT NULL,
  `wtax` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `charge_in_advance_cancelled_items`
--

/*!40000 ALTER TABLE `charge_in_advance_cancelled_items` DISABLE KEYS */;
/*!40000 ALTER TABLE `charge_in_advance_cancelled_items` ENABLE KEYS */;


--
-- Definition of table `charge_in_advance_items`
--

DROP TABLE IF EXISTS `charge_in_advance_items`;
CREATE TABLE `charge_in_advance_items` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `customer_id` varchar(100) DEFAULT NULL,
  `customer_name` varchar(100) DEFAULT NULL,
  `ar_id` varchar(100) DEFAULT NULL,
  `ar_no` varchar(100) DEFAULT NULL,
  `date_applied` date DEFAULT NULL,
  `reference_no` varchar(100) DEFAULT NULL,
  `soa_type` varchar(100) DEFAULT NULL,
  `soa_type_id` varchar(1000) DEFAULT NULL,
  `user_screen_name` varchar(100) DEFAULT NULL,
  `user_id` varchar(100) DEFAULT NULL,
  `remarks` varchar(100) DEFAULT NULL,
  `item_code` varchar(100) DEFAULT NULL,
  `barcode` varchar(100) DEFAULT NULL,
  `description` varchar(100) DEFAULT NULL,
  `generic_name` varchar(100) DEFAULT NULL,
  `item_type` varchar(100) DEFAULT NULL,
  `supplier_name` varchar(100) DEFAULT NULL,
  `supplier_id` varchar(100) DEFAULT NULL,
  `serial_no` varchar(100) DEFAULT NULL,
  `product_qty` double DEFAULT NULL,
  `unit` varchar(100) DEFAULT NULL,
  `conversion` double DEFAULT NULL,
  `selling_price` double DEFAULT NULL,
  `date_added` datetime DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `is_vatable` int(11) DEFAULT NULL,
  `selling_type` int(11) DEFAULT NULL,
  `discount_name` varchar(100) DEFAULT NULL,
  `discount_rate` double DEFAULT NULL,
  `discount_amount` double DEFAULT NULL,
  `discount_customer_name` varchar(100) DEFAULT NULL,
  `discount_customer_id` varchar(100) DEFAULT NULL,
  `branch` varchar(100) DEFAULT NULL,
  `branch_code` varchar(100) DEFAULT NULL,
  `location` varchar(100) DEFAULT NULL,
  `location_id` varchar(100) DEFAULT NULL,
  `category` varchar(100) DEFAULT NULL,
  `category_id` varchar(100) DEFAULT NULL,
  `classification` varchar(100) DEFAULT NULL,
  `classification_id` varchar(100) DEFAULT NULL,
  `sub_classification` varchar(100) DEFAULT NULL,
  `sub_classification_id` varchar(100) DEFAULT NULL,
  `brand` varchar(100) DEFAULT NULL,
  `brand_id` varchar(100) DEFAULT NULL,
  `model` varchar(100) DEFAULT NULL,
  `model_id` varchar(100) DEFAULT NULL,
  `addtl_amount` double DEFAULT NULL,
  `wtax` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `charge_in_advance_items`
--

/*!40000 ALTER TABLE `charge_in_advance_items` DISABLE KEYS */;
/*!40000 ALTER TABLE `charge_in_advance_items` ENABLE KEYS */;


--
-- Definition of table `charge_payment_items`
--

DROP TABLE IF EXISTS `charge_payment_items`;
CREATE TABLE `charge_payment_items` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `barcode` varchar(500) DEFAULT NULL,
  `description` varchar(500) DEFAULT NULL,
  `generic_name` varchar(500) DEFAULT NULL,
  `category` varchar(500) DEFAULT NULL,
  `category_id` varchar(500) DEFAULT NULL,
  `classification` varchar(500) DEFAULT NULL,
  `classification_id` varchar(500) DEFAULT NULL,
  `sub_classification` varchar(500) DEFAULT NULL,
  `sub_classification_id` varchar(500) DEFAULT NULL,
  `product_qty` double DEFAULT NULL,
  `unit` varchar(500) DEFAULT NULL,
  `conversion` double DEFAULT NULL,
  `selling_price` double DEFAULT NULL,
  `date_added` datetime DEFAULT NULL,
  `user_name` varchar(500) DEFAULT NULL,
  `item_type` varchar(500) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `supplier` varchar(500) DEFAULT NULL,
  `fixed_price` int(11) DEFAULT NULL,
  `cost` double DEFAULT NULL,
  `supplier_id` varchar(500) DEFAULT NULL,
  `multi_level_pricing` int(11) DEFAULT NULL,
  `vatable` int(11) DEFAULT NULL,
  `reorder_level` double DEFAULT NULL,
  `markup` double DEFAULT NULL,
  `main_barcode` varchar(500) DEFAULT NULL,
  `brand` varchar(500) DEFAULT NULL,
  `brand_id` varchar(500) DEFAULT NULL,
  `model` varchar(500) DEFAULT NULL,
  `model_id` varchar(500) DEFAULT NULL,
  `selling_type` int(11) DEFAULT NULL,
  `branch` varchar(500) DEFAULT NULL,
  `branch_code` varchar(500) DEFAULT NULL,
  `location` varchar(500) DEFAULT NULL,
  `location_id` varchar(500) DEFAULT NULL,
  `discount_name` varchar(500) DEFAULT NULL,
  `discount_rate` double DEFAULT NULL,
  `discount_amount` double DEFAULT NULL,
  `added_by` varchar(500) DEFAULT NULL,
  `or_no` varchar(500) DEFAULT NULL,
  `serial_no` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `charge_payment_items`
--

/*!40000 ALTER TABLE `charge_payment_items` DISABLE KEYS */;
/*!40000 ALTER TABLE `charge_payment_items` ENABLE KEYS */;


--
-- Definition of table `charge_payments`
--

DROP TABLE IF EXISTS `charge_payments`;
CREATE TABLE `charge_payments` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sales_no` varchar(500) DEFAULT NULL,
  `date_added` varchar(500) DEFAULT NULL,
  `user_name` varchar(500) DEFAULT NULL,
  `session_no` varchar(500) DEFAULT NULL,
  `gross_amount` double DEFAULT NULL,
  `amount_paid` double DEFAULT NULL,
  `amount_due` double DEFAULT NULL,
  `discount_name` varchar(500) DEFAULT NULL,
  `discount` double DEFAULT NULL,
  `discount_amount` double DEFAULT NULL,
  `customer_name` varchar(500) DEFAULT NULL,
  `check_bank` varchar(500) DEFAULT NULL,
  `check_no` varchar(500) DEFAULT NULL,
  `check_amount` double DEFAULT NULL,
  `discount_customer_name` varchar(500) DEFAULT NULL,
  `discount_customer_id` varchar(500) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `or_no` varchar(500) DEFAULT NULL,
  `check_holder` varchar(500) DEFAULT NULL,
  `services` varchar(500) DEFAULT NULL,
  `service_amount` double DEFAULT NULL,
  `charge_account_name` varchar(500) DEFAULT NULL,
  `charge_amount` double DEFAULT NULL,
  `charge_account_id` varchar(500) DEFAULT NULL,
  `credit_card` double DEFAULT NULL,
  `credit_card_name` varchar(500) DEFAULT NULL,
  `credit_card_rate` double DEFAULT NULL,
  `credit_card_amount` double DEFAULT NULL,
  `sales_type` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `charge_payments`
--

/*!40000 ALTER TABLE `charge_payments` DISABLE KEYS */;
/*!40000 ALTER TABLE `charge_payments` ENABLE KEYS */;


--
-- Definition of table `check_holders`
--

DROP TABLE IF EXISTS `check_holders`;
CREATE TABLE `check_holders` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `holder_name` varchar(100) DEFAULT NULL,
  `holder_no` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `check_holders`
--

/*!40000 ALTER TABLE `check_holders` DISABLE KEYS */;
/*!40000 ALTER TABLE `check_holders` ENABLE KEYS */;


--
-- Definition of table `classification`
--

DROP TABLE IF EXISTS `classification`;
CREATE TABLE `classification` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `category` varchar(100) DEFAULT NULL,
  `category_id` varchar(100) DEFAULT NULL,
  `classification` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `classification`
--

/*!40000 ALTER TABLE `classification` DISABLE KEYS */;
/*!40000 ALTER TABLE `classification` ENABLE KEYS */;


--
-- Definition of table `credit_cards`
--

DROP TABLE IF EXISTS `credit_cards`;
CREATE TABLE `credit_cards` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `rate` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `credit_cards`
--

/*!40000 ALTER TABLE `credit_cards` DISABLE KEYS */;
INSERT INTO `credit_cards` (`id`,`name`,`rate`) VALUES 
 (8,'Visa',0),
 (9,'Master Card',0),
 (10,'AMEX',0);
/*!40000 ALTER TABLE `credit_cards` ENABLE KEYS */;


--
-- Definition of table `customers`
--

DROP TABLE IF EXISTS `customers`;
CREATE TABLE `customers` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `customer_name` varchar(100) DEFAULT NULL,
  `customer_no` varchar(100) DEFAULT NULL,
  `contact_no` varchar(100) DEFAULT NULL,
  `credit_limit` double DEFAULT NULL,
  `address` varchar(500) DEFAULT NULL,
  `term` double DEFAULT NULL,
  `location` varchar(100) DEFAULT NULL,
  `balance` double DEFAULT NULL,
  `discount` double DEFAULT NULL,
  `prepaid` double NOT NULL,
  `branch` varchar(255) DEFAULT NULL,
  `branch_id` varchar(255) DEFAULT NULL,
  `location_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `customer_no` (`customer_no`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `customers`
--

/*!40000 ALTER TABLE `customers` DISABLE KEYS */;
/*!40000 ALTER TABLE `customers` ENABLE KEYS */;


--
-- Definition of table `disbursement_categories`
--

DROP TABLE IF EXISTS `disbursement_categories`;
CREATE TABLE `disbursement_categories` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `category_name` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `disbursement_categories`
--

/*!40000 ALTER TABLE `disbursement_categories` DISABLE KEYS */;
INSERT INTO `disbursement_categories` (`id`,`category_name`) VALUES 
 (1,'Transportation'),
 (2,'Maintenance'),
 (3,'Gas and Diesel'),
 (4,'Office'),
 (5,'Taxes'),
 (6,'Wages'),
 (7,'Housekeeping'),
 (8,'Utilities'),
 (9,'Snacks');
/*!40000 ALTER TABLE `disbursement_categories` ENABLE KEYS */;


--
-- Definition of table `disbursements`
--

DROP TABLE IF EXISTS `disbursements`;
CREATE TABLE `disbursements` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` varchar(1000) DEFAULT NULL,
  `user_screen_name` varchar(1000) DEFAULT NULL,
  `date_added` datetime DEFAULT NULL,
  `purpose` varchar(1000) DEFAULT NULL,
  `category_id` varchar(1000) DEFAULT NULL,
  `category_name` varchar(1000) DEFAULT NULL,
  `amount` double DEFAULT NULL,
  `is_vat` int(11) DEFAULT NULL,
  `disbursement_date` date DEFAULT NULL,
  `branch` varchar(100) DEFAULT NULL,
  `branch_id` varchar(100) DEFAULT NULL,
  `location` varchar(100) DEFAULT NULL,
  `location_id` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `disbursements`
--

/*!40000 ALTER TABLE `disbursements` DISABLE KEYS */;
/*!40000 ALTER TABLE `disbursements` ENABLE KEYS */;


--
-- Definition of table `discount_customers`
--

DROP TABLE IF EXISTS `discount_customers`;
CREATE TABLE `discount_customers` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `customer_name` varchar(100) DEFAULT NULL,
  `id_no` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `discount_customers`
--

/*!40000 ALTER TABLE `discount_customers` DISABLE KEYS */;
/*!40000 ALTER TABLE `discount_customers` ENABLE KEYS */;


--
-- Definition of table `discounts`
--

DROP TABLE IF EXISTS `discounts`;
CREATE TABLE `discounts` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `discount_name` varchar(100) DEFAULT NULL,
  `discount_rate` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `discounts`
--

/*!40000 ALTER TABLE `discounts` DISABLE KEYS */;
INSERT INTO `discounts` (`id`,`discount_name`,`discount_rate`) VALUES 
 (1,'NO DISCOUNT',0),
 (2,'REGULAR CUSTOMER',50),
 (3,'SENIOR CITIZEN',5),
 (4,'WITHOLDING TAX ',1);
/*!40000 ALTER TABLE `discounts` ENABLE KEYS */;


--
-- Definition of table `encoding_inventory`
--

DROP TABLE IF EXISTS `encoding_inventory`;
CREATE TABLE `encoding_inventory` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `item_code` varchar(100) DEFAULT NULL,
  `barcode` varchar(100) DEFAULT NULL,
  `description` text,
  `branch` varchar(100) DEFAULT NULL,
  `branch_id` varchar(100) DEFAULT NULL,
  `location` varchar(100) DEFAULT NULL,
  `location_id` varchar(100) DEFAULT NULL,
  `qty` double DEFAULT NULL,
  `date_added` datetime DEFAULT NULL,
  `user_name` varchar(100) DEFAULT NULL,
  `screen_name` varchar(100) DEFAULT NULL,
  `sheet_no` varchar(100) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `counted_by` varchar(100) DEFAULT NULL,
  `checked_by` varchar(100) DEFAULT NULL,
  `cost` double DEFAULT NULL,
  `selling_price` double DEFAULT NULL,
  `user_id` varchar(1000) DEFAULT NULL,
  `user_screen_name` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `encoding_inventory`
--

/*!40000 ALTER TABLE `encoding_inventory` DISABLE KEYS */;
/*!40000 ALTER TABLE `encoding_inventory` ENABLE KEYS */;


--
-- Definition of table `expenses`
--

DROP TABLE IF EXISTS `expenses`;
CREATE TABLE `expenses` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `expense_name` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `expenses`
--

/*!40000 ALTER TABLE `expenses` DISABLE KEYS */;
INSERT INTO `expenses` (`id`,`expense_name`) VALUES 
 (1,'TRANSPORTATION'),
 (2,'DELIVERY'),
 (3,'SNACKS'),
 (4,'BILLS');
/*!40000 ALTER TABLE `expenses` ENABLE KEYS */;


--
-- Definition of table `inv_categories`
--

DROP TABLE IF EXISTS `inv_categories`;
CREATE TABLE `inv_categories` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `category` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `inv_categories`
--

/*!40000 ALTER TABLE `inv_categories` DISABLE KEYS */;
/*!40000 ALTER TABLE `inv_categories` ENABLE KEYS */;


--
-- Definition of table `inv_classifications`
--

DROP TABLE IF EXISTS `inv_classifications`;
CREATE TABLE `inv_classifications` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `category_id` varchar(100) DEFAULT NULL,
  `category_name` varchar(100) DEFAULT NULL,
  `classification` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `inv_classifications`
--

/*!40000 ALTER TABLE `inv_classifications` DISABLE KEYS */;
/*!40000 ALTER TABLE `inv_classifications` ENABLE KEYS */;


--
-- Definition of table `inv_sub_classifications`
--

DROP TABLE IF EXISTS `inv_sub_classifications`;
CREATE TABLE `inv_sub_classifications` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `category_id` varchar(100) DEFAULT NULL,
  `category_name` varchar(100) DEFAULT NULL,
  `classification_name` varchar(100) DEFAULT NULL,
  `sub_classification` varchar(100) DEFAULT NULL,
  `classification_id` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `inv_sub_classifications`
--

/*!40000 ALTER TABLE `inv_sub_classifications` DISABLE KEYS */;
/*!40000 ALTER TABLE `inv_sub_classifications` ENABLE KEYS */;


--
-- Definition of table `inventory`
--

DROP TABLE IF EXISTS `inventory`;
CREATE TABLE `inventory` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `barcode` int(11) DEFAULT NULL,
  `description` varchar(500) DEFAULT NULL,
  `generic_name` varchar(500) DEFAULT NULL,
  `category` varchar(500) DEFAULT NULL,
  `category_id` varchar(500) DEFAULT NULL,
  `classification` varchar(500) DEFAULT NULL,
  `classification_id` varchar(500) DEFAULT NULL,
  `sub_classification` varchar(500) DEFAULT NULL,
  `sub_classification_id` varchar(500) DEFAULT NULL,
  `product_qty` double DEFAULT NULL,
  `unit` text,
  `conversion` double DEFAULT NULL,
  `selling_price` double DEFAULT NULL,
  `date_added` datetime DEFAULT NULL,
  `user_name` varchar(500) DEFAULT NULL,
  `item_type` varchar(500) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `supplier` varchar(500) DEFAULT NULL,
  `fixed_price` int(11) DEFAULT NULL,
  `cost` double DEFAULT NULL,
  `supplier_id` varchar(500) DEFAULT NULL,
  `multi_level_pricing` int(11) DEFAULT NULL,
  `vatable` int(11) DEFAULT NULL,
  `reorder_level` double DEFAULT NULL,
  `markup` double DEFAULT NULL,
  `barcodes` varchar(500) DEFAULT NULL,
  `brand` varchar(100) DEFAULT NULL,
  `brand_id` varchar(100) DEFAULT NULL,
  `model` varchar(100) DEFAULT NULL,
  `model_id` varchar(100) DEFAULT NULL,
  `selling_type` int(11) DEFAULT NULL,
  `branch` varchar(100) DEFAULT NULL,
  `branch_code` varchar(100) DEFAULT NULL,
  `location` varchar(100) DEFAULT NULL,
  `location_id` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=28901 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `inventory`
--

/*!40000 ALTER TABLE `inventory` DISABLE KEYS */;
INSERT INTO `inventory` (`id`,`barcode`,`description`,`generic_name`,`category`,`category_id`,`classification`,`classification_id`,`sub_classification`,`sub_classification_id`,`product_qty`,`unit`,`conversion`,`selling_price`,`date_added`,`user_name`,`item_type`,`status`,`supplier`,`fixed_price`,`cost`,`supplier_id`,`multi_level_pricing`,`vatable`,`reorder_level`,`markup`,`barcodes`,`brand`,`brand_id`,`model`,`model_id`,`selling_type`,`branch`,`branch_code`,`location`,`location_id`) VALUES 
 (28898,1,'Sample Item 1','','',NULL,'',NULL,'',NULL,0,'[pc:0.0/1.0^1]',1,0,'2017-01-13 11:44:16','','',1,'',0,0,'',0,0,0,0,'','',NULL,'',NULL,0,NULL,NULL,'',NULL),
 (28899,2,'Sample Item 2','','',NULL,'',NULL,'',NULL,0,'[pc:0.0/1.0^1]',1,0,'2017-01-13 11:44:23','','',1,'',0,0,'',0,0,0,0,'','',NULL,'',NULL,0,NULL,NULL,'',NULL),
 (28900,3,'Item 3','','',NULL,'',NULL,'',NULL,0,'[pc:200.0/1.0^1]',1,200,'2017-01-13 20:42:31','','',1,'',0,100,'',0,0,0,0,'','',NULL,'',NULL,0,NULL,NULL,'',NULL);
/*!40000 ALTER TABLE `inventory` ENABLE KEYS */;


--
-- Definition of table `inventory_assembly`
--

DROP TABLE IF EXISTS `inventory_assembly`;
CREATE TABLE `inventory_assembly` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `main_item_code` varchar(100) DEFAULT NULL,
  `main_barcode` varchar(100) DEFAULT NULL,
  `item_code` varchar(100) DEFAULT NULL,
  `description` varchar(100) DEFAULT NULL,
  `generic_name` varchar(100) DEFAULT NULL,
  `category` varchar(100) DEFAULT NULL,
  `category_id` varchar(100) DEFAULT NULL,
  `classification` varchar(100) DEFAULT NULL,
  `classification_id` varchar(100) DEFAULT NULL,
  `sub_classification` varchar(100) DEFAULT NULL,
  `sub_classification_id` varchar(100) DEFAULT NULL,
  `product_qty` double DEFAULT NULL,
  `unit` varchar(1000) DEFAULT NULL,
  `conversion` double DEFAULT NULL,
  `selling_price` double DEFAULT NULL,
  `date_added` datetime DEFAULT NULL,
  `user_name` varchar(100) DEFAULT NULL,
  `item_type` varchar(100) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `supplier` varchar(100) DEFAULT NULL,
  `fixed_price` int(11) DEFAULT NULL,
  `cost` double DEFAULT NULL,
  `supplier_id` varchar(100) DEFAULT NULL,
  `multi_level_pricing` int(11) DEFAULT NULL,
  `vatable` int(11) DEFAULT NULL,
  `reorder_level` double DEFAULT NULL,
  `markup` double DEFAULT NULL,
  `barcodes` varchar(100) DEFAULT NULL,
  `brand` varchar(100) DEFAULT NULL,
  `brand_id` varchar(100) DEFAULT NULL,
  `model` varchar(100) DEFAULT NULL,
  `model_id` varchar(100) DEFAULT NULL,
  `selling_type` int(11) DEFAULT NULL,
  `branch` varchar(100) DEFAULT NULL,
  `branch_code` varchar(100) DEFAULT NULL,
  `location` varchar(100) DEFAULT NULL,
  `location_id` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `inventory_assembly`
--

/*!40000 ALTER TABLE `inventory_assembly` DISABLE KEYS */;
/*!40000 ALTER TABLE `inventory_assembly` ENABLE KEYS */;


--
-- Definition of table `inventory_barcodes`
--

DROP TABLE IF EXISTS `inventory_barcodes`;
CREATE TABLE `inventory_barcodes` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `barcode` varchar(500) DEFAULT NULL,
  `description` varchar(500) DEFAULT NULL,
  `generic_name` varchar(500) DEFAULT NULL,
  `category` varchar(500) DEFAULT NULL,
  `category_id` varchar(500) DEFAULT NULL,
  `classification` varchar(500) DEFAULT NULL,
  `classification_id` varchar(500) DEFAULT NULL,
  `sub_classification` varchar(500) DEFAULT NULL,
  `sub_classification_id` varchar(500) DEFAULT NULL,
  `product_qty` double DEFAULT NULL,
  `unit` text,
  `conversion` double DEFAULT NULL,
  `selling_price` double DEFAULT NULL,
  `date_added` datetime DEFAULT NULL,
  `user_name` varchar(500) DEFAULT NULL,
  `item_type` varchar(500) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `supplier` varchar(500) DEFAULT NULL,
  `fixed_price` int(11) DEFAULT NULL,
  `cost` double DEFAULT NULL,
  `supplier_id` varchar(500) DEFAULT NULL,
  `multi_level_pricing` int(11) DEFAULT NULL,
  `vatable` int(11) DEFAULT NULL,
  `reorder_level` double DEFAULT NULL,
  `markup` double DEFAULT NULL,
  `main_barcode` int(11) DEFAULT NULL,
  `brand` varchar(500) DEFAULT NULL,
  `brand_id` varchar(500) DEFAULT NULL,
  `model` varchar(500) DEFAULT NULL,
  `model_id` varchar(500) DEFAULT NULL,
  `selling_type` int(11) DEFAULT NULL,
  `branch` varchar(500) DEFAULT NULL,
  `branch_code` varchar(500) DEFAULT NULL,
  `location` varchar(100) DEFAULT NULL,
  `location_id` varchar(100) DEFAULT NULL,
  `serial_no` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=375870 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `inventory_barcodes`
--

/*!40000 ALTER TABLE `inventory_barcodes` DISABLE KEYS */;
INSERT INTO `inventory_barcodes` (`id`,`barcode`,`description`,`generic_name`,`category`,`category_id`,`classification`,`classification_id`,`sub_classification`,`sub_classification_id`,`product_qty`,`unit`,`conversion`,`selling_price`,`date_added`,`user_name`,`item_type`,`status`,`supplier`,`fixed_price`,`cost`,`supplier_id`,`multi_level_pricing`,`vatable`,`reorder_level`,`markup`,`main_barcode`,`brand`,`brand_id`,`model`,`model_id`,`selling_type`,`branch`,`branch_code`,`location`,`location_id`,`serial_no`) VALUES 
 (375867,'','Sample Item 1','','',NULL,'',NULL,'',NULL,0,'[pc:0.0/1.0^1]',1,0,'2017-01-13 11:44:16','','',1,'',0,0,'',0,0,0,0,1,'',NULL,'',NULL,0,'Dumaguete City','1','Selling Area','1',''),
 (375868,'','Sample Item 2','','',NULL,'',NULL,'',NULL,-7,'[pc:0.0/1.0^1]',1,0,'2017-01-13 11:44:23','','',1,'',0,0,'',0,0,0,0,2,'',NULL,'',NULL,0,'Dumaguete City','1','Selling Area','1',''),
 (375869,'','Item 3','','',NULL,'',NULL,'',NULL,-3,'[pc:200.0/1.0^1]',1,200,'2017-01-13 20:42:31','','',1,'',0,100,'',0,0,0,0,3,'',NULL,'',NULL,0,'Dumaguete City','1','Selling Area','1','');
/*!40000 ALTER TABLE `inventory_barcodes` ENABLE KEYS */;


--
-- Definition of table `inventory_brand`
--

DROP TABLE IF EXISTS `inventory_brand`;
CREATE TABLE `inventory_brand` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(100) DEFAULT NULL,
  `name` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `inventory_brand`
--

/*!40000 ALTER TABLE `inventory_brand` DISABLE KEYS */;
/*!40000 ALTER TABLE `inventory_brand` ENABLE KEYS */;


--
-- Definition of table `inventory_category`
--

DROP TABLE IF EXISTS `inventory_category`;
CREATE TABLE `inventory_category` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `code` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `inventory_category`
--

/*!40000 ALTER TABLE `inventory_category` DISABLE KEYS */;
/*!40000 ALTER TABLE `inventory_category` ENABLE KEYS */;


--
-- Definition of table `inventory_classification`
--

DROP TABLE IF EXISTS `inventory_classification`;
CREATE TABLE `inventory_classification` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `category_code` varchar(100) DEFAULT NULL,
  `category` varchar(100) DEFAULT NULL,
  `code` varchar(100) DEFAULT NULL,
  `name` varchar(100) DEFAULT NULL,
  `markup_percent` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `inventory_classification`
--

/*!40000 ALTER TABLE `inventory_classification` DISABLE KEYS */;
/*!40000 ALTER TABLE `inventory_classification` ENABLE KEYS */;


--
-- Definition of table `inventory_model`
--

DROP TABLE IF EXISTS `inventory_model`;
CREATE TABLE `inventory_model` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `brand_code` varchar(100) DEFAULT NULL,
  `brand` varchar(100) DEFAULT NULL,
  `code` varchar(100) DEFAULT NULL,
  `name` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `inventory_model`
--

/*!40000 ALTER TABLE `inventory_model` DISABLE KEYS */;
/*!40000 ALTER TABLE `inventory_model` ENABLE KEYS */;


--
-- Definition of table `inventory_multi_level_pricing`
--

DROP TABLE IF EXISTS `inventory_multi_level_pricing`;
CREATE TABLE `inventory_multi_level_pricing` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `main_barcode` varchar(100) DEFAULT NULL,
  `barcode` varchar(100) DEFAULT NULL,
  `description` varchar(100) DEFAULT NULL,
  `unit` varchar(100) DEFAULT NULL,
  `conversion` double DEFAULT NULL,
  `markup` double DEFAULT NULL,
  `selling_price` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `inventory_multi_level_pricing`
--

/*!40000 ALTER TABLE `inventory_multi_level_pricing` DISABLE KEYS */;
/*!40000 ALTER TABLE `inventory_multi_level_pricing` ENABLE KEYS */;


--
-- Definition of table `inventory_price_updates`
--

DROP TABLE IF EXISTS `inventory_price_updates`;
CREATE TABLE `inventory_price_updates` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `item_code` varchar(255) DEFAULT NULL,
  `barcode` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `old_unit` text,
  `unit` text,
  `conversion` double DEFAULT NULL,
  `old_selling_price` double DEFAULT NULL,
  `selling_price` double DEFAULT NULL,
  `update_all_branch` int(11) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `date_added` datetime DEFAULT NULL,
  `user_id` varchar(255) DEFAULT NULL,
  `user_screen_name` varchar(255) DEFAULT NULL,
  `branch` varchar(255) DEFAULT NULL,
  `branch_id` varchar(255) DEFAULT NULL,
  `location` varchar(255) DEFAULT NULL,
  `location_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `inventory_price_updates`
--

/*!40000 ALTER TABLE `inventory_price_updates` DISABLE KEYS */;
/*!40000 ALTER TABLE `inventory_price_updates` ENABLE KEYS */;


--
-- Definition of table `inventory_replenishment_items`
--

DROP TABLE IF EXISTS `inventory_replenishment_items`;
CREATE TABLE `inventory_replenishment_items` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `inventory_replenishment_no` varchar(100) DEFAULT NULL,
  `item_code` varchar(100) DEFAULT NULL,
  `barcode` varchar(100) DEFAULT NULL,
  `description` text,
  `product_qty` double DEFAULT NULL,
  `unit` text,
  `conversion` double DEFAULT NULL,
  `selling_price` double DEFAULT NULL,
  `date_added` datetime DEFAULT NULL,
  `user_id` varchar(100) DEFAULT NULL,
  `user_screen_name` varchar(100) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `branch` varchar(100) DEFAULT NULL,
  `branch_id` varchar(100) DEFAULT NULL,
  `location` varchar(100) DEFAULT NULL,
  `location_id` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `inventory_replenishment_items`
--

/*!40000 ALTER TABLE `inventory_replenishment_items` DISABLE KEYS */;
/*!40000 ALTER TABLE `inventory_replenishment_items` ENABLE KEYS */;


--
-- Definition of table `inventory_replenishments`
--

DROP TABLE IF EXISTS `inventory_replenishments`;
CREATE TABLE `inventory_replenishments` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `inventory_replenishment_no` varchar(100) DEFAULT NULL,
  `date_added` datetime DEFAULT NULL,
  `user_id` varchar(100) DEFAULT NULL,
  `user_screen_name` varchar(100) DEFAULT NULL,
  `remarks` varchar(100) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `branch` varchar(100) DEFAULT NULL,
  `branch_id` varchar(100) DEFAULT NULL,
  `location` varchar(100) DEFAULT NULL,
  `location_id` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `inventory_replenishment_no` (`inventory_replenishment_no`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `inventory_replenishments`
--

/*!40000 ALTER TABLE `inventory_replenishments` DISABLE KEYS */;
/*!40000 ALTER TABLE `inventory_replenishments` ENABLE KEYS */;


--
-- Definition of table `inventory_sub_classification`
--

DROP TABLE IF EXISTS `inventory_sub_classification`;
CREATE TABLE `inventory_sub_classification` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `category_code` varchar(100) DEFAULT NULL,
  `category` varchar(100) DEFAULT NULL,
  `classification_code` varchar(100) DEFAULT NULL,
  `classification` varchar(100) DEFAULT NULL,
  `code` varchar(100) DEFAULT NULL,
  `name` varchar(100) DEFAULT NULL,
  `markup` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `inventory_sub_classification`
--

/*!40000 ALTER TABLE `inventory_sub_classification` DISABLE KEYS */;
/*!40000 ALTER TABLE `inventory_sub_classification` ENABLE KEYS */;


--
-- Definition of table `inventory_uom`
--

DROP TABLE IF EXISTS `inventory_uom`;
CREATE TABLE `inventory_uom` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(100) DEFAULT NULL,
  `name` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `inventory_uom`
--

/*!40000 ALTER TABLE `inventory_uom` DISABLE KEYS */;
/*!40000 ALTER TABLE `inventory_uom` ENABLE KEYS */;


--
-- Definition of table `item_multi_level_pricing`
--

DROP TABLE IF EXISTS `item_multi_level_pricing`;
CREATE TABLE `item_multi_level_pricing` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `barcode` varchar(100) DEFAULT NULL,
  `description` varchar(100) DEFAULT NULL,
  `unit` varchar(100) DEFAULT NULL,
  `conversion` double DEFAULT NULL,
  `price` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `item_multi_level_pricing`
--

/*!40000 ALTER TABLE `item_multi_level_pricing` DISABLE KEYS */;
/*!40000 ALTER TABLE `item_multi_level_pricing` ENABLE KEYS */;


--
-- Definition of table `items`
--

DROP TABLE IF EXISTS `items`;
CREATE TABLE `items` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `barcode` varchar(100) DEFAULT NULL,
  `description` varchar(100) DEFAULT NULL,
  `generic_name` varchar(100) DEFAULT NULL,
  `category` varchar(100) DEFAULT NULL,
  `category_id` varchar(100) DEFAULT NULL,
  `classification` varchar(100) DEFAULT NULL,
  `classification_id` varchar(100) DEFAULT NULL,
  `sub_classification` varchar(100) DEFAULT NULL,
  `sub_classification_id` varchar(100) DEFAULT NULL,
  `product_qty` double DEFAULT NULL,
  `unit` varchar(100) DEFAULT NULL,
  `conversion` double DEFAULT NULL,
  `selling_price` double DEFAULT NULL,
  `date_added` datetime DEFAULT NULL,
  `user_name` varchar(100) DEFAULT NULL,
  `item_type` varchar(100) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `supplier` varchar(100) DEFAULT NULL,
  `fixed_price` int(11) DEFAULT NULL,
  `cost` double DEFAULT NULL,
  `supplier_id` varchar(100) DEFAULT NULL,
  `multi_level_pricing` int(11) DEFAULT NULL,
  `vatable` int(11) DEFAULT NULL,
  `reorder_level` double DEFAULT NULL,
  `markup` double DEFAULT NULL,
  `barcodes` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `items`
--

/*!40000 ALTER TABLE `items` DISABLE KEYS */;
/*!40000 ALTER TABLE `items` ENABLE KEYS */;


--
-- Definition of table `local_branch_query_uploads`
--

DROP TABLE IF EXISTS `local_branch_query_uploads`;
CREATE TABLE `local_branch_query_uploads` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `branch_query` longtext,
  `query_module` varchar(255) DEFAULT NULL,
  `to_branch` varchar(255) DEFAULT NULL,
  `to_branch_id` varchar(255) DEFAULT NULL,
  `branch` varchar(255) DEFAULT NULL,
  `branch_id` varchar(255) DEFAULT NULL,
  `location` varchar(255) DEFAULT NULL,
  `location_id` varchar(255) DEFAULT NULL,
  `date_added` datetime DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `local_branch_query_uploads`
--

/*!40000 ALTER TABLE `local_branch_query_uploads` DISABLE KEYS */;
/*!40000 ALTER TABLE `local_branch_query_uploads` ENABLE KEYS */;


--
-- Definition of table `main_branch_query_uploads`
--

DROP TABLE IF EXISTS `main_branch_query_uploads`;
CREATE TABLE `main_branch_query_uploads` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `branch_query` longtext,
  `query_module` varchar(255) DEFAULT NULL,
  `to_branch` varchar(255) DEFAULT NULL,
  `to_branch_id` varchar(255) DEFAULT NULL,
  `branch` varchar(255) DEFAULT NULL,
  `branch_id` varchar(255) DEFAULT NULL,
  `location` varchar(255) DEFAULT NULL,
  `location_id` varchar(255) DEFAULT NULL,
  `date_added` datetime DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `main_branch_query_uploads`
--

/*!40000 ALTER TABLE `main_branch_query_uploads` DISABLE KEYS */;
/*!40000 ALTER TABLE `main_branch_query_uploads` ENABLE KEYS */;


--
-- Definition of table `maintenances`
--

DROP TABLE IF EXISTS `maintenances`;
CREATE TABLE `maintenances` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `stmts` text,
  `status` int(11) DEFAULT NULL,
  `date_added` datetime DEFAULT NULL,
  `user_id` varchar(255) DEFAULT NULL,
  `user_screen_name` varchar(255) DEFAULT NULL,
  `branch` varchar(255) DEFAULT NULL,
  `branch_id` varchar(255) DEFAULT NULL,
  `location` varchar(255) DEFAULT NULL,
  `location_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `maintenances`
--

/*!40000 ALTER TABLE `maintenances` DISABLE KEYS */;
/*!40000 ALTER TABLE `maintenances` ENABLE KEYS */;


--
-- Definition of table `multi_pricing`
--

DROP TABLE IF EXISTS `multi_pricing`;
CREATE TABLE `multi_pricing` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `qty` double DEFAULT NULL,
  `unit` varchar(100) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `invoice_qty` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `multi_pricing`
--

/*!40000 ALTER TABLE `multi_pricing` DISABLE KEYS */;
/*!40000 ALTER TABLE `multi_pricing` ENABLE KEYS */;


--
-- Definition of table `my_service_type`
--

DROP TABLE IF EXISTS `my_service_type`;
CREATE TABLE `my_service_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `service` varchar(100) DEFAULT NULL,
  `branch` varchar(255) DEFAULT NULL,
  `branch_id` varchar(255) DEFAULT NULL,
  `location` varchar(255) DEFAULT NULL,
  `location_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `my_service_type`
--

/*!40000 ALTER TABLE `my_service_type` DISABLE KEYS */;
INSERT INTO `my_service_type` (`id`,`service`,`branch`,`branch_id`,`location`,`location_id`) VALUES 
 (1,'Service','Algorithm - Dgte','9','Selling Area','14'),
 (4,'Field Service','Algorithm - Dgte','9','Selling Area','14'),
 (5,'Back Job','Algorithm - Dgte','9','Selling Area','14'),
 (7,'Lenovo Service Center Only','Algorithm - Dgte','9','Selling Area','14'),
 (8,'Asus Service Center Only','Algorithm - Dgte','9','Selling Area','14');
/*!40000 ALTER TABLE `my_service_type` ENABLE KEYS */;


--
-- Definition of table `my_services`
--

DROP TABLE IF EXISTS `my_services`;
CREATE TABLE `my_services` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `transaction_no` varchar(100) DEFAULT NULL,
  `service_slip_no` varchar(100) DEFAULT NULL,
  `serviced_by` varchar(100) DEFAULT NULL,
  `service_by_id` varchar(100) DEFAULT NULL,
  `department_manager` varchar(100) DEFAULT NULL,
  `department_manager_id` varchar(100) DEFAULT NULL,
  `department` varchar(100) DEFAULT NULL,
  `department_id` varchar(100) DEFAULT NULL,
  `customer_name` varchar(100) DEFAULT NULL,
  `customer_id` varchar(100) DEFAULT NULL,
  `qty` double DEFAULT NULL,
  `unit` varchar(100) DEFAULT NULL,
  `description` varchar(100) DEFAULT NULL,
  `problem` varchar(100) DEFAULT NULL,
  `date_received` date DEFAULT NULL,
  `date_assigned` date DEFAULT NULL,
  `date_released` date DEFAULT NULL,
  `added_by` varchar(100) DEFAULT NULL,
  `remarks` text,
  `status` int(11) DEFAULT NULL,
  `service_type` varchar(100) DEFAULT NULL,
  `service_type_id` varchar(100) DEFAULT NULL,
  `amount` double DEFAULT NULL,
  `cashier` varchar(100) DEFAULT NULL,
  `cashier_id` varchar(100) DEFAULT NULL,
  `user_id` varchar(100) DEFAULT NULL,
  `user_screen_name` varchar(100) DEFAULT NULL,
  `customer_contact_no` varchar(100) DEFAULT NULL,
  `branch` varchar(255) DEFAULT NULL,
  `branch_id` varchar(255) DEFAULT NULL,
  `location` varchar(255) DEFAULT NULL,
  `location_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `my_services`
--

/*!40000 ALTER TABLE `my_services` DISABLE KEYS */;
/*!40000 ALTER TABLE `my_services` ENABLE KEYS */;


--
-- Definition of table `my_services_barcodes_customers`
--

DROP TABLE IF EXISTS `my_services_barcodes_customers`;
CREATE TABLE `my_services_barcodes_customers` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `customer_id` varchar(255) DEFAULT NULL,
  `customer_name` varchar(255) DEFAULT NULL,
  `transaction_no` varchar(255) DEFAULT NULL,
  `date_added` datetime DEFAULT NULL,
  `barcode` varchar(255) DEFAULT NULL,
  `branch` varchar(255) DEFAULT NULL,
  `branch_id` varchar(255) DEFAULT NULL,
  `location` varchar(255) DEFAULT NULL,
  `location_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `my_services_barcodes_customers`
--

/*!40000 ALTER TABLE `my_services_barcodes_customers` DISABLE KEYS */;
/*!40000 ALTER TABLE `my_services_barcodes_customers` ENABLE KEYS */;


--
-- Definition of table `my_services_crews`
--

DROP TABLE IF EXISTS `my_services_crews`;
CREATE TABLE `my_services_crews` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `fname` varchar(100) DEFAULT NULL,
  `mi` varchar(100) DEFAULT NULL,
  `lname` varchar(100) DEFAULT NULL,
  `address` varchar(100) DEFAULT NULL,
  `contact_no` varchar(100) DEFAULT NULL,
  `manager` varchar(100) DEFAULT NULL,
  `manager_id` varchar(100) DEFAULT NULL,
  `department` varchar(100) DEFAULT NULL,
  `department_id` varchar(100) DEFAULT NULL,
  `is_manager` int(11) DEFAULT NULL,
  `is_status` int(11) DEFAULT NULL,
  `account_created` int(11) DEFAULT NULL,
  `branch` varchar(255) DEFAULT NULL,
  `branch_id` varchar(255) DEFAULT NULL,
  `location` varchar(255) DEFAULT NULL,
  `location_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `my_services_crews`
--

/*!40000 ALTER TABLE `my_services_crews` DISABLE KEYS */;
/*!40000 ALTER TABLE `my_services_crews` ENABLE KEYS */;


--
-- Definition of table `my_services_customers`
--

DROP TABLE IF EXISTS `my_services_customers`;
CREATE TABLE `my_services_customers` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `customer_no` varchar(100) DEFAULT NULL,
  `customer_name` varchar(100) DEFAULT NULL,
  `address` varchar(100) DEFAULT NULL,
  `contact_no` varchar(100) DEFAULT NULL,
  `balance` double DEFAULT NULL,
  `branch` varchar(255) DEFAULT NULL,
  `branch_id` varchar(255) DEFAULT NULL,
  `location` varchar(255) DEFAULT NULL,
  `location_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13758 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `my_services_customers`
--

/*!40000 ALTER TABLE `my_services_customers` DISABLE KEYS */;
INSERT INTO `my_services_customers` (`id`,`customer_no`,`customer_name`,`address`,`contact_no`,`balance`,`branch`,`branch_id`,`location`,`location_id`) VALUES 
 (13756,'1|00001','','','',0,'Dumaguete City','1','Selling Area','1'),
 (13757,'1|00002','Ronald Pascua','','',0,'Dumaguete City','1','Selling Area','1');
/*!40000 ALTER TABLE `my_services_customers` ENABLE KEYS */;


--
-- Definition of table `my_services_departments`
--

DROP TABLE IF EXISTS `my_services_departments`;
CREATE TABLE `my_services_departments` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `department` varchar(100) DEFAULT NULL,
  `manager` varchar(100) DEFAULT NULL,
  `manager_id` varchar(100) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `branch` varchar(255) DEFAULT NULL,
  `branch_id` varchar(255) DEFAULT NULL,
  `location` varchar(255) DEFAULT NULL,
  `location_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `my_services_departments`
--

/*!40000 ALTER TABLE `my_services_departments` DISABLE KEYS */;
/*!40000 ALTER TABLE `my_services_departments` ENABLE KEYS */;


--
-- Definition of table `my_services_description`
--

DROP TABLE IF EXISTS `my_services_description`;
CREATE TABLE `my_services_description` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `description` varchar(100) DEFAULT NULL,
  `amount` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `my_services_description`
--

/*!40000 ALTER TABLE `my_services_description` DISABLE KEYS */;
/*!40000 ALTER TABLE `my_services_description` ENABLE KEYS */;


--
-- Definition of table `my_services_description_customers`
--

DROP TABLE IF EXISTS `my_services_description_customers`;
CREATE TABLE `my_services_description_customers` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `description` varchar(100) DEFAULT NULL,
  `amount` double DEFAULT NULL,
  `customer_id` varchar(100) DEFAULT NULL,
  `customer_name` varchar(100) DEFAULT NULL,
  `transaction_no` varchar(100) DEFAULT NULL,
  `date_added` datetime DEFAULT NULL,
  `user_name` varchar(100) DEFAULT NULL,
  `unit` varchar(100) DEFAULT NULL,
  `barcode` varchar(100) DEFAULT NULL,
  `branch` varchar(255) DEFAULT NULL,
  `branch_id` varchar(255) DEFAULT NULL,
  `location` varchar(255) DEFAULT NULL,
  `location_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `my_services_description_customers`
--

/*!40000 ALTER TABLE `my_services_description_customers` DISABLE KEYS */;
/*!40000 ALTER TABLE `my_services_description_customers` ENABLE KEYS */;


--
-- Definition of table `my_services_item_replacements`
--

DROP TABLE IF EXISTS `my_services_item_replacements`;
CREATE TABLE `my_services_item_replacements` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `barcode` varchar(100) DEFAULT NULL,
  `description` varchar(100) DEFAULT NULL,
  `qty` double DEFAULT NULL,
  `price` double DEFAULT NULL,
  `item_code` varchar(100) DEFAULT NULL,
  `category` varchar(100) DEFAULT NULL,
  `category_id` varchar(100) DEFAULT NULL,
  `classification` varchar(100) DEFAULT NULL,
  `classification_id` varchar(100) DEFAULT NULL,
  `sub_classification` varchar(100) DEFAULT NULL,
  `sub_classification_id` varchar(100) DEFAULT NULL,
  `unit` varchar(100) DEFAULT NULL,
  `conversion` double DEFAULT NULL,
  `item_type` varchar(100) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `supplier` varchar(100) DEFAULT NULL,
  `fixed_price` int(11) DEFAULT NULL,
  `supplier_id` varchar(100) DEFAULT NULL,
  `multi_level_pricing` int(11) DEFAULT NULL,
  `vatable` int(11) DEFAULT NULL,
  `reorder_level` double DEFAULT NULL,
  `markup` double DEFAULT NULL,
  `brand` varchar(100) DEFAULT NULL,
  `brand_id` varchar(100) DEFAULT NULL,
  `model` varchar(100) DEFAULT NULL,
  `model_id` varchar(100) DEFAULT NULL,
  `selling_type` varchar(100) DEFAULT NULL,
  `branch` varchar(100) DEFAULT NULL,
  `branch_code` varchar(100) DEFAULT NULL,
  `location` varchar(100) DEFAULT NULL,
  `location_id` varchar(100) DEFAULT NULL,
  `serial_no` varchar(100) DEFAULT NULL,
  `user_id` varchar(100) DEFAULT NULL,
  `user_screen_name` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `my_services_item_replacements`
--

/*!40000 ALTER TABLE `my_services_item_replacements` DISABLE KEYS */;
/*!40000 ALTER TABLE `my_services_item_replacements` ENABLE KEYS */;


--
-- Definition of table `my_services_item_replacements_customers`
--

DROP TABLE IF EXISTS `my_services_item_replacements_customers`;
CREATE TABLE `my_services_item_replacements_customers` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `transaction_no` varchar(100) DEFAULT NULL,
  `customer_id` varchar(100) DEFAULT NULL,
  `customer_name` varchar(100) DEFAULT NULL,
  `item_code` varchar(100) DEFAULT NULL,
  `barcode` varchar(100) DEFAULT NULL,
  `description` varchar(100) DEFAULT NULL,
  `qty` double DEFAULT NULL,
  `selling_price` double DEFAULT NULL,
  `date_added` datetime DEFAULT NULL,
  `user_name` varchar(100) DEFAULT NULL,
  `category` varchar(100) DEFAULT NULL,
  `category_id` varchar(100) DEFAULT NULL,
  `classification` varchar(100) DEFAULT NULL,
  `classification_id` varchar(100) DEFAULT NULL,
  `sub_classification` varchar(100) DEFAULT NULL,
  `sub_classification_id` varchar(100) DEFAULT NULL,
  `unit` varchar(100) DEFAULT NULL,
  `conversion` double DEFAULT NULL,
  `item_type` varchar(100) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `supplier` varchar(100) DEFAULT NULL,
  `fixed_price` int(11) DEFAULT NULL,
  `supplier_id` varchar(100) DEFAULT NULL,
  `multi_level_pricing` int(11) DEFAULT NULL,
  `vatable` int(11) DEFAULT NULL,
  `reorder_level` double DEFAULT NULL,
  `markup` double DEFAULT NULL,
  `brand` varchar(100) DEFAULT NULL,
  `brand_id` varchar(100) DEFAULT NULL,
  `model` varchar(100) DEFAULT NULL,
  `model_id` varchar(100) DEFAULT NULL,
  `selling_type` varchar(100) DEFAULT NULL,
  `branch` varchar(100) DEFAULT NULL,
  `branch_code` varchar(100) DEFAULT NULL,
  `location` varchar(100) DEFAULT NULL,
  `location_id` varchar(100) DEFAULT NULL,
  `serial_no` varchar(100) DEFAULT NULL,
  `user_id` varchar(100) DEFAULT NULL,
  `user_screen_name` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `my_services_item_replacements_customers`
--

/*!40000 ALTER TABLE `my_services_item_replacements_customers` DISABLE KEYS */;
/*!40000 ALTER TABLE `my_services_item_replacements_customers` ENABLE KEYS */;


--
-- Definition of table `my_services_others`
--

DROP TABLE IF EXISTS `my_services_others`;
CREATE TABLE `my_services_others` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `amount` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `my_services_others`
--

/*!40000 ALTER TABLE `my_services_others` DISABLE KEYS */;
/*!40000 ALTER TABLE `my_services_others` ENABLE KEYS */;


--
-- Definition of table `my_services_others_customers`
--

DROP TABLE IF EXISTS `my_services_others_customers`;
CREATE TABLE `my_services_others_customers` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `customer_id` varchar(100) DEFAULT NULL,
  `customer_name` varchar(100) DEFAULT NULL,
  `transaction_no` varchar(100) DEFAULT NULL,
  `date_added` datetime DEFAULT NULL,
  `name` varchar(100) DEFAULT NULL,
  `amount` double DEFAULT NULL,
  `qty` double DEFAULT NULL,
  `branch` varchar(255) DEFAULT NULL,
  `branch_id` varchar(255) DEFAULT NULL,
  `location` varchar(255) DEFAULT NULL,
  `location_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `my_services_others_customers`
--

/*!40000 ALTER TABLE `my_services_others_customers` DISABLE KEYS */;
/*!40000 ALTER TABLE `my_services_others_customers` ENABLE KEYS */;


--
-- Definition of table `my_services_particulars`
--

DROP TABLE IF EXISTS `my_services_particulars`;
CREATE TABLE `my_services_particulars` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `particular` varchar(100) DEFAULT NULL,
  `amount` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `my_services_particulars`
--

/*!40000 ALTER TABLE `my_services_particulars` DISABLE KEYS */;
/*!40000 ALTER TABLE `my_services_particulars` ENABLE KEYS */;


--
-- Definition of table `my_services_problems`
--

DROP TABLE IF EXISTS `my_services_problems`;
CREATE TABLE `my_services_problems` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `problem` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `my_services_problems`
--

/*!40000 ALTER TABLE `my_services_problems` DISABLE KEYS */;
/*!40000 ALTER TABLE `my_services_problems` ENABLE KEYS */;


--
-- Definition of table `my_services_problems_customers`
--

DROP TABLE IF EXISTS `my_services_problems_customers`;
CREATE TABLE `my_services_problems_customers` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `problem` varchar(100) DEFAULT NULL,
  `customer_id` varchar(100) DEFAULT NULL,
  `customer_name` varchar(100) DEFAULT NULL,
  `transaction_no` varchar(100) DEFAULT NULL,
  `date_added` datetime DEFAULT NULL,
  `amount` double DEFAULT NULL,
  `branch` varchar(255) DEFAULT NULL,
  `branch_id` varchar(255) DEFAULT NULL,
  `location` varchar(255) DEFAULT NULL,
  `location_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `my_services_problems_customers`
--

/*!40000 ALTER TABLE `my_services_problems_customers` DISABLE KEYS */;
/*!40000 ALTER TABLE `my_services_problems_customers` ENABLE KEYS */;


--
-- Definition of table `my_services_uom`
--

DROP TABLE IF EXISTS `my_services_uom`;
CREATE TABLE `my_services_uom` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uom` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `my_services_uom`
--

/*!40000 ALTER TABLE `my_services_uom` DISABLE KEYS */;
INSERT INTO `my_services_uom` (`id`,`uom`) VALUES 
 (1,'units'),
 (2,'pc'),
 (4,'pcs'),
 (9,'1'),
 (10,'`'),
 (11,'2'),
 (12,'3'),
 (13,'\\'),
 (14,'000000000063'),
 (15,'\\');
/*!40000 ALTER TABLE `my_services_uom` ENABLE KEYS */;


--
-- Definition of table `new_inventory`
--

DROP TABLE IF EXISTS `new_inventory`;
CREATE TABLE `new_inventory` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(100) DEFAULT NULL,
  `date_added` datetime DEFAULT NULL,
  `new_inventory_no` varchar(100) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `new_inventory`
--

/*!40000 ALTER TABLE `new_inventory` DISABLE KEYS */;
/*!40000 ALTER TABLE `new_inventory` ENABLE KEYS */;


--
-- Definition of table `new_inventory_items`
--

DROP TABLE IF EXISTS `new_inventory_items`;
CREATE TABLE `new_inventory_items` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(100) DEFAULT NULL,
  `date_added` datetime DEFAULT NULL,
  `new_inventory_no` varchar(100) DEFAULT NULL,
  `status` varchar(100) DEFAULT NULL,
  `barcode` varchar(100) DEFAULT NULL,
  `description` varchar(100) DEFAULT NULL,
  `previous_qty` double DEFAULT NULL,
  `new_qty` double DEFAULT NULL,
  `selling_price` double DEFAULT NULL,
  `unit` varchar(100) DEFAULT NULL,
  `conversion` double DEFAULT NULL,
  `category` varchar(100) DEFAULT NULL,
  `category_id` varchar(100) DEFAULT NULL,
  `classification` varchar(100) DEFAULT NULL,
  `classification_id` varchar(100) DEFAULT NULL,
  `sub_class` varchar(100) DEFAULT NULL,
  `sub_class_id` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `new_inventory_items`
--

/*!40000 ALTER TABLE `new_inventory_items` DISABLE KEYS */;
/*!40000 ALTER TABLE `new_inventory_items` ENABLE KEYS */;


--
-- Definition of table `order_items`
--

DROP TABLE IF EXISTS `order_items`;
CREATE TABLE `order_items` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sales_no` varchar(100) DEFAULT NULL,
  `item_code` varchar(100) DEFAULT NULL,
  `barcode` varchar(100) DEFAULT NULL,
  `description` varchar(100) DEFAULT NULL,
  `generic_name` varchar(100) DEFAULT NULL,
  `item_type` varchar(100) DEFAULT NULL,
  `supplier_name` varchar(100) DEFAULT NULL,
  `supplier_id` varchar(100) DEFAULT NULL,
  `serial_no` varchar(100) DEFAULT NULL,
  `product_qty` double DEFAULT NULL,
  `unit` varchar(100) DEFAULT NULL,
  `conversion` double DEFAULT NULL,
  `selling_price` double DEFAULT NULL,
  `date_added` datetime DEFAULT NULL,
  `user_id` varchar(100) DEFAULT NULL,
  `user_screen_name` varchar(100) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `is_vatable` int(11) DEFAULT NULL,
  `selling_type` int(11) DEFAULT NULL,
  `discount_name` varchar(100) DEFAULT NULL,
  `discount_rate` double DEFAULT NULL,
  `discount_amount` double DEFAULT NULL,
  `discount_customer_name` varchar(100) DEFAULT NULL,
  `discount_customer_id` varchar(100) DEFAULT NULL,
  `branch` varchar(100) DEFAULT NULL,
  `branch_code` varchar(100) DEFAULT NULL,
  `location` varchar(100) DEFAULT NULL,
  `location_id` varchar(100) DEFAULT NULL,
  `category` varchar(100) DEFAULT NULL,
  `category_id` varchar(100) DEFAULT NULL,
  `classification` varchar(100) DEFAULT NULL,
  `classification_id` varchar(100) DEFAULT NULL,
  `sub_classification` varchar(100) DEFAULT NULL,
  `sub_classification_id` varchar(100) DEFAULT NULL,
  `brand` varchar(100) DEFAULT NULL,
  `brand_id` varchar(100) DEFAULT NULL,
  `model` varchar(100) DEFAULT NULL,
  `model_id` varchar(100) DEFAULT NULL,
  `addtl_amount` double DEFAULT NULL,
  `wtax` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `order_items`
--

/*!40000 ALTER TABLE `order_items` DISABLE KEYS */;
/*!40000 ALTER TABLE `order_items` ENABLE KEYS */;


--
-- Definition of table `orders`
--

DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sales_no` varchar(100) DEFAULT NULL,
  `date_added` datetime DEFAULT NULL,
  `user_screen_name` varchar(100) DEFAULT NULL,
  `user_id` varchar(100) DEFAULT NULL,
  `session_no` varchar(100) DEFAULT NULL,
  `remarks` varchar(100) DEFAULT NULL,
  `gross_amount` double DEFAULT NULL,
  `amount_due` double DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `sales_type` int(11) DEFAULT NULL,
  `line_discount` double DEFAULT NULL,
  `customer_id` varchar(100) DEFAULT NULL,
  `customer_name` varchar(100) DEFAULT NULL,
  `discount_name` varchar(100) DEFAULT NULL,
  `discount_rate` double DEFAULT NULL,
  `discount_amount` double DEFAULT NULL,
  `discount_customer_name` varchar(100) DEFAULT NULL,
  `discount_customer_id` varchar(100) DEFAULT NULL,
  `charge_type` varchar(100) DEFAULT NULL,
  `charge_type_id` varchar(100) DEFAULT NULL,
  `charge_reference_no` varchar(100) DEFAULT NULL,
  `charge_customer_name` varchar(100) DEFAULT NULL,
  `charge_customer_id` varchar(100) DEFAULT NULL,
  `charge_amount` double DEFAULT NULL,
  `check_bank` varchar(100) DEFAULT NULL,
  `check_no` varchar(100) DEFAULT NULL,
  `check_amount` double DEFAULT NULL,
  `check_holder` varchar(100) DEFAULT NULL,
  `check_date` date DEFAULT NULL,
  `credit_card_type` varchar(100) DEFAULT NULL,
  `credit_card_rate` double DEFAULT NULL,
  `credit_card_amount` double DEFAULT NULL,
  `credit_card_no` varchar(100) DEFAULT NULL,
  `credit_card_holder` varchar(100) DEFAULT NULL,
  `credit_card_approval_code` varchar(100) DEFAULT NULL,
  `gift_certificate_from` varchar(100) DEFAULT NULL,
  `gift_certificate_description` varchar(100) DEFAULT NULL,
  `gift_certificate_no` varchar(100) DEFAULT NULL,
  `gift_certificate_amount` double DEFAULT NULL,
  `prepaid_customer_name` varchar(100) DEFAULT NULL,
  `prepaid_customer_id` varchar(100) DEFAULT NULL,
  `prepaid_amount` double DEFAULT NULL,
  `addtl_amount` double DEFAULT NULL,
  `wtax` double DEFAULT NULL,
  `branch` varchar(100) DEFAULT NULL,
  `branch_id` varchar(100) DEFAULT NULL,
  `location` varchar(100) DEFAULT NULL,
  `location_id` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `sales_no` (`sales_no`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `orders`
--

/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;


--
-- Definition of table `payment_terms`
--

DROP TABLE IF EXISTS `payment_terms`;
CREATE TABLE `payment_terms` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `days` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `payment_terms`
--

/*!40000 ALTER TABLE `payment_terms` DISABLE KEYS */;
INSERT INTO `payment_terms` (`id`,`days`) VALUES 
 (1,30),
 (2,90),
 (3,120),
 (4,150),
 (5,180),
 (6,210),
 (7,240),
 (8,270),
 (9,300);
/*!40000 ALTER TABLE `payment_terms` ENABLE KEYS */;


--
-- Definition of table `prepaid_payments`
--

DROP TABLE IF EXISTS `prepaid_payments`;
CREATE TABLE `prepaid_payments` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cash` double DEFAULT NULL,
  `check_bank` varchar(100) DEFAULT NULL,
  `check_no` varchar(100) DEFAULT NULL,
  `check_amount` double DEFAULT NULL,
  `added_by` varchar(100) DEFAULT NULL,
  `date_added` datetime DEFAULT NULL,
  `customer_name` varchar(100) DEFAULT NULL,
  `customer_id` varchar(100) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `cheque_holder` varchar(1000) DEFAULT NULL,
  `cheque_date` date DEFAULT NULL,
  `user_id` varchar(100) DEFAULT NULL,
  `user_screen_name` varchar(100) DEFAULT NULL,
  `branch` varchar(100) DEFAULT NULL,
  `branch_id` varchar(100) DEFAULT NULL,
  `location` varchar(100) DEFAULT NULL,
  `location_id` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `prepaid_payments`
--

/*!40000 ALTER TABLE `prepaid_payments` DISABLE KEYS */;
/*!40000 ALTER TABLE `prepaid_payments` ENABLE KEYS */;


--
-- Definition of table `purchase_order_items`
--

DROP TABLE IF EXISTS `purchase_order_items`;
CREATE TABLE `purchase_order_items` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `po_no` varchar(100) DEFAULT NULL,
  `user_name` varchar(500) DEFAULT NULL,
  `session_no` varchar(500) DEFAULT NULL,
  `date_added` datetime DEFAULT NULL,
  `supplier` varchar(500) DEFAULT NULL,
  `supllier_id` varchar(500) DEFAULT NULL,
  `remarks` varchar(500) DEFAULT NULL,
  `barcode` varchar(500) DEFAULT NULL,
  `description` varchar(500) DEFAULT NULL,
  `qty` double DEFAULT NULL,
  `cost` double DEFAULT NULL,
  `category` varchar(500) DEFAULT NULL,
  `category_id` varchar(500) DEFAULT NULL,
  `classification` varchar(500) DEFAULT NULL,
  `classification_id` varchar(500) DEFAULT NULL,
  `sub_class` varchar(500) DEFAULT NULL,
  `sub_class_id` varchar(500) DEFAULT NULL,
  `conversion` int(11) DEFAULT NULL,
  `unit` varchar(500) DEFAULT NULL,
  `brand` varchar(100) DEFAULT NULL,
  `brand_id` varchar(100) DEFAULT NULL,
  `model` varchar(100) DEFAULT NULL,
  `model_id` varchar(100) DEFAULT NULL,
  `main_barcode` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `purchase_order_items`
--

/*!40000 ALTER TABLE `purchase_order_items` DISABLE KEYS */;
/*!40000 ALTER TABLE `purchase_order_items` ENABLE KEYS */;


--
-- Definition of table `purchase_orders`
--

DROP TABLE IF EXISTS `purchase_orders`;
CREATE TABLE `purchase_orders` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `puchase_order_no` varchar(255) DEFAULT NULL,
  `user_name` varchar(255) DEFAULT NULL,
  `session_no` varchar(255) DEFAULT NULL,
  `date_added` datetime DEFAULT NULL,
  `supplier` varchar(255) DEFAULT NULL,
  `supplier_id` varchar(255) DEFAULT NULL,
  `remarks` varchar(255) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `date_delivered` date DEFAULT NULL,
  `date_received` date DEFAULT NULL,
  `branch` varchar(255) DEFAULT NULL,
  `branch_id` varchar(255) DEFAULT NULL,
  `location` varchar(255) DEFAULT NULL,
  `location_id` varchar(255) DEFAULT NULL,
  `reference_no` varchar(255) DEFAULT NULL,
  `gross_total` double DEFAULT NULL,
  `discount` varchar(255) DEFAULT NULL,
  `discount_amount` double DEFAULT NULL,
  `discount_rate` double DEFAULT NULL,
  `receipt_no` varchar(255) DEFAULT NULL,
  `receipt_type` varchar(255) DEFAULT NULL,
  `receipt_type_id` varchar(255) DEFAULT NULL,
  `total_qty_ordered` double DEFAULT NULL,
  `total_qty_received` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `purchase_orders`
--

/*!40000 ALTER TABLE `purchase_orders` DISABLE KEYS */;
/*!40000 ALTER TABLE `purchase_orders` ENABLE KEYS */;


--
-- Definition of table `receipt_barcodes`
--

DROP TABLE IF EXISTS `receipt_barcodes`;
CREATE TABLE `receipt_barcodes` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `barcode` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `receipt_barcodes`
--

/*!40000 ALTER TABLE `receipt_barcodes` DISABLE KEYS */;
/*!40000 ALTER TABLE `receipt_barcodes` ENABLE KEYS */;


--
-- Definition of table `receipt_items`
--

DROP TABLE IF EXISTS `receipt_items`;
CREATE TABLE `receipt_items` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `receipt_no` varchar(500) DEFAULT NULL,
  `user_name` varchar(500) DEFAULT NULL,
  `session_no` varchar(500) DEFAULT NULL,
  `date_added` datetime DEFAULT NULL,
  `supplier` varchar(500) DEFAULT NULL,
  `supllier_id` varchar(500) DEFAULT NULL,
  `remarks` varchar(500) DEFAULT NULL,
  `barcode` varchar(100) DEFAULT NULL,
  `description` text,
  `qty` double DEFAULT NULL,
  `cost` double DEFAULT NULL,
  `category` varchar(100) DEFAULT NULL,
  `category_id` varchar(100) DEFAULT NULL,
  `classification` varchar(100) DEFAULT NULL,
  `classification_id` varchar(100) DEFAULT NULL,
  `sub_class` varchar(100) DEFAULT NULL,
  `sub_class_id` varchar(100) DEFAULT NULL,
  `conversion` double DEFAULT NULL,
  `unit` varchar(100) DEFAULT NULL,
  `date_delivered` date DEFAULT NULL,
  `date_received` date DEFAULT NULL,
  `barcodes` varchar(100) DEFAULT NULL,
  `batch_no` varchar(100) DEFAULT NULL,
  `serial_no` text,
  `main_barcode` varchar(100) DEFAULT NULL,
  `brand` varchar(100) DEFAULT NULL,
  `brand_id` varchar(100) DEFAULT NULL,
  `model` varchar(100) DEFAULT NULL,
  `model_id` varchar(100) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `previous_cost` double DEFAULT NULL,
  `receipt_type_id` varchar(100) DEFAULT NULL,
  `branch` varchar(100) DEFAULT NULL,
  `branch_id` varchar(100) DEFAULT NULL,
  `location` varchar(100) DEFAULT NULL,
  `location_id` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `receipt_items`
--

/*!40000 ALTER TABLE `receipt_items` DISABLE KEYS */;
/*!40000 ALTER TABLE `receipt_items` ENABLE KEYS */;


--
-- Definition of table `receipt_serial_nos`
--

DROP TABLE IF EXISTS `receipt_serial_nos`;
CREATE TABLE `receipt_serial_nos` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `serial_no` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `receipt_serial_nos`
--

/*!40000 ALTER TABLE `receipt_serial_nos` DISABLE KEYS */;
/*!40000 ALTER TABLE `receipt_serial_nos` ENABLE KEYS */;


--
-- Definition of table `receipts`
--

DROP TABLE IF EXISTS `receipts`;
CREATE TABLE `receipts` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `receipt_no` varchar(100) DEFAULT NULL,
  `user_name` varchar(100) DEFAULT NULL,
  `session_no` varchar(100) DEFAULT NULL,
  `date_added` datetime DEFAULT NULL,
  `supplier` varchar(100) DEFAULT NULL,
  `supllier_id` varchar(100) DEFAULT NULL,
  `remarks` varchar(100) DEFAULT NULL,
  `date_delivered` date DEFAULT NULL,
  `date_received` date DEFAULT NULL,
  `receipt_type` varchar(100) DEFAULT NULL,
  `reference_no` varchar(100) DEFAULT NULL,
  `branch` varchar(100) DEFAULT NULL,
  `branch_id` varchar(100) DEFAULT NULL,
  `gross_total` double DEFAULT NULL,
  `net_total` double DEFAULT NULL,
  `batch_no` varchar(100) DEFAULT NULL,
  `discount` double DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `receipt_type_id` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `receipts`
--

/*!40000 ALTER TABLE `receipts` DISABLE KEYS */;
/*!40000 ALTER TABLE `receipts` ENABLE KEYS */;


--
-- Definition of table `requisition_slip_items`
--

DROP TABLE IF EXISTS `requisition_slip_items`;
CREATE TABLE `requisition_slip_items` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `requisition_slip_no` varchar(255) DEFAULT NULL,
  `requisition_date` date DEFAULT NULL,
  `requisition_type` varchar(255) DEFAULT NULL,
  `requisition_department` varchar(255) DEFAULT NULL,
  `requisition_department_id` varchar(255) DEFAULT NULL,
  `requested_by` varchar(255) DEFAULT NULL,
  `item_code` varchar(255) DEFAULT NULL,
  `barcode` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `product_qty` double DEFAULT NULL,
  `unit` text,
  `cost` double DEFAULT NULL,
  `selling_price` double DEFAULT NULL,
  `branch` varchar(255) DEFAULT NULL,
  `branch_id` varchar(255) DEFAULT NULL,
  `location` varchar(255) DEFAULT NULL,
  `location_id` varchar(255) DEFAULT NULL,
  `date_added` datetime DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `requisition_slip_items`
--

/*!40000 ALTER TABLE `requisition_slip_items` DISABLE KEYS */;
/*!40000 ALTER TABLE `requisition_slip_items` ENABLE KEYS */;


--
-- Definition of table `requisition_slips`
--

DROP TABLE IF EXISTS `requisition_slips`;
CREATE TABLE `requisition_slips` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `requisition_slip_no` varchar(255) DEFAULT NULL,
  `requisition_date` date DEFAULT NULL,
  `requisition_type` varchar(255) DEFAULT NULL,
  `requisition_department` varchar(255) DEFAULT NULL,
  `requisition_department_id` varchar(255) DEFAULT NULL,
  `requested_by` varchar(255) DEFAULT NULL,
  `branch` varchar(255) DEFAULT NULL,
  `branch_id` varchar(255) DEFAULT NULL,
  `location` varchar(255) DEFAULT NULL,
  `location_id` varchar(255) DEFAULT NULL,
  `date_added` datetime DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `requisition_slips`
--

/*!40000 ALTER TABLE `requisition_slips` DISABLE KEYS */;
/*!40000 ALTER TABLE `requisition_slips` ENABLE KEYS */;


--
-- Definition of table `sale_item_replacements`
--

DROP TABLE IF EXISTS `sale_item_replacements`;
CREATE TABLE `sale_item_replacements` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sales_no` varchar(100) DEFAULT NULL,
  `item_code` varchar(100) DEFAULT NULL,
  `barcode` varchar(100) DEFAULT NULL,
  `description` varchar(100) DEFAULT NULL,
  `generic_name` varchar(100) DEFAULT NULL,
  `item_type` varchar(100) DEFAULT NULL,
  `supplier_name` varchar(100) DEFAULT NULL,
  `supplier_id` varchar(100) DEFAULT NULL,
  `serial_no` varchar(100) DEFAULT NULL,
  `product_qty` double DEFAULT NULL,
  `unit` varchar(100) DEFAULT NULL,
  `conversion` double DEFAULT NULL,
  `selling_price` double DEFAULT NULL,
  `date_added` datetime DEFAULT NULL,
  `user_id` varchar(100) DEFAULT NULL,
  `user_screen_name` varchar(100) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `is_vatable` int(11) DEFAULT NULL,
  `selling_type` int(11) DEFAULT NULL,
  `discount_name` varchar(100) DEFAULT NULL,
  `discount_rate` double DEFAULT NULL,
  `discount_amount` double DEFAULT NULL,
  `discount_customer_name` varchar(100) DEFAULT NULL,
  `discount_customer_id` varchar(100) DEFAULT NULL,
  `branch` varchar(100) DEFAULT NULL,
  `branch_code` varchar(100) DEFAULT NULL,
  `location` varchar(100) DEFAULT NULL,
  `location_id` varchar(100) DEFAULT NULL,
  `category` varchar(100) DEFAULT NULL,
  `category_id` varchar(100) DEFAULT NULL,
  `classification` varchar(100) DEFAULT NULL,
  `classification_id` varchar(100) DEFAULT NULL,
  `sub_classification` varchar(100) DEFAULT NULL,
  `sub_classification_id` varchar(100) DEFAULT NULL,
  `brand` varchar(100) DEFAULT NULL,
  `brand_id` varchar(100) DEFAULT NULL,
  `model` varchar(100) DEFAULT NULL,
  `model_id` varchar(100) DEFAULT NULL,
  `is_replacement` int(11) DEFAULT NULL,
  `reason` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `sale_item_replacements`
--

/*!40000 ALTER TABLE `sale_item_replacements` DISABLE KEYS */;
/*!40000 ALTER TABLE `sale_item_replacements` ENABLE KEYS */;


--
-- Definition of table `sale_items`
--

DROP TABLE IF EXISTS `sale_items`;
CREATE TABLE `sale_items` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sales_no` varchar(100) DEFAULT NULL,
  `item_code` varchar(100) DEFAULT NULL,
  `barcode` varchar(100) DEFAULT NULL,
  `description` text,
  `generic_name` text,
  `item_type` text,
  `supplier_name` varchar(100) DEFAULT NULL,
  `supplier_id` varchar(100) DEFAULT NULL,
  `serial_no` text,
  `product_qty` double DEFAULT NULL,
  `unit` text,
  `conversion` double DEFAULT NULL,
  `selling_price` double DEFAULT NULL,
  `date_added` datetime DEFAULT NULL,
  `user_id` varchar(100) DEFAULT NULL,
  `user_screen_name` varchar(100) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `is_vatable` int(11) DEFAULT NULL,
  `selling_type` int(11) DEFAULT NULL,
  `discount_name` varchar(100) DEFAULT NULL,
  `discount_rate` double DEFAULT NULL,
  `discount_amount` double DEFAULT NULL,
  `discount_customer_name` varchar(100) DEFAULT NULL,
  `discount_customer_id` varchar(100) DEFAULT NULL,
  `branch` varchar(100) DEFAULT NULL,
  `branch_code` varchar(100) DEFAULT NULL,
  `location` varchar(100) DEFAULT NULL,
  `location_id` varchar(100) DEFAULT NULL,
  `category` varchar(100) DEFAULT NULL,
  `category_id` varchar(100) DEFAULT NULL,
  `classification` varchar(100) DEFAULT NULL,
  `classification_id` varchar(100) DEFAULT NULL,
  `sub_classification` varchar(100) DEFAULT NULL,
  `sub_classification_id` varchar(100) DEFAULT NULL,
  `brand` varchar(100) DEFAULT NULL,
  `brand_id` varchar(100) DEFAULT NULL,
  `model` text,
  `model_id` varchar(100) DEFAULT NULL,
  `addtl_amount` double DEFAULT NULL,
  `wtax` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=46173 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `sale_items`
--

/*!40000 ALTER TABLE `sale_items` DISABLE KEYS */;
INSERT INTO `sale_items` (`id`,`sales_no`,`item_code`,`barcode`,`description`,`generic_name`,`item_type`,`supplier_name`,`supplier_id`,`serial_no`,`product_qty`,`unit`,`conversion`,`selling_price`,`date_added`,`user_id`,`user_screen_name`,`status`,`is_vatable`,`selling_type`,`discount_name`,`discount_rate`,`discount_amount`,`discount_customer_name`,`discount_customer_id`,`branch`,`branch_code`,`location`,`location_id`,`category`,`category_id`,`classification`,`classification_id`,`sub_classification`,`sub_classification_id`,`brand`,`brand_id`,`model`,`model_id`,`addtl_amount`,`wtax`) VALUES 
 (46163,'1|000000000001','2','','Sample Item 2','','','','','',1,'[pc:0.0/1.0^1]',1,0,'2017-01-13 20:29:20','1','administrator',0,0,0,'',0,0,'','','Dumaguete City','1','Selling Area','1','',NULL,'',NULL,'',NULL,'',NULL,'',NULL,0,0),
 (46164,'1|000000000002','2','','Sample Item 2','','','','','',1,'[pc:0.0/1.0^1]',1,0,'2017-01-13 20:29:46','1','administrator',0,0,0,'',0,0,'','','Dumaguete City','1','Selling Area','1','',NULL,'',NULL,'',NULL,'',NULL,'',NULL,0,0),
 (46165,'1|000000000003','2','','Sample Item 2','','','','','',1,'[pc:0.0/1.0^1]',1,0,'2017-01-13 20:32:05','1','administrator',0,0,0,'',0,0,'','','Dumaguete City','1','Selling Area','1','',NULL,'',NULL,'',NULL,'',NULL,'',NULL,0,0);
INSERT INTO `sale_items` (`id`,`sales_no`,`item_code`,`barcode`,`description`,`generic_name`,`item_type`,`supplier_name`,`supplier_id`,`serial_no`,`product_qty`,`unit`,`conversion`,`selling_price`,`date_added`,`user_id`,`user_screen_name`,`status`,`is_vatable`,`selling_type`,`discount_name`,`discount_rate`,`discount_amount`,`discount_customer_name`,`discount_customer_id`,`branch`,`branch_code`,`location`,`location_id`,`category`,`category_id`,`classification`,`classification_id`,`sub_classification`,`sub_classification_id`,`brand`,`brand_id`,`model`,`model_id`,`addtl_amount`,`wtax`) VALUES 
 (46166,'1|000000000004','2','','Sample Item 2','','','','','',1,'[pc:0.0/1.0^1]',1,0,'2017-01-13 20:32:12','1','administrator',0,0,0,'',0,0,'','','Dumaguete City','1','Selling Area','1','',NULL,'',NULL,'',NULL,'',NULL,'',NULL,0,0),
 (46167,'1|000000000005','2','','Sample Item 2','','','','','',1,'[pc:0.0/1.0^1]',1,0,'2017-01-13 20:35:07','1','administrator',0,0,0,'',0,0,'','','Dumaguete City','1','Selling Area','1','',NULL,'',NULL,'',NULL,'',NULL,'',NULL,0,0),
 (46168,'1|000000000006','2','','Sample Item 2','','','','','',1,'[pc:0.0/1.0^1]',1,0,'2017-01-13 20:37:31','1','administrator',0,0,0,'',0,0,'','','Dumaguete City','1','Selling Area','1','',NULL,'',NULL,'',NULL,'',NULL,'',NULL,0,0);
INSERT INTO `sale_items` (`id`,`sales_no`,`item_code`,`barcode`,`description`,`generic_name`,`item_type`,`supplier_name`,`supplier_id`,`serial_no`,`product_qty`,`unit`,`conversion`,`selling_price`,`date_added`,`user_id`,`user_screen_name`,`status`,`is_vatable`,`selling_type`,`discount_name`,`discount_rate`,`discount_amount`,`discount_customer_name`,`discount_customer_id`,`branch`,`branch_code`,`location`,`location_id`,`category`,`category_id`,`classification`,`classification_id`,`sub_classification`,`sub_classification_id`,`brand`,`brand_id`,`model`,`model_id`,`addtl_amount`,`wtax`) VALUES 
 (46169,'1|000000000007','2','','Sample Item 2','','','','','',1,'[pc:0.0/1.0^1]',1,0,'2017-01-13 20:41:27','1','administrator',0,0,0,'',0,0,'','','Dumaguete City','1','Selling Area','1','',NULL,'',NULL,'',NULL,'',NULL,'',NULL,0,0),
 (46170,'1|000000000008','3','','Item 3','','','','','',1,'[pc:200.0/1.0^1]',1,200,'2017-01-13 20:42:44','1','administrator',0,0,0,'',0,0,'','','Dumaguete City','1','Selling Area','1','',NULL,'',NULL,'',NULL,'',NULL,'',NULL,0,0),
 (46171,'1|000000000009','3','','Item 3','','','','','',1,'[pc:200.0/1.0^1]',1,200,'2017-01-13 20:43:19','1','administrator',0,0,0,'',0,0,'','','Dumaguete City','1','Selling Area','1','',NULL,'',NULL,'',NULL,'',NULL,'',NULL,0,0);
INSERT INTO `sale_items` (`id`,`sales_no`,`item_code`,`barcode`,`description`,`generic_name`,`item_type`,`supplier_name`,`supplier_id`,`serial_no`,`product_qty`,`unit`,`conversion`,`selling_price`,`date_added`,`user_id`,`user_screen_name`,`status`,`is_vatable`,`selling_type`,`discount_name`,`discount_rate`,`discount_amount`,`discount_customer_name`,`discount_customer_id`,`branch`,`branch_code`,`location`,`location_id`,`category`,`category_id`,`classification`,`classification_id`,`sub_classification`,`sub_classification_id`,`brand`,`brand_id`,`model`,`model_id`,`addtl_amount`,`wtax`) VALUES 
 (46172,'1|000000000010','3','','Item 3','','','','','',1,'[pc:200.0/1.0^1]',1,200,'2017-01-13 20:48:34','1','administrator',0,0,0,'<enter amount>',0,5,'','','Dumaguete City','1','Selling Area','1','',NULL,'',NULL,'',NULL,'',NULL,'',NULL,0,0);
/*!40000 ALTER TABLE `sale_items` ENABLE KEYS */;


--
-- Definition of table `sales`
--

DROP TABLE IF EXISTS `sales`;
CREATE TABLE `sales` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sales_no` varchar(100) NOT NULL DEFAULT '',
  `date_added` datetime DEFAULT NULL,
  `user_screen_name` varchar(100) DEFAULT NULL,
  `user_id` varchar(100) DEFAULT NULL,
  `session_no` varchar(100) DEFAULT NULL,
  `remarks` varchar(100) DEFAULT NULL,
  `gross_amount` double DEFAULT NULL,
  `amount_due` double DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `sales_type` int(11) DEFAULT NULL,
  `line_discount` double DEFAULT NULL,
  `customer_id` varchar(100) DEFAULT NULL,
  `customer_name` varchar(100) DEFAULT NULL,
  `discount_name` varchar(100) DEFAULT NULL,
  `discount_rate` double DEFAULT NULL,
  `discount_amount` double DEFAULT NULL,
  `discount_customer_name` varchar(100) DEFAULT NULL,
  `discount_customer_id` varchar(100) DEFAULT NULL,
  `charge_type` varchar(100) DEFAULT NULL,
  `charge_type_id` varchar(100) DEFAULT NULL,
  `charge_reference_no` varchar(100) DEFAULT NULL,
  `charge_customer_name` varchar(100) DEFAULT NULL,
  `charge_customer_id` varchar(100) DEFAULT NULL,
  `charge_amount` double DEFAULT NULL,
  `check_bank` varchar(100) DEFAULT NULL,
  `check_no` varchar(100) DEFAULT NULL,
  `check_amount` double DEFAULT NULL,
  `check_holder` varchar(100) DEFAULT NULL,
  `check_date` date DEFAULT NULL,
  `credit_card_type` varchar(100) DEFAULT NULL,
  `credit_card_rate` double DEFAULT NULL,
  `credit_card_amount` double DEFAULT NULL,
  `credit_card_no` varchar(100) DEFAULT NULL,
  `credit_card_holder` varchar(100) DEFAULT NULL,
  `credit_card_approval_code` varchar(100) DEFAULT NULL,
  `gift_certificate_from` varchar(100) DEFAULT NULL,
  `gift_certificate_description` varchar(100) DEFAULT NULL,
  `gift_certificate_no` varchar(100) DEFAULT NULL,
  `gift_certificate_amount` double DEFAULT NULL,
  `prepaid_customer_name` varchar(100) DEFAULT NULL,
  `prepaid_customer_id` varchar(100) DEFAULT NULL,
  `prepaid_amount` double DEFAULT NULL,
  `addtl_amount` double DEFAULT NULL,
  `wtax` double DEFAULT NULL,
  `branch` varchar(100) DEFAULT NULL,
  `branch_id` varchar(100) DEFAULT NULL,
  `location` varchar(100) DEFAULT NULL,
  `location_id` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`,`sales_no`),
  UNIQUE KEY `CK_Per_No` (`sales_no`)
) ENGINE=InnoDB AUTO_INCREMENT=27546 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `sales`
--

/*!40000 ALTER TABLE `sales` DISABLE KEYS */;
INSERT INTO `sales` (`id`,`sales_no`,`date_added`,`user_screen_name`,`user_id`,`session_no`,`remarks`,`gross_amount`,`amount_due`,`status`,`sales_type`,`line_discount`,`customer_id`,`customer_name`,`discount_name`,`discount_rate`,`discount_amount`,`discount_customer_name`,`discount_customer_id`,`charge_type`,`charge_type_id`,`charge_reference_no`,`charge_customer_name`,`charge_customer_id`,`charge_amount`,`check_bank`,`check_no`,`check_amount`,`check_holder`,`check_date`,`credit_card_type`,`credit_card_rate`,`credit_card_amount`,`credit_card_no`,`credit_card_holder`,`credit_card_approval_code`,`gift_certificate_from`,`gift_certificate_description`,`gift_certificate_no`,`gift_certificate_amount`,`prepaid_customer_name`,`prepaid_customer_id`,`prepaid_amount`,`addtl_amount`,`wtax`,`branch`,`branch_id`,`location`,`location_id`) VALUES 
 (27536,'1|000000000001','2017-01-13 20:29:25','administrator','1','000000000000','',0,0,0,0,0,'','','',0,0,'','','','','','','',0,'','',0,'','2017-01-13','',0,0,'','','','','','',0,'','',0,0,0,'Dumaguete City','1','Selling Area','1'),
 (27537,'1|000000000002','2017-01-13 20:29:53','administrator','1','000000000000','',0,0,0,0,0,'','','',0,0,'','','','','','','',0,'','',0,'','2017-01-13','',0,0,'','','','','','',0,'','',0,0,0,'Dumaguete City','1','Selling Area','1');
INSERT INTO `sales` (`id`,`sales_no`,`date_added`,`user_screen_name`,`user_id`,`session_no`,`remarks`,`gross_amount`,`amount_due`,`status`,`sales_type`,`line_discount`,`customer_id`,`customer_name`,`discount_name`,`discount_rate`,`discount_amount`,`discount_customer_name`,`discount_customer_id`,`charge_type`,`charge_type_id`,`charge_reference_no`,`charge_customer_name`,`charge_customer_id`,`charge_amount`,`check_bank`,`check_no`,`check_amount`,`check_holder`,`check_date`,`credit_card_type`,`credit_card_rate`,`credit_card_amount`,`credit_card_no`,`credit_card_holder`,`credit_card_approval_code`,`gift_certificate_from`,`gift_certificate_description`,`gift_certificate_no`,`gift_certificate_amount`,`prepaid_customer_name`,`prepaid_customer_id`,`prepaid_amount`,`addtl_amount`,`wtax`,`branch`,`branch_id`,`location`,`location_id`) VALUES 
 (27538,'1|000000000003','2017-01-13 20:32:09','administrator','1','000000000000','',0,0,0,0,0,'','','',0,0,'','','','','','','',0,'','',0,'','2017-01-13','',0,0,'','','','','','',0,'','',0,0,0,'Dumaguete City','1','Selling Area','1'),
 (27539,'1|000000000004','2017-01-13 20:32:22','administrator','1','000000000000','',0,0,0,0,0,'13757','Ronald Pascua','',0,0,'','','','','','','',0,'','',0,'','2017-01-13','',0,0,'','','','','','',0,'','',0,0,0,'Dumaguete City','1','Selling Area','1');
INSERT INTO `sales` (`id`,`sales_no`,`date_added`,`user_screen_name`,`user_id`,`session_no`,`remarks`,`gross_amount`,`amount_due`,`status`,`sales_type`,`line_discount`,`customer_id`,`customer_name`,`discount_name`,`discount_rate`,`discount_amount`,`discount_customer_name`,`discount_customer_id`,`charge_type`,`charge_type_id`,`charge_reference_no`,`charge_customer_name`,`charge_customer_id`,`charge_amount`,`check_bank`,`check_no`,`check_amount`,`check_holder`,`check_date`,`credit_card_type`,`credit_card_rate`,`credit_card_amount`,`credit_card_no`,`credit_card_holder`,`credit_card_approval_code`,`gift_certificate_from`,`gift_certificate_description`,`gift_certificate_no`,`gift_certificate_amount`,`prepaid_customer_name`,`prepaid_customer_id`,`prepaid_amount`,`addtl_amount`,`wtax`,`branch`,`branch_id`,`location`,`location_id`) VALUES 
 (27540,'1|000000000005','2017-01-13 20:35:11','administrator','1','000000000000','',0,0,0,0,0,'13757','Ronald Pascua','',0,0,'','','','','','','',0,'','',0,'','2017-01-13','',0,0,'','','','','','',0,'','',0,0,0,'Dumaguete City','1','Selling Area','1'),
 (27541,'1|000000000006','2017-01-13 20:37:37','administrator','1','000000000000','',0,0,0,0,0,'13757','Ronald Pascua','',0,0,'','','','','','','',0,'','',0,'','2017-01-13','',0,0,'','','','','','',0,'','',0,0,0,'Dumaguete City','1','Selling Area','1');
INSERT INTO `sales` (`id`,`sales_no`,`date_added`,`user_screen_name`,`user_id`,`session_no`,`remarks`,`gross_amount`,`amount_due`,`status`,`sales_type`,`line_discount`,`customer_id`,`customer_name`,`discount_name`,`discount_rate`,`discount_amount`,`discount_customer_name`,`discount_customer_id`,`charge_type`,`charge_type_id`,`charge_reference_no`,`charge_customer_name`,`charge_customer_id`,`charge_amount`,`check_bank`,`check_no`,`check_amount`,`check_holder`,`check_date`,`credit_card_type`,`credit_card_rate`,`credit_card_amount`,`credit_card_no`,`credit_card_holder`,`credit_card_approval_code`,`gift_certificate_from`,`gift_certificate_description`,`gift_certificate_no`,`gift_certificate_amount`,`prepaid_customer_name`,`prepaid_customer_id`,`prepaid_amount`,`addtl_amount`,`wtax`,`branch`,`branch_id`,`location`,`location_id`) VALUES 
 (27542,'1|000000000007','2017-01-13 20:41:36','administrator','1','000000000000','',0,0,0,0,0,'13757','Ronald Pascua','',0,0,'','','','','','','',0,'','',0,'','2017-01-13','',0,0,'','','','','','',0,'','',0,0,0,'Dumaguete City','1','Selling Area','1'),
 (27543,'1|000000000008','2017-01-13 20:42:46','administrator','1','000000000000','',200,200,0,0,0,'','','',0,0,'','','','','','','',0,'','',0,'','2017-01-13','',0,0,'','','','','','',0,'','',0,0,0,'Dumaguete City','1','Selling Area','1');
INSERT INTO `sales` (`id`,`sales_no`,`date_added`,`user_screen_name`,`user_id`,`session_no`,`remarks`,`gross_amount`,`amount_due`,`status`,`sales_type`,`line_discount`,`customer_id`,`customer_name`,`discount_name`,`discount_rate`,`discount_amount`,`discount_customer_name`,`discount_customer_id`,`charge_type`,`charge_type_id`,`charge_reference_no`,`charge_customer_name`,`charge_customer_id`,`charge_amount`,`check_bank`,`check_no`,`check_amount`,`check_holder`,`check_date`,`credit_card_type`,`credit_card_rate`,`credit_card_amount`,`credit_card_no`,`credit_card_holder`,`credit_card_approval_code`,`gift_certificate_from`,`gift_certificate_description`,`gift_certificate_no`,`gift_certificate_amount`,`prepaid_customer_name`,`prepaid_customer_id`,`prepaid_amount`,`addtl_amount`,`wtax`,`branch`,`branch_id`,`location`,`location_id`) VALUES 
 (27544,'1|000000000009','2017-01-13 20:43:29','administrator','1','000000000000','',200,190,0,0,0,'','','<enter amount>',0,10,'','','','','','','',0,'','',0,'','2017-01-13','',0,0,'','','','','','',0,'','',0,0,0,'Dumaguete City','1','Selling Area','1'),
 (27545,'1|000000000010','2017-01-13 20:48:38','administrator','1','000000000000','',200,195,0,0,5,'','','',0,0,'','','','','','','',0,'','',0,'','2017-01-13','',0,0,'','','','','','',0,'','',0,0,0,'Dumaguete City','1','Selling Area','1');
/*!40000 ALTER TABLE `sales` ENABLE KEYS */;


--
-- Definition of table `sales_item`
--

DROP TABLE IF EXISTS `sales_item`;
CREATE TABLE `sales_item` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `barcode` varchar(500) DEFAULT NULL,
  `description` varchar(500) DEFAULT NULL,
  `generic_name` varchar(500) DEFAULT NULL,
  `category` varchar(500) DEFAULT NULL,
  `category_id` varchar(500) DEFAULT NULL,
  `classification` varchar(500) DEFAULT NULL,
  `classification_id` varchar(500) DEFAULT NULL,
  `sub_classification` varchar(500) DEFAULT NULL,
  `sub_classification_id` varchar(500) DEFAULT NULL,
  `product_qty` double DEFAULT NULL,
  `unit` varchar(500) DEFAULT NULL,
  `conversion` double DEFAULT NULL,
  `selling_price` double DEFAULT NULL,
  `date_added` datetime DEFAULT NULL,
  `user_name` varchar(500) DEFAULT NULL,
  `item_type` varchar(500) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `supplier` varchar(500) DEFAULT NULL,
  `fixed_price` int(11) DEFAULT NULL,
  `cost` double DEFAULT NULL,
  `supplier_id` varchar(500) DEFAULT NULL,
  `multi_level_pricing` int(11) DEFAULT NULL,
  `vatable` int(11) DEFAULT NULL,
  `reorder_level` double DEFAULT NULL,
  `markup` double DEFAULT NULL,
  `main_barcode` varchar(500) DEFAULT NULL,
  `brand` varchar(500) DEFAULT NULL,
  `brand_id` varchar(500) DEFAULT NULL,
  `model` varchar(500) DEFAULT NULL,
  `model_id` varchar(500) DEFAULT NULL,
  `selling_type` int(11) DEFAULT NULL,
  `branch` varchar(500) DEFAULT NULL,
  `branch_code` varchar(500) DEFAULT NULL,
  `location` varchar(500) DEFAULT NULL,
  `location_id` varchar(500) DEFAULT NULL,
  `discount_name` varchar(100) DEFAULT NULL,
  `discount_rate` double DEFAULT NULL,
  `discount_amount` double DEFAULT NULL,
  `added_by` varchar(100) DEFAULT NULL,
  `or_no` varchar(100) DEFAULT NULL,
  `serial_no` text,
  `discount_customer_name` varchar(100) DEFAULT NULL,
  `discount_customer_id` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `sales_item`
--

/*!40000 ALTER TABLE `sales_item` DISABLE KEYS */;
/*!40000 ALTER TABLE `sales_item` ENABLE KEYS */;


--
-- Definition of table `sales_on_account`
--

DROP TABLE IF EXISTS `sales_on_account`;
CREATE TABLE `sales_on_account` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `soa_type` varchar(100) DEFAULT NULL,
  `soa_type_id` varchar(100) DEFAULT NULL,
  `soa_date` date DEFAULT NULL,
  `date_added` datetime DEFAULT NULL,
  `added_by` varchar(100) DEFAULT NULL,
  `reference_no` varchar(100) DEFAULT NULL,
  `client_name` varchar(100) DEFAULT NULL,
  `client_id` varchar(100) DEFAULT NULL,
  `amount` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `sales_on_account`
--

/*!40000 ALTER TABLE `sales_on_account` DISABLE KEYS */;
/*!40000 ALTER TABLE `sales_on_account` ENABLE KEYS */;


--
-- Definition of table `sales_order_items`
--

DROP TABLE IF EXISTS `sales_order_items`;
CREATE TABLE `sales_order_items` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sales_no` varchar(100) DEFAULT NULL,
  `item_code` varchar(100) DEFAULT NULL,
  `barcode` varchar(100) DEFAULT NULL,
  `description` varchar(100) DEFAULT NULL,
  `generic_name` varchar(100) DEFAULT NULL,
  `item_type` varchar(100) DEFAULT NULL,
  `supplier_name` varchar(100) DEFAULT NULL,
  `supplier_id` varchar(100) DEFAULT NULL,
  `serial_no` varchar(100) DEFAULT NULL,
  `product_qty` double DEFAULT NULL,
  `unit` varchar(100) DEFAULT NULL,
  `conversion` double DEFAULT NULL,
  `selling_price` double DEFAULT NULL,
  `date_added` datetime DEFAULT NULL,
  `user_id` varchar(100) DEFAULT NULL,
  `user_screen_name` varchar(100) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `is_vatable` int(11) DEFAULT NULL,
  `selling_type` int(11) DEFAULT NULL,
  `discount_name` varchar(100) DEFAULT NULL,
  `discount_rate` double DEFAULT NULL,
  `discount_amount` double DEFAULT NULL,
  `discount_customer_name` varchar(100) DEFAULT NULL,
  `discount_customer_id` varchar(100) DEFAULT NULL,
  `branch` varchar(100) DEFAULT NULL,
  `branch_code` varchar(100) DEFAULT NULL,
  `location` varchar(100) DEFAULT NULL,
  `location_id` varchar(100) DEFAULT NULL,
  `category` varchar(100) DEFAULT NULL,
  `category_id` varchar(100) DEFAULT NULL,
  `classification` varchar(100) DEFAULT NULL,
  `classification_id` varchar(100) DEFAULT NULL,
  `sub_classification` varchar(100) DEFAULT NULL,
  `sub_classification_id` varchar(100) DEFAULT NULL,
  `brand` varchar(100) DEFAULT NULL,
  `brand_id` varchar(100) DEFAULT NULL,
  `model` varchar(100) DEFAULT NULL,
  `model_id` varchar(100) DEFAULT NULL,
  `addtl_amount` double DEFAULT NULL,
  `wtax` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `sales_order_items`
--

/*!40000 ALTER TABLE `sales_order_items` DISABLE KEYS */;
/*!40000 ALTER TABLE `sales_order_items` ENABLE KEYS */;


--
-- Definition of table `sales_orders`
--

DROP TABLE IF EXISTS `sales_orders`;
CREATE TABLE `sales_orders` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sales_no` varchar(100) DEFAULT NULL,
  `date_added` datetime DEFAULT NULL,
  `user_screen_name` varchar(100) DEFAULT NULL,
  `user_id` varchar(100) DEFAULT NULL,
  `session_no` varchar(100) DEFAULT NULL,
  `remarks` varchar(100) DEFAULT NULL,
  `gross_amount` double DEFAULT NULL,
  `amount_due` double DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `sales_type` int(11) DEFAULT NULL,
  `line_discount` double DEFAULT NULL,
  `customer_id` varchar(100) DEFAULT NULL,
  `customer_name` varchar(100) DEFAULT NULL,
  `discount_name` varchar(100) DEFAULT NULL,
  `discount_rate` double DEFAULT NULL,
  `discount_amount` double DEFAULT NULL,
  `discount_customer_name` varchar(100) DEFAULT NULL,
  `discount_customer_id` varchar(100) DEFAULT NULL,
  `charge_type` varchar(100) DEFAULT NULL,
  `charge_type_id` varchar(100) DEFAULT NULL,
  `charge_reference_no` varchar(100) DEFAULT NULL,
  `charge_customer_name` varchar(100) DEFAULT NULL,
  `charge_customer_id` varchar(100) DEFAULT NULL,
  `charge_amount` double DEFAULT NULL,
  `check_bank` varchar(100) DEFAULT NULL,
  `check_no` varchar(100) DEFAULT NULL,
  `check_amount` double DEFAULT NULL,
  `check_holder` varchar(100) DEFAULT NULL,
  `check_date` date DEFAULT NULL,
  `credit_card_type` varchar(100) DEFAULT NULL,
  `credit_card_rate` double DEFAULT NULL,
  `credit_card_amount` double DEFAULT NULL,
  `credit_card_no` varchar(100) DEFAULT NULL,
  `credit_card_holder` varchar(100) DEFAULT NULL,
  `credit_card_approval_code` varchar(100) DEFAULT NULL,
  `gift_certificate_from` varchar(100) DEFAULT NULL,
  `gift_certificate_description` varchar(100) DEFAULT NULL,
  `gift_certificate_no` varchar(100) DEFAULT NULL,
  `gift_certificate_amount` double DEFAULT NULL,
  `prepaid_customer_name` varchar(100) DEFAULT NULL,
  `prepaid_customer_id` varchar(100) DEFAULT NULL,
  `prepaid_amount` double DEFAULT NULL,
  `addtl_amount` double DEFAULT NULL,
  `wtax` double DEFAULT NULL,
  `branch` varchar(100) DEFAULT NULL,
  `branch_id` varchar(100) DEFAULT NULL,
  `location` varchar(100) DEFAULT NULL,
  `location_id` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `sales_no` (`sales_no`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `sales_orders`
--

/*!40000 ALTER TABLE `sales_orders` DISABLE KEYS */;
/*!40000 ALTER TABLE `sales_orders` ENABLE KEYS */;


--
-- Definition of table `sales_services`
--

DROP TABLE IF EXISTS `sales_services`;
CREATE TABLE `sales_services` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `or_no` varchar(100) DEFAULT NULL,
  `service_name` varchar(100) DEFAULT NULL,
  `service_amount` double DEFAULT NULL,
  `date_added` datetime DEFAULT NULL,
  `user_name` varchar(100) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `session_no` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `sales_services`
--

/*!40000 ALTER TABLE `sales_services` DISABLE KEYS */;
/*!40000 ALTER TABLE `sales_services` ENABLE KEYS */;


--
-- Definition of table `selling_type`
--

DROP TABLE IF EXISTS `selling_type`;
CREATE TABLE `selling_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `selling_type`
--

/*!40000 ALTER TABLE `selling_type` DISABLE KEYS */;
INSERT INTO `selling_type` (`id`,`name`) VALUES 
 (1,'Regular'),
 (2,'Assemble');
/*!40000 ALTER TABLE `selling_type` ENABLE KEYS */;


--
-- Definition of table `services`
--

DROP TABLE IF EXISTS `services`;
CREATE TABLE `services` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `service_name` varchar(100) DEFAULT NULL,
  `amount` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `services`
--

/*!40000 ALTER TABLE `services` DISABLE KEYS */;
INSERT INTO `services` (`id`,`service_name`,`amount`) VALUES 
 (1,'DELIVERY',20),
 (2,'DELIVERY2',100);
/*!40000 ALTER TABLE `services` ENABLE KEYS */;


--
-- Definition of table `settings`
--

DROP TABLE IF EXISTS `settings`;
CREATE TABLE `settings` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `company_name` varchar(255) DEFAULT NULL,
  `company_address` varchar(255) DEFAULT NULL,
  `company_operated_by` varchar(255) DEFAULT NULL,
  `company_slogan` varchar(255) DEFAULT NULL,
  `company_contact_no` varchar(255) DEFAULT NULL,
  `company_fax_no` varchar(255) DEFAULT NULL,
  `company_email_address` varchar(255) DEFAULT NULL,
  `bir_serial_no` varchar(255) DEFAULT NULL,
  `bir_permit_no` varchar(255) DEFAULT NULL,
  `bir_accreditation_no` varchar(255) DEFAULT NULL,
  `bir_tin` varchar(255) DEFAULT NULL,
  `bir_machine_no` varchar(255) DEFAULT NULL,
  `bir_min_no` varchar(255) DEFAULT NULL,
  `bir_business_type` varchar(255) DEFAULT NULL,
  `bir_vat_percent` varchar(255) DEFAULT NULL,
  `bir_receipt_footer` varchar(255) DEFAULT NULL,
  `bir_invoice_footer` varchar(255) DEFAULT NULL,
  `receipt_printing_enabled` int(11) DEFAULT NULL,
  `receipt_printer_show_dialog` int(11) DEFAULT NULL,
  `kitchen_printing_enable` int(11) DEFAULT NULL,
  `allow_negative_inventory` int(11) DEFAULT NULL,
  `is_server` int(11) DEFAULT NULL,
  `location` varchar(255) DEFAULT NULL,
  `receipt_printing_enabled2` int(11) DEFAULT NULL,
  `drawer` varchar(255) DEFAULT NULL,
  `developer` varchar(255) DEFAULT NULL,
  `developer_address` varchar(255) DEFAULT NULL,
  `developer_tin_no` varchar(255) DEFAULT NULL,
  `developer_accreditation_no` varchar(255) DEFAULT NULL,
  `developer_accreditation_date` varchar(255) DEFAULT NULL,
  `developer_contact_no` varchar(255) DEFAULT NULL,
  `module_software_type` varchar(255) DEFAULT NULL,
  `module_accounts_payable` int(11) DEFAULT NULL,
  `module_accounts_receivable` int(11) DEFAULT NULL,
  `module_services` int(11) DEFAULT NULL,
  `module_prepayments` int(11) DEFAULT NULL,
  `module_requisition_slip` int(11) DEFAULT NULL,
  `module_charge_in_advance` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `settings`
--

/*!40000 ALTER TABLE `settings` DISABLE KEYS */;
INSERT INTO `settings` (`id`,`company_name`,`company_address`,`company_operated_by`,`company_slogan`,`company_contact_no`,`company_fax_no`,`company_email_address`,`bir_serial_no`,`bir_permit_no`,`bir_accreditation_no`,`bir_tin`,`bir_machine_no`,`bir_min_no`,`bir_business_type`,`bir_vat_percent`,`bir_receipt_footer`,`bir_invoice_footer`,`receipt_printing_enabled`,`receipt_printer_show_dialog`,`kitchen_printing_enable`,`allow_negative_inventory`,`is_server`,`location`,`receipt_printing_enabled2`,`drawer`,`developer`,`developer_address`,`developer_tin_no`,`developer_accreditation_no`,`developer_accreditation_date`,`developer_contact_no`,`module_software_type`,`module_accounts_payable`,`module_accounts_receivable`,`module_services`,`module_prepayments`,`module_requisition_slip`,`module_charge_in_advance`) VALUES 
 (1,'ALGORITHM COMPUTER 1','DARO, DUMAGUETE CITY, NEGROS ORIENTAL','RANDOLF T. BANDIOLA','','225-6928 / 422-9026','422-1953','DARO, DUMAGUETE CITY, NEGROS ORIENTAL','000000000001','000000000002','000000000003','000000000004','000000000005','000000000006','Vat','12','THIS SERVES AS AN OFFICIAL RECEIPT \\n\\n THIS RECEIPT SHALL BE VALID FOR FIVE(5) YEARS FROM THE DATE OF THE PERMIT TO USE','THIS SERVES AS AN OFFICIAL RECEIPT \\n\\n THIS RECEIPT SHALL BE VALID FOR FIVE(5) YEARS FROM THE DATE OF THE PERMIT TO USE',0,0,0,0,0,'Local Branch',0,'','Synapse Software Technologies','Daro, Dumaguete City, Negros Oriental','00000000000000','00000000000000','05/01/2016','(+63) 916 1932 567','Retail',1,1,0,1,0,0);
/*!40000 ALTER TABLE `settings` ENABLE KEYS */;


--
-- Definition of table `sheet`
--

DROP TABLE IF EXISTS `sheet`;
CREATE TABLE `sheet` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `no` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=113 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `sheet`
--

/*!40000 ALTER TABLE `sheet` DISABLE KEYS */;
INSERT INTO `sheet` (`id`,`no`) VALUES 
 (1,1),
 (2,2),
 (3,3),
 (4,4),
 (5,5),
 (6,6),
 (7,7),
 (8,8),
 (9,9),
 (10,10),
 (11,11),
 (12,12),
 (13,13),
 (14,14),
 (15,15),
 (16,16),
 (17,17),
 (18,18),
 (19,19),
 (20,20),
 (21,21),
 (22,22),
 (23,23),
 (24,24),
 (25,25),
 (26,26),
 (27,27),
 (28,28),
 (29,29),
 (30,30),
 (31,31),
 (32,32),
 (33,33),
 (34,34),
 (35,35),
 (36,36),
 (37,37),
 (38,38),
 (39,39),
 (40,40),
 (41,41),
 (42,42),
 (43,43),
 (44,44),
 (45,45),
 (46,46),
 (47,47),
 (48,48),
 (49,49),
 (50,50),
 (51,51),
 (52,52),
 (53,53),
 (54,54),
 (55,55),
 (56,56),
 (57,57),
 (58,58),
 (59,59),
 (60,60),
 (61,61),
 (62,62),
 (63,63),
 (64,64),
 (65,65),
 (66,66),
 (67,67),
 (68,68),
 (69,69),
 (70,70),
 (71,71),
 (72,72),
 (73,73),
 (74,74),
 (75,75),
 (76,76),
 (77,77),
 (78,78),
 (79,79),
 (80,80),
 (81,81),
 (82,82),
 (83,83),
 (84,84),
 (85,85),
 (86,86),
 (87,87),
 (88,88),
 (89,89),
 (90,90),
 (91,91),
 (92,92),
 (93,93),
 (94,94),
 (95,95),
 (96,96),
 (97,97),
 (98,98),
 (99,99);
INSERT INTO `sheet` (`id`,`no`) VALUES 
 (100,101),
 (102,102),
 (103,105),
 (104,0),
 (105,500),
 (106,500),
 (107,501),
 (108,4720),
 (109,7464),
 (110,666),
 (111,2598),
 (112,1388);
/*!40000 ALTER TABLE `sheet` ENABLE KEYS */;


--
-- Definition of table `stock_transfer`
--

DROP TABLE IF EXISTS `stock_transfer`;
CREATE TABLE `stock_transfer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `receipt_no` varchar(500) DEFAULT NULL,
  `user_name` varchar(500) DEFAULT NULL,
  `session_no` varchar(500) DEFAULT NULL,
  `date_added` datetime DEFAULT NULL,
  `supplier` varchar(500) DEFAULT NULL,
  `supllier_id` varchar(500) DEFAULT NULL,
  `remarks` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `stock_transfer`
--

/*!40000 ALTER TABLE `stock_transfer` DISABLE KEYS */;
/*!40000 ALTER TABLE `stock_transfer` ENABLE KEYS */;


--
-- Definition of table `stock_transfer_items`
--

DROP TABLE IF EXISTS `stock_transfer_items`;
CREATE TABLE `stock_transfer_items` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `receipt_no` varchar(500) DEFAULT NULL,
  `user_name` varchar(500) DEFAULT NULL,
  `session_no` varchar(500) DEFAULT NULL,
  `date_added` datetime DEFAULT NULL,
  `supplier` varchar(500) DEFAULT NULL,
  `supllier_id` varchar(500) DEFAULT NULL,
  `remarks` varchar(500) DEFAULT NULL,
  `barcode` varchar(500) DEFAULT NULL,
  `description` varchar(500) DEFAULT NULL,
  `qty` double DEFAULT NULL,
  `cost` double DEFAULT NULL,
  `category` varchar(500) DEFAULT NULL,
  `category_id` varchar(500) DEFAULT NULL,
  `classification` varchar(500) DEFAULT NULL,
  `classification_id` varchar(500) DEFAULT NULL,
  `sub_class` varchar(500) DEFAULT NULL,
  `sub_class_id` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `stock_transfer_items`
--

/*!40000 ALTER TABLE `stock_transfer_items` DISABLE KEYS */;
/*!40000 ALTER TABLE `stock_transfer_items` ENABLE KEYS */;


--
-- Definition of table `stock_transfers`
--

DROP TABLE IF EXISTS `stock_transfers`;
CREATE TABLE `stock_transfers` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `transaction_no` varchar(100) DEFAULT NULL,
  `user_name` varchar(100) DEFAULT NULL,
  `date_added` datetime DEFAULT NULL,
  `remarks` varchar(100) DEFAULT NULL,
  `to_branch` varchar(100) DEFAULT NULL,
  `to_branch_id` varchar(100) DEFAULT NULL,
  `to_location` varchar(100) DEFAULT NULL,
  `to_location_id` varchar(100) DEFAULT NULL,
  `from_branch` varchar(100) DEFAULT NULL,
  `from_branch_id` varchar(100) DEFAULT NULL,
  `from_location` varchar(100) DEFAULT NULL,
  `from_location_id` varchar(100) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `at_branch` varchar(255) DEFAULT NULL,
  `at_branch_id` varchar(255) DEFAULT NULL,
  `at_location` varchar(255) DEFAULT NULL,
  `at_location_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `stock_transfers`
--

/*!40000 ALTER TABLE `stock_transfers` DISABLE KEYS */;
/*!40000 ALTER TABLE `stock_transfers` ENABLE KEYS */;


--
-- Definition of table `stock_transfers_items`
--

DROP TABLE IF EXISTS `stock_transfers_items`;
CREATE TABLE `stock_transfers_items` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `barcode` varchar(500) DEFAULT NULL,
  `description` varchar(500) DEFAULT NULL,
  `generic_name` varchar(500) DEFAULT NULL,
  `category` varchar(500) DEFAULT NULL,
  `category_id` varchar(500) DEFAULT NULL,
  `classification` varchar(500) DEFAULT NULL,
  `classification_id` varchar(500) DEFAULT NULL,
  `sub_classification` varchar(500) DEFAULT NULL,
  `sub_classification_id` varchar(500) DEFAULT NULL,
  `product_qty` double DEFAULT NULL,
  `unit` varchar(500) DEFAULT NULL,
  `conversion` double DEFAULT NULL,
  `selling_price` double DEFAULT NULL,
  `date_added` datetime DEFAULT NULL,
  `user_name` varchar(500) DEFAULT NULL,
  `item_type` varchar(500) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `supplier` varchar(500) DEFAULT NULL,
  `fixed_price` int(11) DEFAULT NULL,
  `cost` double DEFAULT NULL,
  `supplier_id` varchar(500) DEFAULT NULL,
  `multi_level_pricing` int(11) DEFAULT NULL,
  `vatable` int(11) DEFAULT NULL,
  `reorder_level` double DEFAULT NULL,
  `markup` double DEFAULT NULL,
  `barcodes` varchar(500) DEFAULT NULL,
  `brand` varchar(500) DEFAULT NULL,
  `brand_id` varchar(500) DEFAULT NULL,
  `model` varchar(500) DEFAULT NULL,
  `model_id` varchar(500) DEFAULT NULL,
  `selling_type` int(11) DEFAULT NULL,
  `branch` varchar(500) DEFAULT NULL,
  `branch_code` varchar(500) DEFAULT NULL,
  `location` varchar(500) DEFAULT NULL,
  `location_id` varchar(500) DEFAULT NULL,
  `stock_transfer_id` varchar(100) DEFAULT NULL,
  `serial_no` varchar(5000) DEFAULT NULL,
  `to_branch` varchar(100) DEFAULT NULL,
  `to_branch_id` varchar(100) DEFAULT NULL,
  `to_location` varchar(100) DEFAULT NULL,
  `to_location_id` varchar(100) DEFAULT NULL,
  `at_branch` varchar(255) DEFAULT NULL,
  `at_branch_id` varchar(255) DEFAULT NULL,
  `at_location` varchar(255) DEFAULT NULL,
  `at_location_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `stock_transfers_items`
--

/*!40000 ALTER TABLE `stock_transfers_items` DISABLE KEYS */;
/*!40000 ALTER TABLE `stock_transfers_items` ENABLE KEYS */;


--
-- Definition of table `suppliers`
--

DROP TABLE IF EXISTS `suppliers`;
CREATE TABLE `suppliers` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `customer_name` varchar(500) DEFAULT NULL,
  `customer_no` varchar(500) DEFAULT NULL,
  `contact_no` varchar(500) DEFAULT NULL,
  `credit_limit` double DEFAULT NULL,
  `address` varchar(500) DEFAULT NULL,
  `term` double DEFAULT NULL,
  `location` varchar(500) DEFAULT NULL,
  `balance` double DEFAULT NULL,
  `discount` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `suppliers`
--

/*!40000 ALTER TABLE `suppliers` DISABLE KEYS */;
/*!40000 ALTER TABLE `suppliers` ENABLE KEYS */;


--
-- Definition of table `synch_locations`
--

DROP TABLE IF EXISTS `synch_locations`;
CREATE TABLE `synch_locations` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `inventory_counts` longblob,
  `receipts` longblob,
  `sales` longblob,
  `transfers` longblob,
  `adjustments` longblob,
  `returned_items` longblob,
  `charges` longblob,
  `rmas` longblob,
  `item_maintenances` longblob,
  `cash_drawers` longblob,
  `status` int(11) DEFAULT NULL,
  `date_added` datetime DEFAULT NULL,
  `user_id` varchar(255) DEFAULT NULL,
  `user_screen_name` varchar(255) DEFAULT NULL,
  `branch` varchar(255) DEFAULT NULL,
  `branch_id` varchar(255) DEFAULT NULL,
  `location` varchar(255) DEFAULT NULL,
  `location_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `synch_locations`
--

/*!40000 ALTER TABLE `synch_locations` DISABLE KEYS */;
/*!40000 ALTER TABLE `synch_locations` ENABLE KEYS */;


--
-- Definition of table `synch_upload_locations`
--

DROP TABLE IF EXISTS `synch_upload_locations`;
CREATE TABLE `synch_upload_locations` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `inventory_counts` longblob,
  `receipts` longblob,
  `sales` longblob,
  `transfers` longblob,
  `adjustments` longblob,
  `returned_items` longblob,
  `charges` longblob,
  `rmas` longblob,
  `item_maintenances` longblob,
  `cash_drawers` longblob,
  `status` int(11) DEFAULT NULL,
  `date_added` datetime DEFAULT NULL,
  `user_id` varchar(255) DEFAULT NULL,
  `user_screen_name` varchar(255) DEFAULT NULL,
  `branch` varchar(255) DEFAULT NULL,
  `branch_id` varchar(255) DEFAULT NULL,
  `location` varchar(255) DEFAULT NULL,
  `location_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `synch_upload_locations`
--

/*!40000 ALTER TABLE `synch_upload_locations` DISABLE KEYS */;
/*!40000 ALTER TABLE `synch_upload_locations` ENABLE KEYS */;


--
-- Definition of table `terminals`
--

DROP TABLE IF EXISTS `terminals`;
CREATE TABLE `terminals` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `terminal` varchar(255) DEFAULT NULL,
  `ip_address` varchar(255) DEFAULT NULL,
  `branch` varchar(255) DEFAULT NULL,
  `branch_id` varchar(255) DEFAULT NULL,
  `location` varchar(255) DEFAULT NULL,
  `location_id` varchar(255) DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `updated_by` varchar(255) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `terminals`
--

/*!40000 ALTER TABLE `terminals` DISABLE KEYS */;
/*!40000 ALTER TABLE `terminals` ENABLE KEYS */;


--
-- Definition of table `terms`
--

DROP TABLE IF EXISTS `terms`;
CREATE TABLE `terms` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `term_from` int(11) DEFAULT NULL,
  `term_to` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `terms`
--

/*!40000 ALTER TABLE `terms` DISABLE KEYS */;
INSERT INTO `terms` (`id`,`term_from`,`term_to`) VALUES 
 (2,30,60),
 (3,60,90),
 (4,90,120),
 (5,120,150),
 (6,150,180);
/*!40000 ALTER TABLE `terms` ENABLE KEYS */;


--
-- Definition of table `uom`
--

DROP TABLE IF EXISTS `uom`;
CREATE TABLE `uom` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `unit` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `uom`
--

/*!40000 ALTER TABLE `uom` DISABLE KEYS */;
INSERT INTO `uom` (`id`,`unit`) VALUES 
 (1,'PC'),
 (2,'BOX'),
 (3,'TRUCK'),
 (4,'BAG'),
 (5,'SACK'),
 (6,'TRAY-6'),
 (7,'TRAY-12'),
 (9,'TRAY-30'),
 (10,'1KL'),
 (11,'250G'),
 (12,'2KLS'),
 (13,'500G'),
 (14,'25KL'),
 (15,'50KL'),
 (16,'TRAY-15');
/*!40000 ALTER TABLE `uom` ENABLE KEYS */;


--
-- Definition of table `user_default_previleges`
--

DROP TABLE IF EXISTS `user_default_previleges`;
CREATE TABLE `user_default_previleges` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `account` varchar(100) DEFAULT NULL,
  `name` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=96 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user_default_previleges`
--

/*!40000 ALTER TABLE `user_default_previleges` DISABLE KEYS */;
INSERT INTO `user_default_previleges` (`id`,`account`,`name`) VALUES 
 (1,'Administrator','Branches'),
 (3,'Administrator','Branch Locations'),
 (5,'Administrator','Users'),
 (6,'Administrator','Discounts'),
 (8,'Administrator','Cash Count Report'),
 (9,'Administrator','Preferences'),
 (10,'Administrator','Themes'),
 (11,'Administrator','Backup'),
 (12,'Accounting','Accounts Receivable'),
 (13,'Accounting','Accounts Payable'),
 (14,'Accounting','Customer\'s Balances Report'),
 (15,'Accounting','AR Aging Report'),
 (16,'Accounting','Customers'),
 (17,'Accounting','Customer\'s Ledger Report'),
 (18,'Inventory','Item Maintenance'),
 (19,'Inventory','Unit of Measure'),
 (20,'Inventory','Category'),
 (21,'Inventory','Purchase Order'),
 (23,'Inventory','Stock Take'),
 (24,'Inventory','Receipts'),
 (25,'Inventory','Item Barcodes'),
 (26,'Inventory','Stock Take Report'),
 (27,'Inventory','Receipts Report'),
 (28,'Inventory','Stock Transfer'),
 (29,'Inventory','Stock Transfer Report'),
 (30,'Inventory','Stocks Status Report'),
 (31,'Inventory','Stock Ledger Report');
INSERT INTO `user_default_previleges` (`id`,`account`,`name`) VALUES 
 (32,'Inventory','Purchase Order Report'),
 (33,'Services','Service Departments'),
 (34,'Services','Service Department Members'),
 (35,'Services','Service Transaction Type'),
 (36,'Services','Services-Transaction'),
 (37,'Services','Services-View/Encode'),
 (38,'Services','Services Report'),
 (39,'Services','Services Item Replacement Report'),
 (40,'Sales','Disbursements'),
 (41,'Sales','Disbursements Report'),
 (42,'Sales','Banks'),
 (43,'Sales','Voider'),
 (44,'Sales','Void Items Report'),
 (45,'Sales','Service Transaction Releasing'),
 (46,'Sales','Daily Sales Summary Report'),
 (47,'Sales','Sales'),
 (48,'Inventory','Suppliers'),
 (49,'Inventory','Finalize Receipt'),
 (50,'Inventory','Finalize Stock Transfer'),
 (51,'Accounting','Finalize Account Receivable Payments'),
 (52,'Accounting','Accounts Receivable Payment'),
 (53,'Sales','Sales Report'),
 (54,'Inventory','Update Barcodes'),
 (55,'Services','Services-View'),
 (56,'Inventory','Price Inquiry');
INSERT INTO `user_default_previleges` (`id`,`account`,`name`) VALUES 
 (57,'Sales','Void Sales'),
 (58,'Sales','Salesman'),
 (59,'Accounting','Disbursement Categories'),
 (60,'Accounting','Disbursement (View All)'),
 (61,'Accounting','Prepaid Payment'),
 (62,'Accounting','Prepaid Payment Finalize'),
 (63,'Sales','Credit Card'),
 (64,'Inventory','Inventory Count Report'),
 (65,'Inventory','Borrower Slip'),
 (66,'Inventory','Borrower Slip (Finalize)'),
 (67,'Inventory','Inventory Count'),
 (68,'Inventory','Inventory Count (Finalize)'),
 (69,'Sales','Cashier Report'),
 (70,'Sales','Cashier CashCount'),
 (71,'Inventory','Inventory Update Item Pricing'),
 (72,'Inventory','Print Barcodes'),
 (73,'Accounting','Customers (AR)'),
 (74,'Accounting','Customers (Prepaid)'),
 (75,'Inventory','Adjuster'),
 (76,'Accounting','Customers (Update/Delete)'),
 (77,'Sales','Sales (Choose Location)'),
 (78,'Administrator','Update CashDrawer'),
 (79,'Accounting','Charge in Advance'),
 (80,'Inventory','RMA'),
 (81,'Inventory','Inventory Replenishment');
INSERT INTO `user_default_previleges` (`id`,`account`,`name`) VALUES 
 (82,'Inventory','Print Inventory Count'),
 (83,'Accounting','AR Items'),
 (84,'Administrator','Upload to Cloud'),
 (85,'Administrator','Download from Cloud'),
 (86,'Inventory','Update Item Pricing per Branch'),
 (87,'Inventory','Update Item Pricing any Branches'),
 (88,'Inventory','Finalize Price Updates'),
 (89,'Administrator','BIR'),
 (91,'Administrator','Terminals'),
 (92,'Inventory','Requistion Slip'),
 (93,'Inventory','Stock Take (No Cost) Report'),
 (94,'Accounting','Delete AR Transaction'),
 (95,'Accounting','Delete AR Payment');
/*!40000 ALTER TABLE `user_default_previleges` ENABLE KEYS */;


--
-- Definition of table `user_logs`
--

DROP TABLE IF EXISTS `user_logs`;
CREATE TABLE `user_logs` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` varchar(255) DEFAULT NULL,
  `user_screen_name` varchar(255) DEFAULT NULL,
  `ip_address` varchar(255) DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `updated_by` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1864 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user_logs`
--

/*!40000 ALTER TABLE `user_logs` DISABLE KEYS */;
INSERT INTO `user_logs` (`id`,`user_id`,`user_screen_name`,`ip_address`,`created_at`,`updated_at`,`created_by`,`updated_by`) VALUES 
 (1840,'1','administrator',NULL,'2017-01-13 11:15:32','2017-01-13 11:15:32','',''),
 (1841,'1','administrator',NULL,'2017-01-13 11:27:35','2017-01-13 11:27:35','',''),
 (1842,'1','administrator',NULL,'2017-01-13 11:30:54','2017-01-13 11:30:54','',''),
 (1843,'1','administrator',NULL,'2017-01-13 11:33:00','2017-01-13 11:33:00','',''),
 (1844,'1','administrator',NULL,'2017-01-13 11:39:20','2017-01-13 11:39:20','',''),
 (1845,'1','administrator',NULL,'2017-01-13 11:39:51','2017-01-13 11:39:51','',''),
 (1846,'1','administrator',NULL,'2017-01-13 11:40:16','2017-01-13 11:40:16','',''),
 (1847,'1','administrator',NULL,'2017-01-13 11:40:42','2017-01-13 11:40:42','',''),
 (1848,'1','administrator',NULL,'2017-01-13 11:43:51','2017-01-13 11:43:51','',''),
 (1849,'1','administrator',NULL,'2017-01-13 11:46:44','2017-01-13 11:46:44','',''),
 (1850,'1','administrator',NULL,'2017-01-13 11:50:42','2017-01-13 11:50:42','',''),
 (1851,'1','administrator',NULL,'2017-01-13 11:51:03','2017-01-13 11:51:03','','');
INSERT INTO `user_logs` (`id`,`user_id`,`user_screen_name`,`ip_address`,`created_at`,`updated_at`,`created_by`,`updated_by`) VALUES 
 (1852,'1','administrator',NULL,'2017-01-13 19:13:47','2017-01-13 19:13:47','',''),
 (1853,'1','administrator',NULL,'2017-01-13 20:24:32','2017-01-13 20:24:32','',''),
 (1854,'1','administrator',NULL,'2017-01-13 20:29:16','2017-01-13 20:29:16','',''),
 (1855,'1','administrator',NULL,'2017-01-13 20:32:01','2017-01-13 20:32:01','',''),
 (1856,'1','administrator',NULL,'2017-01-13 20:35:03','2017-01-13 20:35:03','',''),
 (1857,'1','administrator',NULL,'2017-01-13 20:37:28','2017-01-13 20:37:28','',''),
 (1858,'1','administrator',NULL,'2017-01-13 20:41:23','2017-01-13 20:41:23','',''),
 (1859,'1','administrator',NULL,'2017-01-13 20:47:57','2017-01-13 20:47:57','',''),
 (1860,'1','administrator',NULL,'2017-01-13 20:50:31','2017-01-13 20:50:31','',''),
 (1861,'1','administrator',NULL,'2017-01-13 20:51:39','2017-01-13 20:51:39','',''),
 (1862,'1','administrator',NULL,'2017-01-13 20:57:20','2017-01-13 20:57:20','',''),
 (1863,'1','administrator',NULL,'2017-01-13 20:57:57','2017-01-13 20:57:57','','');
/*!40000 ALTER TABLE `user_logs` ENABLE KEYS */;


--
-- Definition of table `user_previleges`
--

DROP TABLE IF EXISTS `user_previleges`;
CREATE TABLE `user_previleges` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `account` varchar(100) DEFAULT NULL,
  `previledge` varchar(100) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `user_id` varchar(100) DEFAULT NULL,
  `user_name` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=386 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user_previleges`
--

/*!40000 ALTER TABLE `user_previleges` DISABLE KEYS */;
INSERT INTO `user_previleges` (`id`,`account`,`previledge`,`status`,`user_id`,`user_name`) VALUES 
 (32,'Administrator','Backup',1,'1','admin'),
 (33,'Administrator','Branch Locations',1,'1','admin'),
 (34,'Administrator','Branches',1,'1','admin'),
 (35,'Administrator','Cash Count Report',1,'1','admin'),
 (36,'Administrator','Discounts',1,'1','admin'),
 (37,'Administrator','Preferences',1,'1','admin'),
 (38,'Administrator','Themes',1,'1','admin'),
 (39,'Administrator','Users',1,'1','admin'),
 (40,'Sales','Banks',1,'1','admin'),
 (41,'Sales','Daily Sales Summary Report',1,'1','admin'),
 (42,'Sales','Disbursements',1,'1','admin'),
 (43,'Sales','Disbursements Report',1,'1','admin'),
 (44,'Sales','Service Transaction Releasing',1,'1','admin'),
 (45,'Sales','Void Items Report',1,'1','admin'),
 (46,'Sales','Voider',1,'1','admin'),
 (47,'Accounting','Accounts Payable',1,'1','admin'),
 (48,'Accounting','Accounts Receivable',1,'1','admin'),
 (49,'Accounting','AR Aging Report',1,'1','admin'),
 (50,'Inventory','Category',1,'1','admin'),
 (51,'Accounting','Customer\'s Balances Report',1,'1','admin');
INSERT INTO `user_previleges` (`id`,`account`,`previledge`,`status`,`user_id`,`user_name`) VALUES 
 (52,'Accounting','Customer\'s Ledger Report',1,'1','admin'),
 (53,'Accounting','Customers',1,'1','admin'),
 (54,'Inventory','Item Barcodes',1,'1','admin'),
 (55,'Inventory','Item Maintenance',1,'1','admin'),
 (56,'Inventory','Purchase Order',1,'1','admin'),
 (57,'Inventory','Purchase Order Report',1,'1','admin'),
 (58,'Inventory','Receipts',1,'1','admin'),
 (59,'Inventory','Receipts Report',1,'1','admin'),
 (60,'Services','Service Department Members',1,'1','admin'),
 (61,'Services','Service Departments',1,'1','admin'),
 (62,'Services','Service Transaction Type',1,'1','admin'),
 (63,'Services','Services Item Replacement Report',1,'1','admin'),
 (64,'Services','Services Report',1,'1','admin'),
 (65,'Services','Services-Transaction',1,'1','admin'),
 (66,'Services','Services-View/Encode',1,'1','admin'),
 (67,'Inventory','Stock Ledger Report',1,'1','admin'),
 (68,'Inventory','Stock Take',1,'1','admin'),
 (69,'Inventory','Stock Take Report',1,'1','admin');
INSERT INTO `user_previleges` (`id`,`account`,`previledge`,`status`,`user_id`,`user_name`) VALUES 
 (70,'Inventory','Stock Transfer',1,'1','admin'),
 (71,'Inventory','Stock Transfer Report',1,'1','admin'),
 (72,'Inventory','Stocks Status Report',1,'1','admin'),
 (73,'Inventory','Unit of Measure',1,'1','admin'),
 (134,'Inventory','Finalize Stock Transfer',1,'1','admin'),
 (135,'Inventory','Finalize Receipt',1,'1','admin'),
 (141,'Accounting','Accounts Receivable Payment',1,'1','admin'),
 (142,'Accounting','Finalize Account Receivable Payments',1,'1','admin'),
 (157,'Sales','Sales Report',1,'1','admin'),
 (158,'Inventory','Update Barcodes',1,'1','admin'),
 (194,'Inventory','Inventory Count Report',1,'1','admin'),
 (211,'Inventory','Inventory Count',1,'1','admin'),
 (212,'Inventory','Inventory Count (Finalize)',1,'1','admin'),
 (315,'Inventory','Borrower Slip',1,'1','admin'),
 (316,'Inventory','Borrower Slip (Finalize)',1,'1','admin'),
 (317,'Sales','Cashier CashCount',1,'1','admin'),
 (318,'Sales','Cashier Report',1,'1','admin'),
 (319,'Sales','Credit Card',1,'1','admin');
INSERT INTO `user_previleges` (`id`,`account`,`previledge`,`status`,`user_id`,`user_name`) VALUES 
 (320,'Accounting','Disbursement (View All)',1,'1','admin'),
 (321,'Accounting','Disbursement Categories',1,'1','admin'),
 (322,'Inventory','Inventory Update Item Pricing',1,'1','admin'),
 (323,'Accounting','Prepaid Payment',1,'1','admin'),
 (324,'Accounting','Prepaid Payment Finalize',1,'1','admin'),
 (326,'Sales','Sales',1,'1','admin'),
 (328,'Services','Services-View',1,'1','admin'),
 (329,'Inventory','Suppliers',1,'1','admin'),
 (330,'Sales','Void Sales',1,'1','admin'),
 (331,'Inventory','Adjuster',1,'1','admin'),
 (333,'Sales','Sales (Choose Location)',1,'1','admin'),
 (342,'Administrator','Update CashDrawer',1,'1','admin'),
 (344,'Accounting','Charge in Advance',1,'1','admin'),
 (350,'Inventory','Inventory Replenishment',1,'1','admin'),
 (351,'Inventory','Print Inventory Count',1,'1','admin'),
 (363,'Inventory','Print Barcodes',1,'1','admin'),
 (366,'Accounting','AR Items',1,'1','admin'),
 (378,'Inventory','Update Item Pricing any Branches',1,'1','admin');
INSERT INTO `user_previleges` (`id`,`account`,`previledge`,`status`,`user_id`,`user_name`) VALUES 
 (379,'Inventory','Update Item Pricing per Branch',1,'1','admin'),
 (380,'Inventory','Finalize Price Updates',1,'1','admin'),
 (381,'Inventory','Requistion Slip',1,'1','admin'),
 (385,'Inventory','Stock Take (No Cost) Report',1,'1','admin');
/*!40000 ALTER TABLE `user_previleges` ENABLE KEYS */;


--
-- Definition of table `users`
--

DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `screen_name` varchar(100) DEFAULT NULL,
  `user_name` varchar(100) DEFAULT NULL,
  `password` varchar(100) DEFAULT NULL,
  `user_level` int(11) DEFAULT NULL,
  `date_added` varchar(100) DEFAULT NULL,
  `is_active` int(11) DEFAULT NULL,
  `t_sales` varchar(100) DEFAULT NULL,
  `t_receipts` varchar(100) DEFAULT NULL,
  `t_stock_transfer` varchar(100) DEFAULT NULL,
  `m_items` varchar(100) DEFAULT NULL,
  `m_category` varchar(100) DEFAULT NULL,
  `m_users` varchar(100) DEFAULT NULL,
  `m_uom` varchar(100) DEFAULT NULL,
  `m_suppliers` varchar(100) DEFAULT NULL,
  `r_sales` varchar(100) DEFAULT NULL,
  `r_cash_count` varchar(100) DEFAULT NULL,
  `r_receipts` varchar(100) DEFAULT NULL,
  `r_stock_transferred` varchar(100) DEFAULT NULL,
  `r_stock_take` varchar(100) DEFAULT NULL,
  `m_customers` varchar(100) DEFAULT NULL,
  `m_discount` varchar(100) DEFAULT NULL,
  `m_banks` varchar(100) DEFAULT NULL,
  `r_stock_left_supplier` varchar(100) DEFAULT NULL,
  `t_inventory_adjuster` varchar(100) DEFAULT NULL,
  `t_salesman` varchar(100) DEFAULT NULL,
  `branch` varchar(255) DEFAULT NULL,
  `branch_id` varchar(255) DEFAULT NULL,
  `location` varchar(255) DEFAULT NULL,
  `location_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `users`
--

/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` (`id`,`screen_name`,`user_name`,`password`,`user_level`,`date_added`,`is_active`,`t_sales`,`t_receipts`,`t_stock_transfer`,`m_items`,`m_category`,`m_users`,`m_uom`,`m_suppliers`,`r_sales`,`r_cash_count`,`r_receipts`,`r_stock_transferred`,`r_stock_take`,`m_customers`,`m_discount`,`m_banks`,`r_stock_left_supplier`,`t_inventory_adjuster`,`t_salesman`,`branch`,`branch_id`,`location`,`location_id`) VALUES 
 (1,'administrator','admin','admin',0,'2013-06-28 17:39:02',1,'1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','0','Dumaguete City','1','Selling Area','1');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;


--
-- Definition of table `void_items`
--

DROP TABLE IF EXISTS `void_items`;
CREATE TABLE `void_items` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `barcode` varchar(500) DEFAULT NULL,
  `description` varchar(500) DEFAULT NULL,
  `generic_name` varchar(500) DEFAULT NULL,
  `category` varchar(500) DEFAULT NULL,
  `category_id` varchar(500) DEFAULT NULL,
  `classification` varchar(500) DEFAULT NULL,
  `classification_id` varchar(500) DEFAULT NULL,
  `sub_classification` varchar(500) DEFAULT NULL,
  `sub_classification_id` varchar(500) DEFAULT NULL,
  `product_qty` double DEFAULT NULL,
  `unit` varchar(500) DEFAULT NULL,
  `conversion` double DEFAULT NULL,
  `selling_price` double DEFAULT NULL,
  `date_added` datetime DEFAULT NULL,
  `user_name` varchar(500) DEFAULT NULL,
  `item_type` varchar(500) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `session_no` varchar(500) DEFAULT NULL,
  `item_discount` varchar(500) DEFAULT NULL,
  `discount` double DEFAULT NULL,
  `discount_amount` double DEFAULT NULL,
  `void_no` varchar(100) DEFAULT NULL,
  `fixed_price` int(11) DEFAULT NULL,
  `supplier` varchar(500) DEFAULT NULL,
  `supplier_id` varchar(500) DEFAULT NULL,
  `vatable` int(11) DEFAULT NULL,
  `or_no` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `void_items`
--

/*!40000 ALTER TABLE `void_items` DISABLE KEYS */;
/*!40000 ALTER TABLE `void_items` ENABLE KEYS */;


--
-- Definition of table `voids`
--

DROP TABLE IF EXISTS `voids`;
CREATE TABLE `voids` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `void_no` varchar(100) DEFAULT NULL,
  `date_added` varchar(500) DEFAULT NULL,
  `user_name` varchar(500) DEFAULT NULL,
  `session_no` varchar(500) DEFAULT NULL,
  `gross_amount` double DEFAULT NULL,
  `amount_paid` double DEFAULT NULL,
  `amount_due` double DEFAULT NULL,
  `discount_name` varchar(500) DEFAULT NULL,
  `discount` double DEFAULT NULL,
  `discount_amount` double DEFAULT NULL,
  `customer_name` varchar(500) DEFAULT NULL,
  `check_bank` varchar(500) DEFAULT NULL,
  `check_no` varchar(500) DEFAULT NULL,
  `check_amount` double DEFAULT NULL,
  `discount_customer_name` varchar(500) DEFAULT NULL,
  `discount_customer_id` varchar(500) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `or_no` varchar(500) DEFAULT NULL,
  `check_holder` varchar(500) DEFAULT NULL,
  `services` varchar(500) DEFAULT NULL,
  `service_amount` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `voids`
--

/*!40000 ALTER TABLE `voids` DISABLE KEYS */;
/*!40000 ALTER TABLE `voids` ENABLE KEYS */;


--
-- Definition of table `witholding_tax`
--

DROP TABLE IF EXISTS `witholding_tax`;
CREATE TABLE `witholding_tax` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sector` varchar(100) DEFAULT NULL,
  `rate` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `witholding_tax`
--

/*!40000 ALTER TABLE `witholding_tax` DISABLE KEYS */;
/*!40000 ALTER TABLE `witholding_tax` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
