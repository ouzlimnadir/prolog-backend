package com.fsa.ProLog.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Conteneur implements Serializable {
    @Id
    @GeneratedValue
    private Integer id;

    @Column(unique = true)
    private String ref;

    private String villeDepart;
    private String villeArrivee;

    @OneToOne
    private User driver;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Colis> colis;
}
