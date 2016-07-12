-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Jul 12, 2016 at 07:56 AM
-- Server version: 10.1.13-MariaDB
-- PHP Version: 7.0.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `empsense`
--

-- --------------------------------------------------------

--
-- Table structure for table `accuracy_confusion_mse`
--

CREATE TABLE `accuracy_confusion_mse` (
  `algo_id` int(11) NOT NULL,
  `algo_name` varchar(100) DEFAULT NULL,
  `confusion_accuracy` float DEFAULT NULL,
  `mean_squared_error` float DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `accuracy_confusion_mse`
--

INSERT INTO `accuracy_confusion_mse` (`algo_id`, `algo_name`, `confusion_accuracy`, `mean_squared_error`) VALUES
(1, 'K-Nearest-Neighbors', 0.78, 0.219),
(2, 'Random Forest', 0.83, 0.171),
(3, 'Support Vector Machine', 0.8, 0.197);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `accuracy_confusion_mse`
--
ALTER TABLE `accuracy_confusion_mse`
  ADD PRIMARY KEY (`algo_id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
