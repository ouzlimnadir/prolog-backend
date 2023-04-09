package com.fsa.ProLog.dto.request;

import com.fsa.ProLog.models.Colis;
import com.fsa.ProLog.models.User;
import lombok.Data;

import java.time.LocalDate;

@Data
public class FactureColisRequestDto {

    private Double prix;
    private String start_point;
    private String arrived_point;
    private LocalDate date;
    private User client;
    private Colis colis;

}