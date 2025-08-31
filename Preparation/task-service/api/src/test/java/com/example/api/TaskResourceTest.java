package com.example.api;

import org.glassfish.hk2.utilities.binding.AbstractBinder;

import static jakarta.ws.rs.core.MediaType.APPLICATION_JSON;
import jakarta.ws.rs.core.GenericType;

import com.example.application.*;
import com.example.domain.Task;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.core.Application;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.jupiter.api.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TaskResourceTest extends JerseyTest {

    @Override
    protected Application configure() {
        InMemoryTaskRepository repo = new InMemoryTaskRepository();

        return new ResourceConfig()
                .register(TaskNotFoundMapper.class)
                .register(ConstraintViolationMapper.class)
                .register(org.glassfish.jersey.server.validation.ValidationFeature.class)
                .register(new AbstractBinder() {
                    @Override
                    protected void configure() {
                        bind(repo).to(TaskRepository.class);
                    }
                })
                .register(TaskResource.class) // po AbstractBinder!
                .packages("com.example.api");
    }

    @Test
    void shouldReturnEmptyListInitially() {
        Response response = target("/tasks").request().get();
        assertEquals(200, response.getStatus());
        List<?> tasks = response.readEntity(List.class);
        assertTrue(tasks.isEmpty());
    }

    @Test
    void shouldReturn404WhenTaskNotFound() {
        Response response = target("/tasks/xxx").request().get();
        assertEquals(404, response.getStatus()); // było 500, teraz 404
    }

    @Test
    void shouldListAllTasks() {
        // Dodaj 2 zadania
        target("/tasks").request()
                .post(Entity.entity(new TaskRequest("Task 1", "First"), MediaType.APPLICATION_JSON));
        target("/tasks").request()
                .post(Entity.entity(new TaskRequest("Task 2", "Second"), MediaType.APPLICATION_JSON));

        // Pobierz wszystkie
        List<Task> tasks = target("/tasks")
                .request(APPLICATION_JSON)
                .get(new GenericType<List<Task>>() {});

        assertEquals(2, tasks.size());
    }

    @Test
    void shouldAddAndGetTask() {
        TaskRequest task = new TaskRequest("Test title", "Test description");

        Response post = target("/tasks").request()
                .post(Entity.entity(task, MediaType.APPLICATION_JSON));
        assertEquals(201, post.getStatus());

        String path = post.getLocation().getPath(); // np. "/tasks/UUID"
        System.out.println("Resolved path: " + path); // debug

        Task fetched = target(path).request().get(Task.class);

        assertEquals("Test title", fetched.getTitle());
        assertEquals("Test description", fetched.getDescription());
    }

    @Test
    void shouldUpdateTask() {
        // Tworzymy zadanie przez TaskRequest
        TaskRequest createReq = new TaskRequest("Before", "...");
        Response postResponse = target("/tasks").request()
                .post(Entity.entity(createReq, MediaType.APPLICATION_JSON));

        String location = postResponse.getLocation().getPath(); // np. "/tasks/abcd-uuid"

        // Aktualizujemy je
        TaskRequest updateReq = new TaskRequest("After", "...");
        target(location).request()
                .put(Entity.entity(updateReq, MediaType.APPLICATION_JSON));

        // Pobieramy i sprawdzamy
        Task updated = target(location).request().get(Task.class);
        assertEquals("After", updated.getTitle());
    }

    @Test
    void shouldReturn404WhenUpdatingNonexistentTask() {
        TaskRequest req = new TaskRequest("Updated", "...");
        Response response = target("/tasks/non-existent-id").request()
                .put(Entity.entity(req, MediaType.APPLICATION_JSON));
        assertEquals(404, response.getStatus());
    }

    @Test
    void shouldDeleteTask() {
        // 1. Utwórz nowy task
        TaskRequest createReq = new TaskRequest("Delete me", "To be deleted");
        Response postResponse = target("/tasks").request()
                .post(Entity.entity(createReq, MediaType.APPLICATION_JSON));
        String location = postResponse.getLocation().getPath();

        // 2. Usuń go
        Response deleteResponse = target(location).request().delete();
        assertEquals(204, deleteResponse.getStatus());

        // 3. Spróbuj pobrać usunięty zasób
        Response getResponse = target(location).request().get();
        assertEquals(404, getResponse.getStatus());
    }

    @Test
    void shouldHandleDeletingNonExistentTaskGracefully() {
        Response response = target("/tasks/non-existent-id").request().delete();
        assertEquals(404, response.getStatus());
    }

    @Test
    void shouldRejectBlankTitle() {
        TaskRequest invalid = new TaskRequest("", "desc");
        Response response = target("/tasks").request()
                .post(Entity.entity(invalid, MediaType.APPLICATION_JSON));

        assertEquals(400, response.getStatus());
        String body = response.readEntity(String.class);
        assertTrue(body.contains("Title must not be blank"));
    }

    @Test
    void shouldRejectShortTitle() {
        TaskRequest invalid = new TaskRequest("a", "desc");
        Response response = target("/tasks").request()
                .post(Entity.entity(invalid, MediaType.APPLICATION_JSON));

        assertEquals(400, response.getStatus());
        String body = response.readEntity(String.class);
        assertTrue(body.contains("between 3 and 100 characters"));
    }

}