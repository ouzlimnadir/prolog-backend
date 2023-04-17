package com.fsa.ProLog.dao;

import com.fsa.ProLog.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserDao extends JpaRepository<User,Integer> {
    User findByUsername(String Username);
    Optional<User> findByEmail(String Email);
}
