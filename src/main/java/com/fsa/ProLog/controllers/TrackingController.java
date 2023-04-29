package com.fsa.ProLog.controllers;

import com.fsa.ProLog.dto.request.TrackingRequestDto;
import com.fsa.ProLog.dto.response.TrackingResponseDto;
import com.fsa.ProLog.services.TrackingService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/tracking")
@AllArgsConstructor
public class TrackingController {
    private TrackingService trackingService;

    // GET methods
    @GetMapping
    public ResponseEntity<List<TrackingResponseDto>> getTracking(){
        return ResponseEntity.ok(trackingService.findAll());
    }
    @GetMapping("{id}")
    public ResponseEntity<TrackingResponseDto> findById(@PathVariable("id") String id) {
        TrackingResponseDto trackingResponseDto = trackingService.findById(id);
        return ResponseEntity.ok(trackingResponseDto);
    }

    // POST methods
    @PostMapping
    public ResponseEntity<TrackingResponseDto> save(@RequestBody() TrackingRequestDto trackingRequestDto){
        TrackingResponseDto trackingResponseDto = trackingService.save(trackingRequestDto);
        return new ResponseEntity<>(trackingResponseDto, HttpStatus.CREATED);
    }

    // PUT methods
    @PutMapping("{id}")
    public ResponseEntity<TrackingResponseDto> update(@RequestBody() TrackingRequestDto trackingRequestDto, @PathVariable() String id)
            throws RuntimeException {
        TrackingResponseDto trackingResponseDto = trackingService.update(trackingRequestDto, id);
        return ResponseEntity.accepted().body(trackingResponseDto);
    }

    // DELETE methods
    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable() String id) {
        trackingService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
