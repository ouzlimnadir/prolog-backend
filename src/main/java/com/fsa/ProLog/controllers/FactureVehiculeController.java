package com.fsa.ProLog.controllers;

import com.fsa.ProLog.dto.request.FactureVehiculeRequestDto;
import com.fsa.ProLog.dto.response.FactureVehiculeResponseDto;
import com.fsa.ProLog.services.FactureVehiculeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/factureVehicule")
@AllArgsConstructor
public class FactureVehiculeController {
    private FactureVehiculeService factureVehiculeService;

    // GET methods
    @GetMapping
    public ResponseEntity<List<FactureVehiculeResponseDto>> getFacturesVehicule() {
        return ResponseEntity.ok(factureVehiculeService.findAll());
    }
    @GetMapping("/id/{id}")
    public ResponseEntity<FactureVehiculeResponseDto> findById(@PathVariable("id") Integer id) {
        FactureVehiculeResponseDto factureVehiculeResponseDto = factureVehiculeService.findById(id);
        return ResponseEntity.ok(factureVehiculeResponseDto);
    }

    // POST methods
    @PostMapping
    public ResponseEntity<FactureVehiculeResponseDto> save(@RequestBody() FactureVehiculeRequestDto factureVehiculeRequestDto){
        FactureVehiculeResponseDto factureVehiculeResponseDto = factureVehiculeService.save(factureVehiculeRequestDto);
        return new ResponseEntity<>(factureVehiculeResponseDto, HttpStatus.CREATED);
    }

    // PUT methods
    @PutMapping("/id/{id}")
    public ResponseEntity<FactureVehiculeResponseDto> update(@RequestBody() FactureVehiculeRequestDto factureVehiculeRequestDto, @PathVariable() Integer id)
            throws RuntimeException {
        FactureVehiculeResponseDto factureVehiculeResponseDto = factureVehiculeService.update(factureVehiculeRequestDto, id);
        return ResponseEntity.accepted().body(factureVehiculeResponseDto);
    }

    // DELETE methods
    @DeleteMapping("/id/{id}")
    public ResponseEntity<?> delete(@PathVariable() Integer id) {
        factureVehiculeService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
