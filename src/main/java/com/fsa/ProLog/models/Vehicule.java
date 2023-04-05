package com.fsa.ProLog.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.Date;

@Entity
@Data
public class Vehicule {
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
}
