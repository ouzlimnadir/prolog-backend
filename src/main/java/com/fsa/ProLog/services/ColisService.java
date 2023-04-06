package com.fsa.ProLog.services;

import com.fsa.ProLog.dto.request.ColisRequestDto;
import com.fsa.ProLog.dto.response.ColisResponseDto;
import com.fsa.ProLog.dto.response.UserResponseDto;

import java.util.List;

public interface ColisService {
    // GET methods
    List<UserResponseDto> findAll();
    UserResponseDto findById(Integer id);

    // POST methods
    ColisResponseDto save(ColisRequestDto colisRequestDto);

    // PUT methods
    ColisResponseDto update(ColisRequestDto colisRequestDto, Integer id);

    // DELETE methods
    void deleteById(Integer id);
}
