package com.fsa.ProLog.services;

import com.fsa.ProLog.dto.request.DestinataireRequestDto;
import com.fsa.ProLog.dto.response.DestinataireResponseDto;

import java.util.List;

public interface DestinataireService {

    // GET methods
    List<DestinataireResponseDto> findAll();
    DestinataireResponseDto findById(Integer id);

    // POST methods
    DestinataireResponseDto save(DestinataireRequestDto destinataireRequestDto);

    // PUT methods
    DestinataireResponseDto update(DestinataireRequestDto destinataireRequestDto, Integer id);
    // DELETE methods
    void deleteById(Integer id);

}
