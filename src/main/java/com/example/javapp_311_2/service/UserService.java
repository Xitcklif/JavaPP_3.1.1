package com.example.javapp_311_2.service;

import com.example.javapp_311_2.model.User;

public interface UserService {

    User findById(Long id);
    Iterable<User> findAll();
    void save(User user);
    void deleteById(Long id);
}
