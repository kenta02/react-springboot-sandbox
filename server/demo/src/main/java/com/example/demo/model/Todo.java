package com.example.demo.model;

import jakarta.persistence.*;

/**
 * タスクエンティティ。永続化テーブルの1レコードに対応し、
 * フロントとAPI間で状態を保持するための最小構成を提供する。
 */
@Entity
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private boolean done;

    public Todo() {
    }

    /**
     * 新規Todoを生成する。未完了状態で初期化される。
     *
     * @param title タスク名
     */
    public Todo(String title) {
        this.title = title;
        this.done = false;
    }

    /**
     * DB上の識別子を取得する。
     *
     * @return TodoのID
     */
    public Long getId() {
        return id;
    }

    /**
     * エンティティ識別子を手動で設定する（テストやマイグレーション用）。
     *
     * @param id 設定するID
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * タスク名を取得する。
     *
     * @return タスク名
     */
    public String getTitle() {
        return title;
    }

    /**
     * タスク名を設定する。
     *
     * @param title タスク名
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 完了状態を取得する。
     *
     * @return true=完了, false=未完了
     */
    public boolean isDone() {
        return done;
    }

    /**
     * 完了状態を更新する。
     *
     * @param done 完了状態
     */
    public void setDone(boolean done) {
        this.done = done;
    }
}