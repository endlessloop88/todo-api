package com.endlessloop;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "todo")
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Gorev basligi bos birakilamaz!")
    private String title;

    private boolean completed;

    // PostgreSQL'de user_id adında bir Foreign Key (ilişki kolonu) oluşturur
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = true)
    private User user;

    // 1. Boş Constructor (JPA için zorunlu)
    public Todo() {
    }

    // 2. Parametreli Constructor
    public Todo(String title, boolean completed) {
        this.title = title;
        this.completed = completed;
    }

    // --- GETTER VE SETTER METOTLARI ---

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}