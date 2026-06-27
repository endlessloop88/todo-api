package com.endlessloop;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@RestController
@RequestMapping("/api/todos")
public class TodoController {

    @Autowired
    private TodoRepository todoRepository;

    // 1. Yeni Görev Ekleme
    @PostMapping
    @SuppressWarnings("null")
    public Todo createTodo(@RequestBody Todo todo) {
        return todoRepository.save(todo);
    }

    // 2. TÜM GÖREVLERİ LİSTELEME (GET)
    @GetMapping
    public List<Todo> getAllTodos() {
        return todoRepository.findAll();
    }

    // 3. TAMAMLANMIŞ GÖREVLERİ LİSTELEME (GET)
    @GetMapping("/completed")
    public List<Todo> getCompletedTodos() {
        return todoRepository.findByCompletedTrue();
    }

    // 4. GÖREVİ GÜNCELLEME (PUT)
    @PutMapping("/{id}")
    @SuppressWarnings("null")
    public Todo updateTodo(@PathVariable Long id, @RequestBody Todo todoDetails) {
        Todo todo = todoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Güncellenecek görev bulunamadı! ID: " + id));
        
        todo.setTitle(todoDetails.getTitle());
        todo.setCompleted(todoDetails.isCompleted());
        
        return todoRepository.save(todo);
    }

    // 5. GÖREVİ SİLME (DELETE)
    @DeleteMapping("/{id}")
    @SuppressWarnings("null")
    public String deleteTodo(@PathVariable Long id) {
        Todo todo = todoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Silinecek görev bulunamadı! ID: " + id));
        
        todoRepository.delete(todo);
        return "ID: " + id + " olan görev başarıyla silindi!";
    }
}