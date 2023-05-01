package com.fsa.ProLog.dto.request;

import com.fsa.ProLog.models.Colis;
import com.fsa.ProLog.models.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConteneurRequestDto {

    private String ref;
    private String villeDepart;
    private String villeArrivee;
    private User driver;
    private List<Colis> colis;

}
