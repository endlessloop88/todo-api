package com.endlessloop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.util.List;

@SpringBootApplication
@RestController
@RequestMapping("/api/todos")
@CrossOrigin(origins = "*")
public class TodoApiApplication {

    @Autowired
    private TodoService todoService;

    public static void main(String[] args) {
        SpringApplication.run(TodoApiApplication.class, args);
    }

    // GET ucu: http://localhost:8089/api/todos
    @GetMapping
    public List<Todo> getAllTodos() {
        return todoService.getAllTodos();
    }

    // POST ucu: http://localhost:8089/api/todos
    @PostMapping
    public ResponseEntity<Todo> createTodo(@Valid @RequestBody Todo todo) {
        Todo savedTodo = todoService.createTodo(todo);
        return ResponseEntity.ok(savedTodo);
    }

    // PUT ucu: http://localhost:8089/api/todos/{id}
    @PutMapping("/{id}")
    public ResponseEntity<Todo> updateTodo(@PathVariable Long id, @Valid @RequestBody Todo todo) {
        Todo updated = todoService.updateTodo(id, todo);
        return ResponseEntity.ok(updated);
    }

    // DELETE ucu: http://localhost:8089/api/todos/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTodo(@PathVariable Long id) {
        todoService.deleteTodo(id);
        return ResponseEntity.ok("Gorev basariyla silindi. ID: " + id);
    }
}