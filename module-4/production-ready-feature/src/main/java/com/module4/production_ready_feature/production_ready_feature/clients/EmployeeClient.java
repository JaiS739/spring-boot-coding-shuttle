package com.module4.production_ready_feature.production_ready_feature.clients;

import com.module4.production_ready_feature.production_ready_feature.dto.EmployeeDTO;

import java.util.List;

public interface EmployeeClient {
    List<EmployeeDTO> getAllEmployee();
    EmployeeDTO getEmployeeById(Long employeeId);
}
