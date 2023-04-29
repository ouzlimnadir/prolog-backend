package com.fsa.ProLog.controllers;

import com.fsa.ProLog.dto.request.ConteneurRequestDto;
import com.fsa.ProLog.dto.response.ConteneurResponseDto;
import com.fsa.ProLog.services.ConteneurService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/conteneur")
@AllArgsConstructor
public class ConteneurController {
    private ConteneurService conteneurService;

    // GET methods
    @GetMapping
    public ResponseEntity<List<ConteneurResponseDto>> getConteneur(){
        return ResponseEntity.ok(conteneurService.findAll());
    }
    @GetMapping("{id}")
    public ResponseEntity<ConteneurResponseDto> findById(@PathVariable("id") Integer id) {
        ConteneurResponseDto conteneurResponseDto = conteneurService.findById(id);
        return ResponseEntity.ok(conteneurResponseDto);
    }

    // POST methods
    @PostMapping
    public ResponseEntity<ConteneurResponseDto> save(@RequestBody() ConteneurRequestDto conteneurRequestDto){
        ConteneurResponseDto conteneurResponseDto = conteneurService.save(conteneurRequestDto);
        return new ResponseEntity<>(conteneurResponseDto, HttpStatus.CREATED);
    }

    // PUT methods
    @PutMapping("{id}")
    public ResponseEntity<ConteneurResponseDto> update(@RequestBody() ConteneurRequestDto conteneurRequestDto, @PathVariable() Integer id)
            throws RuntimeException {
        ConteneurResponseDto conteneurResponseDto = conteneurService.update(conteneurRequestDto, id);
        return ResponseEntity.accepted().body(conteneurResponseDto);
    }

    // DELETE methods
    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable() Integer id) {
        conteneurService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
