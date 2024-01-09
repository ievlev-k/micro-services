package ru.itmo.userserver.service;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ru.itmo.userserver.dto.request.UserRequest;
import ru.itmo.userserver.dto.response.UserResponse;
import ru.itmo.userserver.dto.update.UserUpdate;
import org.springframework.security.core.userdetails.UserDetails;
import ru.itmo.userserver.model.User;

import java.util.List;

public interface UserService {
    Page<UserResponse> getAllPage(Pageable pageable);

    List<UserResponse> getAllList();

    UserResponse findById(Long id);

    void save(UserRequest userRequest);

    void update(UserUpdate userUpdate);

    void deleteById(Long id);

    boolean userById(Long id);

    User findByUsername(String username);
}
