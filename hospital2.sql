-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jul 15, 2024 at 08:58 AM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `hospital2`
--

-- --------------------------------------------------------

--
-- Table structure for table `administrator`
--

CREATE TABLE `administrator` (
  `Email` varchar(100) NOT NULL DEFAULT 'jkhospitalx@gmail.com',
  `User` varchar(100) NOT NULL,
  `Password` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `administrator`
--

INSERT INTO `administrator` (`Email`, `User`, `Password`) VALUES
('akashmeshram8856@gmail.com', 'administrator', '123');

-- --------------------------------------------------------

--
-- Table structure for table `adminlogin`
--

CREATE TABLE `adminlogin` (
  `User` varchar(100) NOT NULL,
  `Password` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `adminlogin`
--

INSERT INTO `adminlogin` (`User`, `Password`) VALUES
('admin', 'admin');

-- --------------------------------------------------------

--
-- Table structure for table `doctor`
--

CREATE TABLE `doctor` (
  `id` int(11) NOT NULL,
  `name` varchar(100) NOT NULL,
  `regno` varchar(25) NOT NULL,
  `education` varchar(100) NOT NULL,
  `experience` int(11) NOT NULL,
  `visit1` varchar(10) NOT NULL,
  `visit2` varchar(10) NOT NULL,
  `visit3` varchar(10) NOT NULL,
  `photo_path` varchar(255) NOT NULL,
  `User` varchar(255) NOT NULL,
  `Password` varchar(255) NOT NULL,
  `STATUS` enum('active','inactive') DEFAULT 'active'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `doctor`
--

INSERT INTO `doctor` (`id`, `name`, `regno`, `education`, `experience`, `visit1`, `visit2`, `visit3`, `photo_path`, `User`, `Password`, `STATUS`) VALUES
(7, 'Dr.Akash Meshram', '9874/852/963', 'MBBS MD', 8, '900', '700', '500', 'uploads/IMG_3633.JPG', 'akash', 'akash', 'active');

-- --------------------------------------------------------

--
-- Table structure for table `meal_timing`
--

CREATE TABLE `meal_timing` (
  `meal_timing_id` int(11) NOT NULL,
  `prescription_id` int(11) NOT NULL,
  `meal_timing` varchar(255) NOT NULL,
  `medicine` varchar(100) DEFAULT NULL,
  `dose` int(11) DEFAULT NULL,
  `no_of_days` int(11) DEFAULT NULL,
  `timing` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `meal_timing`
--

INSERT INTO `meal_timing` (`meal_timing_id`, `prescription_id`, `meal_timing`, `medicine`, `dose`, `no_of_days`, `timing`) VALUES
(30, 40, 'After Meal', 'limcee500', 2, 30, 'Night'),
(31, 41, 'After Meal', 'Respira', 5, 1, 'Morning#Afternoon'),
(32, 42, 'After Meal', 'Limcee 500', 1, 30, 'Night'),
(33, 42, 'After Meal', 'IP -Deriva', 1, 30, 'Morning-Night');

-- --------------------------------------------------------

--
-- Table structure for table `med`
--

CREATE TABLE `med` (
  `id` int(11) NOT NULL,
  `medicine_name` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `patientlogin`
--

CREATE TABLE `patientlogin` (
  `User` varchar(100) NOT NULL,
  `Password` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `patientlogin`
--

INSERT INTO `patientlogin` (`User`, `Password`) VALUES
('7499865823', 'vQ9eBswh5z'),
('7517466460', 'bnyM87H199'),
('7897899879', 'JjoOlo6jwK'),
('8528528522', 'M6rYpRprfu'),
('8528528523', 'BX2jmRtcES'),
('8568568561', 'ia18h5QRwm'),
('8856821788', 'Mcqst2NFst'),
('9879879876', 'jwd863UQgT');

-- --------------------------------------------------------

--
-- Table structure for table `patientreg`
--

CREATE TABLE `patientreg` (
  `id` int(11) NOT NULL,
  `Name` varchar(100) NOT NULL,
  `Doctor` varchar(100) DEFAULT NULL,
  `Gender` varchar(100) NOT NULL,
  `MobileNo` varchar(10) NOT NULL,
  `Email` varchar(100) NOT NULL,
  `Age` varchar(100) NOT NULL,
  `Weight` varchar(100) NOT NULL,
  `Address` varchar(100) NOT NULL,
  `Visit` varchar(100) NOT NULL,
  `Fees` varchar(100) NOT NULL,
  `timestamp` timestamp NOT NULL DEFAULT current_timestamp(),
  `Date` date NOT NULL,
  `status` char(7) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `patientreg`
--

INSERT INTO `patientreg` (`id`, `Name`, `Doctor`, `Gender`, `MobileNo`, `Email`, `Age`, `Weight`, `Address`, `Visit`, `Fees`, `timestamp`, `Date`, `status`) VALUES
(1, 'Aakash', 'Dr.Akash Meshram', 'Male', '8856821788', 'akashmeshram2486@gmail.com', '22', '72', 'Amravati', '1st', '900', '2024-05-27 05:36:52', '2024-05-27', 'Offline'),
(4, 'Raaja', 'Dr.Akash Meshram', 'Male', '7517466460', 'akashmeshram2486@gmail.com', '22', '45', 'Raipur', '1st', '900', '2024-06-25 05:33:35', '2024-06-25', 'Online'),
(5, 'Ritesh', 'Dr.Akash Meshram', 'Male', '8568568561', 'akashmeshram2486@gmail.com', '22', '85', 'Morshi', '1st', '900', '2024-06-25 06:06:08', '2024-06-25', 'Offline'),
(6, 'Ram Rathod', 'Dr.Akash Meshram', 'Male', '7499865823', 'rr480401@gmail.com', '21', '60', 'NEr', '1st', '900', '2024-06-30 14:05:42', '2024-06-30', 'Online'),
(7, 'Ram Rathod', 'Dr.Akash Meshram', 'Male', '8528528523', 'rr480401@gmail.com', '21', '60', 'Ner', '1st', '900', '2024-06-30 14:07:15', '2024-06-30', 'Offline');

-- --------------------------------------------------------

--
-- Table structure for table `patient_diagno`
--

CREATE TABLE `patient_diagno` (
  `Id` int(11) NOT NULL,
  `Name` varchar(100) NOT NULL,
  `Mobile` varchar(10) NOT NULL,
  `Weight` varchar(100) NOT NULL,
  `NextVisit` varchar(100) NOT NULL,
  `Prescription` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `prescription`
--

CREATE TABLE `prescription` (
  `prescription_id` int(11) NOT NULL,
  `patient_name` varchar(255) NOT NULL,
  `age` int(11) NOT NULL,
  `weight` int(11) NOT NULL,
  `visit_date` date NOT NULL,
  `prescription` text NOT NULL,
  `patient_id` varchar(255) NOT NULL,
  `doctor_name` varchar(255) NOT NULL,
  `timestamp` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `prescription`
--

INSERT INTO `prescription` (`prescription_id`, `patient_name`, `age`, `weight`, `visit_date`, `prescription`, `patient_id`, `doctor_name`, `timestamp`) VALUES
(40, 'Sarthak  Chore', 18, 55, '2024-05-29', 'all okk\r\n', '7897899879', 'Dr.Akash Meshram', '2024-05-21 05:04:09'),
(41, 'Aakash', 22, 72, '2024-05-23', 'All Well', '8528528522', 'Dr.Akash Meshram', '2024-05-22 04:24:56'),
(42, 'Ritesh', 22, 85, '2024-07-25', 'Drink Plenty of water', '8568568561', 'Dr.Akash Meshram', '2024-06-25 06:09:06');

-- --------------------------------------------------------

--
-- Table structure for table `receptionistlogin`
--

CREATE TABLE `receptionistlogin` (
  `User` varchar(100) NOT NULL,
  `Password` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `receptionistlogin`
--

INSERT INTO `receptionistlogin` (`User`, `Password`) VALUES
('akash', 'akash');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `administrator`
--
ALTER TABLE `administrator`
  ADD PRIMARY KEY (`User`);

--
-- Indexes for table `adminlogin`
--
ALTER TABLE `adminlogin`
  ADD PRIMARY KEY (`User`);

--
-- Indexes for table `doctor`
--
ALTER TABLE `doctor`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `meal_timing`
--
ALTER TABLE `meal_timing`
  ADD PRIMARY KEY (`meal_timing_id`),
  ADD KEY `prescription_id` (`prescription_id`);

--
-- Indexes for table `med`
--
ALTER TABLE `med`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `patientlogin`
--
ALTER TABLE `patientlogin`
  ADD PRIMARY KEY (`User`);

--
-- Indexes for table `patientreg`
--
ALTER TABLE `patientreg`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `patient_diagno`
--
ALTER TABLE `patient_diagno`
  ADD PRIMARY KEY (`Mobile`);

--
-- Indexes for table `prescription`
--
ALTER TABLE `prescription`
  ADD PRIMARY KEY (`prescription_id`);

--
-- Indexes for table `receptionistlogin`
--
ALTER TABLE `receptionistlogin`
  ADD PRIMARY KEY (`User`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `doctor`
--
ALTER TABLE `doctor`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `meal_timing`
--
ALTER TABLE `meal_timing`
  MODIFY `meal_timing_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=34;

--
-- AUTO_INCREMENT for table `med`
--
ALTER TABLE `med`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;

--
-- AUTO_INCREMENT for table `patientreg`
--
ALTER TABLE `patientreg`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `prescription`
--
ALTER TABLE `prescription`
  MODIFY `prescription_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=43;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `meal_timing`
--
ALTER TABLE `meal_timing`
  ADD CONSTRAINT `meal_timing_ibfk_1` FOREIGN KEY (`prescription_id`) REFERENCES `prescription` (`prescription_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
