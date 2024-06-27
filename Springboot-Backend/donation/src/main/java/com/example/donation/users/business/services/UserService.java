package com.example.donation.users.business.services;

import java.util.List;

import com.example.donation.exceptions.DuplicateUserException;
import com.example.donation.users.dao.entities.User;

public interface UserService {
    public List<User> getAllUsers();
    public User getUserById(Long id);
    public User addUser(User user) throws DuplicateUserException;
    public User updateUser(Long id,User user) throws DuplicateUserException;
    public void deleteUser(Long id);    
    public User updateUserImage(Long id,String filename);
}
