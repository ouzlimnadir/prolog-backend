package com.fsa.ProLog.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PointRelaisRequestDto {

    private String ville;
    private String adresse;

}
