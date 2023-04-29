package com.fsa.ProLog.dao;

import com.fsa.ProLog.models.Tracking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrackingDao extends JpaRepository<Tracking,String> {
}
