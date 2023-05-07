package com.fsa.ProLog.dao;

import com.fsa.ProLog.models.Colis;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ColisDao extends JpaRepository<Colis,Integer> {
    Colis findByTrackingNumberTrackingNumber(String trackingNumber);
}
