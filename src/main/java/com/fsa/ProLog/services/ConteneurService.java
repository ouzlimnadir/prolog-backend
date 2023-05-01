package com.fsa.ProLog.services;

import com.fsa.ProLog.dto.request.ConteneurRequestDto;
import com.fsa.ProLog.dto.response.ConteneurResponseDto;

import java.util.List;

public interface ConteneurService {

    List<ConteneurResponseDto> findAll();
    ConteneurResponseDto findById(Integer id);
    //ConteneurResponseDto findByType(String type);

    // POST methods
    ConteneurResponseDto save(ConteneurRequestDto conteneurRequestDto);

    // PUT methods
    ConteneurResponseDto update(ConteneurRequestDto conteneurRequestDto, Integer id);

    // DELETE methods
    void deleteById(Integer id);

    ConteneurResponseDto findByRef(String ref);
}
