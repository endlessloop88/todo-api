package com.endlessloop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@SuppressWarnings("null")
public class TodoService {

    @Autowired
    private TodoRepository todoRepository;

    // Tüm görevleri listeleme (GET)
    public List<Todo> getAllTodos() {
        return todoRepository.findAll();
    }

    // Yeni görev ekleme (POST)
    public Todo createTodo(Todo todo) {
        return todoRepository.save(todo);
    }

    // Mevcut görevi güncelleme (PUT)
    public Todo updateTodo(Long id, Todo updatedTodo) {
        Todo existingTodo = todoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Gorev bulunamadi! ID: " + id));
        
        existingTodo.setTitle(updatedTodo.getTitle());
        existingTodo.setCompleted(updatedTodo.isCompleted());
        
        return todoRepository.save(existingTodo);
    }

    // Görev silme (DELETE)
    public void deleteTodo(Long id) {
        Todo existingTodo = todoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Silinecek gorev bulunamadi! ID: " + id));
        
        todoRepository.delete(existingTodo);
    }

    // Sadece tamamlanmış görevleri getiren servis metodu
    public List<Todo> getCompletedTodos() {
        return todoRepository.findByCompletedTrue();
    }

    // Sadece tamamlanmamış görevleri getiren servis metodu
    public List<Todo> getActiveTodos() {
        return todoRepository.findByCompletedFalse();
    }
} // Sınıfın en sonundaki kapatma parantezi