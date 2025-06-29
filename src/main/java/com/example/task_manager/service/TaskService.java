package com.example.task_manager.service;

import com.example.task_manager.repository.TaskRepository;
import com.example.task_manager.model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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

}


