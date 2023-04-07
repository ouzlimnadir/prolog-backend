package com.fsa.ProLog.services;

import com.fsa.ProLog.dto.request.VehiculeRequestDto;
import com.fsa.ProLog.dto.response.VehiculeResponseDto;

import java.util.List;

public interface VehiculeService {
    // GET methods
    List<VehiculeResponseDto> findAll();
    VehiculeResponseDto findById(Integer id);
    //VehiculeResponseDto findByType(String type);

    // POST methods
    VehiculeResponseDto save(VehiculeRequestDto vehiculeRequestDto);

    // PUT methods
    VehiculeResponseDto update(VehiculeRequestDto vehiculeRequestDto, Integer id);

    // DELETE methods
    void deleteById(Integer id);
}
