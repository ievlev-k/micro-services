package ru.itmo.orderserver.dto.update;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderUpdate {
    private Long id;
    private Long userId;
    private Long paymentId;
    private String deliveryInfo;
}
