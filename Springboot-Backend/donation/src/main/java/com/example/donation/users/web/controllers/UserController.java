package com.example.donation.users.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import com.example.donation.exceptions.DuplicateUserException;
import com.example.donation.users.business.services.UserService;
import com.example.donation.users.dao.entities.User;
import com.example.donation.users.dto.UserDTO;
import com.example.donation.users.dto.UserSummaryDTO;

import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    
    @GetMapping()
    public ResponseEntity<?> getAllUsers() {
        List<UserSummaryDTO> users = this.userService.getAllUsers()
                .stream()
                .map(UserSummaryDTO::toUserSummaryDTO)
                .collect(Collectors.toList());      
        return new ResponseEntity<>(users, HttpStatus.OK);
    }
   
    @GetMapping("/{id}")
    public ResponseEntity<?> getUserById(@PathVariable Long id) {
        UserDTO user = UserDTO.toUserDTO(this.userService.getUserById(id));
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<?> addUser(@RequestBody UserDTO userDTO) throws DuplicateUserException {
       
        User user = UserDTO.fromUserDTO(userDTO);
        return new ResponseEntity<>(this.userService.addUser(user), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateUser(@PathVariable Long id, @RequestBody UserDTO userDTO) throws DuplicateUserException{
        User user = UserDTO.fromUserDTO(userDTO);
        return new ResponseEntity<>(this.userService.updateUser(id, user), HttpStatus.OK);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id) {
        this.userService.deleteUser(id);
        return new ResponseEntity<>( HttpStatus.NO_CONTENT);

    }
}
