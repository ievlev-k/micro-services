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

public interface UserService {
    Flux<UserResponse> getAllPage(Pageable pageable);

    Flux<UserResponse> getAllList();

    Mono<UserResponse> findById(Long id);
//
//    UserResponse findById(Long id);
//
    Mono<Void> save(Mono<UserRequest> userRequest);
//
    Mono<Void> update(Mono<UserUpdate> userUpdate);
//
    Mono<Void> deleteById(Long id);
//
//    boolean userById(Long id);
//
//    User findByUsername(String username);
}
