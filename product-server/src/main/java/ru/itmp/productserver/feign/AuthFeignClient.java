package ru.itmp.productserver.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.security.core.userdetails.UserDetails;
import ru.itmp.productserver.model.User;

import java.util.List;

@FeignClient("USER-SERVER")
public interface AuthFeignClient {
    @PostMapping("/api/v1/auth/get-name")
    public String getUserNameFromJwtToken(@RequestBody String token);

    @PostMapping("/api/v1/auth/valid")
    public boolean validateJwtToken(@RequestBody String token);

    @PostMapping("/api/v1/user/find-user")
    public User findByUsername(@RequestBody String username);

    @PostMapping("/api/v1/user/find-by-id")
    public boolean findUserById(@RequestBody Long id);

}
