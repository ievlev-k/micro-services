package ru.itmo.orderserver.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;



import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table("orders")
public class Order {
    @Id
    private Long id;

    @NotNull
//    @ManyToOne
//    @JoinColumn(name="user_id")
    private User user;

    @NotNull
//    @OneToOne
//    @JoinColumn(name="payment_id")
    private Payment payment;

//    @Column(name = "delivery_info")
    private String deliveryInfo;


    private List<Product> products;
}
