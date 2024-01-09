package ru.itmo.userserver.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.itmo.userserver.util.enums.UserStatus;


import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


@Getter
@Setter
@Entity
@Table(name = "users", schema = "public")
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

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

    @NotNull(message = "Role is mandatory")
    @ManyToOne
    @JoinColumn(name = "role")
    private RoleEntity role;
}
