package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class Todo {
    // 主キー（Id）を自動生成
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // タスク名
    private String title;
    // 完了状態
    private boolean done;

    public Todo() {
    }

    // 初期化
    public Todo(String title) {
        this.title = title;
        this.done = false;
    }

    /**
     * Returns the ID of the Todo object.
     * 
     * @return the ID of the Todo object.
     */
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

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }
}