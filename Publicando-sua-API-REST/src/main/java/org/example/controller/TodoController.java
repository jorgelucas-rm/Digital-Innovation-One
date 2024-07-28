package org.example.controller;

import org.example.model.Task;
import org.example.model.User;
import org.example.service.TodoService;
import org.example.to.TaskTO;
import org.example.to.TaskWithUserTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping("/todo")
public class TodoController {
    @Autowired
    TodoService todoService;

    @GetMapping("/{id}")
    public ResponseEntity<List<Task>> getAllTasksByUser(@PathVariable("id") UUID id){
        return todoService.getAllTasksByUser(id);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Task> findTaskById(@PathVariable("id") Long id){
        return todoService.findTaskById(id);
    }

    @PostMapping("/{id}")
    public ResponseEntity<Task> createTask(@RequestBody TaskWithUserTO task){
        return todoService.createTask(task);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable("id") Long id, @RequestBody TaskTO task){
        return todoService.updateTask(id, task);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteTask(@PathVariable("id") Long id){
        return todoService.deleteTask(id);
    }
}
