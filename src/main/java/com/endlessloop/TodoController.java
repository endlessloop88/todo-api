package com.endlessloop;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/todos")
public class TodoController {

    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    /**
     * Yeni bir Todo oluşturur (DTO ve Validation korumalı)
     */
    @PostMapping
    public ResponseEntity<String> createTodo(@Valid @RequestBody TodoRequest todoRequest) {
        todoService.saveTodo(todoRequest);
        return ResponseEntity.ok("Todo başarıyla ve güvenli bir şekilde oluşturuldu!");
    }

    /**
     * Güvenli ve Pessimistic Lock'lı Todo tamamlama endpoint'i
     */
    @PatchMapping("/{id}/complete")
    public ResponseEntity<String> completeTodo(@PathVariable Long id) {
        todoService.completeTodo(id);
        return ResponseEntity.ok("Todo başarıyla ve güvenli bir şekilde tamamlandı!");
    }
}