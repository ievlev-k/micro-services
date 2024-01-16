package ru.itmo.userserver.service;

import ru.itmo.userserver.dto.request.UserRequest;
import ru.itmo.userserver.model.User;

public interface UserMapper {
    User convert(UserRequest userRequest);

    UserRequest convert(User user);
}
