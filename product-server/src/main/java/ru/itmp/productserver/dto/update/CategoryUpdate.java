package ru.itmp.productserver.dto.update;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryUpdate {
    private Long id;
    private String name;
    private String shortName;
}
