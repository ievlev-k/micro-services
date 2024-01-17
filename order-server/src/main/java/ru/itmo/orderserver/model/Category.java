package ru.itmo.orderserver.model;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

//import javax.persistence.*;
import javax.validation.constraints.NotBlank;

//@En
// tity
@Data

@Getter
@Setter
@NoArgsConstructor
@Table(name = "categories", schema = "public")
public class Category {
    @Id
    private Long id;

    @NotBlank
    private String name;

    private String shortName;
}
