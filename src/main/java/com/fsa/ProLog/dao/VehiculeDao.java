package com.fsa.ProLog.dao;

import com.fsa.ProLog.models.User;
import com.fsa.ProLog.models.Vehicule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehiculeDao extends JpaRepository<Vehicule,Integer> {
    Vehicule findByType(String type);
}
