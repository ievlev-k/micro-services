package ru.itmp.productserver.dto.update;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AttachmentUpdate {
    private Long id;
    private String type;
    private String base64;
    private LocalDateTime create_date;
}
