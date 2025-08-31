package com.example.api;

import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;
import java.net.URI;

import com.example.application.TaskRepository;
import com.example.application.TaskService;
import com.example.domain.Task;
import com.example.infrastructure.JdbcFactory;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;
import java.util.UUID;

@Path("/tasks")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TaskResource {

    private final TaskService taskService;

    // Konstruktor produkcyjny dla Tomcata, korzysta z JdbcFactory
    public TaskResource() {
        TaskRepository repo = JdbcFactory.create();
        this.taskService = new TaskService(repo);
    }

    // Konstruktor testowy (np. do REST testów)
    @Inject
    public TaskResource(TaskRepository repository) {
        this.taskService = new TaskService(repository);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Task> getAll() {
        return taskService.getAllTasks();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Task getById(@PathParam("id") String id) {
        return taskService.getTaskById(id);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response add(@Valid TaskRequest req) {
        String id = UUID.randomUUID().toString();
        taskService.addTask(new Task(id, req.getTitle(), req.getDescription()));
        return Response.created(URI.create("/tasks/" + id)).build();
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void update(@PathParam("id") String id, @Valid TaskRequest req) {
        taskService.updateTask(new Task(id, req.getTitle(), req.getDescription()));
    }

    @DELETE
    @Path("/{id}")
    public void delete(@PathParam("id") String id) {
        taskService.deleteTask(id);
    }

}