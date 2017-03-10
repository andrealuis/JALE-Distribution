-- phpMyAdmin SQL Dump
-- version 4.6.5.2
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 10-03-2017 a las 05:18:46
-- Versión del servidor: 10.1.21-MariaDB
-- Versión de PHP: 7.1.1

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
-- Estructura de tabla para la tabla `atraccion`
--

CREATE TABLE `atraccion` (
  `idMunicipio` int(11) NOT NULL,
  `idAtraccion` int(11) NOT NULL,
  `idImagen` int(11) NOT NULL,
  `nombreAtraccion` varchar(50) NOT NULL,
  `descripcion` varchar(500) NOT NULL,
  `direccion` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 ROW_FORMAT=COMPACT;

--
-- Volcado de datos para la tabla `atraccion`
--

INSERT INTO `atraccion` (`idMunicipio`, `idAtraccion`, `idImagen`, `nombreAtraccion`, `descripcion`, `direccion`) VALUES
(1, 1, 1, 'Parque de la Marimba', 'great place', 'evergreen terrace'),
(2, 2, 2, 'Agua Azul', 'great place', 'evergreen terrace');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `calificacion`
--

CREATE TABLE `calificacion` (
  `id` int(11) NOT NULL,
  `puntaje` int(50) NOT NULL,
  `comentario` varchar(500) NOT NULL,
  `nombreAtraccion` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `calificacion`
--

INSERT INTO `calificacion` (`id`, `puntaje`, `comentario`, `nombreAtraccion`) VALUES
(5, 4, 'hola men', 'cafecafe'),
(6, 4, 'assdasd', 'cafecafe'),
(7, 4, 'sdasdasd', 'cafecafe'),
(8, 4, 'asdasd', 'cafecafe'),
(9, 4, 'asasd', 'Cafecafe'),
(10, 4, 'asd', 'cafecafe'),
(11, 5, 'Ahora si krnal', 'cafecafe'),
(12, 5, 'Cantidad infinita de veces', 'cafecafe'),
(13, 5, 'Al menos una vez', 'cafecafe'),
(14, 4, 'Hola hola', 'cafecafe'),
(15, 4, 'Hola amigos sean bienvenidos a una aventura mas', 'cafecafe'),
(16, 4, 'Hola amigos sean bienvenidos a una aventura mas', 'cafecafe'),
(17, 3, 'gg izi', 'cafecafe'),
(18, 3, 'asd', 'cafecafe'),
(19, 4, 'Es un cafe muy rico, pero riquisimooooooooo', 'cafecafe'),
(20, 4, 'Es un cafe muy rico, pero riquisimooooooooo', 'cafecafe'),
(21, 3, 'assdasd', 'cafecafe'),
(22, 5, '', 'cafecafe'),
(23, 5, 'Señor, Erick esta bien chida su secre le pongo 5 estrellitas :*', 'cafecafe'),
(24, 0, '', 'cafecafe'),
(25, 4, '', 'cafecafe'),
(26, 3, 'Muy buenas', 'cafecafe');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `imagen`
--

CREATE TABLE `imagen` (
  `id` int(11) NOT NULL,
  `idImagen` int(11) NOT NULL,
  `path` varchar(500) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `imagen`
--

INSERT INTO `imagen` (`id`, `idImagen`, `path`) VALUES
(1, 1, 'parque-de-la-marimba-1'),
(2, 1, 'parque-de-la-marimba-2'),
(3, 2, 'agua-azul-2'),
(4, 2, 'agua-azul-1');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `lugares`
--

CREATE TABLE `lugares` (
  `idMunicipio` bigint(20) NOT NULL,
  `nombrePais` varchar(255) DEFAULT NULL,
  `nombreEstado` varchar(255) DEFAULT NULL,
  `nombreMunicipio` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `lugares`
--

INSERT INTO `lugares` (`idMunicipio`, `nombrePais`, `nombreEstado`, `nombreMunicipio`) VALUES
(1, 'Mexico', 'Chiapas', 'Tuxtla Gutierrez'),
(2, 'Mexico', 'Jalisco', 'Guadalajara');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `roles`
--

CREATE TABLE `roles` (
  `idRol` bigint(20) NOT NULL,
  `nombre` varchar(255) NOT NULL,
  `descripcion` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuariorol`
--

CREATE TABLE `usuariorol` (
  `idUsuario` bigint(20) NOT NULL,
  `idRol` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE `usuarios` (
  `idUsuario` bigint(20) NOT NULL,
  `nombrePrefijo` varchar(255) DEFAULT NULL,
  `nombreNombre` varchar(255) DEFAULT NULL,
  `nombreApellidoPaterno` varchar(255) DEFAULT NULL,
  `nombreApellidoMaterno` varchar(255) DEFAULT NULL,
  `nombrePosfijo` varchar(255) DEFAULT NULL,
  `nombreIniciales` varchar(255) DEFAULT NULL,
  `nombreUsuario` varchar(255) NOT NULL,
  `claveAcceso` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`idUsuario`, `nombrePrefijo`, `nombreNombre`, `nombreApellidoPaterno`, `nombreApellidoMaterno`, `nombrePosfijo`, `nombreIniciales`, `nombreUsuario`, `claveAcceso`) VALUES
(0, 'root', 'root', 'root', 'root', 'root', 'root', 'root', 'root');

-- --------------------------------------------------------

--
-- Estructura Stand-in para la vista `vista_atraccion`
-- (Véase abajo para la vista actual)
--
CREATE TABLE `vista_atraccion` (
`id` int(11)
,`nombreAtraccion` varchar(50)
,`descripcion` varchar(500)
,`direccion` varchar(200)
,`path` varchar(500)
);

-- --------------------------------------------------------

--
-- Estructura para la vista `vista_atraccion`
--
DROP TABLE IF EXISTS `vista_atraccion`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `vista_atraccion`  AS  select `imagen`.`id` AS `id`,`atraccion`.`nombreAtraccion` AS `nombreAtraccion`,`atraccion`.`descripcion` AS `descripcion`,`atraccion`.`direccion` AS `direccion`,`imagen`.`path` AS `path` from ((`lugares` join `atraccion` on((`lugares`.`idMunicipio` = `atraccion`.`idMunicipio`))) join `imagen` on((`imagen`.`idImagen` = `atraccion`.`idImagen`))) ;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `calificacion`
--
ALTER TABLE `calificacion`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `imagen`
--
ALTER TABLE `imagen`
  ADD UNIQUE KEY `id` (`id`);

--
-- Indices de la tabla `lugares`
--
ALTER TABLE `lugares`
  ADD PRIMARY KEY (`idMunicipio`),
  ADD UNIQUE KEY `nombreMunicipio` (`nombreMunicipio`);

--
-- Indices de la tabla `roles`
--
ALTER TABLE `roles`
  ADD PRIMARY KEY (`idRol`),
  ADD UNIQUE KEY `nombre` (`nombre`);

--
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`idUsuario`),
  ADD UNIQUE KEY `nombreUsuario` (`nombreUsuario`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `calificacion`
--
ALTER TABLE `calificacion`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=27;
--
-- AUTO_INCREMENT de la tabla `imagen`
--
ALTER TABLE `imagen`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
