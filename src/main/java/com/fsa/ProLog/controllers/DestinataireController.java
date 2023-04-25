package com.fsa.ProLog.controllers;

import com.fsa.ProLog.dto.request.DestinataireRequestDto;
import com.fsa.ProLog.dto.response.DestinataireResponseDto;
import com.fsa.ProLog.services.DestinataireService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/destinataire")
@AllArgsConstructor
public class DestinataireController {
    private DestinataireService destinataireService;

    // GET methods
    @GetMapping
    public ResponseEntity<List<DestinataireResponseDto>> getDestinataires() {
        return ResponseEntity.ok(destinataireService.findAll());
    }
    @GetMapping("{id}")
    public ResponseEntity<DestinataireResponseDto> findById(@PathVariable("id") Integer id) {
        DestinataireResponseDto destinataireResponseDto = destinataireService.findById(id);
        return ResponseEntity.ok(destinataireResponseDto);
    }

    // POST methods
    @PostMapping
    public ResponseEntity<DestinataireResponseDto> save(@RequestBody() DestinataireRequestDto destinataireRequestDto){
        DestinataireResponseDto destinataireResponseDto = destinataireService.save(destinataireRequestDto);
        return new ResponseEntity<>(destinataireResponseDto, HttpStatus.CREATED);
    }

    // PUT methods
    @PutMapping("{id}")
    public ResponseEntity<DestinataireResponseDto> update(@RequestBody() DestinataireRequestDto destinataireRequestDto, @PathVariable() Integer id)
            throws RuntimeException {
        DestinataireResponseDto destinataireResponseDto = destinataireService.update(destinataireRequestDto, id);
        return ResponseEntity.accepted().body(destinataireResponseDto);
    }

    // DELETE methods
    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable() Integer id) {
        destinataireService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
