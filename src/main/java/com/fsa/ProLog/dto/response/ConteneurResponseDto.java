package com.fsa.ProLog.dto.response;

import com.fsa.ProLog.models.Colis;
import com.fsa.ProLog.models.User;
import lombok.Data;

import java.util.List;

@Data
public class ConteneurResponseDto {

    private Integer id;
    private User driver;
    private List<Colis> packages;

}
