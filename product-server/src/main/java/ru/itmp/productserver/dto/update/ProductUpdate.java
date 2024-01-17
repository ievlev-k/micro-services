package ru.itmp.productserver.dto.update;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.UUID;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductUpdate {

    private Long id;
    @NotBlank
    private String name;

    @NotNull(message = "userId must be not null")
    private UUID userId;

    @NotNull(message = "category must be not null")
    private Long categoryId;

    @NotBlank(message = "description must be not null")
    private String description;

    @Positive(message = "price must be not null")
    private Long price;
}
