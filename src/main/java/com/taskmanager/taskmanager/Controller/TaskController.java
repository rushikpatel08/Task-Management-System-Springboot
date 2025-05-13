package com.taskmanager.taskmanager.Controller;

import com.taskmanager.taskmanager.Entity.Task;
import com.taskmanager.taskmanager.Entity.User;
import com.taskmanager.taskmanager.Service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200") // CORS setup for your frontend
@RestController
public class TaskController {

    @Autowired
    private TaskService taskService;

    // Mapping to POST tasks
    @PostMapping("/inserttask")
    public Task insertTask(@RequestBody Task task) {
        System.out.println("Received task: " + task);  // Logging the received task object
        return taskService.insertTask(task);
    }


    @GetMapping("/displaytask")
    public List<Task> DisplayUser() {
        return taskService.displayTask();
    }


    @GetMapping("/displaytaskbyassignedtoid/{id}")
    public List<Task> displayTaskByAssignedToId(@PathVariable Long id)
    {
        return taskService.displayTaskByAssignedToId(id);
    }

    @DeleteMapping("/deletetask/{id}")
    public void deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
    }
}