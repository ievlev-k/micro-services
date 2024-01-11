package ru.itmo.userserver.contriller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import ru.itmo.userserver.dto.request.UserRequest;
import ru.itmo.userserver.dto.response.UserResponse;
import ru.itmo.userserver.dto.update.UserUpdate;
import ru.itmo.userserver.model.User;
import ru.itmo.userserver.service.UserService;
import ru.itmo.userserver.service.impl.UserDetailsServiceImpl;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/v1/user")
public class UserController {
    private final UserService userService;
    private final UserDetailsServiceImpl userDetailsService;
    @GetMapping
    @PreAuthorize("hasAnyAuthority('ADMIN','USER')")
    public Page<UserResponse> getAllUsers(@PageableDefault(size = 5) Pageable pageable) {
        return userService.getAllPage(pageable);
    }

    @GetMapping("/all")
    @PreAuthorize("hasAnyAuthority('ADMIN','USER')")
    public List<UserResponse> getAllUsers() {
//        System.out.println(token);
        return userService.getAllList();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN','USER')")
    public UserResponse getUserById(@PathVariable Long id) {
        return userService.findById(id);
    }

    @PostMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public void addUser(@Valid @RequestBody UserRequest userRequest) {
        userService.save(userRequest);
    }

    @PutMapping
    @PreAuthorize("hasAnyAuthority('ADMIN','USER')")
    public void updateUser(@Valid @RequestBody UserUpdate userUpdate) {
        userService.update(userUpdate);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN','USER')")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteById(id);
    }

    @PostMapping("/find-user")
    public User findByUsername(@RequestBody String username){
        return userService.findByUsername(username);
    }

    @PostMapping("/find-by-id")
    public boolean findUserById(@RequestBody Long id){
        return userService.userById(id);
    }
}
