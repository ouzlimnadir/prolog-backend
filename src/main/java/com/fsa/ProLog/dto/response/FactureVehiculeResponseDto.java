package com.fsa.ProLog.dto.response;

import com.fsa.ProLog.models.User;
import com.fsa.ProLog.models.Vehicule;
import lombok.Data;

import java.time.LocalDate;

@Data
public class FactureVehiculeResponseDto {
    private Integer id;
    private Double prix;
    private String start_point;
    private String arrived_point;
    private LocalDate date;
    private UserResponseDto client;
    private UserResponseDto chauffeur;
    private VehiculeResponseDto vehicule;
}
