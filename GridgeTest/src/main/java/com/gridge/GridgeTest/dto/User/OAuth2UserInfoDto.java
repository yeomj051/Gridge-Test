package com.gridge.GridgeTest.dto.User;

import com.gridge.GridgeTest.entity.UserInfo;

public interface OAuth2UserInfoDto {
    String getProvider();
    String getProviderId();
    String getName();
    UserInfo toEntity();
}
