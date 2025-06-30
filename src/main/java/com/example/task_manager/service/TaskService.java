package com.example.task_manager.service;

import com.example.task_manager.repository.TaskRepository;
import com.example.task_manager.model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class TaskService {

    @Autowired
    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> get() {
        taskRepository.findAll();
        return taskRepository.findAll();
    }


    public Optional<Task> get(Integer id) {
        return taskRepository.findById(id);

    }

    public void remove(Integer id) {
        taskRepository.deleteById(id);
    }

    public Task save(Task task) {
        if (task.getDueDate() == null) {
            task.setDueDate(LocalDateTime.now().plusDays(3));
        }
        return taskRepository.save(task);
    }

    public Task updateTask(Integer id, Task newTask) {
        return taskRepository.findById(id).map(task -> {
            task.setTitle(newTask.getTitle());
            task.setDescription(newTask.getDescription());
            task.setComplete(newTask.isComplete());
            return taskRepository.save(task);

        }).orElseThrow(() -> new RuntimeException("Task not found with id " + id));
    };

    public Task patchTask(Integer id, Map<String, Object> updates) {
        Task task = taskRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Task not found."));

        if (updates.containsKey("title")) {
            Object value = updates.get("title");
            if (value instanceof String title && !title.trim().isEmpty()) {
                task.setTitle(title);
            } else {
                throw new IllegalArgumentException("Title must be a non-empty string.");
            }
        }

        if (updates.containsKey("description")) {
            Object value = updates.get("description");
            if (value instanceof String description) {
                task.setDescription(description);
            } else {
                throw new IllegalArgumentException("Description must be a string.");
            }
        }

        if (updates.containsKey("isComplete")) {
            Object value = updates.get("isComplete");
            if (value instanceof Boolean boolVal) {
                task.setComplete(boolVal);
            } else if (value instanceof String strVal) {
                task.setComplete(Boolean.parseBoolean(strVal));
            } else {
                throw new IllegalArgumentException("isComplete must be a boolean or string (\"true\"/\"false\").");
            }
        }
        return taskRepository.save(task);
    }


}


