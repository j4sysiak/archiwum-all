package com.example.api;

import com.example.application.TaskNotFoundException;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

import java.util.HashMap;
import java.util.Map;

@Provider
public class NotFoundMapper implements ExceptionMapper<TaskNotFoundException> {

    @Override
    public Response toResponse(TaskNotFoundException ex) {
        Map<String, String> error = new HashMap<>();
        error.put("error", ex.getMessage());

        return Response.status(Response.Status.NOT_FOUND)
                .entity(error)
                .type("application/json")
                .build();
    }
}