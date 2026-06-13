package com.endlessloop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@SpringBootApplication
@RestController
@RequestMapping("/api/todos")
@CrossOrigin(origins = "*") 
public class TodoApiApplication {

    private final TodoRepository todoRepository;

    public TodoApiApplication(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(TodoApiApplication.class, args);
    }

    // 1. Tüm Görevleri Listele
    @GetMapping
    public List<Todo> getAllTodos() {
        return todoRepository.findAll();
    }

    // 2. Yeni Görev Ekle
    @PostMapping
    public Todo createTodo(@RequestBody Todo todo) {
        return todoRepository.save(todo);
    }

    // 3. Görevi Güncelle
    @PutMapping("/{id}")
    public Todo updateTodo(@PathVariable Long id, @RequestBody Todo todoDetails) {
        Todo todo = todoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Görev bulunamadı! ID: " + id));
        
        todo.setTitle(todoDetails.getTitle());
        todo.setCompleted(todoDetails.isCompleted());
        
        return todoRepository.save(todo);
    }

    // 4. Görevi Sil
    @DeleteMapping("/{id}")
    public String deleteTodo(@PathVariable Long id) {
        Todo todo = todoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Görev bulunamadı! ID: " + id));
        
        todoRepository.delete(todo);
        return id + " ID'li görev başarıyla silindi!";
    }
}