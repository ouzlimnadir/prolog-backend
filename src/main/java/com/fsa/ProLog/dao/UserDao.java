package com.fsa.ProLog.dao;

import com.fsa.ProLog.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User,Integer> {
    User findByUsername(String Username);
}
