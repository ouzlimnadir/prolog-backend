package com.fsa.ProLog.dto.request;

import com.fsa.ProLog.dto.response.ColisResponseDto;
import com.fsa.ProLog.models.Colis;
import com.fsa.ProLog.models.User;
import lombok.Data;

import java.util.Date;

@Data
public class FactureColisRequestDto {

    private Double prix;
    private Date date;
    private User client;
    private Colis colis;

}
