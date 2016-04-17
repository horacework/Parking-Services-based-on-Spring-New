-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: 2016-04-17 19:48:42
-- 服务器版本： 10.1.9-MariaDB
-- PHP Version: 5.6.15

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `parking`
--

-- --------------------------------------------------------

--
-- 表的结构 `markerinfo`
--

CREATE TABLE `markerinfo` (
  `id` varchar(36) NOT NULL,
  `name` varchar(20) NOT NULL,
  `latitude` double NOT NULL,
  `longitude` double NOT NULL,
  `imgUrl` varchar(60) DEFAULT NULL,
  `zan` int(11) NOT NULL DEFAULT '0',
  `isDel` tinyint(1) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `markerinfo`
--

INSERT INTO `markerinfo` (`id`, `name`, `latitude`, `longitude`, `imgUrl`, `zan`, `isDel`) VALUES
('b4850fda-047b-11e6-b034-00ff9099da81', '广工大停车场', 23.0444140612, 113.3944387036, NULL, 0, 0),
('b4851ab1-047b-11e6-b034-00ff9099da81', '中心湖停车场', 23.0474740612, 113.3910077036, NULL, 0, 0),
('e5a3715d-047c-11e6-b034-00ff9099da81', '华工大停车场', 23.1547505064, 113.3404893861, NULL, 0, 0),
('e5a380fc-047c-11e6-b034-00ff9099da81', '中山大学停车场', 23.0962370113, 113.2940412863, NULL, 0, 0);

-- --------------------------------------------------------

--
-- 表的结构 `user`
--

CREATE TABLE `user` (
  `id` varchar(36) NOT NULL,
  `name` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `isDel` tinyint(1) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `user`
--

INSERT INTO `user` (`id`, `name`, `password`, `isDel`) VALUES
('213121', 'chen', 'aaaa', 0);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `markerinfo`
--
ALTER TABLE `markerinfo`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `id` (`id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
