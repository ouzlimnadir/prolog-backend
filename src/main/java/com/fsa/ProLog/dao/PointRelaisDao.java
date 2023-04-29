package com.fsa.ProLog.dao;

import com.fsa.ProLog.models.PointRelais;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PointRelaisDao extends JpaRepository<PointRelais,Integer> {
}
