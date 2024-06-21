package com.example.donation.dons.web.rest;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.donation.dons.dao.entities.Don;
import com.example.donation.dons.dao.entities.DonStatus;

@RequestMapping("/don")
public interface DonRest {
    //create don
    @PostMapping("/create")
    public ResponseEntity<Don> createDon(@RequestBody Don requestMap);

    //update don by id
    @PutMapping("/{id}")
    public ResponseEntity<Don> updateDon(@RequestBody Don don, @PathVariable Long id);

    //delete don by id
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDon(@PathVariable Long id);

    //read all dons
    @GetMapping
    public ResponseEntity<List<Don>> getAllDon();

    //read don by id
    @GetMapping("/{id}")
    public ResponseEntity<Don> getByIdDon(@PathVariable Long id);

    //update don's status
    @PutMapping("/{id}/status")
    public ResponseEntity<Don> updateDonStatus(@RequestParam DonStatus status, @PathVariable Long id);
    
}