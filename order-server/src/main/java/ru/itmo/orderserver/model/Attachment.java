package ru.itmo.orderserver.model;
//
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//import ru.itmo.orderserver.util.enums.AttachmentType;
//
//
//import javax.persistence.*;
//import javax.validation.constraints.NotBlank;
//import javax.validation.constraints.NotNull;
//import java.util.List;
//
//@Entity
//@NoArgsConstructor
//@Setter
//@Getter
//@Table(name = "attachments", schema = "public")
//public class Attachment {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id")
//    private Long id;
//
//    @NotBlank
//    @Column(name = "base64")
//    private String base64;
//
//    @NotNull
//    @Column(name = "type")
//    @Enumerated(EnumType.STRING)
//    private AttachmentType type;
//
//    @Column(name = "create_date")
//    private String createDate;
//
//    @ManyToMany
//    @JoinTable(
//            name = "product_attachments",
//            joinColumns = @JoinColumn(name = "attachment_id"),
//            inverseJoinColumns = @JoinColumn(name = "product_id")
//    )
//    private List<Product> products;
//}
