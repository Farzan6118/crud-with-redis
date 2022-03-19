package com.example.cachewithredis.Controller;

import com.example.cachewithredis.model.User;
import com.example.cachewithredis.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(value = "user")
public class UserController {

    private final UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("ping")
    public String ping() {
        return "PONG";
    }

    @GetMapping
    public User newUser() {
        return new User();
    }

    @GetMapping("list")
    public Iterable<User> listUsers() {
        return userRepository.findAll();
    }

    @GetMapping("{id}")
    public Optional<User> getUserById(@PathVariable String id) {
        return userRepository.findById(id);
    }

    @GetMapping("count")
    public Long countUsers() {
        return userRepository.count();
    }

    @PostMapping
    public void saveUser(@RequestBody User user) {
        userRepository.save(user);
    }

    @DeleteMapping()
    public void deleteUser(@RequestBody User user) {
        userRepository.delete(user);
    }
}
