package com.boosting.code.authMService.services;

import com.boosting.code.authMService.dtos.LoginDto;
import com.boosting.code.authMService.dtos.RegistrationDto;
import com.boosting.code.authMService.models.AuthServiceResponseDto;
import org.springframework.http.ResponseEntity;

public interface IUserService {
    AuthServiceResponseDto createUser(RegistrationDto registrationDto);

    AuthServiceResponseDto loginUser(LoginDto loginDto);

    ResponseEntity<String> validateToken(String tokenToValidate);
}
