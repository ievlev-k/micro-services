package ru.itmo.orderserver.model;

//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//
//import javax.persistence.*;
//import javax.validation.constraints.NotNull;
//import java.util.List;
//
//@Entity
//@Getter
//@Setter
//@NoArgsConstructor
//@Table(name = "orders", schema = "public")
//public class Order {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id")
//    private Long id;
//
//    @NotNull
//    @ManyToOne
//    @JoinColumn(name="user_id")
//    private User user;
//
//    @NotNull
//    @OneToOne
//    @JoinColumn(name="payment_id")
//    private Payment payment;
//
//    @Column(name = "delivery_info")
//    private String deliveryInfo;
//
//    @ManyToMany(fetch = FetchType.EAGER)
//    @JoinTable(name = "order_products",
//            joinColumns = @JoinColumn(name = "order_id"),
//            inverseJoinColumns = @JoinColumn(name = "product_id"))
//    private List<Product> products;
//}
