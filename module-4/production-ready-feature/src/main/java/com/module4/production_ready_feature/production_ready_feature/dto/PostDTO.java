package com.module4.production_ready_feature.production_ready_feature.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.envers.Audited;
import org.hibernate.envers.NotAudited;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PostDTO {
    private Long id;
    private String title;

    @NotAudited // this description field will not be audited - who, when audited
    private String description;
}
