package com.endlessloop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@RestController
@RequestMapping("/api/todos") // Tüm isteklerin ana adresi: localhost:8080/api/todos
public class TodoApiApplication {

	// Geçici hafıza (Veritabanı yerine kullanıyoruz)
	private final List<Todo> todoList = new ArrayList<>();
	private Long idCounter = 1L; // ID'leri otomatik 1, 2, 3 diye artırmak için

	public static void main(String[] args) {
		SpringApplication.run(TodoApiApplication.class, args);
	}

	// 1. TÜM GÖREVLERİ LİSTELE (GET) -> localhost:8080/api/todos
	@GetMapping
	public List<Todo> getAllTodos() {
		return todoList;
	}

	// 2. YENİ GÖREV EKLE (POST) -> localhost:8080/api/todos
	@PostMapping
	public Todo createTodo(@RequestBody Todo todo) {
		todo.setId(idCounter++); // Göreve otomatik ID veriyoruz
		todoList.add(todo);
		return todo;
	}

	// 3. GÖREVİ SİL (DELETE) -> localhost:8080/api/todos/1
	@DeleteMapping("/{id}")
	public String deleteTodo(@PathVariable Long id) {
		// Listede bu ID'ye sahip görevi bul ve sil
		boolean removed = todoList.removeIf(todo -> todo.getId().equals(id));
		
		if (removed) {
			return id + " numaralı görev başarıyla silindi!";
		} else {
			return id + " numaralı görev bulunamadı.";
		}
	}

	// 4. GÖREV DURUMUNU DEĞİŞTİR (PATCH) -> localhost:8080/api/todos/1
	@PatchMapping("/{id}")
	public Todo toggleTodoStatus(@PathVariable Long id) {
		for (Todo todo : todoList) {
			if (todo.getId().equals(id)) {
				// true ise false, false ise true yapar (Tersine çevirir)
				todo.setCompleted(!todo.isCompleted());
				return todo;
			}
		}
		return null; // Görev listede yoksa boş döner
	}
}