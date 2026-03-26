package com.example.demo.controller;

import com.example.demo.dto.TodoRequest;
import com.example.demo.model.Todo;
import com.example.demo.service.TodoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todos")
public class TodoController {
    private final TodoService service;

    public TodoController(TodoService service) {
        this.service = service;
    }

    @GetMapping
    public List<Todo> getAll() {
        return service.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    // 画面からの登録リクエストを受け取る
    public Todo create(@RequestBody @Valid TodoRequest request) {
        return service.create(request);
    }

    // /更新リクエスト
    @PutMapping("/{id}")
    public Todo update(@PathVariable Long id, @RequestBody @Valid TodoRequest request) {
        return service.update(id, request);
    }

    // 削除リクエスト
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}