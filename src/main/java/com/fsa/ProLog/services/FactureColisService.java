package com.fsa.ProLog.services;

import com.fsa.ProLog.dto.request.FactureColisRequestDto;
import com.fsa.ProLog.dto.response.FactureColisResponseDto;

import java.util.List;

public interface FactureColisService {
    
    // GET methods
    List<FactureColisResponseDto> findAll();
    FactureColisResponseDto findById(Integer id);
    
    // POST methods
    FactureColisResponseDto save(FactureColisRequestDto factureColisRequestDto);

    // PUT methods
    FactureColisResponseDto update(FactureColisRequestDto factureColisRequestDto, Integer id);

    // DELETE methods
    void deleteById(Integer id);

}
