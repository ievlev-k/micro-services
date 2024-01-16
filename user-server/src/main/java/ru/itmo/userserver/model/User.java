package ru.itmo.userserver.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import lombok.*;


import ru.itmo.userserver.util.enums.UserStatus;
import jakarta.persistence.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.UUID;


@Getter
@Setter
@Entity
@Table(name = "users", schema = "public")
@NoArgsConstructor
@Builder(toBuilder = true)
@AllArgsConstructor
public class User {
    @Id
    @Column(name = "id")
    @NotNull
    private UUID id;

    @NotBlank(message = "username is mandatory")
    @Column(name = "username", unique = true)
    private String username;

    @NotBlank(message = "Phone number is mandatory")
    @Column(name = "phone")
    private String phone;

    @NotBlank(message = "social_media is mandatory")
    @Column(name = "social_media")
    private String socialMedia;

    @NotNull(message = "room is mandatory")
    @Column(name = "room")
    private Long room;

    @NotBlank(message = "firstName is mandatory")
    @Column(name = "first_name")
    private String firstName;

    @NotBlank(message = "last name is mandatory")
    @Column(name = "last_name")
    private String lastName;

    @Email
    @NotBlank(message= "email is mandatory and unique")
    @Column(name = "email", unique = true)
    private String email;

    @NotBlank(message = "password is mandatory")
    @Column(name = "password")
    private String password;


    @NotNull(message = "UserStatus is mandatory")
    @Column(name = "user_status")
    @Enumerated(EnumType.STRING)
    private UserStatus status;

    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    @NotNull
    private Role role;
}
