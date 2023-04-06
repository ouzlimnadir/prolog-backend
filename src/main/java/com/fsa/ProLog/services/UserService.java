package com.fsa.ProLog.services;

import com.fsa.ProLog.dto.request.UserRequestDto;
import com.fsa.ProLog.dto.response.UserResponseDto;

import java.util.List;

public interface UserService {

    // GET methods
    List<UserResponseDto> findAll();
    UserResponseDto findById(Integer id);
    UserResponseDto findByUsername(String username);

    // POST methods
    UserResponseDto save(UserRequestDto userRequestDto);

    // PUT methods
    UserResponseDto update(UserRequestDto userRequestDto, Integer id);

    // DELETE methods
    void deleteById(Integer id);
}
