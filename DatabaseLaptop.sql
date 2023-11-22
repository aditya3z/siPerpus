-- phpMyAdmin SQL Dump
-- version 4.7.7
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 30, 2019 at 06:36 AM
-- Server version: 10.1.30-MariaDB
-- PHP Version: 7.2.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `laptop`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `id` int(11) NOT NULL,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`id`, `username`, `password`) VALUES
(0, 'abbiyou', '$2y$10$4alJF5zpzcendAlPSUVYmuP2347KRN/JPhgdTEmqxblawxn0UeV/6'),
(0, 'alan', '$2y$10$.rLmyaquzKy2UTcOvIDb1.CSF5USWqwjca18CdSSJtxtIdkzO3X3K'),
(0, 'hernanda', '$2y$10$HgBZ6v98eL.VvlkIZgOZ7.Sw1rSBlex8Z6fv5S/zFS4fh0KKjubSm');

-- --------------------------------------------------------

--
-- Table structure for table `merk_laptop`
--

CREATE TABLE `merk_laptop` (
  `No` int(100) NOT NULL,
  `Gambar` varchar(100) NOT NULL,
  `Merk` varchar(100) NOT NULL,
  `Type` varchar(100) NOT NULL,
  `RAM` varchar(100) NOT NULL,
  `Processor` varchar(100) NOT NULL,
  `Harga` int(11) NOT NULL,
  `Index` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `merk_laptop`
--

INSERT INTO `merk_laptop` (`No`, `Gambar`, `Merk`, `Type`, `RAM`, `Processor`, `Harga`, `Index`) VALUES
(1, 'ASUS_X455LA.jpg', 'asus', 'X455LA', '4 GB', 'Intel Core I5', 4747500, 'asusX.html'),
(3, 'rog.png', 'asus', 'ROG GL552JX', '16 GB', 'Intel Core I7', 12450000, 'asus1.html'),
(4, 'lenovo.jpg', 'LENOVO', '520 14IKB', '8 GB', 'Intel Core I5', 10580000, 'lenovo.html'),
(5, 'mmg2.jpg', 'APPLE', 'MACKBOOK AIR MMGG2', '8 GB', 'Intel Core I7', 13800000, 'apple1.html'),
(6, '001.jpg', 'DELL', '14-bw002AU', '4 GB', 'AMD E-2900e', 3650000, 'dell1.html'),
(7, '002.jpg', 'DELL', '14-bw002AU', '4 GB', 'AMD E-2900e', 3650000, 'dell2.html'),
(10, '5c1c97768f8a2.jpeg', 'Lenovo', 'vibe 1e', '4GB', 'core i7', 5000000, 'asus1.html'),
(11, '5c1c9ee379b28.jpeg', 'ASUS', '1234', '8 GB', 'core i7', 5000000, 'asus1.html');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `username`, `password`) VALUES
(0, 'alan', '$2y$10$C60RlCfIZ5mv1UkP.KksDe3QV6ouMcJugmrXY0ThEAxZOafK7GWvG'),
(0, 'faisal', '$2y$10$ykYH6jW1tmpXwOBtDegi5.axvAbHQFt/TvkrAJO21tfk.LgBJzSfK'),
(0, 'hernanda', '$2y$10$PSxemcb5pMK4IjNIY1.AteMjEi16eh8.7.tt2iNtfHMWOF2vON1.2');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`username`);

--
-- Indexes for table `merk_laptop`
--
ALTER TABLE `merk_laptop`
  ADD PRIMARY KEY (`No`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`username`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `merk_laptop`
--
ALTER TABLE `merk_laptop`
  MODIFY `No` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
