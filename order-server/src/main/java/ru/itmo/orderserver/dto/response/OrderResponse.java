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
    private UUID user_id;
    private Long payment_id;
    private String delivery_info;
//    private List<Long> products;
}
