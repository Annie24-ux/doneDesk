package com.example.task_manager.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.time.LocalDateTime;


@Entity
//@AllArgsConstructor
@Table(name = "TASK_TBL")
public class task {

    private int id;
    private String title;
    private String description;
    private boolean isComplete;
    private LocalDateTime dueDate;


    public task() {
    }


    public task(int id, String title, String description, boolean isComplete, LocalDateTime dueDate) {
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
