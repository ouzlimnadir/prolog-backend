package com.fsa.ProLog.dto.response;

import com.fsa.ProLog.models.PointRelais;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class TrackingResponseDto {

    private String trackingNumber;
    private List<PointRelais> pointsDeRelais;
    private List<Date> dateChemin;

}
