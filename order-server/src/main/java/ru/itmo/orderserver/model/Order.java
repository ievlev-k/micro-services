package ru.itmo.orderserver.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;
import java.util.UUID;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
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
//    @Transient
    private UUID user_id;

    @NotNull
//    @OneToOne
//    @JoinColumn(name="payment_id")
//    @Transient
    private Long payment_id;

//    @Column(name = "delivery_info")
    private String delivery_info;

    @Transient
    private List<Product> products;
}
