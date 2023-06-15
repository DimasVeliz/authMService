package com.boosting.code.authMService.services.impl;

import com.boosting.code.authMService.services.IHashingService;
import org.springframework.stereotype.Service;

@Service
public class HashingServiceImpl implements IHashingService {
    @Override
    public String hashPassword(String plainPassword) {
        return null;
    }

    @Override
    public boolean comparePasswords(String original, String hashed) {
        return false;
    }
}
