package com.boosting.code.authMService.services;

import com.boosting.code.authMService.dtos.LoginDto;
import com.boosting.code.authMService.dtos.RegistrationDto;
import com.boosting.code.authMService.models.AuthServiceResponseDto;

public interface IUserService {
    AuthServiceResponseDto createUser(RegistrationDto registrationDto);

    AuthServiceResponseDto loginUser(LoginDto loginDto);

    String validateToken(String tokenToValidate);
}
