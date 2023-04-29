package com.fsa.ProLog.services;

import com.fsa.ProLog.dto.request.TrackingRequestDto;
import com.fsa.ProLog.dto.response.TrackingResponseDto;

import java.util.List;

public interface TrackingService {

    List<TrackingResponseDto> findAll();
    TrackingResponseDto findById(String id);
    //TrackingResponseDto findByType(String type);

    // POST methods
    TrackingResponseDto save(TrackingRequestDto trackingRequestDto);

    // PUT methods
    TrackingResponseDto update(TrackingRequestDto trackingRequestDto, String id);

    // DELETE methods
    void deleteById(String id);
    
}
