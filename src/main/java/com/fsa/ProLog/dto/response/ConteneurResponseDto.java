package com.fsa.ProLog.dto.response;

import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@ToString(exclude = "colis")
public class ConteneurResponseDto {

    private Integer id;
    private String villeDepart;
    private String villeArrivee;
    private String ref;
    private Boolean fin;
    private UserResponseDto driver;
    private List<ColisResponseDto> colis;
}
