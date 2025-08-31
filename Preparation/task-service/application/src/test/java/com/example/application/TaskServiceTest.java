package com.example.application;

import com.example.domain.Task;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TaskServiceTest {

    private TaskService taskService;

    @BeforeEach
    void setUp() {
        TaskRepository fakeRepo = new InMemoryTaskRepository(); // dodamy za chwilę
        taskService = new TaskService(fakeRepo);

        // dane testowe
        taskService.addTask(new Task("1", "Zadanie 1", "Opis 1"));
        taskService.addTask(new Task("2", "Zadanie 2", "Opis 2"));
    }

    @Test
    void shouldReturnAllTasks() {
        List<Task> tasks = taskService.getAllTasks();
        assertEquals(2, tasks.size());
    }

    @Test
    void shouldReturnTaskById() {
        Task task = taskService.getTaskById("1");
        assertEquals("Zadanie 1", task.getTitle());
    }

    @Test
    void shouldThrowExceptionWhenTaskNotFound() {
        assertThrows(TaskNotFoundException.class, () -> {
            taskService.getTaskById("999");
        });
    }

    @Test
    void shouldAddNewTask() {
        taskService.addTask(new Task("3", "Zadanie 3", "Opis 3"));
        assertEquals(3, taskService.getAllTasks().size());
    }

    @Test
    void shouldUpdateTask() {
        Task updated = new Task("2", "Nowy tytuł", "Nowy opis");
        taskService.updateTask(updated);
        Task result = taskService.getTaskById("2");
        assertEquals("Nowy tytuł", result.getTitle());
    }

    @Test
    void shouldDeleteTask() {
        taskService.deleteTask("1");
        assertEquals(1, taskService.getAllTasks().size());
    }
}