package ru.itmo.userserver.model;

import lombok.Data;
import ru.itmo.userserver.util.enums.Role;


import javax.validation.constraints.NotBlank;

import jakarta.persistence.*;

@Entity
@Table(name = "roles")
@Data
public class RoleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @NotBlank(message = "Role is mandatory")
    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    private Role role;
}
