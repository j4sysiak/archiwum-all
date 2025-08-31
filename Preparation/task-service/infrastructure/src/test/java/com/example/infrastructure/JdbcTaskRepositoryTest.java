package com.example.infrastructure;

import com.example.application.TaskRepository;
import com.example.application.TaskNotFoundException;
import com.example.domain.Task;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.junit.jupiter.api.*;

import javax.sql.DataSource;
import java.sql.*;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class JdbcTaskRepositoryTest {

    private static DataSource dataSource;
    private TaskRepository repository;

    @BeforeAll
    static void initDb() throws Exception {
        Class.forName("org.postgresql.Driver");

        HikariConfig config = new HikariConfig();
        config.setJdbcUrl("jdbc:postgresql://localhost:5432/tasksdb_test");
        config.setUsername("postgres");
        config.setPassword("admin");
        config.setMaximumPoolSize(1); // mały pool wystarczy na testy

        dataSource = new HikariDataSource(config);

        try (Connection conn = dataSource.getConnection();
             Statement stmt = conn.createStatement()) {
            stmt.execute("""
                DROP TABLE IF EXISTS tasks;
                CREATE TABLE tasks (
                    id VARCHAR(50) PRIMARY KEY,
                    title VARCHAR(255) NOT NULL,
                    description TEXT
                )
            """);
        }
    }

    @BeforeEach
    void setUp() {
        repository = new JdbcTaskRepository(dataSource);
    }

    @AfterAll
    static void tearDown() throws Exception {
        if (dataSource instanceof HikariDataSource ds) {
            ds.close();
        }
    }

    @Test
    void shouldSaveAndFindTask() {
        Task task = new Task("test166", "Z tytułem66", "Z opisem66");
        repository.save(task);
        Task found = repository.findById("test166").orElseThrow();
        assertEquals("Z tytułem66", found.getTitle());
    }


    @Test
    void shouldUpdateTask() {
        Task task = new Task("test2", "Tytuł", "Opis");
        repository.save(task);
        task.setTitle("Zmieniony");
        repository.update(task);
        Task updated = repository.findById("test2").orElseThrow();
        assertEquals("Zmieniony", updated.getTitle());
    }


    @Test
    void shouldDeleteTask() {
        Task task = new Task("test3", "Do usunięcia", "...");
        repository.save(task);
        repository.deleteById("test3");
        assertTrue(repository.findById("test3").isEmpty());
    }

    @Test
    void shouldThrowWhenNotFound() {
        assertThrows(TaskNotFoundException.class, () -> {
            repository.deleteById("nie-ma");
        });
    }

    @Test
    void shouldListAllTasks() {
        repository.save(new Task("a", "t1", "d1"));
        repository.save(new Task("b", "t2", "d2"));
        List<Task> list = repository.findAll();
        assertTrue(list.size() >= 2); // zależy od stanu bazy
    }
}