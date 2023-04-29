package com.fsa.ProLog.services;

import com.fsa.ProLog.dto.request.PointRelaisRequestDto;
import com.fsa.ProLog.dto.response.PointRelaisResponseDto;

import java.util.List;

public interface PointRelaisService {

    List<PointRelaisResponseDto> findAll();
    PointRelaisResponseDto findById(Integer id);
    //PointRelaisResponseDto findByType(String type);

    // POST methods
    PointRelaisResponseDto save(PointRelaisRequestDto pointRelaisRequestDto);

    // PUT methods
    PointRelaisResponseDto update(PointRelaisRequestDto pointRelaisRequestDto, Integer id);

    // DELETE methods
    void deleteById(Integer id);
    
}
