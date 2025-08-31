
package com.example.api;

import com.example.application.TaskService;
import com.example.domain.Task;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import java.util.List;

@Path("/tasks")
public class TaskResource {

    private final TaskService taskService = new TaskService();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Task> getAll() {
        return taskService.getAllTasks();
    }
}
