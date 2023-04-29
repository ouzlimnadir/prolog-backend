package com.fsa.ProLog.controllers;

import com.fsa.ProLog.dto.request.PointRelaisRequestDto;
import com.fsa.ProLog.dto.response.PointRelaisResponseDto;
import com.fsa.ProLog.services.PointRelaisService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/pointRelais")
@AllArgsConstructor
public class PointRelaisController {
    private PointRelaisService pointRelaisService;

    // GET methods
    @GetMapping
    public ResponseEntity<List<PointRelaisResponseDto>> getPointRelais(){
        return ResponseEntity.ok(pointRelaisService.findAll());
    }
    @GetMapping("{id}")
    public ResponseEntity<PointRelaisResponseDto> findById(@PathVariable("id") Integer id) {
        PointRelaisResponseDto pointRelaisResponseDto = pointRelaisService.findById(id);
        return ResponseEntity.ok(pointRelaisResponseDto);
    }

    // POST methods
    @PostMapping
    public ResponseEntity<PointRelaisResponseDto> save(@RequestBody() PointRelaisRequestDto pointRelaisRequestDto){
        PointRelaisResponseDto pointRelaisResponseDto = pointRelaisService.save(pointRelaisRequestDto);
        return new ResponseEntity<>(pointRelaisResponseDto, HttpStatus.CREATED);
    }

    // PUT methods
    @PutMapping("{id}")
    public ResponseEntity<PointRelaisResponseDto> update(@RequestBody() PointRelaisRequestDto pointRelaisRequestDto, @PathVariable() Integer id)
            throws RuntimeException {
        PointRelaisResponseDto pointRelaisResponseDto = pointRelaisService.update(pointRelaisRequestDto, id);
        return ResponseEntity.accepted().body(pointRelaisResponseDto);
    }

    // DELETE methods
    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable() Integer id) {
        pointRelaisService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
