package com.fsa.ProLog.services;

import com.fsa.ProLog.dto.request.FactureVehiculeRequestDto;
import com.fsa.ProLog.dto.response.FactureVehiculeResponseDto;

import java.util.List;

public interface FactureVehiculeService {

    // GET methods
    List<FactureVehiculeResponseDto> findAll();
    FactureVehiculeResponseDto findById(Integer id);

    // POST methods
    FactureVehiculeResponseDto save(FactureVehiculeRequestDto factureVehiculeRequestDto);

    // PUT methods
    FactureVehiculeResponseDto update(FactureVehiculeRequestDto factureVehiculeRequestDto, Integer id);

    // DELETE methods
    void deleteById(Integer id);
    
}
