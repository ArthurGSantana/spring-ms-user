package com.ms.user.model.dto;

import java.util.UUID;

public class EmailDto {
    private UUID userId;
    private String email;
    private String subject;
    private String text;

    public EmailDto(UUID userId, String email, String subject, String text) {
        this.userId = userId;
        this.email = email;
        this.subject = subject;
        this.text = text;
    }

    public EmailDto() {
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
