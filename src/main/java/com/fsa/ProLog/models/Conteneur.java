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

    @OneToOne
    private User driver;

    @OneToMany
    private List<Colis> packages;
}