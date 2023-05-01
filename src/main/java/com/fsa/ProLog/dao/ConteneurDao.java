package com.fsa.ProLog.dao;

import com.fsa.ProLog.models.Conteneur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ConteneurDao extends JpaRepository<Conteneur, Integer> {
    Optional<Conteneur> findByRef(String ref);
}
