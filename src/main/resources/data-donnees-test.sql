INSERT INTO priorite (id, nom) VALUES
    (1, 'Haute'),
    (2, 'Moyenne'),
    (3, 'Basse');

INSERT INTO droit (id, nom) VALUES
    (1, 'employe'),
    (2, 'redacteur'),
    (3, 'administrateur');

-- password = toto
INSERT INTO utilisateur (id, pseudo, password, droit_id) VALUES
    (1, 'admin', '$2a$10$ixb66SmcVv3Ep6wqImlS5.QLcWCQ7PXMhGz5syEUyaxu07uF8v2HO',3),
    (2, 'employe1', '$2a$10$ixb66SmcVv3Ep6wqImlS5.QLcWCQ7PXMhGz5syEUyaxu07uF8v2HO',1),
    (3, 'employe2', '$2a$10$ixb66SmcVv3Ep6wqImlS5.QLcWCQ7PXMhGz5syEUyaxu07uF8v2HO',1),
    (4, 'redacteur', '$2a$10$ixb66SmcVv3Ep6wqImlS5.QLcWCQ7PXMhGz5syEUyaxu07uF8v2HO',2);

INSERT INTO tache (id, description, nom, valide, priorite_id) VALUES
    (1, 'Préparer le rapport annuel', 'Rapport Annuel', FALSE, 1),
    (2, 'Mettre à jour le site web', 'Mise à jour site', FALSE, 2),
    (3, 'Organiser une réunion d\'équipe', 'Réunion équipe', TRUE, 3),
    (4, 'Corriger les bugs de l\'application', 'Correction bugs', FALSE, 1),
    (5, 'Créer un document marketing', 'Document Marketing', TRUE, 2);

INSERT INTO tache_utilisateurs (tache_id, utilisateurs_id) VALUES
    (1, 2), -- Tâche 1 assignée à l'employé 1
    (1, 3), -- Tâche 1 assignée à l'employé 2
    (2, 4), -- Tâche 2 assignée au rédacteur
    (3, 3), -- Tâche 3 assignée à l'employé 2
    (4, 2), -- Tâche 4 assignée à l'employé 1
    (5, 4); -- Tâche 5 assignée au rédacteur
