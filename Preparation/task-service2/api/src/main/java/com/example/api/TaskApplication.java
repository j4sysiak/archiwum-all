
package com.example.api;

import jakarta.ws.rs.ApplicationPath;
import org.glassfish.jersey.server.ResourceConfig;

@ApplicationPath("/api")
public class TaskApplication extends ResourceConfig {
    public TaskApplication() {
        packages("com.example.api");
    }
}
