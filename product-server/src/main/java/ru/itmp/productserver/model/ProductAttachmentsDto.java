package ru.itmp.productserver.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductAttachmentsDto {
    @NotNull
    private Long productId;

    @NotNull
    private List<Long> attachmentIds;
}
