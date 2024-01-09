package ru.itmo.userserver.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itmo.userserver.model.RoleEntity;
import ru.itmo.userserver.util.enums.UserStatus;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserResponse {

    private Long id;
    private String username;
    private RoleEntity role;
    private UserStatus userStatus;
}
