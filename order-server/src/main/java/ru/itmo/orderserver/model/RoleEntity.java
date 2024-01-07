package ru.itmo.orderserver.model;

import lombok.Data;
import ru.itmo.orderserver.util.enums.Role;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;

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
