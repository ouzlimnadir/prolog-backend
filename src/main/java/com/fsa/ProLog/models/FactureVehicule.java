package com.fsa.ProLog.models;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Data
public class FactureVehicule implements Serializable {
    @Id
    @GeneratedValue
    private Integer id;

    private Double prix;
    private String start_point;
    private String arrived_point;
    private LocalDate date;

    @ManyToOne
    private User client;

    @ManyToOne
    private User chauffeur;

    @ManyToOne
    private Vehicule vehicule;

}
