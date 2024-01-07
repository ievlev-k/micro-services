package ru.itmp.productserver.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductRequest {

    private Long id;
    @NotBlank
    private String name;

    @NotNull(message = "userId must be not null")
    private Long userId;

    @NotNull(message = "category must be not null")
    private Long categoryId;

    @NotBlank(message = "description must be not null")
    private String description;

    @NotNull(message = "price must be not null")
    private Long price;

}
