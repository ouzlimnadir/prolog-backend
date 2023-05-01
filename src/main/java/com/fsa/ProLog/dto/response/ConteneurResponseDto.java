package com.fsa.ProLog.dto.response;

import com.fsa.ProLog.models.Colis;
import com.fsa.ProLog.models.User;
import lombok.Data;

import java.util.List;

@Data
public class ConteneurResponseDto {

    private Integer id;
    private String villeDepart;
    private String villeArrivee;
    private String ref;
    private UserResponseDto driver;
    private List<Colis> colis;
}
