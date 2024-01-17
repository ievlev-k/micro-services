package ru.itmo.orderserver.model;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

//import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;


//@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
@Table("products")
public class Product {
    @Id
    private Long id;

    @NotBlank(message = "name is mandatory")
    private String name;

    @NotNull(message = "user is mandatory")
    private User user;

    @NotNull(message = "Category is mandatory")
    private Category category;

//    @Column(name = "description")
    private String description;

//    @ManyToMany
//    @JoinTable(name = "product_attachments",
//            joinColumns = @JoinColumn(name = "product_id"),
//            inverseJoinColumns = @JoinColumn(name = "attachment_id"))
    private List<Attachment> attachments;

//    @ManyToMany(mappedBy = "products")
//    List<Order> order;

    @NotNull
//    @Column(name = "price")
    private Long price;
}
