package com.fsa.ProLog.controllers;

import com.fsa.ProLog.dto.response.ColisResponseDto;
import com.fsa.ProLog.services.ColisService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/colis")
public class ColisController {
    private ColisService colisService;

    @GetMapping
    public ResponseEntity<List<ColisResponseDto>> getColis(){
        return null;//ResponseEntity.ok(colisService.findAll());
    }
}
