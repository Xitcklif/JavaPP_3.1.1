package com.example.javapp_311_2.service;

import com.example.javapp_311_2.model.User;
import com.example.javapp_311_2.repo.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    private final UserRepository ur;

    public UserServiceImpl(UserRepository ur) {
        this.ur = ur;
    }

    @Override
    public User findById(Long id) {
        Optional<User> userFromDb = ur.findById(id);
        return userFromDb.orElse(new User());
    }

    @Override
    public Iterable<User> findAll() {
        return ur.findAll();
    }

    @Override
    public void save(User user) {
        ur.save(user);
    }

    @Override
    public void deleteById(Long id) {
        ur.deleteById(id);
    }
}
