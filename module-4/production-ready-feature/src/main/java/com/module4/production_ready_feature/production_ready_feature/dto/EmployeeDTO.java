package com.module4.production_ready_feature.production_ready_feature.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class EmployeeDTO {

    private Long id;

    private String name;

    private String dept;
}
