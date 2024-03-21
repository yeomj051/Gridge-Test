package com.gridge.GridgeTest.dto.User;

import com.gridge.GridgeTest.dto.AuthProvider;
import com.gridge.GridgeTest.entity.UserInfo;
import java.util.Map;

public class KakaoUserInfoDto implements OAuth2UserInfoDto {

    private Map<String, Object> attributes;
    private Map<String, Object> kakaoAccount;
    private Map<String, Object> kakaoProfile ;

    public KakaoUserInfoDto(Map<String, Object> attributes) {
        this.attributes = attributes;
        this.kakaoAccount = (Map) attributes.get("kakao_account");
        this.kakaoProfile = (Map) kakaoAccount.get("profile");
    }
    @Override
    public String getProvider() {
        return "kakao";
    }

    @Override
    public String getProviderId() {
        return attributes.get("id").toString();
    }

    @Override
    public String getName() {
        return "";
    }

    public UserInfo toEntity(){
        return UserInfo.builder()
                .name(getName())
                .provider(AuthProvider.valueOf(getProvider()))
                .providerId(getProviderId())
                .build();
    }
}
