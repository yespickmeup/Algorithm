-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Oct 16, 2018 at 04:33 PM
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
-- Table structure for table `user_previlege_others`
--

CREATE TABLE `user_previlege_others` (
  `id` int(11) NOT NULL,
  `account` varchar(255) DEFAULT NULL,
  `account_name` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `user_id` varchar(255) DEFAULT NULL,
  `user_name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user_previlege_others`
--

INSERT INTO `user_previlege_others` (`id`, `account`, `account_name`, `name`, `user_id`, `user_name`) VALUES
(5, 'Transactions', 'Sales', 'Cashcount - (View)', '1', 'admin'),
(12, 'Transactions', 'Sales', 'Cashcount - (Add)', '1', 'admin'),
(13, 'Transactions', 'Sales', 'Choose Location - (View)', '1', 'admin'),
(14, 'Transactions', 'Sales', 'Discount-Amount - (View)', '1', 'admin'),
(15, 'Transactions', 'Sales', 'Discount-Item - (View)', '1', 'admin'),
(17, 'Transactions', 'Sales', 'Return Exchange - (View)', '1', 'admin'),
(18, 'Transactions', 'Sales', 'Sales by Item - (View)', '1', 'admin'),
(19, 'Transactions', 'Sales', 'Sales Ledger - (View)', '1', 'admin'),
(20, 'Transactions', 'Sales', 'Sales Summary - (View)', '1', 'admin'),
(22, 'Transactions', 'Sales', 'Void - (View)', '1', 'admin'),
(23, 'Transactions', 'Sales', 'Sales Transactions - (View)', '1', 'admin'),
(24, 'Transactions', 'Sales', 'Remittance - (View)', '1', 'admin'),
(25, 'Transactions', 'Sales', 'Cashcount', '43', '3'),
(26, 'Transactions', 'Sales', 'Choose Location', '43', '3'),
(27, 'Transactions', 'Sales', 'Discount-Item', '43', '3'),
(28, 'Transactions', 'Sales', 'Discount-Amount', '43', '3'),
(29, 'Transactions', 'Sales', 'Sales by Item', '43', '3'),
(30, 'Transactions', 'Sales', 'Return Exchange', '43', '3'),
(31, 'Transactions', 'Sales', 'Remittance', '43', '3'),
(32, 'Transactions', 'Sales', 'Sales Ledger', '43', '3'),
(33, 'Transactions', 'Sales', 'Sales Summary', '43', '3'),
(34, 'Transactions', 'Sales', 'Sales Transactions', '43', '3'),
(35, 'Transactions', 'Sales', 'Void', '43', '3'),
(36, 'Maintenance', 'Sales', 'Customers AR', '43', '3'),
(37, 'Maintenance', 'Sales', 'Disbursement Categories', '43', '3'),
(38, 'Transactions', 'Sales', 'Cashcount - (View)', '43', '3'),
(39, 'Transactions', 'Sales', 'Cashcount', '44', '4'),
(40, 'Transactions', 'Sales', 'Choose Location', '44', '4'),
(41, 'Transactions', 'Sales', 'Discount-Item', '44', '4'),
(42, 'Transactions', 'Sales', 'Discount-Amount', '44', '4'),
(43, 'Transactions', 'Sales', 'Sales by Item', '44', '4'),
(44, 'Transactions', 'Sales', 'Return Exchange', '44', '4'),
(45, 'Transactions', 'Sales', 'Remittance', '44', '4'),
(46, 'Transactions', 'Sales', 'Sales Ledger', '44', '4'),
(47, 'Transactions', 'Sales', 'Sales Summary', '44', '4'),
(48, 'Transactions', 'Sales', 'Sales Transactions', '44', '4'),
(49, 'Transactions', 'Sales', 'Void', '44', '4'),
(50, 'Maintenance', 'Sales', 'Customers AR', '44', '4'),
(51, 'Maintenance', 'Sales', 'Disbursement Categories', '44', '4'),
(52, 'Transactions', 'Sales', 'Cashcount - (View)', '45', '5'),
(53, 'Transactions', 'Sales', 'Choose Location - (View)', '45', '5'),
(54, 'Transactions', 'Sales', 'Discount-Item - (View)', '45', '5'),
(55, 'Transactions', 'Sales', 'Discount-Amount - (View)', '45', '5'),
(56, 'Transactions', 'Sales', 'Sales by Item - (View)', '45', '5'),
(57, 'Transactions', 'Sales', 'Return Exchange - (View)', '45', '5'),
(58, 'Transactions', 'Sales', 'Remittance - (View)', '45', '5'),
(59, 'Transactions', 'Sales', 'Sales Ledger - (View)', '45', '5'),
(60, 'Transactions', 'Sales', 'Sales Summary - (View)', '45', '5'),
(61, 'Transactions', 'Sales', 'Sales Transactions - (View)', '45', '5'),
(62, 'Transactions', 'Sales', 'Void - (View)', '45', '5'),
(63, 'Maintenance', 'Sales', 'Customers AR', '45', '5'),
(64, 'Maintenance', 'Sales', 'Disbursement Categories', '45', '5'),
(65, 'Transactions', 'Sales', 'Cashcount - (View)', '46', '6'),
(66, 'Transactions', 'Sales', 'Discount-Item - (View)', '46', '6'),
(67, 'Transactions', 'Sales', 'Discount-Amount - (View)', '46', '6'),
(68, 'Transactions', 'Sales', 'Sales by Item - (View)', '46', '6'),
(69, 'Transactions', 'Sales', 'Return Exchange - (View)', '46', '6'),
(70, 'Transactions', 'Sales', 'Remittance - (View)', '46', '6'),
(71, 'Transactions', 'Sales', 'Sales Ledger - (View)', '46', '6'),
(72, 'Transactions', 'Sales', 'Sales Summary - (View)', '46', '6'),
(73, 'Transactions', 'Sales', 'Sales Transactions - (View)', '46', '6'),
(74, 'Transactions', 'Sales', 'Void - (View)', '46', '6'),
(75, 'Maintenance', 'Sales', 'Customers AR', '46', '6'),
(76, 'Maintenance', 'Sales', 'Disbursement Categories', '46', '6'),
(77, 'Maintenance', 'Sales', 'Customers AR', '46', '6'),
(78, 'Maintenance', 'Sales', 'Disbursement Categories', '46', '6'),
(79, 'Transactions', 'Sales', 'Cashcount - (View)', '46', '6'),
(80, 'Transactions', 'Sales', 'Choose Location - (View)', '46', '6'),
(81, 'Transactions', 'Sales', 'Sales by Item - (View)', '46', '6'),
(82, 'Transactions', 'Sales', 'Return Exchange - (View)', '46', '6'),
(83, 'Transactions', 'Sales', 'Remittance - (View)', '46', '6'),
(84, 'Transactions', 'Sales', 'Sales Ledger - (View)', '46', '6'),
(85, 'Transactions', 'Sales', 'Sales Summary - (View)', '46', '6'),
(86, 'Transactions', 'Sales', 'Sales Transactions - (View)', '46', '6'),
(87, 'Transactions', 'Sales', 'Void - (View)', '46', '6'),
(88, 'Maintenance', 'Sales', 'Customers AR', '46', '6'),
(89, 'Maintenance', 'Sales', 'Disbursement Categories', '46', '6'),
(90, 'Transactions', 'Prepaid Payments', 'Adjustment - (View)', '1', 'admin'),
(95, 'Transactions', 'Accounts Receivable Payments', 'Delete Finalized - (Add)', '1', 'admin'),
(96, 'Transactions', 'Accounts Receivable Payments', 'Delete Finalized AR Payment - (Add)', '1', 'admin'),
(97, 'Transactions', 'Accounts Receivable', 'Delete Finalized AR - (Add)', '1', 'admin'),
(98, 'Transactions', 'Sales', 'Void Sales - (View)', '1', 'admin'),
(99, 'Transactions', 'Sales', 'Void Sales - (Add)', '1', 'admin');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `user_previlege_others`
--
ALTER TABLE `user_previlege_others`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `user_previlege_others`
--
ALTER TABLE `user_previlege_others`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=100;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
