package ru.itmo.userserver.dto.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import ru.itmo.userserver.model.Role;
import ru.itmo.userserver.util.enums.UserStatus;

import java.util.UUID;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


@Getter
@Setter
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserRequest {

    private UUID id;

    @NotBlank(message = "Username is mandatory")
    private String username;

    @NotBlank(message = "Password is mandatory")
    private String password;

    @NotNull(message = "UserStatus is mandatory")
    private UserStatus status;

    @NotNull(message =  "Role is mandatory")
    private Role role;

    @NotBlank(message = "phone is mandatory")
    private String phone;

    @NotBlank(message = "social_media is mandatory")
    private String socialMedia;

    @NotNull(message = "room is mandatory")
    private Long room;

    @NotBlank(message = "first_name is mandatory")
    private String firstName;

    @NotBlank(message = "last name is mandatory")
    private String lastName;

    @NotBlank(message = "email is mandatory")
    private String email;




}
