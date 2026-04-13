package com.module4.production_ready_feature.production_ready_feature.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PostDTO {
    private Long id;
    private String title;
    private String description;
}
