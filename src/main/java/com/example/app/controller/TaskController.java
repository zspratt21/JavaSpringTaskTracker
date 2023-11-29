package com.example.app.controller;

import com.example.app.model.Task;
import com.example.app.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    @Autowired
    private TaskRepository TaskRepository;

    @PostMapping
    public ResponseEntity<Task> createTask(@RequestBody Task Task) {
        Task savedTask = TaskRepository.save(Task);
        return ResponseEntity.ok(savedTask);
    }

    @GetMapping
    public ResponseEntity<List<Task>> getAllTasks() {
        return ResponseEntity.ok(TaskRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable Long id) {
        Optional<Task> Task = TaskRepository.findById(id);
        return Task.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable Long id, @RequestBody Task newTask) {
        if (Objects.equals(newTask.getId(), id)) {
            return TaskRepository.findById(id)
                    .map(Task -> {
                        Task.setName(newTask.getName());
                        Task.setDescription(newTask.getDescription());
                        Task.setIsCompleted(newTask.getIsCompleted());
                        return ResponseEntity.ok(TaskRepository.save(Task));
                    })
                    .orElseGet(() -> ResponseEntity.notFound().build());
        }
        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
        if (TaskRepository.existsById(id)) {
            TaskRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
