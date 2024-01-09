package ru.itmo.userserver.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itmo.userserver.util.enums.UserStatus;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRequest {

    private Long id;

    @NotBlank(message = "Username is mandatory")
    private String username;

    @NotBlank(message = "Password is mandatory")
    private String password;

    @NotNull(message = "UserStatus is mandatory")
    private UserStatus status;

    @NotNull(message =  "Role is mandatory")
    private Integer roleId;

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
