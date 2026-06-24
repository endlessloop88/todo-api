package com.endlessloop;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {
    
    // completed alanı true olanları getirecek özel sorgu
    List<Todo> findByCompletedTrue();
    
    // completed alanı false olanları getirecek özel sorgu
    List<Todo> findByCompletedFalse();
}