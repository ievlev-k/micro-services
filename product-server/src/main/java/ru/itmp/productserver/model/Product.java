package ru.itmp.productserver.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "products", schema = "public")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotBlank(message = "name is mandatory")
    @Column(name = "name")
    private String name;

    @NotNull(message = "user is mandatory")
    @Column(name = "user_id")
    private UUID user;

    @NotNull(message = "Category is mandatory")
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @Column(name = "description")
    private String description;

    @ManyToMany
    @JoinTable(name = "product_attachments",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "attachment_id"))
    private List<Attachment> attachments;

//    @ManyToMany(mappedBy = "products")
//    List<Order> order;

    @NotNull
    @Column(name = "price")
    private Long price;
}

