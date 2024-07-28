package org.example.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String nome;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Task> todoList = new ArrayList<>();

    public void addTask(Task task){
        this.todoList.add(task);
    }
}