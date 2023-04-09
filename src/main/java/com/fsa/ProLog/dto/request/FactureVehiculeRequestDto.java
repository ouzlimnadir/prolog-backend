package com.fsa.ProLog.dto.request;

import com.fsa.ProLog.models.Colis;
import com.fsa.ProLog.models.User;
import com.fsa.ProLog.models.Vehicule;
import lombok.Data;

import java.time.LocalDate;

@Data
public class FactureVehiculeRequestDto {
    private Double prix;
    private String start_point;
    private String arrived_point;
    private LocalDate date;
    private User client;
    private User chauffeur;
    private Vehicule vehicule;
}
