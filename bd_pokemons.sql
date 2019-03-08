-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost
-- Tiempo de generación: 08-03-2019 a las 13:34:28
-- Versión del servidor: 10.1.35-MariaDB
-- Versión de PHP: 7.2.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `bd_pokemons`
--
CREATE DATABASE IF NOT EXISTS `bd_pokemons` DEFAULT CHARACTER SET utf8 COLLATE utf8_spanish2_ci;
USE `bd_pokemons`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `entrenadores`
--

CREATE TABLE `entrenadores` (
  `nombre` varchar(20) COLLATE utf8_spanish2_ci NOT NULL,
  `tipo` varchar(20) COLLATE utf8_spanish2_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

--
-- Volcado de datos para la tabla `entrenadores`
--

INSERT INTO `entrenadores` (`nombre`, `tipo`) VALUES
('Ash Ketchum', 'bueno'),
('Entrenador1', 'bueno'),
('Fran', 'malo'),
('Lidia', 'bueno'),
('Team Rocket', 'malo');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pokemons`
--

CREATE TABLE `pokemons` (
  `nombre` varchar(30) COLLATE utf8_spanish2_ci NOT NULL,
  `entrenador` varchar(20) COLLATE utf8_spanish2_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

--
-- Volcado de datos para la tabla `pokemons`
--

INSERT INTO `pokemons` (`nombre`, `entrenador`) VALUES
('Charizard', 'Ash Ketchum'),
('Charmander to chungo', 'Lidia'),
('Jigglypuff', 'Lidia'),
('Digglet', 'Fran'),
('Mew', 'Fran'),
('Mewtwo', 'Lidia'),
('Miauz', 'Team Rocket'),
('Koffing', 'Team Rocket'),
('Pikachu', 'Ash Ketchum'),
('Pokemon1', 'Entrenador1'),
('Pokemon2', 'Team Rocket');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `entrenadores`
--
ALTER TABLE `entrenadores`
  ADD PRIMARY KEY (`nombre`);

--
-- Indices de la tabla `pokemons`
--
ALTER TABLE `pokemons`
  ADD KEY `fk_entrenador` (`entrenador`);

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `pokemons`
--
ALTER TABLE `pokemons`
  ADD CONSTRAINT `fk_entrenador` FOREIGN KEY (`entrenador`) REFERENCES `entrenadores` (`nombre`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
