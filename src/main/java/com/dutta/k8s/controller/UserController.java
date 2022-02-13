package com.dutta.k8s.controller;

import com.dutta.k8s.entity.User;
import com.dutta.k8s.repo.UserRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {


    private UserRepository userRepository;
//Constructor Injection
    public UserController(UserRepository repository) {
        this.userRepository = repository;
    }

    @PostMapping("/addUser")
    public String saveUser(@RequestBody User user)
    {
        userRepository.save(user);
        return "User added sucessfully :"+user.getId();
    }

    @GetMapping("/userById")
    public User getUserById(@PathVariable Long id)
    {
       return userRepository.getById(id);
    }

    @GetMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable Long id) {
        userRepository.deleteById(id);
        return "Deleted User Successfully::"+id;
    }

    @GetMapping("/users")
    public List<User> getUsers() {
        return userRepository.findAll();
    }


}
