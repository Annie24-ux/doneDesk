package com.example.task_manager.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDateTime;


@Entity
@Table(name = "TASKS_TBL")
public class Task {

    @Id
    private int id;
    @JsonProperty("title")
    private String title;
    @JsonProperty("description")
    private String description;
    @JsonProperty("isComplete")
    private boolean isComplete;
    @JsonProperty("dueDate")
    private LocalDateTime dueDate;


    public Task() {
    }


//    public Task(int id, String title, String description, boolean isComplete, LocalDateTime dueDate) {
//        this.id = id;
//        this.title = title;
//        this.description = description;
//        this.isComplete = isComplete;
//        this.dueDate = dueDate;
//    }

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
