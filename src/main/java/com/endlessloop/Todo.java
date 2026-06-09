package com.endlessloop;

public class Todo {
    private Long id;
    private String title;
    private boolean completed;

    // Boş Constructor (Spring'in verileri işleyebilmesi için şart)
    public Todo() {
    }

    // Dolu Constructor (Yeni görevleri oluşturmak için)
    public Todo(Long id, String title, boolean completed) {
        this.id = id;
        this.title = title;
        this.completed = completed;
    }

    // GETTER ve SETTER Metotları
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
}