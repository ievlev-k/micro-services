package ru.itmo.orderserver.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderProductDto {
    @NotNull
    private Long orderId;

    @NotNull
    private List<Long> productIds;
}
