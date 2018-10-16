-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Oct 16, 2018 at 04:27 PM
-- Server version: 5.5.15
-- PHP Version: 7.0.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_algorithm`
--

-- --------------------------------------------------------

--
-- Table structure for table `user_default_previleges`
--

CREATE TABLE `user_default_previleges` (
  `id` int(11) NOT NULL,
  `account` varchar(100) DEFAULT NULL,
  `name` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user_default_previleges`
--

INSERT INTO `user_default_previleges` (`id`, `account`, `name`) VALUES
(112, 'Transactions', 'Accounts Payable'),
(113, 'Transactions', 'Accounts Receivable'),
(114, 'Transactions', 'Borrower Slip'),
(115, 'Transactions', 'Charge In Advance'),
(116, 'Transactions', 'Conversion'),
(117, 'Transactions', 'Disbursements'),
(118, 'Transactions', 'Inventory Adjuster'),
(119, 'Transactions', 'Inventory Encoding'),
(120, 'Transactions', 'Prepaid Payments'),
(121, 'Transactions', 'Purchase Order'),
(122, 'Transactions', 'Receipts'),
(123, 'Transactions', 'Return from Customer'),
(124, 'Transactions', 'Return Exchange'),
(125, 'Transactions', 'Return to Supplier'),
(126, 'Transactions', 'Sales'),
(127, 'Transactions', 'Services'),
(128, 'Transactions', 'Stock Transfer'),
(154, 'Transactions', 'Accounts Receivable Payments'),
(155, 'Transactions', 'Inventory Replenishment'),
(156, 'Transactions', 'Price Inquiry'),
(157, 'Transactions', 'RMA'),
(158, 'Transactions', 'Requisition Slip'),
(159, 'Transactions', 'Other Adjustments'),
(160, 'Maintenance', 'Backup'),
(161, 'Maintenance', 'Banks'),
(162, 'Maintenance', 'Branches'),
(163, 'Maintenance', 'Branch Locations'),
(164, 'Maintenance', 'Categories'),
(165, 'Maintenance', 'Credit Cards'),
(166, 'Maintenance', 'Customers'),
(167, 'Maintenance', 'Disbursement Categories'),
(168, 'Maintenance', 'Discounts'),
(169, 'Maintenance', 'Item Barcodes'),
(170, 'Maintenance', 'Item Maintenance'),
(171, 'Maintenance', 'Preferences'),
(172, 'Maintenance', 'Price Update'),
(173, 'Maintenance', 'Services'),
(174, 'Maintenance', 'Suppliers'),
(175, 'Maintenance', 'Unit of Measure'),
(176, 'Maintenance', 'Users'),
(177, 'Reports', 'AR Items'),
(178, 'Reports', 'Barcodes'),
(179, 'Reports', 'Cashier Report'),
(180, 'Reports', 'Customers'),
(182, 'Reports', 'Inventory Count'),
(183, 'Reports', 'Item Ledger'),
(184, 'Reports', 'Re-Order Level'),
(185, 'Reports', 'Services'),
(186, 'Reports', 'Stock Take'),
(187, 'Reports', 'BIR'),
(188, 'Reports', 'Suppliers'),
(189, 'Transactions', 'Accounts Payable Payments'),
(190, 'Maintenance', 'Stock Transfer Privileges');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `user_default_previleges`
--
ALTER TABLE `user_default_previleges`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `user_default_previleges`
--
ALTER TABLE `user_default_previleges`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=191;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
