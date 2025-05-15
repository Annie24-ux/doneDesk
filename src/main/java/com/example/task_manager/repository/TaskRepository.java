package com.example.task_manager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.task_manager.model.Task;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task, Integer> {

}
