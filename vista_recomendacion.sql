-- phpMyAdmin SQL Dump
-- version 4.6.5.2
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 22-03-2017 a las 07:55:58
-- Versión del servidor: 10.1.21-MariaDB
-- Versión de PHP: 5.6.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `bdcec`
--

-- --------------------------------------------------------

--
-- Estructura para la vista `vista_recomendacion`
--

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `vista_recomendacion`  AS  select `imagen`.`id` AS `id`,`pais`.`nombrePais` AS `nombrePais`,`estado`.`nombreEstado` AS `nombreEstado`,`municipio`.`nombreMunicipio` AS `nombreMunicipio`,`atraccion`.`idAtraccion` AS `idAtraccion`,`atraccion`.`nombreAtraccion` AS `nombreAtraccion`,`imagen`.`path` AS `path`,avg(`calificacion`.`puntaje`) AS `puntaje` from (((((`atraccion` join `imagen` on((`atraccion`.`idAtraccion` = `imagen`.`idAtraccion`))) join `calificacion` on((`calificacion`.`nombreAtraccion` = `atraccion`.`nombreAtraccion`))) join `municipio` on((`atraccion`.`idMunicipio` = `municipio`.`idMunicipio`))) join `estado` on((`estado`.`idEstado` = `municipio`.`idEstado`))) join `pais` on((`estado`.`idPais` = `pais`.`idPais`))) group by `atraccion`.`nombreAtraccion` having (avg(`calificacion`.`puntaje`) > 3) ;

--
-- VIEW  `vista_recomendacion`
-- Datos: Ninguna
--


/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
