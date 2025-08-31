package com.example.application;

import com.example.domain.Task;

import java.util.List;
import java.util.Optional;

public interface TaskRepository {
    List<Task> findAll();
    void save(Task task);
    Optional<Task> findById(String id);
    void deleteById(String id);
    void update(Task task);
}