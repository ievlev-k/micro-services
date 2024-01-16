package ru.itmo.userserver.service;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.itmo.userserver.dto.request.UserRequest;
import ru.itmo.userserver.dto.response.UserResponse;
import ru.itmo.userserver.dto.update.UserUpdate;
//import org.springframework.security.core.userdetails.UserDetails;
import ru.itmo.userserver.model.User;

import java.util.List;
import java.util.UUID;

public interface UserService {
    Flux<UserResponse> getAllPage(Pageable pageable);

    Flux<UserResponse> getAllList();

    Mono<UserResponse> findById(UUID id);
//
//    UserResponse findById(Long id);
//
    UserResponse save(User user);
//
    Mono<Void> update(Mono<UserUpdate> userUpdate);
//
    Mono<Void> deleteById(UUID id);

    User findByUsernameAndPassword(String login, String password);

    UUID createUser(User user);

    User findUserById(UUID id);
//
//    boolean userById(Long id);
//
//    User findByUsername(String username);
}
