package com.gridge.GridgeTest.service;

import com.gridge.GridgeTest.dto.AuthProvider;
import com.gridge.GridgeTest.dto.User.OAuth2UserInfoDto;
import com.gridge.GridgeTest.dto.User.OAuth2UserInfoFactory;
import com.gridge.GridgeTest.dto.UserPrincipalDto;
import com.gridge.GridgeTest.entity.UserInfo;
import com.gridge.GridgeTest.exception.OAuth2AuthenticationProcessingException;
import com.gridge.GridgeTest.repository.UserInfoRepository;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Getter
public class CommonOAuth2UserService {

    @Autowired
    private UserInfoRepository userInfoRepository;

    @Transactional
    public UserInfo registerNewUser(OAuth2UserInfoDto oAuth2UserInfo) {
        UserInfo user = oAuth2UserInfo.toEntity();
        return userInfoRepository.save(user);
    }

    @Transactional
    protected OAuth2User processOAuth2User(OAuth2UserRequest oAuth2UserRequest, OAuth2User oAuth2User) {
        OAuth2UserInfoDto oAuth2UserInfo = OAuth2UserInfoFactory.getOAuth2UserInfo(oAuth2UserRequest.getClientRegistration().getRegistrationId(), oAuth2User.getAttributes());
        if(StringUtils.isEmpty(oAuth2UserInfo.getProviderId())) {
            throw new OAuth2AuthenticationProcessingException("Email not found from OAuth2 provider");
        }
        Optional<UserInfo> userOptional = userInfoRepository.findByAuthProviderAndAuthProviderId(AuthProvider.valueOf(oAuth2UserInfo.getProvider()), oAuth2UserInfo.getProviderId());
        UserInfo user = null;
        if(userOptional.isPresent()) {
            user = userOptional.get();
        }
        else {
            user = registerNewUser(oAuth2UserInfo);
        }
        return new UserPrincipalDto(user, oAuth2User.getAttributes());
    }
}
