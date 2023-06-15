package com.boosting.code.authMService.repositories;

import com.boosting.code.authMService.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User,Integer> {
}
