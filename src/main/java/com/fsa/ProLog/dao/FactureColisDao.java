package com.fsa.ProLog.dao;

import com.fsa.ProLog.models.FactureColis;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FactureColisDao extends JpaRepository<FactureColis,Integer> {
}
