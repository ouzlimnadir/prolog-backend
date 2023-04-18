package com.fsa.ProLog.models;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name="user")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User implements Serializable, UserDetails {

    @Id
    @GeneratedValue
    @Column(updatable = false)
    private Integer id;

    private String fullname;

//    @Column(unique = true)
//    private String username;

    @OneToMany(mappedBy = "client",cascade = CascadeType.ALL)
    private List<FactureColis> facturesColis;

    @OneToMany(mappedBy = "client",cascade = CascadeType.ALL)
    private List<FactureVehicule> facturesVehiculesClient;

    @OneToMany(mappedBy = "chauffeur",cascade = CascadeType.ALL)
    private List<FactureVehicule> facturesVehiculesChauffeur;

    private String password;

    @Column(unique = true)
    private String email;

    private String telephone;

    @Enumerated(EnumType.STRING)
    private Role role;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }

    @Override
    public String getUsername() {
        return email;
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
