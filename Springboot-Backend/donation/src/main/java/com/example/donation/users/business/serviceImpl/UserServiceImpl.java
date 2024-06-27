package com.example.donation.users.business.serviceImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.donation.users.business.services.FilesStorageService;
import com.example.donation.exceptions.DuplicateUserException;
import com.example.donation.users.business.services.UserService;

import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import com.example.donation.users.dao.entities.User;
import com.example.donation.users.dao.repository.UserRepository;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final FilesStorageService filesStorageService;
    public UserServiceImpl(UserRepository userRepository, FilesStorageService filesStorageService){
        this.userRepository = userRepository;
        this.filesStorageService = filesStorageService;
    }

    @Override
    public List<User> getAllUsers() {
        return this.userRepository.findAll(Sort.by(Direction.ASC, "name"));
    }

    @Override
    public User getUserById(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("ID cannot be null");
        }
        return this.userRepository.findById(id).orElseThrow(() -> new 
        EntityNotFoundException("User with id " + id + "not found"));
    }

    @Override
    public User addUser(User user) throws DuplicateUserException {
        if(user == null){
            throw new IllegalArgumentException("User cannot be null");
        }
        try {
            return userRepository.save(user);
        } catch (DataIntegrityViolationException e) {
            throw new DuplicateUserException("A user with the same email or other unique field already exists.");
        }
    }

    @Override
    public User updateUser(Long id, User user) throws DuplicateUserException {
        if(id == null || user == null){
            throw new IllegalArgumentException("Id or user cannot be null");
        }
        getUserById(id);
        try {
            return userRepository.save(user);
        } catch (DataIntegrityViolationException e) {
            throw new DuplicateUserException("A user with the same email or other unique field already exists."); 
        }
    }

    @Override
    @Transactional
    public void deleteUser(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("ID cannot be null");
        }
        try {
            // Retrieve the contact by ID
            User user = this.getUserById(id);
            // Get the image filename associated with the contact
            String filename = user.getImage();
            // If the contact has an image, delete it
            if (filename != null) {
                filesStorageService.delete(filename);
            }
            // Delete the contact from the repository by ID
            userRepository.deleteById(id);
        } catch (DataAccessException e) {
            // Capture any data access exceptions (e.g., foreign key constraint violations)
            throw new RuntimeException("Failed to delete contact with id: " + id, e);
        }
    }

    @Override
    public User updateUserImage(Long id, String filename) {
        if (id == null) {
            throw new IllegalArgumentException("ID cannot be null");
        }

        User user = getUserById(id);
        if(user.getImage() == null){
            user.setImage(filename);
        }else{
            this.filesStorageService.delete(user.getImage());
            user.setImage(filename);
        }
        return userRepository.save(user);
    }

}
