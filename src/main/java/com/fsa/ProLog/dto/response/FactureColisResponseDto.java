package com.fsa.ProLog.dto.response;

import lombok.Data;

import java.util.Date;

@Data
public class FactureColisResponseDto {
    private Integer id;
    private Double prix;
    private Date date;

    private UserResponseDto client;
    private ColisResponseDto colis;
}
