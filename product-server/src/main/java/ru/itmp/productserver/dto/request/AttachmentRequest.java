package ru.itmp.productserver.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itmp.productserver.util.enums.AttachmentType;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class AttachmentRequest {

    private Long id;

    private String base64;

    private AttachmentType type;

    private String createDate;
}