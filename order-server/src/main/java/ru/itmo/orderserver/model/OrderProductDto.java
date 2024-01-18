package ru.itmo.orderserver.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Transient;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderProductDto {
    @NotNull
    private Long orderId;

    @NotNull
    @Transient
    private List<Long> productIds;
}
