package com.endlessloop;

import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;
import java.util.Optional;

public interface TodoRepository extends JpaRepository<Todo, Long> {

    // Mevcut metotların kalabilir
    List<Todo> findByCompletedTrue();
    List<Todo> findByCompletedFalse();

    // Yeni eklediğimiz kilitli arama metodu:
    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @Query("SELECT t FROM Todo t WHERE t.id = :id")
    Optional<Todo> findByIdWithLock(@Param("id") Long id);
}