package com.example.todo_app.model;

public enum Priority {
    HIGH("high"),
    MEDIUM("medium"),
    LOW("low");

    private final String value;

    Priority(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}