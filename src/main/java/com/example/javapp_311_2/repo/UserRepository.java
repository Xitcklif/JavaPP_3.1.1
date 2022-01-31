package com.example.javapp_311_2.repo;

import com.example.javapp_311_2.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface UserRepository extends CrudRepository<User, Long> {
}
