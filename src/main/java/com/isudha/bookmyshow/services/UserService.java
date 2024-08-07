package com.isudha.bookmyshow.services;

import com.isudha.bookmyshow.models.User;
import com.isudha.bookmyshow.repositories.UserRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService {
    private UserRepo userRepo;

    public User createUser(String username, String password){
        return userRepo.save(new User(username, password));
    }

    public Optional<User> findUserByUsername(String username){
        return userRepo.findByUsername(username);
    }
}
