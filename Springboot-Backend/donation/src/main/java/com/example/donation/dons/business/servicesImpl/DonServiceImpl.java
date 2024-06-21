package com.example.donation.dons.business.servicesImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.donation.dons.business.services.DonService;
import com.example.donation.dons.dao.entities.Don;
import com.example.donation.dons.dao.entities.DonStatus;
import com.example.donation.dons.dao.repositories.DonRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class DonServiceImpl implements DonService {

    @Autowired
    DonRepository donRepository;

    //Read all
    @Override
    public List<Don> getAllDon() {
        return donRepository.findAll();
    }

    //Read by id
    @Override
    public Optional <Don> getDonById(Long id) {
        return donRepository.findById(id);
    }
    
    //Create
    @Override
    public Don addDon(Don don) {
        return donRepository.save(don);
    }

    //Update
    @Override
    public Don updateDon(Don don, Long id) {
       Don newDon  = donRepository.findById(id)
        .orElseThrow(() -> new EntityNotFoundException("Don not found with id:"+id));
        newDon.setName(don.getName());
        newDon.setPhoto(don.getPhoto());
        newDon.setCategory(don.getCategory());

        return donRepository.save(newDon);
    }

    //delete by id
    @Override
    public void deleteDonById(Long id) {
       donRepository.deleteById(id);
    }

    //Update Don's Status
    @Override
    public Optional<Don> updateDonStatus(DonStatus status, Long id) {
        Optional<Don> optionalDon = donRepository.findById(id);
        if (optionalDon.isPresent()) {
            Don don = optionalDon.get();
            don.setStatus(status);
            donRepository.save(don);
                return Optional.of(don);
        } 
        else {
                return Optional.empty();
            }
    }       
}