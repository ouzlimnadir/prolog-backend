package com.fsa.ProLog.dto.request;

import com.fsa.ProLog.models.VehiculeType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VehiculeRequestDto {
    private VehiculeType type;
    private Integer volume;
    private String immatriculation;
    private String marque;
    private LocalDate fin_assurance;
    private LocalDate fin_vignette;
}
