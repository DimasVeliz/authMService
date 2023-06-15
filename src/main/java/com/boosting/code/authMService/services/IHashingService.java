package com.boosting.code.authMService.services;

public interface IHashingService {

    String hashPassword(String plainPassword);
    boolean comparePasswords(String original, String hashed);
}
