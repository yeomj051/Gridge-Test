package com.gridge.GridgeTest.dto;

public enum ReportCategory {
    SPAM("스팸"),
    NUDE_IMAGES("나체 이미지 또는 성적 행위"),
    HATE_SPEECH("혐오 발언 또는 상징"),
    VIOLENCE("폭력 또는 위험한 단체"),
    ILLEGAL_PRODUCTS("불법 또는 규제 상품 판매"),
    INTELLECTUAL_PROPERTY("지식재산권 침해"),
    SUICIDE_OR_SELF_HARM("자살 또는 자해"),
    FRAUD_OR_FALSE_INFORMATION("사기 또는 거짓 정보"),
    DISLIKED_CONTENT("마음에 들지 않습니다");
    private final String description;

    ReportCategory(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
