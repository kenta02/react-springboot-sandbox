package com.example.demo.service;

import com.example.demo.dto.TodoRequest;
import com.example.demo.model.Todo;
import com.example.demo.repository.TodoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * APIコントローラとリポジトリの橋渡しを行い、
 * Todoデータの操作ロジックを1か所で管理する。
 */
@Service
@Transactional
public class TodoService {
    private final TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    /**
     * Todoを全件取得する。
     *
     * @return 登録済みTodoのリスト
     */
    public List<Todo> findAll() {
        return todoRepository.findAll();
    }

    // IDでtodo取得（見つからない場合は例外）
    /**
     * 指定IDのTodoを取得する。存在しない場合は例外を投げる。
     *
     * @param id TodoのID
     * @return Todoエンティティ
     */
    public Todo findById(Long id) {
        return todoRepository.findById(id).orElseThrow(() -> new RuntimeException("Todo not found"));
    }

    /**
     * 新しいTodoを登録する。
     *
     * @param request Todo作成リクエスト
     * @return 保存済みTodo
     */
    public Todo create(TodoRequest request) {
        return todoRepository.save(new Todo(request.getTitle()));
    }

    /**
     * 既存Todoのタイトルを更新する。
     *
     * @param id      TodoのID
     * @param request 更新内容
     * @return 更新済みTodo
     */
    public Todo update(Long id, TodoRequest request) {
        Todo todo = findById(id);
        todo.setTitle(request.getTitle());
        return todoRepository.save(todo);
    }

    /**
     * Todoを削除する。
     *
     * @param id TodoのID
     */
    public void delete(Long id) {
        todoRepository.deleteById(id);
    }
}
