-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Oct 16, 2018 at 04:31 PM
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
-- Table structure for table `user_default_previlege_others`
--

CREATE TABLE `user_default_previlege_others` (
  `id` int(11) NOT NULL,
  `account` varchar(255) DEFAULT NULL,
  `account_name` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user_default_previlege_others`
--

INSERT INTO `user_default_previlege_others` (`id`, `account`, `account_name`, `name`) VALUES
(1, 'Transactions', 'Sales', 'Cashcount'),
(2, 'Transactions', 'Sales', 'Choose Location'),
(3, 'Transactions', 'Sales', 'Discount-Item'),
(4, 'Transactions', 'Sales', 'Discount-Amount'),
(5, 'Transactions', 'Sales', 'Sales by Item'),
(6, 'Transactions', 'Sales', 'Return Exchange'),
(7, 'Transactions', 'Sales', 'Sales Ledger'),
(8, 'Transactions', 'Sales', 'Sales Summary'),
(9, 'Transactions', 'Sales', 'Void'),
(10, 'Transactions', 'Sales', 'Remittance'),
(11, 'Transactions', 'Sales', 'Sales Transactions'),
(12, 'Maintenance', 'Customers', 'AR'),
(13, 'Maintenance', 'Sales', 'Customers AR'),
(14, 'Maintenance', 'Sales', 'Disbursement Categories'),
(15, 'Transactions', 'Prepaid Payments', 'Adjustment'),
(18, 'Transactions', 'Accounts Receivable', 'Delete Finalized AR'),
(19, 'Transactions', 'Accounts Receivable Payments', 'Delete Finalized AR Payment'),
(20, 'Transactions', 'Sales', 'Void Sales');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `user_default_previlege_others`
--
ALTER TABLE `user_default_previlege_others`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `user_default_previlege_others`
--
ALTER TABLE `user_default_previlege_others`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
