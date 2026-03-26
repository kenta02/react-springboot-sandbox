package com.example.demo.controller;

import com.example.demo.dto.TodoRequest;
import com.example.demo.model.Todo;
import com.example.demo.service.TodoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * HTTPリクエストを受け付け、TodoのCRUDを提供するREST APIエンドポイント。
 */
@RestController
@RequestMapping("/api/todos")
public class TodoController {
    private final TodoService service;

    public TodoController(TodoService service) {
        this.service = service;
    }

    /**
     * 全Todoを取得する。
     *
     * @return Todoのリスト
     */
    @GetMapping
    public List<Todo> getAll() {
        return service.findAll();
    }

    /**
     * 新しいTodoを作成するAPI。
     *
     * @param request 登録データ
     * @return 作成されたTodo
     */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Todo create(@RequestBody @Valid TodoRequest request) {
        return service.create(request);
    }

    /**
     * 既存Todoのタイトルを更新するAPI。
     *
     * @param id      更新対象ID
     * @param request 更新内容
     * @return 更新済みTodo
     */
    @PutMapping("/{id}")
    public Todo update(@PathVariable Long id, @RequestBody @Valid TodoRequest request) {
        return service.update(id, request);
    }

    /**
     * 指定IDのTodoを削除するAPI。
     *
     * @param id 削除対象ID
     */
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}