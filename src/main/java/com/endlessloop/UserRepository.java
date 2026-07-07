package com.endlessloop;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import jakarta.persistence.LockModeType;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    // Pessimistic Lock: Bu kullanıcıyı veri tabanından çekerken o satırı tamamen kilitler.
    // Başka hiçbir thread, bu işlem bitene kadar (Transaction bitene kadar) o kullanıcıyı güncelleyemez!
    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @Query("SELECT u FROM User u WHERE u.id = :id")
    Optional<User> findByIdWithLock(Long id);
}