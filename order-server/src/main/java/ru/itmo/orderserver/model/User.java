package ru.itmo.orderserver.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import ru.itmo.orderserver.util.enums.UserStatus;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.UUID;

//
//import javax.persistence.*;
//import javax.validation.constraints.Email;
//import javax.validation.constraints.NotBlank;
//import javax.validation.constraints.NotNull;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table("users")
public class User {
    @Id
    private UUID id;

    @NotBlank(message = "username is mandatory")
//    @Column(name = "username", unique = true)
    private String username;

    @NotBlank(message = "Phone number is mandatory")
//    @Column(name = "phone")
    private String phone;

    @NotBlank(message = "social_media is mandatory")
//    @Column(name = "social_media")
    private String socialMedia;

    @NotNull(message = "room is mandatory")
//    @Column(name = "room")
    private Long room;

    @NotBlank(message = "firstName is mandatory")
//    @Column(name = "first_name")
    private String firstName;

    @NotBlank(message = "last name is mandatory")
//    @Column(name = "last_name")
    private String lastName;

    @Email
    @NotBlank(message= "email is mandatory and unique")
//    @Column(name = "email", unique = true)
    private String email;

    @NotBlank(message = "password is mandatory")
//    @Column(name = "password")
    private String password;


    @NotNull(message = "UserStatus is mandatory")
//    @Column(name = "user_status")
//    @Enumerated(EnumType.STRING)
    private UserStatus status;

    @NotNull(message = "Role is mandatory")
//    @ManyToOne
//    @JoinColumn(name = "role")
    private RoleEntity role;
}
