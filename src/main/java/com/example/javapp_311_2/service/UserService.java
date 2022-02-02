package com.example.javapp_311_2.service;

import com.example.javapp_311_2.model.User;
import com.example.javapp_311_2.repo.UserRepository;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository ur;

    public UserService(UserRepository ur) {
        this.ur = ur;
    }

    public User findById(Long id) {
        Optional<User> userFromDb = ur.findById(id);
        return userFromDb.orElse(new User());
    }

    public Iterable<User> findAll() {
        return ur.findAll();
    }

    public void save(User user) {
        ur.save(user);
    }

    public boolean deleteById(Long id) {
        if (ur.findById(id).isPresent()) {
            ur.deleteById(id);
            return true;
        }

        return false;
    }
}
