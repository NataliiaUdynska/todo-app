package com.example.todo_app.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String description;

    private boolean completed = false;

    @Enumerated(EnumType.STRING)
    private Priority priority = Priority.LOW;

    public Priority getPriority() { return priority; }
    public void setPriority(Priority priority) { this.priority = priority; }

    @Column(name = "created_at", updatable = false )
    private LocalDateTime createdAt;

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    // Устанавливаем время при создании/ Set the time when created
    public Task() {
        this.createdAt = LocalDateTime.now();
    }

    public Task(String description) {
        this.description = description;
        this.createdAt = LocalDateTime.now();
    }

    // Геттеры и сеттеры
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public boolean isCompleted() { return completed; }
    public void setCompleted(boolean completed) { this.completed = completed; }

    @Override
    public String toString() {
        return (completed ? "✅ " : "▢ ") + description;
    }
}