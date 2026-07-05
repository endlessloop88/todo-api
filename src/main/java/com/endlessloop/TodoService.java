package com.endlessloop;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TodoService {

    private final TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    /**
     * DTO'dan gelen temiz veriyi alır, Entity'ye dönüştürür ve kaydeder.
     */
    public void saveTodo(TodoRequest todoRequest) {
        Todo todo = new Todo();
        todo.setTitle(todoRequest.getTitle());
        todo.setCompleted(false);
        
        todoRepository.save(todo);
    }

    /**
     * Todo'yu güvenli ve kilitli bir şekilde tamamlandı yapar.
     */
    @Transactional
    public void completeTodo(Long todoId) {
        Todo todo = todoRepository.findByIdWithLock(todoId)
                .orElseThrow(() -> new RuntimeException("Todo bulunamadı!"));

        todo.setCompleted(true);
        todoRepository.save(todo);
    }
}