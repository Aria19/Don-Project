package com.example.donation.users.dao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.donation.users.dao.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmailId(@Param("email") String email);
}