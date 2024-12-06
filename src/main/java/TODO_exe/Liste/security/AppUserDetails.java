package TODO_exe.Liste.security;

import TODO_exe.Liste.model.Utilisateur;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

public class AppUserDetails implements UserDetails {

    private Utilisateur utilisateur;

    public AppUserDetails(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        int droit = utilisateur.getDroit();
        switch (droit) {
            case 1:
                return List.of(new SimpleGrantedAuthority("ROLE_EMPLOYE"));
            case 2:
                return List.of(new SimpleGrantedAuthority("ROLE_REDACTEUR"));
            case 3:
                return List.of(new SimpleGrantedAuthority("ROLE_ADMINISTRATEUR"));
            default:
                return List.of(new SimpleGrantedAuthority("ROLE_EMPLOYE"));
        }

    }

    @Override
    public String getPassword() {
        return utilisateur.getPassword();
    }

    @Override
    public String getUsername() {
        return utilisateur.getPseudo();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
