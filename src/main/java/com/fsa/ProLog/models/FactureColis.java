package com.fsa.ProLog.models;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Entity
@Data
public class FactureColis implements Serializable {
    @Id
    @GeneratedValue
    @Column(updatable = false)
    private Integer id;


    private Double prix;
    private Date date;

    @ManyToOne()
    private User client;

    @OneToOne
    private Colis colis;

}
