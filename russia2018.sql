-- phpMyAdmin SQL Dump
-- version 4.5.5.1
-- http://www.phpmyadmin.net
--
-- Client :  127.0.0.1
-- Généré le :  Mar 13 Février 2018 à 01:14
-- Version du serveur :  5.7.11
-- Version de PHP :  5.6.19

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `russia2018`
--

-- --------------------------------------------------------

--
-- Structure de la table `administrateur`
--

CREATE TABLE `administrateur` (
  `ID_ADMIN` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `administrateur`
--

INSERT INTO `administrateur` (`ID_ADMIN`) VALUES
(1);

-- --------------------------------------------------------

--
-- Structure de la table `administrer`
--

CREATE TABLE `administrer` (
  `ID_EQUIPE` int(11) NOT NULL,
  `ID_ADMIN` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `chambre`
--

CREATE TABLE `chambre` (
  `ID_chambre` int(11) NOT NULL,
  `ID_hotel` int(11) NOT NULL,
  `fumeur` int(11) NOT NULL,
  `handicape` int(11) NOT NULL,
  `option` varchar(20) NOT NULL,
  `type` varchar(20) NOT NULL,
  `numero` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `cooperation`
--

CREATE TABLE `cooperation` (
  `ID_COOPERATION` int(11) NOT NULL,
  `ID_ADMIN` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `cooperation`
--

INSERT INTO `cooperation` (`ID_COOPERATION`, `ID_ADMIN`) VALUES
(1, 1);

-- --------------------------------------------------------

--
-- Structure de la table `equipe`
--

CREATE TABLE `equipe` (
  `ID_EQUIPE` int(11) NOT NULL,
  `ID_PRONOSTIC` int(11) NOT NULL,
  `ID_JOUEUR` int(11) NOT NULL,
  `ID_STAFF` int(11) NOT NULL,
  `NOM_EQUIPE` varchar(20) DEFAULT NULL,
  `LOGO` longblob,
  `PAYS` varchar(20) DEFAULT NULL,
  `CLASSEMENT` longblob
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `follow_up`
--

CREATE TABLE `follow_up` (
  `ID_FOLLOWUP` int(11) NOT NULL,
  `DATE_FOLLOW` date DEFAULT NULL,
  `STATUT_FOLLOW` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `follow_up`
--

INSERT INTO `follow_up` (`ID_FOLLOWUP`, `DATE_FOLLOW`, `STATUT_FOLLOW`) VALUES
(1, '2018-02-09', '0'),
(2, '2018-02-13', '0');

-- --------------------------------------------------------

--
-- Structure de la table `gerer`
--

CREATE TABLE `gerer` (
  `ID_MATCH` int(11) NOT NULL,
  `ID_ADMIN` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `hotel`
--

CREATE TABLE `hotel` (
  `ID_HOTEL` int(11) NOT NULL,
  `NOM_HOTEL` varchar(20) DEFAULT NULL,
  `ID_chambre` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `joueur`
--

CREATE TABLE `joueur` (
  `ID_JOUEUR` int(11) NOT NULL,
  `NOM_J` varchar(20) DEFAULT NULL,
  `PRENOM_J` varchar(20) DEFAULT NULL,
  `NUMERO_J` varchar(20) DEFAULT NULL,
  `AGE_J` int(11) DEFAULT NULL,
  `EMPLACEMENT_J` varchar(20) DEFAULT NULL,
  `ETAT_J` varchar(20) DEFAULT NULL,
  `APPRECIATION_J` varchar(20) DEFAULT NULL,
  `NATIONALITE_J` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `match`
--

CREATE TABLE `match` (
  `id_match` int(11) NOT NULL,
  `ID_EQUIPE` int(11) NOT NULL,
  `date_match` date NOT NULL,
  `stade` varchar(20) NOT NULL,
  `nbr_ticket` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `news`
--

CREATE TABLE `news` (
  `ID_NEWS` int(11) NOT NULL,
  `ID_COOPERATION` int(11) NOT NULL,
  `TITRE_N` varchar(20) DEFAULT NULL,
  `TYPE_N` varchar(20) DEFAULT NULL,
  `MOT_CLES` varchar(20) DEFAULT NULL,
  `TEXTE_N` varchar(20) DEFAULT NULL,
  `IMAGE_N` longblob
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `news`
--

INSERT INTO `news` (`ID_NEWS`, `ID_COOPERATION`, `TITRE_N`, `TYPE_N`, `MOT_CLES`, `TEXTE_N`, `IMAGE_N`) VALUES
(1, 1, 'azdaz', 'dazd', 'dazd', 'azdazd', NULL),
(2, 1, 'aaaa', 'aaaa', 'aaaa', 'aaaa', 0x61616161),
(3, 1, 'aaaa', 'aaaa', 'aaaa', 'aaaa', 0x61616161),
(4, 1, 'aaaa', 'aaaa', 'aaaa', 'aaaa', 0x61616161),
(5, 1, 'aaaa', 'aaaa', 'aaaa', 'aaaa', 0x61616161),
(6, 1, 'aaaa', 'aaaa', 'aaaa', 'aaaa', 0x61616161),
(7, 1, 'aaaa', 'aaaa', 'aaaa', 'aaaa', 0x61616161),
(8, 1, 'aaaa', 'aaaa', 'aaaa', 'aaaa', 0x61616161),
(9, 1, 'aaaa', 'aaaa', 'aaaa', 'aaaa', 0x61616161),
(10, 1, 'aaaa', 'aaaa', 'aaaa', 'aaaa', 0x61616161),
(11, 1, 'aaaa', 'aaaa', 'aaaa', 'aaaa', 0x61616161),
(12, 1, 'aaaa', 'aaaa', 'aaaa', 'aaaa', 0x61616161),
(13, 1, 'aaaa', 'aaaa', 'aaaa', 'aaaa', 0x61616161),
(14, 1, 'aaaa', 'aaaa', 'aaaa', 'aaaa', 0x61616161),
(15, 1, 'aaaa', 'aaaa', 'aaaa', 'aaaa', 0x61616161),
(16, 1, 'aaaa', 'aaaa', 'aaaa', 'aaaa', 0x61616161),
(18, 1, 'aaaa', 'aaaa', 'aaaa', 'aaaa', 0x61616161),
(19, 1, 'aaaa', 'aaaa', 'aaaa', 'aaaa', 0x61616161),
(20, 1, 'aaaa', 'aaaa', 'aaaa', 'aaaa', 0x61616161),
(21, 1, 'aaaa', 'aaaa', 'aaaa', 'aaaa', 0x61616161),
(22, 1, 'aaaa', 'aaaa', 'aaaa', 'aaaa', 0x61616161),
(23, 1, 'aaaa', 'aaaa', 'aaaa', 'aaaa', 0x61616161),
(24, 1, 'aaaa', 'aaaa', 'aaaa', 'aaaa', 0x61616161),
(25, 1, 'aaaa', 'aaaa', 'aaaa', 'aaaa', 0x61616161),
(26, 1, 'aaaa', 'aaaa', 'aaaa', 'aaaa', 0x61616161),
(27, 1, 'aaaa', 'aaaa', 'aaaa', 'aaaa', 0x61616161),
(28, 1, 'aaaa', 'aaaa', 'aaaa', 'aaaa', 0x61616161),
(29, 1, 'aaaa', 'aaaa', 'aaaa', 'aaaa', 0x61616161),
(30, 1, 'aaaa', 'aaaa', 'aaaa', 'aaaa', 0x61616161),
(31, 1, 'aaaa', 'aaaa', 'aaaa', 'aaaa', 0x61616161),
(32, 1, 'aaaa', 'aaaa', 'aaaa', 'aaaa', 0x61616161),
(33, 1, 'aaaa', 'aaaa', 'aaaa', 'aaaa', 0x61616161),
(34, 1, 'aaaa', 'aaaa', 'aaaa', 'aaaa', 0x61616161),
(35, 1, 'aaaa', 'aaaa', 'aaaa', 'aaaa', 0x61616161),
(36, 1, 'aaaa', 'aaaa', 'aaaa', 'aaaa', 0x61616161),
(37, 1, 'aaaa', 'aaaa', 'aaaa', 'aaaa', 0x61616161),
(38, 1, 'aaaa', 'aaaa', 'aaaa', 'aaaa', 0x61616161),
(39, 1, 'aaaa', 'aaaa', 'aaaa', 'aaaa', 0x61616161),
(40, 1, 'aaaa', 'aaaa', 'aaaa', 'aaaa', 0x61616161),
(41, 1, 'aaaa', 'aaaa', 'aaaa', 'aaaa', 0x61616161),
(42, 1, 'aaaa', 'aaaa', 'aaaa', 'aaaa', 0x61616161),
(43, 1, 'aaaa', 'aaaa', 'aaaa', 'aaaa', 0x61616161),
(44, 1, 'aaaa', 'aaaa', 'aaaa', 'aaaa', 0x61616161),
(45, 1, 'aaaa', 'aaaa', 'aaaa', 'aaaa', 0x61616161),
(46, 1, 'aaaa', 'aaaa', 'aaaa', 'aaaa', 0x61616161),
(47, 1, 'aaaa', 'aaaa', 'aaaa', 'aaaa', 0x61616161),
(48, 1, 'aaaa', 'aaaa', 'aaaa', 'aaaa', 0x61616161),
(49, 1, 'aaaa', 'aaaa', 'aaaa', 'aaaa', 0x61616161),
(50, 1, 'aaaa', 'aaaa', 'bbbbbbbbbbbbbbbb', 'adazdazdazdazd', 0x61616161),
(51, 1, 'aaaa', 'aaaa', 'bbbbbbbbbbbbbbbb', 'adazdazdazdazd', 0x61616161),
(52, 1, 'aaaa', 'aaaa', 'bbbbbbbbbbbbbbbb', 'adazdazdazdazd', 0x61616161),
(53, 1, 'aaaa', 'aaaa', 'bbbbbbbbbbbbbbbb', 'adazdazdazdazd', 0x61616161);

-- --------------------------------------------------------

--
-- Structure de la table `pronostic`
--

CREATE TABLE `pronostic` (
  `ID_PRONOSTIC` int(11) NOT NULL,
  `ID_UTILISATEUR` int(11) NOT NULL,
  `ID_MATCH` int(11) NOT NULL,
  `CHOIX_EQUIPE` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `reclamation`
--

CREATE TABLE `reclamation` (
  `ID_RECLAMATION` int(11) NOT NULL,
  `ID_FOLLOWUP` int(11) DEFAULT NULL,
  `ID_UTILISATEUR` int(11) NOT NULL,
  `SUJET_REC` varchar(20) DEFAULT NULL,
  `DESCRIPTION_REC` varchar(20) DEFAULT NULL,
  `DATE_REC` varchar(20) DEFAULT NULL,
  `ETAT_REC` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `reclamation`
--

INSERT INTO `reclamation` (`ID_RECLAMATION`, `ID_FOLLOWUP`, `ID_UTILISATEUR`, `SUJET_REC`, `DESCRIPTION_REC`, `DATE_REC`, `ETAT_REC`) VALUES
(2, 1, 1, 'aaaa', 'aaaa', 'aaaa', 'aaaa'),
(3, 1, 1, 'aaaa', 'aaaa', 'aaaa', 'aaaa');

-- --------------------------------------------------------

--
-- Structure de la table `reservation`
--

CREATE TABLE `reservation` (
  `ID_RESERVATION` int(11) NOT NULL,
  `ID_HOTEL` int(11) DEFAULT NULL,
  `ID_TRANSPORT` int(11) DEFAULT NULL,
  `ID_UTILISATEUR` int(11) DEFAULT NULL,
  `DATE_RESERVATION` date DEFAULT NULL,
  `DATE_ARRIVEE` date DEFAULT NULL,
  `DATE_DEPART` date DEFAULT NULL,
  `HEURE_ARRIVEE` time DEFAULT NULL,
  `NB_NUIT` int(11) DEFAULT NULL,
  `mode_paiement` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `reservation`
--

INSERT INTO `reservation` (`ID_RESERVATION`, `ID_HOTEL`, `ID_TRANSPORT`, `ID_UTILISATEUR`, `DATE_RESERVATION`, `DATE_ARRIVEE`, `DATE_DEPART`, `HEURE_ARRIVEE`, `NB_NUIT`, `mode_paiement`) VALUES
(4, NULL, NULL, NULL, '2020-05-10', '2020-02-08', '2020-01-04', '00:00:17', 3, 'carte'),
(5, NULL, NULL, NULL, '2020-05-10', '2020-02-08', '2020-01-04', '00:00:17', 3, 'carte'),
(6, NULL, NULL, NULL, '2020-05-10', '2020-02-08', '2020-01-04', '00:00:17', 3, 'carte'),
(7, NULL, NULL, NULL, '2020-05-10', '2020-02-08', '2020-01-04', '00:00:17', 3, 'carte'),
(10, NULL, NULL, NULL, '2020-05-10', '2020-02-08', '2020-01-04', '00:00:17', 3, 'carte');

-- --------------------------------------------------------

--
-- Structure de la table `staff`
--

CREATE TABLE `staff` (
  `ID_STAFF` int(11) NOT NULL,
  `NOM_S` varchar(20) DEFAULT NULL,
  `PRENOM_S` varchar(20) DEFAULT NULL,
  `FONCTION_S` varchar(20) DEFAULT NULL,
  `PRESENCE_S` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `suivie`
--

CREATE TABLE `suivie` (
  `ID_STAFF` int(11) NOT NULL,
  `ID_FOLLOWUP` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `tickets`
--

CREATE TABLE `tickets` (
  `ID_TICKET` int(11) NOT NULL,
  `ID_MATCH` int(11) NOT NULL,
  `ID_UTILISATEUR` int(11) NOT NULL,
  `TYPE` varchar(20) DEFAULT NULL,
  `PRIX` float DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `transport`
--

CREATE TABLE `transport` (
  `ID_TRANSPORT` int(11) NOT NULL,
  `NUMERO_T` int(11) DEFAULT NULL,
  `TYPE_T` varchar(20) DEFAULT NULL,
  `MODE_PAIMENT` varchar(20) DEFAULT NULL,
  `NOM_T` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `transport`
--

INSERT INTO `transport` (`ID_TRANSPORT`, `NUMERO_T`, `TYPE_T`, `MODE_PAIMENT`, `NOM_T`) VALUES
(1, 10, 'type', ' mode_pay', 'nom');

-- --------------------------------------------------------

--
-- Structure de la table `utilisateur`
--

CREATE TABLE `utilisateur` (
  `ID_UTILISATEUR` int(11) NOT NULL,
  `PSEUDO_U` varchar(20) DEFAULT NULL,
  `MDP_U` varchar(20) DEFAULT NULL,
  `NOM_U` varchar(20) DEFAULT NULL,
  `PRENOM_U` varchar(20) DEFAULT NULL,
  `AGE_U` int(11) DEFAULT NULL,
  `NATIONAALITE_U` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `utilisateur`
--

INSERT INTO `utilisateur` (`ID_UTILISATEUR`, `PSEUDO_U`, `MDP_U`, `NOM_U`, `PRENOM_U`, `AGE_U`, `NATIONAALITE_U`) VALUES
(1, 'test', 'test', 'test', 'test', 111, 'test');

--
-- Index pour les tables exportées
--

--
-- Index pour la table `administrateur`
--
ALTER TABLE `administrateur`
  ADD PRIMARY KEY (`ID_ADMIN`);

--
-- Index pour la table `administrer`
--
ALTER TABLE `administrer`
  ADD PRIMARY KEY (`ID_EQUIPE`,`ID_ADMIN`),
  ADD KEY `FK_ADMINISTRER2` (`ID_ADMIN`);

--
-- Index pour la table `chambre`
--
ALTER TABLE `chambre`
  ADD PRIMARY KEY (`ID_chambre`),
  ADD KEY `ID_hotel` (`ID_hotel`);

--
-- Index pour la table `cooperation`
--
ALTER TABLE `cooperation`
  ADD PRIMARY KEY (`ID_COOPERATION`),
  ADD KEY `FK_AJOUTER` (`ID_ADMIN`);

--
-- Index pour la table `equipe`
--
ALTER TABLE `equipe`
  ADD PRIMARY KEY (`ID_EQUIPE`),
  ADD KEY `FK_COMPOSER` (`ID_JOUEUR`),
  ADD KEY `FK_JUGER` (`ID_PRONOSTIC`),
  ADD KEY `FK_MANIPULE` (`ID_STAFF`);

--
-- Index pour la table `follow_up`
--
ALTER TABLE `follow_up`
  ADD PRIMARY KEY (`ID_FOLLOWUP`);

--
-- Index pour la table `gerer`
--
ALTER TABLE `gerer`
  ADD PRIMARY KEY (`ID_MATCH`,`ID_ADMIN`),
  ADD KEY `FK_GERER2` (`ID_ADMIN`);

--
-- Index pour la table `hotel`
--
ALTER TABLE `hotel`
  ADD PRIMARY KEY (`ID_HOTEL`),
  ADD KEY `ID_chambre` (`ID_chambre`);

--
-- Index pour la table `joueur`
--
ALTER TABLE `joueur`
  ADD PRIMARY KEY (`ID_JOUEUR`);

--
-- Index pour la table `match`
--
ALTER TABLE `match`
  ADD PRIMARY KEY (`id_match`),
  ADD KEY `ID_EQUIPE` (`ID_EQUIPE`);

--
-- Index pour la table `news`
--
ALTER TABLE `news`
  ADD PRIMARY KEY (`ID_NEWS`),
  ADD KEY `FK_COOPERER` (`ID_COOPERATION`);

--
-- Index pour la table `pronostic`
--
ALTER TABLE `pronostic`
  ADD PRIMARY KEY (`ID_PRONOSTIC`),
  ADD KEY `FK_PREVOIR` (`ID_UTILISATEUR`);

--
-- Index pour la table `reclamation`
--
ALTER TABLE `reclamation`
  ADD PRIMARY KEY (`ID_RECLAMATION`),
  ADD KEY `FK_FAIRE` (`ID_UTILISATEUR`),
  ADD KEY `FK_SUIVRE` (`ID_FOLLOWUP`);

--
-- Index pour la table `reservation`
--
ALTER TABLE `reservation`
  ADD PRIMARY KEY (`ID_RESERVATION`),
  ADD KEY `FK_ACHETER` (`ID_TRANSPORT`),
  ADD KEY `FK_CHOISIR` (`ID_HOTEL`);

--
-- Index pour la table `staff`
--
ALTER TABLE `staff`
  ADD PRIMARY KEY (`ID_STAFF`);

--
-- Index pour la table `suivie`
--
ALTER TABLE `suivie`
  ADD PRIMARY KEY (`ID_STAFF`,`ID_FOLLOWUP`);

--
-- Index pour la table `tickets`
--
ALTER TABLE `tickets`
  ADD PRIMARY KEY (`ID_TICKET`);

--
-- Index pour la table `transport`
--
ALTER TABLE `transport`
  ADD PRIMARY KEY (`ID_TRANSPORT`);

--
-- Index pour la table `utilisateur`
--
ALTER TABLE `utilisateur`
  ADD PRIMARY KEY (`ID_UTILISATEUR`);

--
-- AUTO_INCREMENT pour les tables exportées
--

--
-- AUTO_INCREMENT pour la table `chambre`
--
ALTER TABLE `chambre`
  MODIFY `ID_chambre` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `follow_up`
--
ALTER TABLE `follow_up`
  MODIFY `ID_FOLLOWUP` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT pour la table `match`
--
ALTER TABLE `match`
  MODIFY `id_match` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `news`
--
ALTER TABLE `news`
  MODIFY `ID_NEWS` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=54;
--
-- AUTO_INCREMENT pour la table `reclamation`
--
ALTER TABLE `reclamation`
  MODIFY `ID_RECLAMATION` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT pour la table `reservation`
--
ALTER TABLE `reservation`
  MODIFY `ID_RESERVATION` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
--
-- AUTO_INCREMENT pour la table `transport`
--
ALTER TABLE `transport`
  MODIFY `ID_TRANSPORT` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `administrer`
--
ALTER TABLE `administrer`
  ADD CONSTRAINT `FK_ADMINISTRER` FOREIGN KEY (`ID_EQUIPE`) REFERENCES `equipe` (`ID_EQUIPE`),
  ADD CONSTRAINT `FK_ADMINISTRER2` FOREIGN KEY (`ID_ADMIN`) REFERENCES `administrateur` (`ID_ADMIN`);

--
-- Contraintes pour la table `chambre`
--
ALTER TABLE `chambre`
  ADD CONSTRAINT `chambre_ibfk_1` FOREIGN KEY (`ID_hotel`) REFERENCES `hotel` (`ID_HOTEL`);

--
-- Contraintes pour la table `cooperation`
--
ALTER TABLE `cooperation`
  ADD CONSTRAINT `FK_AJOUTER` FOREIGN KEY (`ID_ADMIN`) REFERENCES `administrateur` (`ID_ADMIN`);

--
-- Contraintes pour la table `equipe`
--
ALTER TABLE `equipe`
  ADD CONSTRAINT `FK_COMPOSER` FOREIGN KEY (`ID_JOUEUR`) REFERENCES `joueur` (`ID_JOUEUR`),
  ADD CONSTRAINT `FK_JUGER` FOREIGN KEY (`ID_PRONOSTIC`) REFERENCES `pronostic` (`ID_PRONOSTIC`),
  ADD CONSTRAINT `FK_MANIPULE` FOREIGN KEY (`ID_STAFF`) REFERENCES `staff` (`ID_STAFF`);

--
-- Contraintes pour la table `gerer`
--
ALTER TABLE `gerer`
  ADD CONSTRAINT `FK_GERER2` FOREIGN KEY (`ID_ADMIN`) REFERENCES `administrateur` (`ID_ADMIN`);

--
-- Contraintes pour la table `hotel`
--
ALTER TABLE `hotel`
  ADD CONSTRAINT `hotel_ibfk_1` FOREIGN KEY (`ID_chambre`) REFERENCES `chambre` (`ID_chambre`);

--
-- Contraintes pour la table `news`
--
ALTER TABLE `news`
  ADD CONSTRAINT `FK_COOPERER` FOREIGN KEY (`ID_COOPERATION`) REFERENCES `cooperation` (`ID_COOPERATION`);

--
-- Contraintes pour la table `pronostic`
--
ALTER TABLE `pronostic`
  ADD CONSTRAINT `FK_PREVOIR` FOREIGN KEY (`ID_UTILISATEUR`) REFERENCES `utilisateur` (`ID_UTILISATEUR`);

--
-- Contraintes pour la table `reclamation`
--
ALTER TABLE `reclamation`
  ADD CONSTRAINT `FK_FAIRE` FOREIGN KEY (`ID_UTILISATEUR`) REFERENCES `utilisateur` (`ID_UTILISATEUR`),
  ADD CONSTRAINT `fk_followup` FOREIGN KEY (`ID_FOLLOWUP`) REFERENCES `follow_up` (`ID_FOLLOWUP`);

--
-- Contraintes pour la table `reservation`
--
ALTER TABLE `reservation`
  ADD CONSTRAINT `FK_CHOISIR` FOREIGN KEY (`ID_HOTEL`) REFERENCES `hotel` (`ID_HOTEL`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
