package com.rest.webservices.restfulwebservices.Controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.rest.webservices.restfulwebservices.Exception.UserNotFountException;
import com.rest.webservices.restfulwebservices.user.User;
import com.rest.webservices.restfulwebservices.user.UserDaoService;

import jakarta.validation.Valid;

@RestController
public class UserController {

    @Autowired
    private UserDaoService userDaoService;

    @GetMapping("/users")
    public List<User> findAll() {
        return userDaoService.findAllUsers();
    }

    // @GetMapping("/users/{id}")
    // public User findUser(@PathVariable int id) {

    //     User user = userDaoService.findById(id);

    //     if (user == null)
    //         throw new UserNotFountException("User is not present with the ID: " + id);

    //     return user;
    // }

    @PostMapping("/users")
    public ResponseEntity<Object> saveUser(@Valid @RequestBody User user) {
        User savedUser = userDaoService.saveUser(user);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/user/{id}")
    public void deleteUser(@PathVariable int id) {

        userDaoService.DeleteUserById(id);
    }
}
