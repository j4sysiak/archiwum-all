package com.example.infrastructure;

import com.example.application.TaskNotFoundException;
import com.example.application.TaskRepository;
import com.example.domain.Task;

import javax.sql.DataSource;
import java.sql.*;
import java.util.*;

public class JdbcTaskRepository implements TaskRepository {

    private final DataSource dataSource;

    public JdbcTaskRepository(DataSource dataSource) {
        this.dataSource = dataSource;
        createTableIfNotExists();
    }

    private void createTableIfNotExists() {
        try (Connection connection = dataSource.getConnection();
             Statement stmt = connection.createStatement()) {

            stmt.execute("""
                CREATE TABLE IF NOT EXISTS tasks (
                    id VARCHAR(50) PRIMARY KEY,
                    title VARCHAR(255) NOT NULL,
                    description TEXT
                )
            """);
        } catch (SQLException e) {
            throw new RuntimeException("Failed to create table", e);
        }
    }

    @Override
    public List<Task> findAll() {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement ps = connection.prepareStatement("SELECT * FROM tasks");
             ResultSet rs = ps.executeQuery()) {

            List<Task> tasks = new ArrayList<>();
            while (rs.next()) {
                tasks.add(new Task(
                        rs.getString("id"),
                        rs.getString("title"),
                        rs.getString("description")
                ));
            }
            return tasks;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Optional<Task> findById(String id) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement ps = connection.prepareStatement("SELECT * FROM tasks WHERE id = ?")) {

            ps.setString(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return Optional.of(new Task(
                            rs.getString("id"),
                            rs.getString("title"),
                            rs.getString("description")
                    ));
                }
                return Optional.empty();
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void save(Task task) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement ps = connection.prepareStatement("INSERT INTO tasks (id, title, description) VALUES (?, ?, ?)")) {

            ps.setString(1, task.getId());
            ps.setString(2, task.getTitle());
            ps.setString(3, task.getDescription());
            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Task task) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement ps = connection.prepareStatement("UPDATE tasks SET title = ?, description = ? WHERE id = ?")) {

            ps.setString(1, task.getTitle());
            ps.setString(2, task.getDescription());
            ps.setString(3, task.getId());
            int updated = ps.executeUpdate();
            if (updated == 0) throw new TaskNotFoundException("Task with ID " + task.getId() + " not found");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteById(String id) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement ps = connection.prepareStatement("DELETE FROM tasks WHERE id = ?")) {

            ps.setString(1, id);
            int deleted = ps.executeUpdate();
            if (deleted == 0) throw new TaskNotFoundException("Task with ID " + id + " not found");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}