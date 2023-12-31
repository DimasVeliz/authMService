package com.boosting.code.authMService.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RegistrationDto {
    private String userName;
    private String password;
    private String email;
}
