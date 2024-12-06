package TODO_exe.Liste.controller;

import TODO_exe.Liste.dao.TacheDao;
import TODO_exe.Liste.dao.UtilisateurDao;
import TODO_exe.Liste.model.Tache;
import TODO_exe.Liste.model.Utilisateur;
import TODO_exe.Liste.security.AppUserDetails;
import TODO_exe.Liste.security.IsAdmin;
import TODO_exe.Liste.security.IsRedacteur;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
public class TacheController {

    @Autowired
    private TacheDao tacheDao;

    @IsAdmin
    @IsRedacteur
    @PostMapping("/tache")
    public ResponseEntity<Tache> create(@RequestBody @Valid Tache tache) {

        tache.setId(null);

        tache.setDescription(tache.getDescription());
        tache.setNom(tache.getNom());
        tache.setPriorite(tache.getPriorite());
        tache.setValide(false);
        tache.setCreateur(tache.getCreateur());

        tacheDao.save(tache);

        return new ResponseEntity<>(tache, HttpStatus.CREATED);

    }

    @IsAdmin
    @IsRedacteur
    @PutMapping ("/tache/{id}")
    public ResponseEntity<Tache> update(@PathVariable Integer id, @AuthenticationPrincipal AppUserDetails utilisateurConnecte, @RequestBody @Valid Tache tache) {

        tache.setId(id);

        Optional<Tache> optionalTache = tacheDao.findById(id);

        if (optionalTache.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        Tache tacheExistante = optionalTache.get();

        boolean isAdmin = utilisateurConnecte.getAuthorities().stream().anyMatch(auth -> auth.getAuthority().equals("ROLE_ADMINISTRATEUR"));

        boolean isCreator = tacheExistante.getCreateur().getId().equals(utilisateurConnecte.getUtilisateur().getId());

        if (!isAdmin && !isCreator) {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }

        tacheExistante.setNom(tache.getNom());
        tacheExistante.setDescription(tache.getDescription());
        tacheExistante.setPriorite(tache.getPriorite());
        tacheExistante.setValide(tache.getValide());

        tacheDao.save(tacheExistante);

        return new ResponseEntity<>(tacheExistante, HttpStatus.OK);

    }

    @GetMapping("/tache")
    public List<Tache> getAll() {

        return tacheDao.findAll();

    }
    @GetMapping("/tache/{id}")
    public ResponseEntity<Tache> getById(@PathVariable Integer id) {

        Optional<Tache> optionalTache = tacheDao.findById(id);

        if (optionalTache.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(optionalTache.get(),HttpStatus.OK);

    }


}
