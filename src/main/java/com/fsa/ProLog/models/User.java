package com.fsa.ProLog.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="user")
@Data
public class User implements Serializable {

    @Id
    @GeneratedValue
    @Column(updatable = false)
    private Integer id;

    @Column(unique = true)
    private String username;

    @OneToMany(mappedBy = "client",cascade = CascadeType.ALL)
    private List<FactureColis> facturesColis;

    @OneToMany(mappedBy = "client",cascade = CascadeType.ALL)
    private List<FactureVehicule> facturesVehiculesClient;

    @OneToMany(mappedBy = "chauffeur",cascade = CascadeType.ALL)
    private List<FactureVehicule> facturesVehiculesChauffeur;

    @Column(unique = true)
    private String password;

    private String email;

    private String telephone;

    private Role role;
}
