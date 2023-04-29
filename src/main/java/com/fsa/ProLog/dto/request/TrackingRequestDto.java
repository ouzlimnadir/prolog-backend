package com.fsa.ProLog.dto.request;

import com.fsa.ProLog.models.PointRelais;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TrackingRequestDto {

    private String trackingNumber;
    private List<PointRelais> pointsDeRelais;
    private List<Date> dateChemin;

}
