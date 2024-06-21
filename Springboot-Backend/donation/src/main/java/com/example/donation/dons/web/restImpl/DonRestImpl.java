package com.example.donation.dons.web.restImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.example.donation.dons.business.services.DonService;
import com.example.donation.dons.dao.entities.Don;
import com.example.donation.dons.dao.entities.DonStatus;
import com.example.donation.dons.web.rest.DonRest;

@RestController
public class DonRestImpl implements DonRest {
    @Autowired
    DonService donservice;

    @Override
    public ResponseEntity<Don> createDon(Don requestMap) {
        Don createdDon = donservice.addDon(requestMap);
        return new ResponseEntity<>(createdDon, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Don> updateDon(Don don, Long id) {
        Don updatedDon = donservice.updateDon(don, id);
        return new ResponseEntity<>(updatedDon, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Void> deleteDon(Long id) {
        donservice.deleteDonById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Override
    public ResponseEntity<List<Don>> getAllDon() {
        List<Don> dons = donservice.getAllDon();
        return new ResponseEntity<>(dons, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Don> getByIdDon(Long id) {
        Don don = donservice.getDonById(id)
                .orElseThrow(() -> new RuntimeException("Don not found with id " + id));
        return new ResponseEntity<>(don, HttpStatus.OK);

    }

    @Override
    public ResponseEntity<Don> updateDonStatus(DonStatus status, Long id) {
        Don updatedDon = donservice.updateDonStatus(status, id)
            .orElseThrow(() -> new RuntimeException("Don not found with id " + id));
        return new ResponseEntity<>(updatedDon, HttpStatus.OK);
    }

    /* @Override
    public ResponseEntity<Don> updateDonCategory(Long id, Don category) {
        ;
    } */

}