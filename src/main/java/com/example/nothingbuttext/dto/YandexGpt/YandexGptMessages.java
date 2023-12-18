package com.example.nothingbuttext.dto.YandexGpt;

import lombok.*;


public class YandexGptMessages {
    private String role;
    private String message;
    public YandexGptMessages(String role, String message) {
        this.role = role;
        this.message = message;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getRole() {
        return role;
    }

    public String getMessage() {
        return message;
    }
}
