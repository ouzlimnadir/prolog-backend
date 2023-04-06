package com.fsa.ProLog.dto.response;

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
    private Integer trackingNumber;
}
