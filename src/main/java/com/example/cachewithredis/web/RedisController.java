package com.example.cachewithredis.web;

import com.example.cachewithredis.model.User;
import com.example.cachewithredis.repository.RedisUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "user")
public class RedisController {

    private RedisUserRepository userRepository;

    @Autowired
    public RedisController(RedisUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping
    public User save(@RequestBody User user) {
        userRepository.save(user);
        return user;
    }

    @GetMapping("/")
    public User getUser() {
        return new User();
    }

    @GetMapping
    public List list() {
        return userRepository.findAll();
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable String id) {
        return userRepository.findById(id);
    }

    @PutMapping
    public User update(@RequestBody User user) {
        userRepository.update(user);
        return user;
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable String id) {
        userRepository.delete(id);
        return id;
    }
}
