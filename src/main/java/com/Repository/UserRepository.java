package com.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.Entity.UserEntity;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {
    Optional<UserEntity> findByEmail(String email);
}
