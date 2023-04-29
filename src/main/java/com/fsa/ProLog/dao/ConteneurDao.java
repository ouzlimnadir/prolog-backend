package com.fsa.ProLog.dao;

import com.fsa.ProLog.models.Conteneur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConteneurDao extends JpaRepository<Conteneur, Integer> {
}
