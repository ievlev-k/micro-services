package ru.itmo.orderserver.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentRequest {
    private Long id;
    private String createDate;
    private String description;
    private Long status;
    private Long amount;
}
