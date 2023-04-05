package com.fsa.ProLog.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class FactureVehicule {
    @Id
    @GeneratedValue
    private Integer id;

    @ManyToOne
    private User client;
}
