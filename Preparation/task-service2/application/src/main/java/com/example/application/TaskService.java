
package com.example.application;

import com.example.domain.Task;

import java.time.LocalDate;
import java.util.List;

public class TaskService {

    public List<Task> getAllTasks() {
        return List.of(
            new Task("1", "Napisz kod", "Pierwszy endpoint REST", LocalDate.now().plusDays(1)),
            new Task("2", "Zrób kawę", "Bo programowanie", LocalDate.now().plusDays(2))
        );
    }
}
