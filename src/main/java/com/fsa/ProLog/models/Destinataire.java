package com.fsa.ProLog.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Destinataire {

    // TODO test endpoints

    // TODO (oublié)

    @Id
    @GeneratedValue
    private Integer id;

    private String firstname;
    private String lastname;
    private String adresse;
    private String telephone;

    @OneToOne(mappedBy = "destinataire", cascade = CascadeType.ALL)
    private Colis colis;

}
