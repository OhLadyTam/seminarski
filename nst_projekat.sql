-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Jan 27, 2017 at 01:42 AM
-- Server version: 5.6.17
-- PHP Version: 5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `nst_projekat`
--

-- --------------------------------------------------------

--
-- Table structure for table `aktivnost`
--

CREATE TABLE IF NOT EXISTS `aktivnost` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `IdProcesa` int(11) NOT NULL,
  `Naziv` text NOT NULL,
  `Opis` text,
  `Oznaka` text,
  PRIMARY KEY (`Id`),
  UNIQUE KEY `IdProcesa` (`IdProcesa`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `aktivnost_dokument`
--

CREATE TABLE IF NOT EXISTS `aktivnost_dokument` (
  `IdAktivnosti` int(11) NOT NULL,
  `IdTipaDokumenta` int(11) NOT NULL,
  `tipVeze` int(11) NOT NULL,
  `tipOperacije` int(11) NOT NULL,
  PRIMARY KEY (`IdAktivnosti`,`IdTipaDokumenta`,`tipVeze`),
  UNIQUE KEY `IdAktivnosti` (`IdAktivnosti`),
  UNIQUE KEY `IdTipaDokumenta` (`IdTipaDokumenta`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `dokument`
--

CREATE TABLE IF NOT EXISTS `dokument` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `IdTipDokumenta` int(11) NOT NULL,
  `DatumKreiranja` datetime DEFAULT NULL,
  `Napomena` text,
  `LokacijaOriginala` varchar(50) DEFAULT NULL,
  `poslato` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`Id`),
  UNIQUE KEY `IdTipDokumenta` (`IdTipDokumenta`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `podsistem`
--

CREATE TABLE IF NOT EXISTS `podsistem` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `IdNadSistema` int(11) DEFAULT NULL,
  `Opis` text,
  `Oznaka` text,
  `Naziv` text NOT NULL,
  PRIMARY KEY (`Id`),
  UNIQUE KEY `IdNadSistema` (`IdNadSistema`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `proces`
--

CREATE TABLE IF NOT EXISTS `proces` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `IdPodsistema` int(11) NOT NULL,
  `Naziv` text NOT NULL,
  `Oznaka` text,
  `Opis` text,
  `Nivo` varchar(50) NOT NULL,
  `IdNadProcesa` int(11) DEFAULT NULL,
  PRIMARY KEY (`Id`),
  UNIQUE KEY `IdPodsistema` (`IdPodsistema`),
  UNIQUE KEY `IdNadProcesa` (`IdNadProcesa`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `tipdokumenta`
--

CREATE TABLE IF NOT EXISTS `tipdokumenta` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Naziv` text NOT NULL,
  `Opis` text NOT NULL,
  `LokacijaModela` varchar(50) NOT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `aktivnost`
--
ALTER TABLE `aktivnost`
  ADD CONSTRAINT `aktivnost_ibfk_1` FOREIGN KEY (`IdProcesa`) REFERENCES `proces` (`Id`);

--
-- Constraints for table `aktivnost_dokument`
--
ALTER TABLE `aktivnost_dokument`
  ADD CONSTRAINT `aktivnost_dokument_ibfk_1` FOREIGN KEY (`IdAktivnosti`) REFERENCES `aktivnost` (`Id`),
  ADD CONSTRAINT `aktivnost_dokument_ibfk_2` FOREIGN KEY (`IdTipaDokumenta`) REFERENCES `tipdokumenta` (`Id`);

--
-- Constraints for table `dokument`
--
ALTER TABLE `dokument`
  ADD CONSTRAINT `dokument_ibfk_1` FOREIGN KEY (`IdTipDokumenta`) REFERENCES `tipdokumenta` (`Id`);

--
-- Constraints for table `podsistem`
--
ALTER TABLE `podsistem`
  ADD CONSTRAINT `podsistem_ibfk_1` FOREIGN KEY (`IdNadSistema`) REFERENCES `podsistem` (`Id`);

--
-- Constraints for table `proces`
--
ALTER TABLE `proces`
  ADD CONSTRAINT `proces_ibfk_1` FOREIGN KEY (`IdPodsistema`) REFERENCES `podsistem` (`Id`),
  ADD CONSTRAINT `proces_ibfk_2` FOREIGN KEY (`IdNadProcesa`) REFERENCES `proces` (`Id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
