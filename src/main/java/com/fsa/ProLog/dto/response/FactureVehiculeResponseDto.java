package com.fsa.ProLog.dto.response;

import lombok.Data;

import java.time.LocalDate;

@Data
public class FactureVehiculeResponseDto {
    private Integer id;
    private Double prix;
    private String start_point;
    private String arrived_point;
    private LocalDate date;
}
