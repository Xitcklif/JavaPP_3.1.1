package com.example.javapp_311_2;

import com.example.javapp_311_2.model.User;
import com.example.javapp_311_2.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class DBInit {

    @Autowired
    private UserRepository userService;

    @PostConstruct
    public void createNewUsersOnStart() {
        userService.save(new User("Andrey", "Ivanov", "ai@mail.ru", "54325"));
        userService.save(new User("Sergey", "Petrov", "sp@mail.ru", "home"));
        userService.save(new User("Vladimir", "Putin", "vp@mail.ru", "car"));
        userService.save(new User("Alexander", "Lukoshenko", "al@mail.ru", "789546"));
        userService.save(new User("Anton", "Pavlov", "ap@mail.ru", "airplane"));
    }
}
