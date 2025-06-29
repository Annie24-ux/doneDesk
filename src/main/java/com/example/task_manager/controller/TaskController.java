package com.example.task_manager.controller;

import com.example.task_manager.model.Task;
import com.example.task_manager.repository.TaskRepository;
import com.example.task_manager.service.TaskService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tasks")
@CrossOrigin(origins = "http://localhost:63342")


public class TaskController {
    private TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;

    }

    @GetMapping()
    public ResponseEntity<List<Task>> getAllTasks() {
        List<Task> tasks = taskService.get();
        return ResponseEntity.ok(tasks);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Task>> getTaskById(@PathVariable Integer id) {
        Optional<Task> taskById = taskService.get(id);

        return taskById.map(task -> ResponseEntity.ok(Optional.of(task))).orElseGet(() -> ResponseEntity.notFound().build());
    }


    @PostMapping
    public ResponseEntity<Task> createTask(@RequestBody Task task) {

        taskService.save(task);
        return ResponseEntity.status(HttpStatus.CREATED).body(task);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Task> editTask(@PathVariable Integer id, @RequestBody Task newTask) {
        try {
            Task task = taskService.updateTask(id, newTask);
            return ResponseEntity.ok(task);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Task> deleteTask(@PathVariable Integer id) {
        Optional<Task> doneTask = taskService.get(id);

        if(doneTask.isPresent()) {
            taskService.remove(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
