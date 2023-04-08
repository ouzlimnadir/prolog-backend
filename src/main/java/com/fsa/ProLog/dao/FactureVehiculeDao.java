package com.fsa.ProLog.dao;

import com.fsa.ProLog.models.FactureVehicule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FactureVehiculeDao extends JpaRepository<FactureVehicule,Integer> {
}
