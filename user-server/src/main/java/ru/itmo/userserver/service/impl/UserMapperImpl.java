package ru.itmo.userserver.service.impl;

import org.springframework.stereotype.Service;
import ru.itmo.userserver.dto.request.UserRequest;
import ru.itmo.userserver.model.User;
import ru.itmo.userserver.service.UserMapper;

@Service
public class UserMapperImpl implements UserMapper {

    @Override
    public User convert(UserRequest userRequest) {
        System.out.println(userRequest.getUsername());
        System.out.println(userRequest.getEmail());
        System.out.println(userRequest.getLastName());
        return User.builder()
                .id(null)
                .username(userRequest.getUsername())
                .email(userRequest.getEmail())
                .firstName(userRequest.getFirstName())
                .lastName(userRequest.getLastName())
                .password(userRequest.getPassword())
                .phone(userRequest.getPhone())
                .role(userRequest.getRole())
                .room(userRequest.getRoom())
                .socialMedia(userRequest.getSocialMedia())
                .status(userRequest.getStatus())
                .build();
    }

    @Override
    public UserRequest convert(User user) {
        if(user == null) return null;
        return UserRequest.builder()
                .username(user.getUsername())
                .role(user.getRole())
                .build();
    }
}
