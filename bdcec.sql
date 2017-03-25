-- phpMyAdmin SQL Dump
-- version 4.6.5.2
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 25-03-2017 a las 06:18:01
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
  `nombreAtraccion` varchar(50) NOT NULL,
  `descripcion` varchar(500) NOT NULL,
  `direccion` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 ROW_FORMAT=COMPACT;

--
-- Volcado de datos para la tabla `atraccion`
--

INSERT INTO `atraccion` (`idMunicipio`, `idAtraccion`, `nombreAtraccion`, `descripcion`, `direccion`) VALUES
(1, 1, 'Parque de la Marimba', 'El lugar indicado para escuchar musica interpretada en marimba, para pasarla bien con la familia y ¿por que no? Bailar un poco', 'Av. Central Pte. S/N, Centro, Guadalupe, 29000 Tuxtla Gutiérrez, CHIS'),
(2, 2, 'Agua Azul', 'En la actualidad cuenta con una superficie de 168.500 metros cuadrados, con amplios y cuidados jardines; dentro de éstos se distribuyen 1.465 árboles de diferentes especies, brindando un paisaje acogedor, invitando a pasar un día de campo bajo la sombra de alguno de ellos.', 'Calzada Independencia Sur 973, Centro, La Aurora, 44100 Guadalajara, JAL');

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
(1, 4, 'Un buen lugar para pasar el rato con la familia', 'Parque de la Marimba'),
(2, 5, 'Que buen lugar en la capital chiapaneca', 'Parque de la Marimba'),
(3, 5, 'Puedes pasar un rato agradable escuchando marimba', 'Parque de la Marimba'),
(4, 4, 'Muy bueno, aunque pasa mucha gente pidiendo dinero, es molesto!', 'Parque de la Marimba'),
(5, 4, 'Hay muchos cafes por la zona, que buen lugar!', 'Parque de la Marimba'),
(6, 3, 'Un lindo parque, aunque sería mejor si no cobraran por entrar', 'Agua Azul'),
(7, 4, 'La pase bien ', 'Agua Azul'),
(8, 4, 'Buen lugar para pasar con la familia', 'Agua Azul');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `estado`
--

CREATE TABLE `estado` (
  `idPais` int(11) NOT NULL,
  `idEstado` int(11) NOT NULL,
  `nombreEstado` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `estado`
--

INSERT INTO `estado` (`idPais`, `idEstado`, `nombreEstado`) VALUES
(1, 1, 'Chiapas'),
(1, 2, 'Jalisco'),
(1, 3, 'Oaxaca'),
(1, 4, 'Veracruz');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `imagen`
--

CREATE TABLE `imagen` (
  `id` int(11) NOT NULL,
  `idAtraccion` int(11) NOT NULL,
  `path` varchar(500) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `imagen`
--

INSERT INTO `imagen` (`id`, `idAtraccion`, `path`) VALUES
(1, 1, 'parque-de-la-marimba-1'),
(2, 1, 'parque-de-la-marimba-2'),
(3, 2, 'agua-azul-2'),
(4, 2, 'agua-azul-1');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `municipio`
--

CREATE TABLE `municipio` (
  `idEstado` int(11) NOT NULL,
  `idMunicipio` int(11) NOT NULL,
  `nombreMunicipio` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `municipio`
--

INSERT INTO `municipio` (`idEstado`, `idMunicipio`, `nombreMunicipio`) VALUES
(1, 1, 'Tuxtla Gutierrez'),
(2, 2, 'Guadalajara');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pais`
--

CREATE TABLE `pais` (
  `idPais` int(11) NOT NULL,
  `nombrePais` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `pais`
--

INSERT INTO `pais` (`idPais`, `nombrePais`) VALUES
(1, 'México'),
(2, 'España');

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
-- Estructura Stand-in para la vista `vista_recomendacion`
-- (Véase abajo para la vista actual)
--
CREATE TABLE `vista_recomendacion` (
`id` int(11)
,`nombrePais` varchar(50)
,`nombreEstado` varchar(50)
,`nombreMunicipio` varchar(50)
,`idAtraccion` int(11)
,`nombreAtraccion` varchar(50)
,`path` varchar(500)
,`puntaje` decimal(53,4)
);

-- --------------------------------------------------------

--
-- Estructura para la vista `vista_atraccion`
--
DROP TABLE IF EXISTS `vista_atraccion`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `vista_atraccion`  AS  select `imagen`.`id` AS `id`,`atraccion`.`nombreAtraccion` AS `nombreAtraccion`,`atraccion`.`descripcion` AS `descripcion`,`atraccion`.`direccion` AS `direccion`,`imagen`.`path` AS `path` from ((`municipio` join `atraccion` on((`municipio`.`idMunicipio` = `atraccion`.`idMunicipio`))) join `imagen` on((`imagen`.`idAtraccion` = `atraccion`.`idAtraccion`))) ;

-- --------------------------------------------------------

--
-- Estructura para la vista `vista_recomendacion`
--
DROP TABLE IF EXISTS `vista_recomendacion`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `vista_recomendacion`  AS  select `imagen`.`id` AS `id`,`pais`.`nombrePais` AS `nombrePais`,`estado`.`nombreEstado` AS `nombreEstado`,`municipio`.`nombreMunicipio` AS `nombreMunicipio`,`atraccion`.`idAtraccion` AS `idAtraccion`,`atraccion`.`nombreAtraccion` AS `nombreAtraccion`,`imagen`.`path` AS `path`,avg(`calificacion`.`puntaje`) AS `puntaje` from (((((`atraccion` join `imagen` on((`atraccion`.`idAtraccion` = `imagen`.`idAtraccion`))) join `calificacion` on((`calificacion`.`nombreAtraccion` = `atraccion`.`nombreAtraccion`))) join `municipio` on((`atraccion`.`idMunicipio` = `municipio`.`idMunicipio`))) join `estado` on((`estado`.`idEstado` = `municipio`.`idEstado`))) join `pais` on((`estado`.`idPais` = `pais`.`idPais`))) group by `atraccion`.`nombreAtraccion` having (avg(`calificacion`.`puntaje`) > 3) ;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `atraccion`
--
ALTER TABLE `atraccion`
  ADD PRIMARY KEY (`idAtraccion`);

--
-- Indices de la tabla `calificacion`
--
ALTER TABLE `calificacion`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `estado`
--
ALTER TABLE `estado`
  ADD PRIMARY KEY (`idEstado`);

--
-- Indices de la tabla `imagen`
--
ALTER TABLE `imagen`
  ADD UNIQUE KEY `id` (`id`);

--
-- Indices de la tabla `municipio`
--
ALTER TABLE `municipio`
  ADD PRIMARY KEY (`idMunicipio`);

--
-- Indices de la tabla `pais`
--
ALTER TABLE `pais`
  ADD PRIMARY KEY (`idPais`);

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
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=33;
--
-- AUTO_INCREMENT de la tabla `estado`
--
ALTER TABLE `estado`
  MODIFY `idEstado` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT de la tabla `imagen`
--
ALTER TABLE `imagen`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT de la tabla `municipio`
--
ALTER TABLE `municipio`
  MODIFY `idMunicipio` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT de la tabla `pais`
--
ALTER TABLE `pais`
  MODIFY `idPais` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
