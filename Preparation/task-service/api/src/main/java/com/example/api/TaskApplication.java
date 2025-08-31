package com.example.api;

import com.example.application.InMemoryTaskRepository;
import com.example.application.TaskRepository;
import com.example.infrastructure.PostgresTaskRepository;
import com.zaxxer.hikari.HikariDataSource;
import org.glassfish.hk2.utilities.binding.AbstractBinder;
import jakarta.ws.rs.ApplicationPath;
import org.glassfish.jersey.server.ResourceConfig;

@ApplicationPath("/task-service")
public class TaskApplication extends ResourceConfig {

    public TaskApplication() {
        register(TaskResource.class);
        register(TaskNotFoundMapper.class);
        register(ConstraintViolationMapper.class);
        register(org.glassfish.jersey.server.validation.ValidationFeature.class);
        register(org.glassfish.jersey.jackson.internal.jackson.jaxrs.json.JacksonJaxbJsonProvider.class);

        // na produkcji
        register(new AbstractBinder() {
            @Override
            protected void configure() {
                HikariDataSource ds = new HikariDataSource();
                ds.setJdbcUrl("jdbc:postgresql://localhost:5432/tasksdb");
                ds.setUsername("postgres");
                ds.setPassword("admin");
                ds.setDriverClassName("org.postgresql.Driver");

                bind(new PostgresTaskRepository(ds)).to(TaskRepository.class);
            }
        });

        // 👉 Rejestracja implementacji TaskRepository:
        /*
                 register(new AbstractBinder() {
            @Override
            protected void configure() {
                bind(new InMemoryTaskRepository()).to(TaskRepository.class);
            }
        });
        */

    }

}