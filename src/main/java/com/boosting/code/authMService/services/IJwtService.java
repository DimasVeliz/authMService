package com.boosting.code.authMService.services;

import com.boosting.code.authMService.models.User;

public interface IJwtService {
    String generateToken(User userDetails);

    String generateRefreshToken(User userDetails);

    boolean isTokenValid(String token, User userDetails);

    boolean isTokenValidByName(String token, String userNamePassed);

    boolean isTokenExpired(String token);
}
