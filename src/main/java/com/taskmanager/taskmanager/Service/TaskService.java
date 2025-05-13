package com.taskmanager.taskmanager.Service;

import com.taskmanager.taskmanager.Entity.Task;
import com.taskmanager.taskmanager.Entity.User;
import com.taskmanager.taskmanager.Repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    // Insert task into the repository
    public Task insertTask(Task task) {
        return taskRepository.save(task);
    }

    public List<Task> displayTask()
    {
        return taskRepository.findAll();
    }

    public List<Task> displayTaskByAssignedToId(Long id)
    {
        return taskRepository.findByAssignedToId(id);
    }

    public void deleteTask(Long id)
    {
        taskRepository.deleteById(id);
    }
}
