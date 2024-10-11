package com.example.users_bakend.services;


import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.users_bakend.models.UsersModel;
import com.example.users_bakend.repositories.UserRepository;

// This class is a service for the UsersModel class
@Service
public class UserService {
    // This annotation is used to inject the UserRepository class
    @Autowired
    UserRepository userRepository;

    // This method is used to get all users
    public ArrayList<UsersModel> getUsers() {
        return (ArrayList<UsersModel>) userRepository.findAll();
    }

    // This method is used to save a user
    public UsersModel saveUser(UsersModel user) {
        return userRepository.save(user);
    }
    
    // This method is used to update a user
    public UsersModel updateUser(UsersModel user) {
        return userRepository.save(user);

    }
    // This method is used to get a user by id
    public Optional<UsersModel> getUserById(Long id) {
        return userRepository.findById(id);
    }
    // This method is used to get users by status
    public ArrayList<UsersModel> getUsersByStatus(Integer status) {
        return userRepository.findByStatus(status);
    }

    // This method is used to delete a user
    public boolean deleteUser(Long id) {
        try {
            userRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
