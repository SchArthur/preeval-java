package TODO_exe.Liste.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Utilisateur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @NotBlank(message = "Le pseudo ne peut pas être vide")
    String pseudo;

    @NotBlank(message = "Le mot de passe ne peut pas être vide")
    String password;

    @JsonView
    @ManyToOne
    Droit droit;

    @JsonIgnore
    @ManyToMany
    @JoinTable(
            name = "tache_utilisateurs",
            joinColumns = @JoinColumn(name = "utilisateurs_id"),
            inverseJoinColumns = @JoinColumn(name = "tache_id")
    )
    private List<Tache> tachesAssignees;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public @NotBlank(message = "Le pseudo ne peut pas être vide") String getPseudo() {
        return pseudo;
    }

    public void setPseudo(@NotBlank(message = "Le pseudo ne peut pas être vide") String pseudo) {
        this.pseudo = pseudo;
    }

    public @NotBlank(message = "Le mot de passe ne peut pas être vide") String getPassword() {
        return password;
    }

    public void setPassword(@NotBlank(message = "Le mot de passe ne peut pas être vide") String password) {
        this.password = password;
    }

    public List<Tache> getTachesAssignees() {
        return tachesAssignees;
    }

    public void setTachesAssignees(List<Tache> tachesAssignees) {
        this.tachesAssignees = tachesAssignees;
    }

    public Integer getDroit() {
        return droit.getId();
    }

    public void setDroit(Droit droit) {
        this.droit = droit;
    }
}
