package com.fsa.ProLog.models;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Entity
@Data
public class User implements Serializable {

    @Id
    @GeneratedValue
    @Column(updatable = false)
    private Integer id;

    private String telephone;

    @OneToMany(mappedBy = "client",cascade = CascadeType.ALL)
    @JoinColumn(name="client_id")
    private List<FactureColis> facturesColis;

    @OneToMany(mappedBy = "client",cascade = CascadeType.ALL)
    @JoinColumn(name="client_id")
    private List<FactureVehicule> facturesVehicules;

    private Role role;
}
