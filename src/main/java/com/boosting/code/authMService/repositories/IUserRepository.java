package com.boosting.code.authMService.repositories;

import com.boosting.code.authMService.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IUserRepository extends JpaRepository<User,Integer> {
    Optional<User> findByEmail(String email);
}
