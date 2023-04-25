package com.fsa.ProLog.models;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Data
public class FactureColis implements Serializable {
    @Id
    @GeneratedValue
    @Column(updatable = false)
    private Integer id;


    private Double prix;
    private LocalDate date;

    @ManyToOne()
    private User client;

    @OneToOne
    private Colis colis;

}
