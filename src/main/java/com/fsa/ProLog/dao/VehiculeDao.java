package com.fsa.ProLog.dao;

import com.fsa.ProLog.models.Vehicule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehiculeDao extends JpaRepository<Vehicule,Integer> {
    Vehicule findByType(String type);
}
