package com.example.users_bakend.controllers;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.users_bakend.models.UsersModel;
import com.example.users_bakend.services.UserService;


// This class is a controller for the UsersModel class
@RestController
// This annotation is used to map the path to the controller
@RequestMapping("/users")
// This annotation is used to allow requests from the specified origin
@CrossOrigin("http://localhost:4200/")
public class UserController {
    // This annotation is used to inject the UserService class
    @Autowired
    UserService userService;

    // This method is used to get all users
    @GetMapping()
    public ArrayList<UsersModel> getUsersMapping() {
        return userService.getUsers();
    }

    // This method is used to save a user
    @PostMapping()
    public UsersModel saveUserMapping(@RequestBody UsersModel user) {
        return userService.saveUser(user);
    }

    // This method is used to update a user
    @GetMapping(path = "/{id}")
    public Optional <UsersModel> getUserByIdMapping(@PathVariable("id") Long id) {
        return this.userService.getUserById(id);
    }

    // This method is used to get users by status
    @GetMapping(path = "/status/{status}")
    public ArrayList<UsersModel> getUsersByStatusMapping(@PathVariable("status") Integer status) {
        return this.userService.getUsersByStatus(status);
    }

    // This method is used to delete a user
    @DeleteMapping(path = "/{id}")
    public String deleteUserMapping(@PathVariable("id") Long id) {
        boolean ok = this.userService.deleteUser(id);
        if (ok) {
            return "User deleted with id: " + id;
        } else {
            return "User not deleted";
        }
    }
    




}
