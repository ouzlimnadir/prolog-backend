package com.fsa.ProLog.controllers;

import com.fsa.ProLog.dto.request.UserRequestDto;
import com.fsa.ProLog.dto.response.UserResponseDto;
import com.fsa.ProLog.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/user")
@AllArgsConstructor
public class UserController {
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<UserResponseDto>> getUsers() {
        return ResponseEntity.ok(userService.findAll());
    }
    @PostMapping
    public ResponseEntity<UserResponseDto> save(@RequestBody() UserRequestDto userRequestDto){
        UserResponseDto userResponseDto = userService.save(userRequestDto);
        return new ResponseEntity<>(userResponseDto, HttpStatus.CREATED);
    }
    @GetMapping("/id/{id}")
    public ResponseEntity<UserResponseDto> findById(@PathVariable("id") Integer id) {
        UserResponseDto userResponseDto = userService.findById(id);
        return ResponseEntity.ok(userResponseDto);
    }

    @GetMapping("/username/{username}")
    public ResponseEntity<UserResponseDto> findByUsername(@PathVariable() String username) {
        UserResponseDto userResponseDto = userService.findByUsername(username);
        return ResponseEntity.ok(userResponseDto);
    }

    @DeleteMapping("/id/{id}")
    public ResponseEntity<?> delete(@PathVariable() Integer id) {
        userService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/id/{id}")
    public ResponseEntity<UserResponseDto> update(@RequestBody() UserRequestDto userRequestDto, @PathVariable() Integer id)
            throws RuntimeException {
        UserResponseDto userResponseDto = userService.update(userRequestDto, id);
        return ResponseEntity.accepted().body(userResponseDto);
    }
}
