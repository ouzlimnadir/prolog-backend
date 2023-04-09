package com.fsa.ProLog.controllers;

import com.fsa.ProLog.dto.request.VehiculeRequestDto;
import com.fsa.ProLog.dto.response.VehiculeResponseDto;
import com.fsa.ProLog.services.VehiculeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/vehicule")
@AllArgsConstructor
public class VehiculeController {
    private VehiculeService vehiculeService;
    
    // GET methods
    @GetMapping
    public ResponseEntity<List<VehiculeResponseDto>> getVehicules() {
        return ResponseEntity.ok(vehiculeService.findAll());
    }
    @GetMapping("{id}")
    public ResponseEntity<VehiculeResponseDto> findById(@PathVariable("id") Integer id) {
        VehiculeResponseDto vehiculeResponseDto = vehiculeService.findById(id);
        return ResponseEntity.ok(vehiculeResponseDto);
    }

    // POST methods
    @PostMapping
    public ResponseEntity<VehiculeResponseDto> save(@RequestBody() VehiculeRequestDto vehiculeRequestDto){
        VehiculeResponseDto vehiculeResponseDto = vehiculeService.save(vehiculeRequestDto);
        return new ResponseEntity<>(vehiculeResponseDto, HttpStatus.CREATED);
    }

    // PUT methods
    @PutMapping("{id}")
    public ResponseEntity<VehiculeResponseDto> update(@RequestBody() VehiculeRequestDto vehiculeRequestDto, @PathVariable() Integer id)
            throws RuntimeException {
        VehiculeResponseDto vehiculeResponseDto = vehiculeService.update(vehiculeRequestDto, id);
        return ResponseEntity.accepted().body(vehiculeResponseDto);
    }

    // DELETE methods
    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable() Integer id) {
        vehiculeService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
