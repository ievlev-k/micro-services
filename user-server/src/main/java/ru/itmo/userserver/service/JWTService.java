package ru.itmo.userserver.service;


import ru.itmo.userserver.model.User;

public interface JWTService {
    User getUserDetails(String token);
}
