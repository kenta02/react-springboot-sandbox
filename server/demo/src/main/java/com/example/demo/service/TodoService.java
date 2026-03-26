package com.example.demo.service;

import com.example.demo.dto.TodoRequest;
import com.example.demo.model.Todo;
import com.example.demo.repository.TodoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

// / 1) ビジネスロジック層: ControllerとRepositoryの中継と整形を担当
@Service
@Transactional
public class TodoService {
    // DI: Repositoryを注入
    private final TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    // 全件取得
    public List<Todo> findAll() {
        return todoRepository.findAll();
    }

    // IDでtodo取得（見つからない場合は例外）
    public Todo findById(Long id) {
        return todoRepository.findById(id).orElseThrow(() -> new RuntimeException("Todo not found"));
    }

    // タスク登録
    public Todo create(TodoRequest request) {
        return todoRepository.save(new Todo(request.getTitle()));
    }

    // タスク更新
    public Todo update(Long id, TodoRequest request) {
        Todo todo = findById(id);
        todo.setTitle(request.getTitle());
        return todoRepository.save(todo);
    }

    // タスク削除
    public void delete(Long id) {
        todoRepository.deleteById(id);
    }
}
