package TODO_exe.Liste.dao;

import TODO_exe.Liste.model.Tache;
import TODO_exe.Liste.model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UtilisateurDao extends JpaRepository<Utilisateur, Integer> {

    @Query("SELECT t FROM Tache t JOIN t.utilisateurs u WHERE u.id = :userId ORDER BY t.priorite.id")
    Optional<List<Tache>> trouverTachesAssociees(@Param("userId") Integer id);

    @Query("SELECT t FROM Tache t JOIN t.utilisateurs u WHERE u.id = :userId AND t.valide = false ORDER BY t.priorite.id")
    Optional<List<Tache>> trouverTachesAssocieesNonValide(@Param("userId") Integer id);

    @Query("SELECT u FROM Utilisateur u WHERE u.pseudo = :pseudo")
    Optional<Utilisateur> trouverParPseudo(@Param("pseudo") String pseudo);

}
