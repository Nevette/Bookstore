package com.nevette.bookstore.controllers;

import com.nevette.bookstore.dtos.CreateUserDTO;
import com.nevette.bookstore.entities.User;
import com.nevette.bookstore.repositories.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class UserController {

    private final UserRepository userRepository;

    protected UserController(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @PostMapping
    public ResponseEntity addUser(@RequestBody CreateUserDTO request){
        User user = new User();
        user.setCreationDate(LocalDateTime.now());
        user.setEmail(request.getEmail());
        user.setName(request.getName());
        user.setPassword(request.getPassword());
        userRepository.save(user);
        return ResponseEntity.noContent().build();
    }
}
