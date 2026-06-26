package com.endlessloop;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/api/todos")
public class TodoController {

    @Autowired
    private TodoRepository todoRepository;

    @PostMapping
    public Todo createTodo(@RequestBody Todo todo) {
        Todo savedTodo = todoRepository.save(todo);
        if (savedTodo == null) {
            throw new RuntimeException("Todo kaydedilemedi!");
        }
        return savedTodo;
    }
}