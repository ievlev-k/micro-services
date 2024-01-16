package ru.itmo.userserver.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class LoginRequest {

    @NotBlank(message = "UserName is mandatory")
    private String username;

    @NotBlank(message = "Password is mandatory")
    private String password;
}
