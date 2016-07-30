-- phpMyAdmin SQL Dump
-- version 3.4.10.1deb1
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: May 18, 2016 at 05:09 PM
-- Server version: 5.5.49
-- PHP Version: 5.3.10-1ubuntu3.22

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `empsense`
--

-- --------------------------------------------------------

--
-- Table structure for table `login`
--

CREATE TABLE IF NOT EXISTS `login` (
  `username` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `login`
--

INSERT INTO `login` (`username`, `password`) VALUES
('admin', '0192023a7bbd73250516f069df18b500');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
--Data Trainning Tables
CREATE TABLE IF NOT EXISTS `employeesIT_Train` (
  `Employee_ID` varchar(100) DEFAULT NULL,
  `Employee_Name` varchar(1000) DEFAULT NULL,
  `Age` int(11) DEFAULT NULL,
  `Gender` varchar(6) DEFAULT NULL,
  `Marital_Status` varchar(10) DEFAULT NULL,
  `Having_Degree` varchar(10) DEFAULT NULL,
  `Job_Role` varchar(100) DEFAULT NULL,
  `Department` varchar(100) DEFAULT NULL,
  `WorkFrom` DATETIME DEFAULT NULL,
  `WorkTo` DATETIME DEFAULT NULL,  
  `Tenure` int(11) DEFAULT NULL,
  `Salary` float(10,2) DEFAULT NULL,
  `Bonus` float(10,2) DEFAULT NULL,
  `Claims` float(10,2) DEFAULT NULL,
  `Worked Project` varchar(1000) DEFAULT NULL,
  `No_of_Leaves` int(11) DEFAULT NULL,
  `Distance` float(8,3) DEFAULT NULL,
  `No_of_Parents` int(11) DEFAULT NULL,
  `No_of_Children` int(11) DEFAULT NULL,
  `No_of_Complaints` int(11) DEFAULT NULL,
  `Reason_To_Leave` varchar(1000) DEFAULT NULL,
  `churn` boolean,
  `probability` float(10,3) DEFAULT 0.0
);

CREATE TABLE IF NOT EXISTS `employeesIT_Raw_Train` (
  `Employee_ID` int(11) DEFAULT NULL,
  `Employee_Name` int(11) DEFAULT NULL,
  `Age` int(11) DEFAULT NULL,
  `Gender` int DEFAULT NULL,
  `Marital_Status` int DEFAULT NULL,
  `Having_Degree` int DEFAULT NULL,
  `Job_Role` int DEFAULT NULL,
  `Department` int DEFAULT NULL,
  `WorkFrom` int(11) DEFAULT NULL,
  `WorkTo` int(11) DEFAULT NULL,
  `Tenure` int(11) DEFAULT NULL,
  `Salary` float(10,2) DEFAULT NULL,
  `Bonus` float(10,2) DEFAULT NULL,
  `Claims` float(10,2) DEFAULT NULL,
  `Worked Project` int(11) DEFAULT NULL,
  `No_of_Leaves` int(11) DEFAULT NULL,
  `Distance` float(8,3) DEFAULT NULL,
  `No_of_Parents` int(11) DEFAULT NULL,
  `No_of_Children` int(11) DEFAULT NULL,
  `No_of_Complaints` int(11) DEFAULT NULL,
  `Reason_To_Leave` int DEFAULT NULL,
  `churn` int  
);

--Data Predicting Tables
CREATE TABLE IF NOT EXISTS `employeesIT_Predict` (
  `Employee_ID` varchar(100) DEFAULT NULL,
  `Employee_Name` varchar(1000) DEFAULT NULL,
  `Age` int(11) DEFAULT NULL,
  `Gender` varchar(6) DEFAULT NULL,
  `Marital_Status` varchar(10) DEFAULT NULL,
  `Having_Degree` varchar(10) DEFAULT NULL,
  `Job_Role` varchar(100) DEFAULT NULL,
  `Department` varchar(100) DEFAULT NULL,
  `WorkFrom` DATETIME DEFAULT NULL,
  `WorkTo` DATETIME DEFAULT NULL,
  `Tenure` int(11) DEFAULT NULL,
  `Salary` float(10,2) DEFAULT NULL,
  `Bonus` float(10,2) DEFAULT NULL,
  `Claims` float(10,2) DEFAULT NULL,
  `Worked Project` varchar(1000) DEFAULT NULL,
  `No_of_Leaves` int(11) DEFAULT NULL,
  `Distance` float(8,3) DEFAULT NULL,
  `No_of_Parents` int(11) DEFAULT NULL,
  `No_of_Children` int(11) DEFAULT NULL,
  `No_of_Complaints` int(11) DEFAULT NULL,
  `probability` float(10,3) DEFAULT 0.0,
  `Reason_To_Leave` varchar(1000) DEFAULT NULL
);

CREATE TABLE IF NOT EXISTS `employeesIT_Raw_Predict` (
  `Employee_ID` int(11) DEFAULT NULL,
  `Employee_Name` int(11) DEFAULT NULL,
  `Age` int(11) DEFAULT NULL,
  `Gender` int DEFAULT NULL,
  `Marital_Status` int DEFAULT NULL,
  `Having_Degree` int DEFAULT NULL,
  `Job_Role` int DEFAULT NULL,
  `Department` int(11) DEFAULT NULL,
  `WorkFrom` int(11) DEFAULT NULL,
  `WorkTo` int(11) DEFAULT NULL,
  `Tenure` int(11) DEFAULT NULL,
  `Salary` float(10,2) DEFAULT NULL,
  `Bonus` float(10,2) DEFAULT NULL,
  `Claims` float(10,2) DEFAULT NULL,
  `Worked Project` int(11) DEFAULT NULL,
  `No_of_Leaves` int(11) DEFAULT NULL,
  `Distance` float(8,3) DEFAULT NULL,
  `No_of_Parents` int(11) DEFAULT NULL,
  `No_of_Children` int(11) DEFAULT NULL,
  `No_of_Complaints` int(11) DEFAULT NULL,
  `Reason_To_Leave` int DEFAULT NULL
); 

CREATE TABLE IF NOT EXISTS `reasonUniques` (
  `id` int DEFAULT NULL,
  `reason` varchar(1000) DEFAULT NULL
);
