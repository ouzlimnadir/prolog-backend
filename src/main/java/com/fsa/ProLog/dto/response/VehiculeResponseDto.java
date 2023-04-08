package com.fsa.ProLog.dto.response;

import com.fsa.ProLog.models.VehiculeType;
import lombok.Data;

import java.time.LocalDate;


@Data
public class VehiculeResponseDto {
    private Integer id;
    private VehiculeType type;
    private Integer volume;
    private String immatriculation;
    private String marque;
    private LocalDate fin_assurance;
    private LocalDate fin_vignette;
}
