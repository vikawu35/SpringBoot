package com.example.springbootcrud.service;

import com.example.springbootcrud.model.User;

import java.util.*;

public interface UserService {

    List<User> getAllUsers();
    Optional<User> getUserById(Long id);
    void createUser(User user);
    void updateUser(Long id, User updatedUser);
    void deleteUser(Long id);

}
