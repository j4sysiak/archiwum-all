
package com.example.domain;

import java.time.LocalDate;

public class Task {
    private String id;
    private String title;
    private String description;
    private LocalDate dueDate;

    public Task(String id, String title, String description, LocalDate dueDate) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
    }

    public String getId() { return id; }
    public String getTitle() { return title; }
    public String getDescription() { return description; }
    public LocalDate getDueDate() { return dueDate; }
}
