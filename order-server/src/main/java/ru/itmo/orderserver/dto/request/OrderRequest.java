package ru.itmo.orderserver.dto.request;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderRequest {
    private Long id;
    @NotNull
    private Long userId;

    @NotBlank
    private String deliveryInfo;

//    @NotNull
//    private List<Long> productIds;

    @NotNull
    private Long paymentId;
}