package ru.itmo.orderserver.model;
//
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import ru.itmo.orderserver.util.enums.Role;



import javax.validation.constraints.NotBlank;

//@Entity
@Table("roles")
@Data
public class RoleEntity {

    @Id
    private Integer id;

    @NotBlank(message = "Role is mandatory")
    private Role role;
}
