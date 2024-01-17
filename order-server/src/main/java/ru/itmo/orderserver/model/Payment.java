package ru.itmo.orderserver.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;



import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table("payments")
public class Payment {
    @Id

    private long id;

    private String createDate;

    @NotNull(message = "status is mandatory")
    private long status;

    @NotNull(message = "amount is mandatory")
    private long amount;

    private String description;
}
