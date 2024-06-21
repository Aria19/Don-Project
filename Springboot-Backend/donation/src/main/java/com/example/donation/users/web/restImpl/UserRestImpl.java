package com.example.donation.users.web.restImpl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.example.donation.users.business.services.UserService;
import com.example.donation.users.constants.DonConstants;
import com.example.donation.users.utils.DonUtils;
import com.example.donation.users.web.rest.UserRest;

@RestController
public class UserRestImpl implements UserRest {

    @Autowired
    UserService userservice;

    @Override
    public ResponseEntity<String> signUp(Map<String, String> requestMap) {
        try {
            return userservice.signUp(requestMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return DonUtils.getResponseEntity(DonConstants.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
