package com.example.donation.dons.dao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.donation.dons.dao.entities.Don;

@Repository
public interface DonRepository extends JpaRepository<Don, Long> {
    
}
