package com.fsa.ProLog.dao;

import com.fsa.ProLog.models.Destinataire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DestinataireDao extends JpaRepository<Destinataire,Integer> {
}
