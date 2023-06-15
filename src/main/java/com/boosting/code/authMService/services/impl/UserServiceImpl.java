package com.boosting.code.authMService.services.impl;

import com.boosting.code.authMService.dtos.LoginDto;
import com.boosting.code.authMService.dtos.RegistrationDto;
import com.boosting.code.authMService.models.AuthServiceResponseDto;
import com.boosting.code.authMService.repositories.IUserRepository;
import com.boosting.code.authMService.services.IJwtService;
import com.boosting.code.authMService.services.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements IUserService {

    private final IUserRepository userRepository;
    private final HashingServiceImpl hashingService;
    private final IJwtService jwtService;
    @Override
    public AuthServiceResponseDto createUser(RegistrationDto registrationDto) {
        return null;
    }

    @Override
    public AuthServiceResponseDto loginUser(LoginDto loginDto) {
        return null;
    }

    @Override
    public ResponseEntity<String> validateToken(String tokenToValidate) {
        return null;
    }
}
