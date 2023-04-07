package com.fsa.ProLog.models;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Entity
@Data
public class FactureVehicule implements Serializable {
    @Id
    @GeneratedValue
    private Integer id;

    @ManyToOne
    private User client;

    @OneToOne
    private Vehicule vehicule;

        /* TODO :
            Gestion des factures Vehicules
            Setup controllers
            Routage dto des repository
        */
}
