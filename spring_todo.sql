-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le : ven. 06 déc. 2024 à 10:34
-- Version du serveur : 8.3.0
-- Version de PHP : 8.3.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `spring_todo`
--

-- --------------------------------------------------------

--
-- Structure de la table `priorite`
--

DROP TABLE IF EXISTS `priorite`;
CREATE TABLE IF NOT EXISTS `priorite` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nom` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Structure de la table `tache`
--

DROP TABLE IF EXISTS `tache`;
CREATE TABLE IF NOT EXISTS `tache` (
  `createur_id` int DEFAULT NULL,
  `id` int NOT NULL AUTO_INCREMENT,
  `priorite_id` int DEFAULT NULL,
  `valide` bit(1) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `nom` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKoavdfyisqpuu5mbog6atmkpw6` (`createur_id`),
  KEY `FK6kk0kxs5jc5tecsvyyoues398` (`priorite_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Structure de la table `tache_utilisateurs`
--

DROP TABLE IF EXISTS `tache_utilisateurs`;
CREATE TABLE IF NOT EXISTS `tache_utilisateurs` (
  `tache_id` int NOT NULL,
  `utilisateurs_id` int NOT NULL,
  KEY `FK54hfa5vif297v5m14bdb3qnhu` (`utilisateurs_id`),
  KEY `FKqj6idrcrjvx85cc37b7rjreej` (`tache_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Structure de la table `utilisateur`
--

DROP TABLE IF EXISTS `utilisateur`;
CREATE TABLE IF NOT EXISTS `utilisateur` (
  `id` int NOT NULL AUTO_INCREMENT,
  `password` varchar(255) NOT NULL,
  `pseudo` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `tache`
--
ALTER TABLE `tache`
  ADD CONSTRAINT `FK6kk0kxs5jc5tecsvyyoues398` FOREIGN KEY (`priorite_id`) REFERENCES `priorite` (`id`),
  ADD CONSTRAINT `FKoavdfyisqpuu5mbog6atmkpw6` FOREIGN KEY (`createur_id`) REFERENCES `utilisateur` (`id`);

--
-- Contraintes pour la table `tache_utilisateurs`
--
ALTER TABLE `tache_utilisateurs`
  ADD CONSTRAINT `FK54hfa5vif297v5m14bdb3qnhu` FOREIGN KEY (`utilisateurs_id`) REFERENCES `utilisateur` (`id`),
  ADD CONSTRAINT `FKqj6idrcrjvx85cc37b7rjreej` FOREIGN KEY (`tache_id`) REFERENCES `tache` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
