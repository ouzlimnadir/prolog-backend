package com.fsa.ProLog.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PointRelais implements Serializable {

    @Id
    @GeneratedValue
    private Integer id;
    private String ville;
    private String adresse;

}
