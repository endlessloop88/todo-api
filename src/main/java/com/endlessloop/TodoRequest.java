package com.endlessloop;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class TodoRequest {

    @NotBlank(message = "Todo başlığı boş olamaz!")
    @Size(min = 3, max = 100, message = "Todo başlığı en az 3, en fazla 100 karakter olmalıdır!")
    private String title;

    // Getter ve Setter metotları
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}