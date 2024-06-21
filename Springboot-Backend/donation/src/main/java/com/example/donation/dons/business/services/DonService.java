package com.example.donation.dons.business.services;
import java.util.List;
import java.util.Optional;

import com.example.donation.dons.dao.entities.Don;
import com.example.donation.dons.dao.entities.DonStatus;

public interface DonService {

    //Read
    List<Don> getAllDon();
    Optional<Don> getDonById(Long id);

    //create
    Don addDon(Don don);

    //Update
    Don updateDon(Don don, Long id);

    //Update Don Status
    Optional<Don> updateDonStatus(DonStatus don, Long id);

    //delete
    void deleteDonById(Long id);
}