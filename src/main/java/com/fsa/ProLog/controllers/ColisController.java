package com.fsa.ProLog.controllers;

import com.fsa.ProLog.dto.request.ColisRequestDto;
import com.fsa.ProLog.dto.response.ColisResponseDto;
import com.fsa.ProLog.services.ColisService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/colis")
@AllArgsConstructor
public class ColisController {
    private ColisService colisService;

    // GET methods
    @GetMapping
    public ResponseEntity<List<ColisResponseDto>> getColis(){
        return ResponseEntity.ok(colisService.findAll());
    }
    @GetMapping("{id}")
    public ResponseEntity<ColisResponseDto> findById(@PathVariable("id") Integer id) {
        ColisResponseDto colisResponseDto = colisService.findById(id);
        return ResponseEntity.ok(colisResponseDto);
    }
    @GetMapping("/trackingNumber/{trackingNumber}")
    public ResponseEntity<ColisResponseDto> findByTrackingNumber(@PathVariable() String trackingNumber) {
        ColisResponseDto colisResponseDto = colisService.findByTrackingNumber(trackingNumber);
        return ResponseEntity.ok(colisResponseDto);
    }

    // POST methods
    @PostMapping
    public ResponseEntity<ColisResponseDto> save(@RequestBody() ColisRequestDto colisRequestDto){
        ColisResponseDto colisResponseDto = colisService.save(colisRequestDto);
        return new ResponseEntity<>(colisResponseDto, HttpStatus.CREATED);
    }

    // PUT methods
    @PutMapping("{id}")
    public ResponseEntity<ColisResponseDto> update(@RequestBody() ColisRequestDto colisRequestDto, @PathVariable() Integer id)
            throws RuntimeException {
        ColisResponseDto colisResponseDto = colisService.update(colisRequestDto, id);
        return ResponseEntity.accepted().body(colisResponseDto);
    }

    // DELETE methods
    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable() Integer id) {
        colisService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
