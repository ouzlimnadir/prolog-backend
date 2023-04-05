package com.fsa.ProLog.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
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
    private Integer longueur;
    private Integer largeur;
    private Integer hauteur;
    private Boolean froid;
    private Boolean fragile;
    private Integer trackingNumber;
}
