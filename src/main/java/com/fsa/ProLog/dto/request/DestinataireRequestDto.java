package com.fsa.ProLog.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DestinataireRequestDto {

    private String firstname;
    private String lastname;
    private String adresse;
    private String telephone;

}