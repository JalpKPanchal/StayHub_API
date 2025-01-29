package com.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.Entity.UserEntity;
import com.Repository.UserRepository;

import java.util.Optional;

@RestController
@RequestMapping("/auth")
public class SignupController {

    @Autowired
    private UserRepository userRepository;

    // Signup API
    @GetMapping("/signup")
    public Object signup(@RequestBody UserEntity userEntity) {
        Optional<UserEntity> existingUser = userRepository.findByEmail(userEntity.getEmail());
        if (existingUser.isPresent()) {
            return "Error: Email already registered!";
        }

        userEntity.setRole("member"); // Default role is "member"
        userRepository.save(userEntity);
        return userEntity;
    }
}
