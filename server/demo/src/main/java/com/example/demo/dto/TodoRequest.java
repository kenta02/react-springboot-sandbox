package com.example.demo.dto;

import jakarta.validation.constraints.NotBlank;

/**
 * クライアントからPOST/PUTで送信されるTodo作成・更新の入力情報を表現する。
 * バリデーションはController層で既存チェックを行うことを想定する。
 */
public class TodoRequest {
    @NotBlank(message = "title is required")
    private String title;

    /**
     * 入力されたタスク名を取得する。
     *
     * @return タスク名
     */
    public String getTitle() {
        return title;
    }

    /**
     * 入力されたタスク名をセットする。
     *
     * @param title タスク名
     */
    public void setTitle(String title) {
        this.title = title;
    }
}