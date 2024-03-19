package com.gridge.GridgeTest.dto;

public enum Status {
    ACTIVE("활성화"),      //해당 엔터티가 현재 활성화되어 있는 상태입니다.
    INACTIVE("비활성화"),   //해당 엔터티가 현재 비활성화되어 있는 상태입니다.
    DELETED("삭제"),      //해당 엔터티가 삭제되었거나 더 이상 사용되지 않는 상태입니다.
    BLOCKED("차단"),      //해당 엔터티가 관리자에 의해 일시적으로 사용이 차단된 상태입니다.
    DORMANT("휴면");      //해당 엔터티가 일시적으로 사용이 중지된 상태입니다.
    private final String description;

    Status(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
