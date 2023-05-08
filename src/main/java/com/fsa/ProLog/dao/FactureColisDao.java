package com.fsa.ProLog.dao;

import com.fsa.ProLog.models.FactureColis;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FactureColisDao extends JpaRepository<FactureColis,Integer> {
    List<FactureColis> findByClientIdOrderByIdDesc(Integer id);

    Optional<FactureColis> findByColisTrackingNumberTrackingNumber(String trackingNumber);
}
