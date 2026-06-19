package com.endlessloop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class TodoService {

    @Autowired
    private TodoRepository todoRepository;

    // 1. Tüm görevleri listeleme mantığı
    public List<Todo> getAllTodos() {
        return todoRepository.findAll();
    }

    // 2. Yeni görev ekleme mantığı
    public Todo createTodo(Todo todo) {
        return todoRepository.save(todo);
    }

    // 3. Görev güncelleme mantığı
    public Optional<Todo> updateTodo(Long id, Todo todoDetails) {
        return todoRepository.findById(id)
                .map(existingTodo -> {
                    existingTodo.setTitle(todoDetails.getTitle());
                    existingTodo.setCompleted(todoDetails.isCompleted());
                    return todoRepository.save(existingTodo);
                });
    }

    // 4. Görev silme mantığı
    public boolean deleteTodo(Long id) {
        return todoRepository.findById(id)
                .map(todo -> {
                    todoRepository.delete(todo);
                    return true;
                })
                .orElse(false);
    }
}