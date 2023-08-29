package com.example.springbootcrud.controller;

import com.example.springbootcrud.model.User;
import com.example.springbootcrud.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller

public class UserController {

    private final UserServiceImpl userServiceImpl;

    @Autowired
    public UserController(UserServiceImpl userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }

    @GetMapping("/users")
    public String listUsers(Model model) {
        model.addAttribute("users", userServiceImpl.getAllUsers());
        return "index";
    }

    @GetMapping("/users/new")
    public String createUserForm(Model model) {
        model.addAttribute("user", new User());
        return "new";
    }

    @PostMapping("/users")
    public String createUser(@ModelAttribute User user) {
        userServiceImpl.createUser(user);
        return "redirect:/users";
    }

    @GetMapping("/users/{id}/edit")
    public String editUserForm(@PathVariable("id") Long id,
                           Model model) {
        userServiceImpl.getUserById(id).ifPresent(user -> model.addAttribute("user", user));
        return "edit";
    }

    @PostMapping("/users/{id}")
    public String updateUser(@PathVariable("id") Long id, @ModelAttribute User updatedUser) {
        userServiceImpl.updateUser(id, updatedUser);
        return "redirect:/users";
    }

    @PostMapping("/users/{id}/delete")
    public String deleteUser(@PathVariable("id") Long id) {
        userServiceImpl.deleteUser(id);
        return "redirect:/users";
    }


}
