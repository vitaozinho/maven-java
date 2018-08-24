-- phpMyAdmin SQL Dump
-- version 4.7.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: 24-Ago-2018 às 22:31
-- Versão do servidor: 5.7.17
-- PHP Version: 5.6.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `java-db`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `tb_editora`
--

CREATE TABLE `tb_editora` (
  `nrCNPJ` int(11) NOT NULL,
  `nmEditora` varchar(50) NOT NULL,
  `endEditora` varchar(100) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `tb_editora`
--

INSERT INTO `tb_editora` (`nrCNPJ`, `nmEditora`, `endEditora`) VALUES
(5585, 'eee', 'eee');

-- --------------------------------------------------------

--
-- Estrutura da tabela `tb_escritor`
--

CREATE TABLE `tb_escritor` (
  `nrCPF` int(11) NOT NULL,
  `nmEscritor` varchar(100) NOT NULL,
  `endEscritor` varchar(100) DEFAULT NULL,
  `nrCnpjEditora` int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `tb_escritor`
--

INSERT INTO `tb_escritor` (`nrCPF`, `nmEscritor`, `endEscritor`, `nrCnpjEditora`) VALUES
(333, 'vitor', 'camargo', 5585);

-- --------------------------------------------------------

--
-- Estrutura da tabela `tb_livros`
--

CREATE TABLE `tb_livros` (
  `cdLivro` int(11) NOT NULL,
  `nmLivro` varchar(50) DEFAULT NULL,
  `nrPag` int(11) DEFAULT NULL,
  `nrCnpjEditora` int(11) DEFAULT NULL,
  `nrCpfEscritor` int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `tb_livros`
--

INSERT INTO `tb_livros` (`cdLivro`, `nmLivro`, `nrPag`, `nrCnpjEditora`, `nrCpfEscritor`) VALUES
(1, 'hp', 500, 5585, 332);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tb_editora`
--
ALTER TABLE `tb_editora`
  ADD PRIMARY KEY (`nrCNPJ`);

--
-- Indexes for table `tb_escritor`
--
ALTER TABLE `tb_escritor`
  ADD PRIMARY KEY (`nrCPF`),
  ADD KEY `nrCnpjEditora` (`nrCnpjEditora`);

--
-- Indexes for table `tb_livros`
--
ALTER TABLE `tb_livros`
  ADD PRIMARY KEY (`cdLivro`),
  ADD KEY `nrCnpjEditora` (`nrCnpjEditora`),
  ADD KEY `nrCpfEscritor` (`nrCpfEscritor`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `tb_livros`
--
ALTER TABLE `tb_livros`
  MODIFY `cdLivro` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
