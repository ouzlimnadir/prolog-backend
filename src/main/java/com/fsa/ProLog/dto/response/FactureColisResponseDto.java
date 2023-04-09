package com.fsa.ProLog.dto.response;

import com.fsa.ProLog.models.Colis;
import com.fsa.ProLog.models.User;
import lombok.Data;

import java.time.LocalDate;

@Data
public class FactureColisResponseDto {
    private Integer id;
    private Double prix;
    private String start_point;
    private String arrived_point;
    private LocalDate date;

    private UserResponseDto client;
    private ColisResponseDto colis;
}
