package TODO_exe.Liste.controller;

import TODO_exe.Liste.dao.TacheDao;
import TODO_exe.Liste.dao.UtilisateurDao;
import TODO_exe.Liste.model.Tache;
import TODO_exe.Liste.model.Utilisateur;
import TODO_exe.Liste.security.IsAdmin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
public class UtilisateurController {

    @Autowired
    private UtilisateurDao utilisateurDao;
    @Autowired
    private TacheDao tacheDao;

    @IsAdmin
    @GetMapping("/utilisateur/{id}")
    public ResponseEntity<Utilisateur> get(@PathVariable Integer id) {
        Optional<Utilisateur> optionalUtilisateur = utilisateurDao.findById(id);

        if (optionalUtilisateur.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(optionalUtilisateur.get(),HttpStatus.OK);
    }

    @GetMapping("/utilisateur/{id}/taches")
    public ResponseEntity<List<Tache>> getUserTaches(@PathVariable Integer id) {
        Optional<List<Tache>> optionalTaches = utilisateurDao.trouverTachesAssociees(id);

        if (optionalTaches.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(optionalTaches.get(),HttpStatus.OK);
    }

    @GetMapping("/utilisateur/{id}/taches_non_valide")
    public ResponseEntity<List<Tache>> getUserTachesNonValide(@PathVariable Integer id) {
        Optional<List<Tache>> optionalTaches = utilisateurDao.trouverTachesAssocieesNonValide(id);

        if (optionalTaches.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(optionalTaches.get(),HttpStatus.OK);
    }
}
