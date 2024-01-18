package ru.itmo.orderserver.dto.update;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderUpdate {
    private Long id;
    private UUID user_id;
    private Long payment_id;
    private String delivery_info;
}
