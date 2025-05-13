package com.taskmanager.taskmanager.Controller;

import com.taskmanager.taskmanager.Entity.User;
import com.taskmanager.taskmanager.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    public UserService userService;
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/insertuser")
    public User InsertUser(@RequestBody User user)
    {
        return userService.InsertUser(user);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/displayuser")
    public List<User> DisplayUser() {
        return userService.DisplayUser();
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping("/deleteuser/{id}")
    public void DeleteUser(@PathVariable Long id) {
        userService.DeleteUser(id);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/login")
    public User loginUser(@RequestBody User loginRequest) {
        String username = loginRequest.getEmail();
        String password = loginRequest.getPassword();

        User user = userService.findByEmail(username);

        if (user != null && user.getPassword().equals(password)) {
            return user; // Successful login
        } else {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Invalid username or password");
        }
    }

}
