package com.gridge.GridgeTest.dto;

import com.gridge.GridgeTest.entity.UserInfo;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.core.user.OAuth2User;

import java.util.Collection;
import java.util.Map;

@Getter
@NoArgsConstructor
public class UserPrincipalDto implements UserDetails, OAuth2User{
    private static final long serialVersionUID = 1L;
    private UserInfo user;
    private Map<String, Object> attributes;

    public UserPrincipalDto(UserInfo user) {
        this.user = user;
    }

    // OAuth2.0 로그인시 사용
    public UserPrincipalDto(UserInfo user, Map<String, Object> attributes) {
        this.user = user;
        this.attributes = attributes;
    }

    public UserInfo getUser() {
        return user;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public String getUsername() {
        return String.valueOf(user.getUserId());
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public Map<String, Object> getAttributes() {
        return attributes;
    }

    @Override
    public String getName() {
        return String.valueOf(user.getUserId());
    }
}
