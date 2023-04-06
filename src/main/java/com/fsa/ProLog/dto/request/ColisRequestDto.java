package com.fsa.ProLog.dto.request;

import lombok.Data;

@Data
public class ColisRequestDto {
    private Integer poids;

    // Volume
    private Integer longueur;
    private Integer largeur;
    private Integer hauteur;

    //
    private Boolean froid;
    private Boolean fragile;
}
