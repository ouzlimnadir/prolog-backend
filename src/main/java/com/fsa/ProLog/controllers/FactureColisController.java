package com.fsa.ProLog.controllers;

import com.fsa.ProLog.dto.request.FactureColisRequestDto;
import com.fsa.ProLog.dto.response.FactureColisResponseDto;
import com.fsa.ProLog.services.FactureColisService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/factureColis")
@AllArgsConstructor
public class FactureColisController {
    private FactureColisService factureColisService;

    // TODO get factures by client ID

    // GET methods
    @GetMapping
    public ResponseEntity<List<FactureColisResponseDto>> getFacturesColis() {
        return ResponseEntity.ok(factureColisService.findAll());
    }
    @GetMapping("{id}")
    public ResponseEntity<FactureColisResponseDto> findById(@PathVariable("id") Integer id) {
        FactureColisResponseDto factureColisResponseDto = factureColisService.findById(id);
        return ResponseEntity.ok(factureColisResponseDto);
    }
    @GetMapping("/clientId/{id}")
    public ResponseEntity<List<FactureColisResponseDto>> getFacturesColisByClientId(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(factureColisService.findByClientId(id));
    }

    // POST methods
    @PostMapping
    public ResponseEntity<FactureColisResponseDto> save(@RequestBody() FactureColisRequestDto factureColisRequestDto){
        FactureColisResponseDto factureColisResponseDto = factureColisService.save(factureColisRequestDto);
        return new ResponseEntity<>(factureColisResponseDto, HttpStatus.CREATED);
    }

    // PUT methods
    @PutMapping("{id}")
    public ResponseEntity<FactureColisResponseDto> update(@RequestBody() FactureColisRequestDto factureColisRequestDto, @PathVariable() Integer id)
            throws RuntimeException {
        FactureColisResponseDto factureColisResponseDto = factureColisService.update(factureColisRequestDto, id);
        return ResponseEntity.accepted().body(factureColisResponseDto);
    }

    // DELETE methods
    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable() Integer id) {
        factureColisService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
