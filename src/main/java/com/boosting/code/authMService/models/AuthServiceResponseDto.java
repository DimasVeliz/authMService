package com.boosting.code.authMService.models;

import com.boosting.code.authMService.dtos.UserDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthServiceResponseDto {
    String token;
    String refreshToken;
    UserDto userDto;
}
