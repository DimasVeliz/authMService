package com.boosting.code.authMService.services.impl;

import com.boosting.code.authMService.dtos.LoginDto;
import com.boosting.code.authMService.dtos.RegistrationDto;
import com.boosting.code.authMService.dtos.UserDto;
import com.boosting.code.authMService.models.AuthServiceResponseDto;
import com.boosting.code.authMService.models.User;
import com.boosting.code.authMService.repositories.IUserRepository;
import com.boosting.code.authMService.services.IJwtService;
import com.boosting.code.authMService.services.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements IUserService {

    private final IUserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final IJwtService jwtService;

    @Override
    public AuthServiceResponseDto createUser(RegistrationDto registrationDto) {
        var user = User.builder()
                .userName(registrationDto.getUserName())
                .email(registrationDto.getEmail())
                .password(passwordEncoder.encode(registrationDto.getPassword()))
                .uuid(UUID.randomUUID().toString())
                .build();
        var savedUser = userRepository.save(user);
        var jwtToken = jwtService.generateToken(user);
        var refreshToken = jwtService.generateRefreshToken(user);

        return AuthServiceResponseDto.builder()
                .userDto(UserDto.builder().email(savedUser.getEmail()).username(savedUser.getUserName()).build()
                )
                .refreshToken(refreshToken)
                .token(jwtToken)
                .build();
    }

    @Override
    public AuthServiceResponseDto loginUser(LoginDto loginDto) {

        var savedUser = userRepository.findByEmail(loginDto.getEmail())
                .orElse(null);

        var matchesPassword = passwordEncoder.matches(loginDto.getPassword(), savedUser.getPassword());
        if (!matchesPassword)
            return null;

        var jwtToken = jwtService.generateToken(savedUser);

        var refreshToken = jwtService.generateRefreshToken(savedUser);

        return AuthServiceResponseDto.builder()
                .userDto(UserDto.builder().email(savedUser.getEmail()).username(savedUser.getUserName()).build()
                )
                .refreshToken(refreshToken)
                .token(jwtToken)
                .build();
    }

    @Override
    public String validateToken(String tokenToValidate) {
        return !jwtService.isTokenExpired(tokenToValidate) ? "VALID_TOKEN" : "INVALID_TOKEN";
    }
}
