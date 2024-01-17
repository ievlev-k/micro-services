package ru.itmo.orderserver.dto.response;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderResponse {
    private Long id;
    private UUID user;
    private Long payment;
    private String deliveryInfo;
//    private List<Long> products;
}
