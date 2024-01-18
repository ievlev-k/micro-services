package ru.itmo.orderserver.dto.request;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.UUID;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderRequest {
    private Long id;
    @NotNull
    private UUID user_id;

    @NotBlank
    private String delivery_info;

//    @NotNull
//    private List<Long> productIds;

    @NotNull
    private Long payment_id;
}