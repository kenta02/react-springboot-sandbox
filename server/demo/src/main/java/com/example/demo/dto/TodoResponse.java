package com.example.demo.dto;

/**
 * APIからクライアントへ返却するTodo情報。内部エンティティと公開形式を分離する。
 */
public class TodoResponse {
    private Long id;
    private String title;
    private boolean done;

    /**
     * 変換済みTodoを生成する。
     *
     * @param id    ID
     * @param title タスク名
     * @param done  完了状態
     */
    public TodoResponse(Long id, String title, boolean done) {
        this.id = id;
        this.title = title;
        this.done = done;
    }

    /**
     * TodoIDを取得する。
     *
     * @return ID
     */
    public Long getId() {
        return id;
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
     * 完了状態を取得する。
     *
     * @return 完了フラグ
     */
    public boolean isDone() {
        return done;
    }
}