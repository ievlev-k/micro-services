package ru.itmo.userserver.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.itmo.userserver.dto.request.LoginRequest;
import ru.itmo.userserver.dto.request.UserRequest;
import ru.itmo.userserver.dto.response.UserResponse;
import ru.itmo.userserver.mapper.UserMapper;
import ru.itmo.userserver.model.JWTToken;
import ru.itmo.userserver.model.Role;
import ru.itmo.userserver.service.AuthorizationService;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import ru.itmo.userserver.service.JWTService;
import ru.itmo.userserver.service.UserService;
import ru.itmo.userserver.util.Util;

import java.util.UUID;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/v1/auth")
@Profile("!test")
public class AuthController {
    private final AuthorizationService authorizationService;
    private final JWTService jwtService;
    private final UserService userService;
    private final UserMapper userMapper;

    private UUID getUserLogin(String token, Role role){
        System.out.println("token: " + token);
        if (token != null && token.length() >= 7) {
            var user = jwtService.getUserDetails(Util.getBearerToken(token));
            if (user.getRole().equals(role))
                return user.getId();
        }
        return null;
    }

    @Autowired
    public AuthController(AuthorizationService authorizationService, JWTService jwtService, UserService userService, UserMapper userMapper) {
        this.authorizationService = authorizationService;
        this.jwtService = jwtService;
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @PostMapping("/login")
    public Mono<ResponseEntity<JWTToken>> loginUser(@RequestBody LoginRequest loginRequest) {
        var token = authorizationService.createJWTToken(loginRequest);
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("Authorization",
                "Bearer " + token.getValue());
        return Mono.just(ResponseEntity.ok()
                .headers(responseHeaders)
                .body(token));
    }

    @PostMapping("/signup")
    public Mono<ResponseEntity<UserResponse>> signUp(@RequestBody UserRequest userRequest) {

        if (userRequest.getRole().equals(Role.ADMIN)) {
            return Mono.just(ResponseEntity.status(HttpStatus.FORBIDDEN).body(null));
        }
        
        return Mono.just(ResponseEntity.status(HttpStatus.CREATED)
                .body(userService.save(userMapper.userRequestToUser(userRequest))));
    }

    @PostMapping("/checkAdminPermission")
    @ResponseBody
    public Boolean checkAdminPermission(@RequestBody String token){
        return getUserLogin(token, Role.ADMIN) != null;
    }

    @PostMapping("/checkUserPermission")
    @ResponseBody
    public Boolean checkUserPermission(@RequestBody String token) {
        return getUserLogin(token, Role.USER) != null;
    }
}