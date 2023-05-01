package com.fsa.ProLog.dto.request;

import com.fsa.ProLog.dto.response.ColisResponseDto;
import com.fsa.ProLog.models.Colis;
import com.fsa.ProLog.models.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FactureColisRequestDto {

    private Double prix;
    private Date date;
    private User client;
    private Colis colis;

}
