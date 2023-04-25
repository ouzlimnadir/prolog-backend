package com.fsa.ProLog.dao;

import com.fsa.ProLog.models.FactureColis;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FactureColisDao extends JpaRepository<FactureColis,Integer> {
    List<FactureColis> findByClientId(Integer id);
}
