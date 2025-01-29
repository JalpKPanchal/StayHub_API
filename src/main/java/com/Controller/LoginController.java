package com.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.Entity.UserEntity;
import com.Repository.UserRepository;

import java.util.Optional;

@RestController
@RequestMapping("/auth")
public class LoginController {

    @Autowired
    private UserRepository userRepository;

    // Login via PathVariable
    @GetMapping("/login/{email}/{password}")
    public Object login(@PathVariable String email, @PathVariable String password) {
        Optional<UserEntity> user = userRepository.findByEmail(email);

        if (user.isPresent()) {
            if (user.get().getPassword().equals(password)) {
                return "Login successful! Role: " + user.get().getRole();
            } else {
                return "Error: Incorrect password!";
            }
        } else {
            return "Error: User not found!";
        }
    }
}
