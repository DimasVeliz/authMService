package com.boosting.code.authMService.controllers;

import com.boosting.code.authMService.dtos.LoginDto;
import com.boosting.code.authMService.dtos.RegistrationDto;
import com.boosting.code.authMService.models.AuthServiceResponseDto;
import com.boosting.code.authMService.services.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class authController {
    private final IUserService userService;

    @PostMapping
    public ResponseEntity<AuthServiceResponseDto> createUser(@RequestBody RegistrationDto registrationDto){
        AuthServiceResponseDto serviceResponse = userService.createUser(registrationDto);
        return serviceResponse!=null?new ResponseEntity<>(serviceResponse,HttpStatus.OK): new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PostMapping
    public ResponseEntity<AuthServiceResponseDto> loginUser(@RequestBody LoginDto loginDto){
        AuthServiceResponseDto serviceResponse = userService.loginUser(loginDto);
        return serviceResponse!=null?new ResponseEntity<>(serviceResponse,HttpStatus.OK): new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PostMapping
    public ResponseEntity<String> validateToken(@RequestBody String tokenToValidate){
        String serviceResponse= userService.validateToken(tokenToValidate);
        return new ResponseEntity<>(serviceResponse,HttpStatus.OK);
    }
}
