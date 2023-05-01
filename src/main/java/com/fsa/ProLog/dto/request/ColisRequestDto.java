package com.fsa.ProLog.dto.request;

import com.fsa.ProLog.models.Destinataire;
import com.fsa.ProLog.models.PointRelais;
import com.fsa.ProLog.models.Tracking;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

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

    private Boolean delivered;
    private Boolean inContainer;

    private Tracking trackingNumber;
    private String adresse;
    private Destinataire destinataire;

}
