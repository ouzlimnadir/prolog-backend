package com.fsa.ProLog.dto.response;

import lombok.Data;

import java.util.List;

@Data
public class ConteneurResponseDto {

    private Integer id;
    private String villeDepart;
    private String villeArrivee;
    private String ref;
    private UserResponseDto driver;
    private List<ColisResponseDto> colis;
}
