package com.example.javapp_311_2.controller;

import com.example.javapp_311_2.model.User;
import com.example.javapp_311_2.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public String showUser(@PathVariable("id") long id, Model model) {
        model.addAttribute("user", userService.findById(id));
        return "users/userPage";
    }

    @PostMapping("/update/{id}")
    public String updateUser(@PathVariable("id") long id,
                             @ModelAttribute("user") User user) {

        userService.save(user);
        return "redirect:/";
    }

    @PostMapping("/remove/{id}")
    public String deleteUser(@PathVariable("id") long id) {
        userService.deleteById(id);
        return "redirect:/";
    }
}
