package com.taskmanager.taskmanager.Repository;

import com.taskmanager.taskmanager.Entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task,Long> {
    List<Task> findByAssignedToId(Long userId);
}
