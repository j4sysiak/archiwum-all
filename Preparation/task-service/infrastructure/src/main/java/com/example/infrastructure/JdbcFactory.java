package com.example.infrastructure;

import com.example.application.TaskRepository;
import org.postgresql.Driver;
import com.zaxxer.hikari.*;

public class JdbcFactory {
    public static TaskRepository create() {
        try {
            Class.forName("org.postgresql.Driver"); // wymagane w Tomcacie

            HikariConfig config = new HikariConfig();
            config.setJdbcUrl("jdbc:postgresql://localhost:5432/tasksdb");
            config.setUsername("postgres"); // ← zamień jeśli masz innego
            config.setPassword("admin"); // ← zamień jeśli masz inne hasło
            //config.setDriverClassName("org.postgresql.Driver");

            HikariDataSource ds = new HikariDataSource(config);
            return new JdbcTaskRepository(ds); // ✅ nie getConnection()
        } catch (Exception e) {
            throw new RuntimeException("Failed to connect to PostgreSQL", e);
        }
    }
}