package ru.itmo.userserver.contriller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
//import org.springframework.security.access.prepost.PreAuthorize;
//import org.springframework.security.access.prepost.PreAuthorize;
//import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.itmo.userserver.dto.request.UserRequest;
import ru.itmo.userserver.dto.response.UserResponse;
import ru.itmo.userserver.dto.update.UserUpdate;
import ru.itmo.userserver.model.User;
import ru.itmo.userserver.service.UserService;
import ru.itmo.userserver.service.impl.UserDetailsServiceImpl;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/v1/user")
public class UserController {
    private final UserService userService;

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
    public Mono<UserResponse> getUserById(@PathVariable Long id) {
        return userService.findById(id);
    }
//
    @PostMapping
//    @PreAuthorize("hasAuthority('ADMIN')")
    public Mono<Void> addUser(@Valid @RequestBody Mono<UserRequest> userRequest) {
       return   userService.save(userRequest);
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
    public Mono<Void> deleteUser(@PathVariable Long id) {
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
