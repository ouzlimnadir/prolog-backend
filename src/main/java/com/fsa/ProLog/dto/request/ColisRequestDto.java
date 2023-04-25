package com.fsa.ProLog.dto.request;

import com.fsa.ProLog.models.Destinataire;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ColisRequestDto {
    private Integer poids; // en gramme

    // Volume en centimetre cube
    private Integer longueur;
    private Integer largeur;
    private Integer hauteur;

    //
    private Boolean froid;
    private Boolean fragile;

    private Integer trackingNumber;
    private String adresse;
    private Destinataire destinataire;

}
