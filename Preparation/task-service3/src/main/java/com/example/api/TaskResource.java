package com.example.api;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import java.util.List;

@Path("/tasks")
public class TaskResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<String> getAllTasks() {
        return List.of("Zadanie 1", "Zadanie 2", "Zadanie 3");
    }
}
