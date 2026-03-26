package com.example.demo.repository;

import com.example.demo.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Todo向け永続化アクセスの抽象。CRUDやページングなどはJpaRepositoryから継承する。
 */
public interface TodoRepository extends JpaRepository<Todo, Long> {
}