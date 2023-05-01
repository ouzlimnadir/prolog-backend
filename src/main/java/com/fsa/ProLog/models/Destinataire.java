package com.fsa.ProLog.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Destinataire implements Serializable {

    // TODO Remove Constructor without id

    @Id
    @GeneratedValue
    private Integer id;

    private String firstname;
    private String lastname;
    private String adresse;
    private String telephone;

    @OneToOne(mappedBy = "destinataire", cascade = CascadeType.ALL)
    private Colis colis;

    public Destinataire(String firstname, String lastname, String adresse, String telephone) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.adresse = adresse;
        this.telephone = telephone;
    }
}
