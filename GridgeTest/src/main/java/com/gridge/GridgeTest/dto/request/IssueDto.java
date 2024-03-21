package com.gridge.GridgeTest.dto.request;

import lombok.Getter;

import javax.validation.constraints.NotEmpty;

@Getter
public class IssueDto {
    private int userId;
    @NotEmpty(message = "refreshToken 을 입력해주세요.")
    private String refreshToken;
}