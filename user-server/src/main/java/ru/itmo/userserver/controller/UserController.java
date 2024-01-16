package ru.itmo.userserver.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
//import org.springframework.security.access.prepost.PreAuthorize;
//import org.springframework.security.access.prepost.PreAuthorize;
//import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.itmo.userserver.dto.request.UserRequest;
import ru.itmo.userserver.dto.response.UserResponse;
import ru.itmo.userserver.dto.update.UserUpdate;
import ru.itmo.userserver.mapper.UserMapper;
import ru.itmo.userserver.model.Role;
import ru.itmo.userserver.service.JWTService;
import ru.itmo.userserver.service.UserService;
import ru.itmo.userserver.util.Util;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/v1/user")
public class UserController {
    private final UserService userService;
    private final JWTService jwtService;
    private final UserMapper userMapper;


    private UUID getUserLogin(String token, Role role){
        if (token != null && token.length() >= 7) {
            var user = jwtService.getUserDetails(Util.getBearerToken(token));
            if (user.getRole().equals(role))
                return user.getId();
        }
        return null;
    }

    @GetMapping
//    @PreAuthorize("hasAnyAuthority('ADMIN','USER')")
    public Flux<UserResponse> getAllUsers(@RequestParam(defaultValue = "0")
                                              @Min(value = 0, message = "must not be less than zero")
                                              int page,
                                          @RequestParam(defaultValue = "5")
                                              @Max(value = 50, message = "must not be more than 50 characters")
                                              int size) {
        return userService.getAllPage(PageRequest.of(page, size));
    }

    @GetMapping("/all")
//    @PreAuthorize("hasAnyAuthority('ADMIN','USER')")
    public Flux<UserResponse> getAllUsers() {
//        System.out.println(token);
        return userService.getAllList();
    }
//
    @GetMapping("/{id}")
//    @PreAuthorize("hasAnyAuthority('ADMIN','USER')")
    public Mono<UserResponse> getUserById(@PathVariable UUID id) {
        return userService.findById(id);
    }
//
    @PostMapping
//    @PreAuthorize("hasAuthority('ADMIN')")
    public Mono<ResponseEntity<UserResponse>> addUser(@RequestHeader("Authorization") String token, @RequestBody UserRequest userRequest) {
        
        if (getUserLogin(token, Role.ADMIN) == null) {
            return Mono.just(ResponseEntity.status(HttpStatus.FORBIDDEN).body(null));
        }
        System.out.println("pass check permission");
        return Mono.just(ResponseEntity.status(HttpStatus.CREATED)
                .body(userService.save(userMapper.userRequestToUser(userRequest))));
    }
//
    @PutMapping
//    @PreAuthorize("hasAnyAuthority('ADMIN','USER')")
    public Mono<Void> updateUser(@Valid @RequestBody Mono<UserUpdate> userUpdate) {
        return userService.update(userUpdate);
    }
//
    @DeleteMapping("/{id}")
//    @PreAuthorize("hasAnyAuthority('ADMIN','USER')")
    public Mono<Void> deleteUser(@PathVariable UUID id) {
        return userService.deleteById(id);
    }
//
//    @PostMapping("/find-user")
//    public User findByUsername(@RequestBody String username){
//        return userService.findByUsername(username);
//    }
////
//    @PostMapping("/find-by-id")
//    public boolean findUserById(@RequestBody Long id){
//        return userService.userById(id);
//    }
}
