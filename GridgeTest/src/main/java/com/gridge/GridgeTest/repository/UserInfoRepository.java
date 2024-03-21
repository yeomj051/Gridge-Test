package com.gridge.GridgeTest.repository;

import com.gridge.GridgeTest.dto.AuthProvider;
import com.gridge.GridgeTest.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserInfoRepository extends JpaRepository<UserInfo, Integer> {

    Optional<UserInfo> findByUserId(Integer userId);
    Optional<UserInfo> findByAuthProviderAndAuthProviderId(AuthProvider authProvider, String authProviderId);
}
