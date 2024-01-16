package ru.itmo.userserver.dto.response;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itmo.userserver.model.Role;
import ru.itmo.userserver.util.enums.UserStatus;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserResponse {

    private UUID id;
    private String username;
    private Role role;
    private UserStatus userStatus;
}
