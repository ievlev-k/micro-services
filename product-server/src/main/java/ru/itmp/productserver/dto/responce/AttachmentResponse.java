package ru.itmp.productserver.dto.responce;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AttachmentResponse {
    private Long id;
    private String type;
    private String base64;
    private String createDate;
}
