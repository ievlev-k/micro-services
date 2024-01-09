package ru.itmo.userserver.mapper;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import ru.itmo.userserver.dto.request.UserRequest;
import ru.itmo.userserver.dto.response.UserResponse;
import ru.itmo.userserver.dto.update.UserUpdate;
import ru.itmo.userserver.model.User;


import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class UserMapper {

    private final ModelMapper mapper;


    public UserResponse userToUserResponse(User user) {
        return mapper.map(user, UserResponse.class);
    }

    public User userRequestToUser(UserRequest request) {
        return mapper.map(request, User.class);
    }

    public User userUpdateToUser(UserUpdate update) {
        return mapper.map(update, User.class);
    }

    public List<UserResponse> userToUserResponseList(List<User> user) {
        return user
                .stream()
                .map(this::userToUserResponse)
                .collect(Collectors.toList());
    }

    public Page<UserResponse> userToUserResponsePage(Page<User> userPage) {
        return userPage
                .map(this::userToUserResponse);
    }
}
