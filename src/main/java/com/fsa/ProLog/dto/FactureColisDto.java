package com.fsa.ProLog.dto;

import com.fsa.ProLog.models.Colis;
import com.fsa.ProLog.models.FactureColis;
import com.fsa.ProLog.models.User;
import lombok.Data;

import java.time.LocalDate;

@Data
public class FactureColisDto {
    private Integer id;
    private Double prix;
    private String start_point;
    private String arrived_point;
    private LocalDate date;
    private User client;
    private Colis colis;

//    public FactureColisDto fromEntity(FactureColis factureColis){
//        if(factureColis==null)return null;
//        FactureColisDto factureColisDto = new FactureColisDto();
//
//        factureColisDto.setId(factureColis.getId());
//        factureColisDto.setPrix(factureColis.getPrix());
//        factureColisDto.setStart_point(factureColis.getStart_point());
//        factureColisDto.setArrived_point(factureColis.getArrived_point());
//        factureColisDto.setDate(factureColis.getDate());
//        factureColisDto.setClient(factureColis.getClient());
//        factureColisDto.setColis(factureColis.getColis());
//
//        return factureColisDto;
//    }
//    public FactureColis toEntity(FactureColisDto factureColisDto){
//        if(factureColisDto==null) return null;
//        FactureColis factureColis = new FactureColis();
//
//        factureColis.setId(factureColisDto.getId());
//        factureColis.setPrix(factureColisDto.getPrix());
//        factureColis.setStart_point(factureColisDto.getStart_point());
//        factureColis.setArrived_point(factureColisDto.getArrived_point());
//        factureColis.setDate(factureColisDto.getDate());
//        factureColis.setClient(factureColisDto.getClient());
//        factureColis.setColis(factureColisDto.getColis());
//
//        return factureColis;
//    }
}
