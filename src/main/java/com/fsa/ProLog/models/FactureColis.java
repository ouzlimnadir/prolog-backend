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
    private Integer id;

    private Date date;

    @ManyToOne()
    private User client;

    @OneToOne
    private Colis colis;
}
