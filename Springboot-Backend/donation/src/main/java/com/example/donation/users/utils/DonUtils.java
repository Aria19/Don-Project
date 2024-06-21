package com.example.donation.users.utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class DonUtils {
    private DonUtils(){

    }

    public static ResponseEntity<String> getResponseEntity(String responseMessage, HttpStatus httpStatus){
        return new ResponseEntity<String>("{\"message\":\"" + responseMessage + "\"}",httpStatus);
    }
}
