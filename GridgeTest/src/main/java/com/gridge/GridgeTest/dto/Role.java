package com.gridge.GridgeTest.dto;

public enum Role {
    SUBSCRIBED_USER("구독한 사용자"),
    REGULAR_USER("일반 사용자"),
    ADMIN("관리자");

    private final String description;

    Role(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
