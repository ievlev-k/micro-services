package ru.itmo.userserver.service;

import ru.itmo.userserver.dto.request.LoginRequest;
import ru.itmo.userserver.model.JWTToken;

public interface AuthorizationService {
    JWTToken createJWTToken(LoginRequest user);
}
