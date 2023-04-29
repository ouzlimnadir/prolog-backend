package com.fsa.ProLog.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Tracking implements Serializable {
    @Id
    private String trackingNumber;

    @ManyToMany
    private List<PointRelais> pointsDeRelais;

    @ElementCollection
    private List<Date> dateChemin;

    @OneToOne(mappedBy = "trackingNumber")
    private Colis colis;

}
