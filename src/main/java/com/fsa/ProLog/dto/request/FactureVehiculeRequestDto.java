package com.fsa.ProLog.dto.request;

import com.fsa.ProLog.models.User;
import com.fsa.ProLog.models.Vehicule;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FactureVehiculeRequestDto {
    private Double prix;
    private String start_point;
    private String arrived_point;
    private LocalDate date;
    private User client;
    private User chauffeur;
    private Vehicule vehicule;
}
