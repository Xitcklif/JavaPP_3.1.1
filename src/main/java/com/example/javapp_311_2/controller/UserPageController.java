package com.example.javapp_311_2.controller;

import com.example.javapp_311_2.model.User;
import com.example.javapp_311_2.repo.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
public class UserPageController {

    private final UserRepository userRepository;

    public UserPageController(UserRepository userRepository) {
        this.userRepository = userRepository;
        this.userRepository.save(new User("Andrey", "Ivanov", "ai@mail.ru", "54325"));
        this.userRepository.save(new User("Sergey", "Petrov", "sp@mail.ru", "home"));
        this.userRepository.save(new User("Vladimir", "Putin", "vp@mail.ru", "car"));
        this.userRepository.save(new User("Alexander", "Lukoshenko", "al@mail.ru", "789546"));
        this.userRepository.save(new User("Anton", "Pavlov", "ap@mail.ru", "airplane"));
    }

    @GetMapping()
    public String openUserPage(Model model) {
        Iterable<User> users = userRepository.findAll();
        model.addAttribute("users", users);
        return "users/usersPage";
    }

    @GetMapping("/{id}")
    public String showUser(@PathVariable("id") long id, Model model) {
        model.addAttribute("user", userRepository.findById(id).get());
        return "users/userPage";
    }

    @GetMapping("/create")
    public String createPage(Model model) {
        model.addAttribute("user", new User());
        return "users/createPage";
    }

    @PostMapping()
    public String createNewUser(@ModelAttribute("user") User user) {
        userRepository.save(user);
        return "redirect:/";
    }

    @PostMapping("update/{id}")
    public String updateUser(@PathVariable("id") long id,
                             @ModelAttribute("user") User user) {

        userRepository.save(user);
        return "redirect:/";
    }

    @PostMapping("/remove/{id}")
    public String deleteUser(@PathVariable("id") long id) {

        userRepository.delete(userRepository.findById(id).get());
        return "redirect:/";
    }
}
