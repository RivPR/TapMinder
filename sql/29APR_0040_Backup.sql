-- phpMyAdmin SQL Dump
-- version 4.4.10
-- http://www.phpmyadmin.net
--
-- Host: localhost:3306
-- Generation Time: Apr 29, 2016 at 08:40 AM
-- Server version: 5.5.42
-- PHP Version: 7.0.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";

--
-- Database: `tapminder`
--

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `firstname` varchar(45) NOT NULL,
  `lastname` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `usertype_id` int(11) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `firstname`, `lastname`, `email`, `password`, `usertype_id`) VALUES
(1, 'James', 'Jones', 'jjones@fakemail.com', 'password', 1),
(2, 'Tim', 'Trunk', 'ttrunk@fakemail.com', 'password', 2),
(3, 'Tri', 'Tran', 'ttran@fakemail.com', 'password', 1),
(4, 'Angel4', 'Argo', 'aargo@fakemail.com', 'password', 2),
(5, 'Alex', 'Arnot', 'aarnot@fakemail.com', 'password', 3),
(6, 'David', 'Dannies', 'ddannies@fakemail.com', 'password', 3),
(7, 'Elizabeth', 'Elijah', 'eelijah@fakemail.com', 'password', 1),
(8, 'Geoffrey', 'Genes', 'mrPoopyHead@fakemail.com', 'password', 1),
(9, 'Roger', 'Ralphs', 'rralphs@fakemail.com', 'password', 1),
(10, 'Yum', 'Noch', 'ynoch@fakemail.com', 'password', 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_user_type_table11_idx` (`usertype_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=11;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `users`
--
ALTER TABLE `users`
  ADD CONSTRAINT `fk_user_type_table11` FOREIGN KEY (`usertype_id`) REFERENCES `user_type` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;
