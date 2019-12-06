-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Tempo de geração: 07/11/2019 às 01:42
-- Versão do servidor: 5.6.41-84.1
-- Versão do PHP: 7.2.7

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `dyotec69_SistemaLocadora`
--

-- --------------------------------------------------------

--
-- Estrutura para tabela `usuario`
--

CREATE TABLE `usuario` (
  `id` int(11) NOT NULL,
  `nomeUsuario` varchar(15) DEFAULT NULL,
  `senha` varchar(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Fazendo dump de dados para tabela `usuario`
--

INSERT INTO `usuario` (`id`, `nomeUsuario`, `senha`) VALUES
(1, 'matheus', '123'),
(2, 'adps', '123'),
(3, 'silny', '123'),
(4, 'maria ', '123'),
(5, 'ismair', '123'),
(6, 'master', '123'),
(7, 'maria', '123'),
(8, 'marcos', '123'),
(9, 'andre', '123');

-- --------------------------------------------------------

--
-- Estrutura para tabela `veiculos`
--

CREATE TABLE `veiculos` (
  `marca` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `modelo` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `cor` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `ano` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `potencia` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `placa` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `combustivel` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `disponibilidade` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `id` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Fazendo dump de dados para tabela `veiculos`
--

INSERT INTO `veiculos` (`marca`, `modelo`, `cor`, `ano`, `potencia`, `placa`, `combustivel`, `disponibilidade`, `id`) VALUES
('VW', 'GOL G6', '2015', 'BRANCO', 'FLEX', '1,6', 'ONB-1568', 'DISPONIVEL', 1),
('VW', 'GOL G7', 'PRATA', '2018', '1,6', 'OPB-1588', 'FLEX', 'DISPONIVEL', 2),
('VW', 'GOL G6', 'BRANCO', '2015', '1,6', 'ONB-1568', 'FLEX', 'DISPONIVEL', 3),
('VW', 'GOL G7', 'PRATA', '2017', 'OPB-1588', 'FLEX', '1,6', 'DISPONIVEL', 4),
('VW', 'GOL G6', 'BRANCO', '2015', '1,6', 'ONB-1568', 'FLEX', 'DISPONIVEL', 5),
('VW', 'GOL G7', 'PRATA', '2018', '1,6', 'OPB-1588', 'FLEX', 'DISPONIVEL', 6),
('VW', 'GOL G6', 'BRANCO', '2015', '1,6', 'ONB-1568', 'FLEX', 'DISPONIVEL', 7),
('VW', 'GOL G7', '2018', 'PRATA', 'FLEX', '1,6', 'OPB-1588', 'DISPONIVEL', 8),
('VW', 'GOL G6', 'BRANCO', '2015', '1,6', 'ONB-1568', 'FLEX', 'DISPONIVEL', 9),
('VW', 'GOL G7', 'PRATA', '2018', '1,6', 'OPB-1588', 'FLEX', 'DISPONIVEL', 10),
('VW', 'GOL G6', 'BRANCO', '2015', '1,6', 'ONB-1568', 'FLEX', 'DISPONIVEL', 11),
('VW', 'GOL G7', 'PRATA', '2018', '1,6', 'OPB-1588', 'FLEX', 'DISPONIVEL', 12),
('VW', 'GOL G6', 'BRANCO', '2015', '1,6', 'ONB-1568', 'FLEX', 'DISPONIVEL', 13),
('VW', 'GOL G7', 'PRATA', '2018', '1,6', 'OPB-1588', 'FLEX', 'DISPONIVEL', 14),
('VW', 'GOL G6', 'BRANCO', '2015', '1,6', 'ONB-1568', 'FLEX', 'DISPONIVEL', 15),
('VW', 'GOL G7', 'PRATA', '2018', '1,6', 'OPB-1588', 'FLEX', 'DISPONIVEL', 16),
('VW', 'GOL G6', 'BRANCO', '2015', '1,6', 'ONB-1568', 'FLEX', 'DISPONIVEL', 17),
('VW', 'GOL G7', 'PRATA', '2018', '1,6', 'OPB-1588', 'FLEX', 'DISPONIVEL', 18),
('VW', 'GOL G6', 'BRANCO', '2015', '1,6', 'ONB-1568', 'FLEX', 'DISPONIVEL', 19),
('VW', 'GOL G7', 'PRATA', '2018', '1,6', 'OPB-1588', 'FLEX', 'DISPONIVEL', 20),
('VW', 'GOL G6', 'BRANCO', '2015', '1,6', 'ONB-1568', 'FLEX', 'DISPONIVEL', 21),
('VW', 'GOL G7', 'PRATA', '2018', '1,6', 'OPB-1588', 'FLEX', 'DISPONIVEL', 22),
('VW', 'GOL G6', 'BRANCO', '2015', '1,6', 'ONB-1568', 'FLEX', 'DISPONIVEL', 23),
('VW', 'GOL G7', 'PRATA', '2018', '1,6', 'OPB-1588', 'FLEX', 'DISPONIVEL', 24),
('VW', 'GOL G6', 'BRANCO', '2015', '1,6', 'ONB-1568', 'FLEX', 'DISPONIVEL', 25),
('VW', 'GOL G7', 'PRATA', '2018', '1,6', 'OPB-1588', 'FLEX', 'DISPONIVEL', 26),
('VW', 'GOL G6', 'BRANCO', '2015', '1,6', 'ONB-1568', 'FLEX', 'DISPONIVEL', 27),
('VW', 'GOL G7', 'PRATA', '2018', '1,6', 'OPB-1588', 'FLEX', 'DISPONIVEL', 28),
('VW', 'GOL G6', 'BRANCO', '2015', '1,6', 'ONB-1568', 'FLEX', 'DISPONIVEL', 29),
('VW', 'GOL G7', 'PRATA', '2018', '1,6', 'OPB-1588', 'FLEX', 'DISPONIVEL', 30),
('VW', 'GOL G6', 'BRANCO', '2015', '1,6', 'ONB-1568', 'FLEX', 'DISPONIVEL', 31),
('VW', 'GOL G7', 'PRATA', '2018', '1,6', 'OPB-1588', 'FLEX', 'DISPONIVEL', 32);

--
-- Índices de tabelas apagadas
--

--
-- Índices de tabela `veiculos`
--
ALTER TABLE `veiculos`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de tabelas apagadas
--

--
-- AUTO_INCREMENT de tabela `veiculos`
--
ALTER TABLE `veiculos`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=33;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
