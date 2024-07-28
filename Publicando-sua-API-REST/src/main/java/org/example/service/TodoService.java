package org.example.service;

import org.example.model.Task;
import org.example.model.User;
import org.example.repository.TaskRepository;
import org.example.repository.UserRepository;
import org.example.to.TaskTO;
import org.example.to.TaskWithUserTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TodoService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    TaskRepository taskRepository;

    public ResponseEntity<List<Task>> getAllTasksByUser(UUID id) {
        User user = userRepository.findById(id).orElse(null);

        if (user == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(user.getTodoList(), HttpStatus.OK);
    }

    public ResponseEntity<Task> findTaskById(Long id) {
        Task task = taskRepository.findById(id).orElse(null);

        if (task == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(task, HttpStatus.OK);
    }

    public ResponseEntity<Task> createTask(TaskWithUserTO task) {
        User user = userRepository.findById(task.getUserId()).orElse(null);

        if (user == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Task newTask = null;

        newTask.setTitle(task.getTitle());
        newTask.setDescription(task.getDescription());

        user.addTask(newTask);

        return new ResponseEntity<>(newTask, HttpStatus.OK);
    }

    public ResponseEntity<Task> updateTask(Long id, TaskTO task) {
        Task updateTask = taskRepository.findById(id).orElse(null);

        if (updateTask == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        updateTask.setTitle(task.getTitle());
        updateTask.setDescription(task.getDescription());

        return new ResponseEntity<>(updateTask, HttpStatus.OK);
    }

    public ResponseEntity deleteTask(Long id) {
        Task task = taskRepository.findById(id).orElse(null);

        if (task == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        taskRepository.delete(task);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
