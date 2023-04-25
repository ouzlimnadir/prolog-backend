package com.fsa.ProLog.dto.response;

import lombok.Data;

import java.time.LocalDate;

@Data
public class FactureColisResponseDto {
    private Integer id;
    private Double prix;
    private LocalDate date;

    private UserResponseDto client;
    private ColisResponseDto colis;
}
