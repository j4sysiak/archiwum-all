package com.example.application;

import com.example.domain.Task;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import jakarta.inject.Singleton;

@Singleton
public class InMemoryTaskRepository implements TaskRepository {

    private final Map<String, Task> storage = new ConcurrentHashMap<>();

    @Override
    public List<Task> findAll() {
        return new ArrayList<>(storage.values());
    }

    @Override
    public Optional<Task> findById(String id) {
        return Optional.ofNullable(storage.get(id));
    }

    @Override
    public void save(Task task) {
        storage.put(task.getId(), task);
    }

    @Override
    public void update(Task task) {
        if (!storage.containsKey(task.getId())) {
            throw new TaskNotFoundException("Task with ID " + task.getId() + " not found");
        }
        storage.put(task.getId(), task);
    }

    @Override
    public void deleteById(String id) {
        if (!storage.containsKey(id)) {
            throw new TaskNotFoundException("Task with ID " + id + " not found");
        }
        storage.remove(id);
    }
}