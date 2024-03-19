package com.gridge.GridgeTest.dto;

public enum OrderStatus {
    COMPLETED("완료"),    // 결제가 완료되어 정상적으로 처리된 상태입니다.
    PROCESSING("처리 중"), // 결제가 처리 중인 상태입니다.
    FAILED("실패");   //결제가 실패한 상태입니다.

    private final String description;

    OrderStatus(String description) {
        this.description = description;
    }
    public String getDescription() {
        return description;
    }
}
