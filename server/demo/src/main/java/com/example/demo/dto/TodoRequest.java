package com.example.demo.dto;

import jakarta.validation.constraints.NotBlank;

// フロントからの受け口となるリクエストモデル
public class TodoRequest {
    // バリデーション: 空白不可
    @NotBlank(message = "title is required")
    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}