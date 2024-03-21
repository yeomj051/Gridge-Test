package com.gridge.GridgeTest.repository;

import com.gridge.GridgeTest.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
