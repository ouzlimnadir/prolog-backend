package com.fsa.ProLog.models;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

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
    private Date fin_assurance;
    private Date fin_vignette;
    @OneToOne(mappedBy ="vehicule",cascade = CascadeType.ALL)
    private FactureVehicule factureVehicule;
}
