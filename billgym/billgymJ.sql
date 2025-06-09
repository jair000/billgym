-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 09-06-2025 a las 15:49:25
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `billgym`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `clientes`
--

CREATE TABLE `clientes` (
  `id` int(11) NOT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `apellidos` varchar(255) DEFAULT NULL,
  `dni` varchar(255) DEFAULT NULL,
  `edad` int(11) DEFAULT NULL,
  `telefono` varchar(255) DEFAULT NULL,
  `correo` varchar(255) DEFAULT NULL,
  `tiempo_suscripcion` varchar(255) DEFAULT NULL,
  `direccion` varchar(255) DEFAULT NULL,
  `id_sede` int(11) DEFAULT NULL,
  `fecha` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `compras`
--

CREATE TABLE `compras` (
  `id_compras` int(11) NOT NULL,
  `id_producto` int(11) DEFAULT NULL,
  `cantidad` int(11) NOT NULL,
  `precio_unitario` decimal(38,2) DEFAULT NULL,
  `fecha_compra` date DEFAULT NULL,
  `id_proveedor` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Disparadores `compras`
--
DELIMITER $$
CREATE TRIGGER `trg_aumentar_stock` AFTER INSERT ON `compras` FOR EACH ROW BEGIN
    UPDATE productos SET stock = stock + NEW.cantidad WHERE id_producto = NEW.id_producto;
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `login`
--

CREATE TABLE `login` (
  `id_loguin` int(11) NOT NULL,
  `id_usuario` int(11) NOT NULL,
  `usuario` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `login`
--

INSERT INTO `login` (`id_loguin`, `id_usuario`, `usuario`, `password`) VALUES
(1, 1, 'usuario1', 'contrasena123'),
(2, 2, 'lucia', 'passlucia123'),
(3, 3, 'carlos', 'passcarlos123'),
(4, 4, 'maria', 'passmaria123'),
(5, 5, 'fernando', 'passfernando123'),
(6, 6, 'andrea', 'passandrea123'),
(7, 7, 'javier', 'passjavier123'),
(8, 8, 'rosa', 'passrosa123'),
(9, 9, 'luis', 'passluis123'),
(10, 10, 'diana', 'passdiana123');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `maquinas`
--

CREATE TABLE `maquinas` (
  `id_maquinas` int(11) NOT NULL,
  `nombre` varchar(200) NOT NULL,
  `descripcion` text DEFAULT NULL,
  `marca` varchar(200) DEFAULT NULL,
  `modelo` varchar(200) DEFAULT NULL,
  `fecha_adqusicion` date DEFAULT NULL,
  `estado` varchar(150) DEFAULT NULL,
  `id_sede` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `productos`
--

CREATE TABLE `productos` (
  `id_producto` int(11) NOT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `descripcion` varchar(255) DEFAULT NULL,
  `precio_publico` decimal(38,2) DEFAULT NULL,
  `stock` int(11) NOT NULL,
  `fecha_vencimiento` date DEFAULT NULL,
  `precio_compra` decimal(38,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `proveedores`
--

CREATE TABLE `proveedores` (
  `id_proveedor` int(11) NOT NULL,
  `nombre` varchar(200) NOT NULL,
  `direccion` varchar(255) NOT NULL,
  `telefono` varchar(20) DEFAULT NULL,
  `correo` varchar(100) DEFAULT NULL,
  `ruc` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `registro_clientes`
--

CREATE TABLE `registro_clientes` (
  `id_registro` int(11) NOT NULL,
  `id_cliente` int(11) DEFAULT NULL,
  `id_usuario` int(11) DEFAULT NULL,
  `fecha_registro` datetime DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura Stand-in para la vista `reporte_financiero`
-- (Véase abajo para la vista actual)
--
CREATE TABLE `reporte_financiero` (
`fecha_reporte` date
,`ingresos` decimal(32,2)
,`costos_productos` decimal(65,2)
,`costos_salarios` decimal(64,6)
,`otros_costos` int(1)
,`ganancia_neta` decimal(65,6)
);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `sedes`
--

CREATE TABLE `sedes` (
  `id_sede` int(11) NOT NULL,
  `nombres` varchar(100) NOT NULL,
  `direccion` varchar(250) NOT NULL,
  `ciudad` varchar(100) NOT NULL,
  `telefono` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `sedes`
--

INSERT INTO `sedes` (`id_sede`, `nombres`, `direccion`, `ciudad`, `telefono`) VALUES
(1, 'Sede Central', 'Av. Los Próceres 123, San Borja', 'Lima', '987654321'),
(2, 'Sede San Isidro', 'Calle Los Sauces 200, San Isidro', 'Lima', '987111222'),
(3, 'Sede Miraflores', 'Av. Larco 321, Miraflores', 'Lima', '987222333'),
(4, 'Sede Surco', 'Jr. Los Álamos 450, Santiago de Surco', 'Lima', '987333444'),
(5, 'Sede La Molina', 'Av. La Universidad 789, La Molina', 'Lima', '987444555'),
(6, 'Sede Callao', 'Av. Faucett 1500, Callao', 'Callao', '987555666');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE `usuarios` (
  `id` int(11) NOT NULL,
  `nombres` varchar(255) DEFAULT NULL,
  `apellidos` varchar(255) DEFAULT NULL,
  `dni` varchar(255) DEFAULT NULL,
  `f_nacimiento` date DEFAULT NULL,
  `direccion` varchar(255) DEFAULT NULL,
  `telefono` varchar(255) DEFAULT NULL,
  `correo` varchar(255) DEFAULT NULL,
  `f_contratacion` date NOT NULL,
  `rol` enum('GERENTE_GENERAL','RECEPCIONISTA','ENTRENADOR','LIMPIEZA','SUPERVISOR') NOT NULL,
  `turno` varchar(255) DEFAULT NULL,
  `salario` decimal(38,2) DEFAULT NULL,
  `activo` tinyint(1) NOT NULL DEFAULT 1,
  `id_sede` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`id`, `nombres`, `apellidos`, `dni`, `f_nacimiento`, `direccion`, `telefono`, `correo`, `f_contratacion`, `rol`, `turno`, `salario`, `activo`, `id_sede`) VALUES
(1, 'Jairo', 'Perez', '7036214', '2004-06-12', 'Av. Lima 123', '999999999', 'jairo@example.com', '2025-06-09', 'GERENTE_GENERAL', 'Mañana', 3000.00, 1, 1),
(2, 'Lucía', 'Ramírez', '70836215', '1995-03-10', 'Av. Primavera 300', '900000001', 'lucia@example.com', '2025-06-09', 'RECEPCIONISTA', 'Mañana', 1500.00, 1, 2),
(3, 'Carlos', 'Gómez', '70836216', '1988-07-22', 'Jr. Las Flores 123', '900000002', 'carlos@example.com', '2025-06-09', 'ENTRENADOR', 'Tarde', 2200.00, 1, 3),
(4, 'María', 'Lopez', '70836217', '1992-05-14', 'Av. Javier Prado 456', '900000003', 'maria@example.com', '2025-06-09', 'LIMPIEZA', 'Mañana', 1200.00, 1, 2),
(5, 'Fernando', 'Ríos', '70836218', '1985-11-30', 'Calle El Sol 321', '900000004', 'fernando@example.com', '2025-06-09', 'SUPERVISOR', 'Noche', 2500.00, 1, 1),
(6, 'Andrea', 'Salazar', '70836219', '1990-09-09', 'Av. Caminos del Inca 500', '900000005', 'andrea@example.com', '2025-06-09', 'RECEPCIONISTA', 'Tarde', 1500.00, 1, 4),
(7, 'Javier', 'Huamán', '70836220', '1994-02-18', 'Jr. San Martín 400', '900000006', 'javier@example.com', '2025-06-09', 'ENTRENADOR', 'Mañana', 2100.00, 1, 5),
(8, 'Rosa', 'Quispe', '70836221', '1987-08-25', 'Calle Bolognesi 789', '900000007', 'rosa@example.com', '2025-06-09', 'LIMPIEZA', 'Tarde', 1250.00, 1, 3),
(9, 'Luis', 'Mendoza', '70836222', '1991-01-12', 'Av. La Marina 1234', '900000008', 'luis@example.com', '2025-06-09', 'SUPERVISOR', 'Mañana', 2600.00, 1, 4),
(10, 'Diana', 'Paredes', '70836223', '1993-06-06', 'Av. Colonial 567', '900000009', 'diana@example.com', '2025-06-09', 'RECEPCIONISTA', 'Noche', 1550.00, 1, 5);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ventas`
--

CREATE TABLE `ventas` (
  `id_venta` int(11) NOT NULL,
  `id_cliente` int(11) DEFAULT NULL,
  `id_producto` int(11) DEFAULT NULL,
  `cantidad` int(11) NOT NULL,
  `precio_unitario` decimal(10,2) NOT NULL,
  `fecha_venta` datetime DEFAULT current_timestamp(),
  `total_venta` decimal(10,2) NOT NULL,
  `id_usuario_vendedor` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Disparadores `ventas`
--
DELIMITER $$
CREATE TRIGGER `trg_disminuir_stock` BEFORE INSERT ON `ventas` FOR EACH ROW BEGIN
    DECLARE stock_actual INT;
    SELECT stock INTO stock_actual FROM productos WHERE id_producto = NEW.id_producto;

    IF stock_actual < NEW.cantidad THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Stock insuficiente para realizar la venta';
    ELSE
        UPDATE productos SET stock = stock - NEW.cantidad WHERE id_producto = NEW.id_producto;
    END IF;
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Estructura para la vista `reporte_financiero`
--
DROP TABLE IF EXISTS `reporte_financiero`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `reporte_financiero`  AS SELECT curdate() AS `fecha_reporte`, ifnull((select sum(`v`.`total_venta`) from `ventas` `v` where cast(`v`.`fecha_venta` as date) = curdate()),0) AS `ingresos`, ifnull((select sum(`c`.`cantidad` * `c`.`precio_unitario`) from `compras` `c` where cast(`c`.`fecha_compra` as date) = curdate()),0) AS `costos_productos`, ifnull((select sum(`u`.`salario` / 30) from `usuarios` `u` where `u`.`activo` = 1),0) AS `costos_salarios`, 0 AS `otros_costos`, ifnull((select sum(`v`.`total_venta`) from `ventas` `v` where cast(`v`.`fecha_venta` as date) = curdate()),0) - ifnull((select sum(`c`.`cantidad` * `c`.`precio_unitario`) from `compras` `c` where cast(`c`.`fecha_compra` as date) = curdate()),0) - ifnull((select sum(`u`.`salario` / 30) from `usuarios` `u` where `u`.`activo` = 1),0) AS `ganancia_neta` ;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `clientes`
--
ALTER TABLE `clientes`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `dni` (`dni`),
  ADD KEY `id_sede` (`id_sede`);

--
-- Indices de la tabla `compras`
--
ALTER TABLE `compras`
  ADD PRIMARY KEY (`id_compras`),
  ADD KEY `id_producto` (`id_producto`),
  ADD KEY `id_proveedor` (`id_proveedor`);

--
-- Indices de la tabla `login`
--
ALTER TABLE `login`
  ADD PRIMARY KEY (`id_loguin`),
  ADD KEY `id_usuario` (`id_usuario`);

--
-- Indices de la tabla `maquinas`
--
ALTER TABLE `maquinas`
  ADD PRIMARY KEY (`id_maquinas`),
  ADD KEY `id_sede` (`id_sede`);

--
-- Indices de la tabla `productos`
--
ALTER TABLE `productos`
  ADD PRIMARY KEY (`id_producto`);

--
-- Indices de la tabla `proveedores`
--
ALTER TABLE `proveedores`
  ADD PRIMARY KEY (`id_proveedor`),
  ADD UNIQUE KEY `ruc` (`ruc`);

--
-- Indices de la tabla `registro_clientes`
--
ALTER TABLE `registro_clientes`
  ADD PRIMARY KEY (`id_registro`),
  ADD KEY `id_cliente` (`id_cliente`),
  ADD KEY `id_usuario` (`id_usuario`);

--
-- Indices de la tabla `sedes`
--
ALTER TABLE `sedes`
  ADD PRIMARY KEY (`id_sede`);

--
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `dni` (`dni`),
  ADD KEY `id_sede` (`id_sede`);

--
-- Indices de la tabla `ventas`
--
ALTER TABLE `ventas`
  ADD PRIMARY KEY (`id_venta`),
  ADD KEY `id_cliente` (`id_cliente`),
  ADD KEY `id_producto` (`id_producto`),
  ADD KEY `id_usuario_vendedor` (`id_usuario_vendedor`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `clientes`
--
ALTER TABLE `clientes`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `compras`
--
ALTER TABLE `compras`
  MODIFY `id_compras` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `login`
--
ALTER TABLE `login`
  MODIFY `id_loguin` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT de la tabla `maquinas`
--
ALTER TABLE `maquinas`
  MODIFY `id_maquinas` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `productos`
--
ALTER TABLE `productos`
  MODIFY `id_producto` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `proveedores`
--
ALTER TABLE `proveedores`
  MODIFY `id_proveedor` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `registro_clientes`
--
ALTER TABLE `registro_clientes`
  MODIFY `id_registro` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `sedes`
--
ALTER TABLE `sedes`
  MODIFY `id_sede` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT de la tabla `ventas`
--
ALTER TABLE `ventas`
  MODIFY `id_venta` int(11) NOT NULL AUTO_INCREMENT;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `clientes`
--
ALTER TABLE `clientes`
  ADD CONSTRAINT `clientes_ibfk_1` FOREIGN KEY (`id_sede`) REFERENCES `sedes` (`id_sede`);

--
-- Filtros para la tabla `compras`
--
ALTER TABLE `compras`
  ADD CONSTRAINT `compras_ibfk_1` FOREIGN KEY (`id_producto`) REFERENCES `productos` (`id_producto`),
  ADD CONSTRAINT `compras_ibfk_2` FOREIGN KEY (`id_proveedor`) REFERENCES `proveedores` (`id_proveedor`);

--
-- Filtros para la tabla `login`
--
ALTER TABLE `login`
  ADD CONSTRAINT `login_ibfk_1` FOREIGN KEY (`id_usuario`) REFERENCES `usuarios` (`id`);

--
-- Filtros para la tabla `maquinas`
--
ALTER TABLE `maquinas`
  ADD CONSTRAINT `maquinas_ibfk_1` FOREIGN KEY (`id_sede`) REFERENCES `sedes` (`id_sede`);

--
-- Filtros para la tabla `registro_clientes`
--
ALTER TABLE `registro_clientes`
  ADD CONSTRAINT `registro_clientes_ibfk_1` FOREIGN KEY (`id_cliente`) REFERENCES `clientes` (`id`),
  ADD CONSTRAINT `registro_clientes_ibfk_2` FOREIGN KEY (`id_usuario`) REFERENCES `usuarios` (`id`);

--
-- Filtros para la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD CONSTRAINT `usuarios_ibfk_1` FOREIGN KEY (`id_sede`) REFERENCES `sedes` (`id_sede`);

--
-- Filtros para la tabla `ventas`
--
ALTER TABLE `ventas`
  ADD CONSTRAINT `ventas_ibfk_1` FOREIGN KEY (`id_cliente`) REFERENCES `clientes` (`id`),
  ADD CONSTRAINT `ventas_ibfk_2` FOREIGN KEY (`id_producto`) REFERENCES `productos` (`id_producto`),
  ADD CONSTRAINT `ventas_ibfk_3` FOREIGN KEY (`id_usuario_vendedor`) REFERENCES `usuarios` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
