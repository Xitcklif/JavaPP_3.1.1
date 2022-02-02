package com.example.javapp_311_2.controller;

import com.example.javapp_311_2.model.User;
import com.example.javapp_311_2.service.UserService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
public class AdminController {

    private final UserService userService;

    public AdminController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String openUserPage(Model model) {
        model.addAttribute("users", userService.findAll());
        return "users/usersPage";
    }

    @GetMapping("/create")
    public String createPage(Model model) {
        model.addAttribute("user", new User());
        return "users/createPage";
    }

    @PostMapping()
    public String newUser(@ModelAttribute("user") User user) {
        userService.save(user);
        return "redirect:/";
    }
}
