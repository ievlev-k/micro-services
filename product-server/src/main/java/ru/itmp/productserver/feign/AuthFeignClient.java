package ru.itmp.productserver.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.itmp.productserver.model.User;

import java.util.List;

@FeignClient("USER-SERVER")
public interface AuthFeignClient {

    @PostMapping("/api/v1/auth/checkAdminPermission")
    @ResponseBody
    Boolean checkAdminPermission(@RequestBody String token);

    @PostMapping("/api/v1/auth/checkUserPermission")
    @ResponseBody
    Boolean checkUserPermission(@RequestBody String token);

}
