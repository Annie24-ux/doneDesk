package com.example.task_manager.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;


@Entity
@Table(name = "TASKS_TBL")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 255, nullable = false)
    @NotBlank(message = "Title is required")
    private String title;

    @Column(length = 1000)
    private String description;

    private boolean isComplete;

    private LocalDateTime dueDate;

    public Task() {
    }

    public Task(int id, String title, String description, boolean isComplete, LocalDateTime dueDate) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.isComplete = isComplete;
        this.dueDate = dueDate;
    }


    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public LocalDateTime getDueDate() {
        return dueDate;
    }

    public boolean isComplete() {
        return isComplete;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setComplete(boolean complete) {
        isComplete = complete;
    }

    public void setDueDate(LocalDateTime dueDate) {
        this.dueDate = dueDate;
    }
}
