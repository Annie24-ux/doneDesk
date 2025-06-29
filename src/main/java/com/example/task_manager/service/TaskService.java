package com.example.task_manager.service;

import com.example.task_manager.repository.TaskRepository;
import com.example.task_manager.model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public Task patchTask(Integer id, Map<String, Object> updates){
        Task task = taskRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Task not found. "));

        if (updates.containsKey("title")) {
            Object titleValue = updates.get("title");
            if (titleValue != null) {
                task.setTitle(titleValue.toString());
            } else {
                throw new IllegalArgumentException("Title cannot be null");
            }
        }


        if(updates.containsKey("description")){
            task.setDescription((String) updates.get("description"));
        }

        if (updates.containsKey("isComplete")) {
            task.setComplete(Boolean.parseBoolean((String) updates.get("isComplete")));
        }
        return taskRepository.save(task);
    }

}


