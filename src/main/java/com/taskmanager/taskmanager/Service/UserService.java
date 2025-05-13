package com.taskmanager.taskmanager.Service;
import com.taskmanager.taskmanager.Entity.Task;
import com.taskmanager.taskmanager.Entity.User;
import com.taskmanager.taskmanager.Repository.TaskRepository;
import com.taskmanager.taskmanager.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User InsertUser(User user)
    {
        return userRepository.save(user);
    }

    public List<User> DisplayUser()
    {
        return userRepository.findAll();
    }

    public void DeleteUser(Long id)
    {
        userRepository.deleteById(id);
    }

    public User findByEmail(String email)
    {
        return userRepository.findByEmail(email);
    }


}
