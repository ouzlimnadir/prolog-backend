package com.fsa.ProLog.dto.response;

import com.fsa.ProLog.models.Tracking;
import lombok.Data;

@Data
public class ColisResponseDto {
    private Integer id;
    private Integer poids;

    // Volume
    private Integer longueur;
    private Integer largeur;
    private Integer hauteur;

    //
    private Boolean froid;
    private Boolean fragile;

    private Boolean recup;
    private Boolean delivered;
    private Boolean inContainer;


    private TrackingResponseDto trackingNumber;

    private String adresse;
    private DestinataireResponseDto destinataire;
}
