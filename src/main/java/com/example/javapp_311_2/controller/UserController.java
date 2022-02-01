package com.example.javapp_311_2.controller;

import com.example.javapp_311_2.model.User;
import com.example.javapp_311_2.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class UserController {

    private final UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/{id}")
    public String showUser(@PathVariable("id") long id, Model model) {
        model.addAttribute("user", userRepository.findById(id).get());
        return "users/userPage";
    }

    @PostMapping("/update/{id}")
    public String updateUser(@PathVariable("id") long id,
                             @ModelAttribute("user") User user) {

        userRepository.save(user);
        return "redirect:/user/" + id;
    }

    @PostMapping("/remove/{id}")
    public String deleteUser(@PathVariable("id") long id) {
        userRepository.delete(userRepository.findById(id).get());
        return "redirect:/";
    }
}
