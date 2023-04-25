package com.fsa.ProLog.models;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Entity
@Data
public class Colis implements Serializable {
    @Id
    @GeneratedValue
    @Column(updatable = false)
    private Integer id;
    private Integer poids;

    // Volume
    private Integer longueur;
    private Integer largeur;
    private Integer hauteur;

    //
    private Boolean froid;
    private Boolean fragile;

    private String adresse;
//    @SequenceGenerator(
//            name = "traking_number_seq",
//            sequenceName = "traking_number_seq",
//            initialValue = 25643,
//            allocationSize = 1
//    )
    //@GeneratedValue//(strategy = GenerationType.SEQUENCE, generator = "traking_number_seq")
    // TODO class tracking
    @Column(unique = true)
    private Integer trackingNumber;

    // Les clefs etrangeres
    @OneToOne(mappedBy ="colis",cascade = CascadeType.ALL)
    private FactureColis factureColis;

    @OneToOne
    private Destinataire destinataire;
}
