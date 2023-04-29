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

    @Column(columnDefinition = "boolean default false")
    private Boolean delivered;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "tracking_number")
    private Tracking trackingNumber;

    // Les clefs etrangeres
    @OneToOne(mappedBy ="colis",cascade = CascadeType.ALL)
    private FactureColis factureColis;

    @OneToOne(cascade = CascadeType.ALL)
    private Destinataire destinataire;
}
