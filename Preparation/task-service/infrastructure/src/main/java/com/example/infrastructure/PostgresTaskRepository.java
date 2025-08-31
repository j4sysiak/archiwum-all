package com.example.infrastructure;

import com.example.application.TaskRepository;
import com.example.domain.Task;

import javax.sql.DataSource;
import java.sql.*;
import java.util.*;

public class PostgresTaskRepository implements TaskRepository {

    private final DataSource dataSource;

    public PostgresTaskRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public List<Task> findAll() {
        List<Task> tasks = new ArrayList<>();
        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement("SELECT id, title, description FROM tasks");
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                tasks.add(new Task(
                        rs.getString("id"),
                        rs.getString("title"),
                        rs.getString("description")
                ));
            }

        } catch (SQLException e) {
            throw new RuntimeException("Failed to fetch tasks", e);
        }
        return tasks;
    }

    @Override
    public Optional<Task> findById(String id) {
        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement("SELECT id, title, description FROM tasks WHERE id = ?")) {
            stmt.setString(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return Optional.of(new Task(
                        rs.getString("id"),
                        rs.getString("title"),
                        rs.getString("description")
                ));
            }
            return Optional.empty();
        } catch (SQLException e) {
            throw new RuntimeException("Failed to fetch task", e);
        }
    }

    @Override
    public void save(Task task) {
        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement("INSERT INTO tasks (id, title, description) VALUES (?, ?, ?)")) {
            stmt.setString(1, task.getId());
            stmt.setString(2, task.getTitle());
            stmt.setString(3, task.getDescription());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Failed to insert task", e);
        }
    }

    @Override
    public void update(Task task) {
        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement("UPDATE tasks SET title = ?, description = ? WHERE id = ?")) {
            stmt.setString(1, task.getTitle());
            stmt.setString(2, task.getDescription());
            stmt.setString(3, task.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Failed to update task", e);
        }
    }

    @Override
    public void deleteById(String id) {
        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement("DELETE FROM tasks WHERE id = ?")) {
            stmt.setString(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Failed to delete task", e);
        }
    }
}