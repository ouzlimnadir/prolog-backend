package com.fsa.ProLog.models;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;


@Entity
@Data
public class Vehicule implements Serializable {
    @Id
    @GeneratedValue
    @Column(updatable = false)
    private Integer id;
    private String type;
    private Integer volume;
    private String immatriculation;
    private String marque;
    private LocalDate fin_assurance;
    private LocalDate fin_vignette;
    @OneToOne(mappedBy ="vehicule",cascade = CascadeType.ALL)
    private FactureVehicule factureVehicule;
}
