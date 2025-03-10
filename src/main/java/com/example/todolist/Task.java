package com.example.todolist;

/**
 * Represents a single Task with ID, title, and description.
 */
public class Task {
    private int id;
    private String title;
    private String description;

    // Constructor for existing task (loaded from DB)
    public Task(int id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }

    // Constructor for new task (DB will auto-assign an ID)
    public Task(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
}
