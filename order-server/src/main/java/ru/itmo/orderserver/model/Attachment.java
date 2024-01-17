package ru.itmo.orderserver.model;
//
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import ru.itmo.orderserver.util.enums.AttachmentType;


//import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@NoArgsConstructor
@Setter
@Getter
@Table("attachments")
public class Attachment {
    @Id
    private Long id;

    @NotBlank
    private String base64;

    @NotNull
    private AttachmentType type;


    private String createDate;


    private List<Product> products;
}
