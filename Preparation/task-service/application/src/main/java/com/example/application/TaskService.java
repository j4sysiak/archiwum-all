package com.example.application;

import com.example.domain.Task;
import jakarta.ws.rs.NotFoundException;

import java.util.List;

public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public void addTask(Task task) {
        if (task.getId() == null || task.getId().isBlank()) {
            throw new IllegalArgumentException("Task ID is required");
        }
        if (task.getTitle() == null || task.getTitle().isBlank()) {
            throw new IllegalArgumentException("Task title is required");
        }
        taskRepository.save(task);
    }

    public Task getTaskById(String id) {
        return taskRepository.findById(id)
                .orElseThrow(() -> new TaskNotFoundException("Task with ID " + id + " not found"));
    }

    public void deleteTask(String id) {
        taskRepository.deleteById(id);
    }

    public void updateTask(Task task) {
        Task existing = getTaskById(task.getId());
        if (existing == null) {
            throw new NotFoundException("Task not found: " + task.getId());
        }
        if (task.getId() == null || task.getId().isBlank()) {
            throw new IllegalArgumentException("Task ID is required for update");
        }
        if (task.getTitle() == null || task.getTitle().isBlank()) {
            throw new IllegalArgumentException("Task title is required");
        }
        taskRepository.update(task);
    }

}