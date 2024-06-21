package com.example.donation.users.business.services;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;



@Service
public interface UserService {

    ResponseEntity<String> signUp(Map<String, String> requestMap);
    
    

}
