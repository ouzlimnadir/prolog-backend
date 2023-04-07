package com.fsa.ProLog.dto.request;

import lombok.Data;

import java.time.LocalDate;

@Data
public class VehiculeRequestDto {
    private String type;
    private Integer volume;
    private String immatriculation;
    private String marque;
    private LocalDate fin_assurance;
    private LocalDate fin_vignette;
}
