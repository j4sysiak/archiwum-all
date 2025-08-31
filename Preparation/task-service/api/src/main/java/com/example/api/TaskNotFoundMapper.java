package com.example.api;

import com.example.application.TaskNotFoundException;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class TaskNotFoundMapper implements ExceptionMapper<TaskNotFoundException> {
    @Override
    public Response toResponse(TaskNotFoundException e) {
        return Response.status(Response.Status.NOT_FOUND)
                .entity(e.getMessage())
                .type("text/plain")
                .build();
    }
}