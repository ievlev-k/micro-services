package ru.itmo.orderserver.dto.response;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderResponse {
    private Long id;
    private Long user;
    private Long payment;
    private String deliveryInfo;
//    private List<Long> products;
}
