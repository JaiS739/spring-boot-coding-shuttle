package com.module4.employee_service.services;

import com.module4.employee_service.dto.EmployeeDTO;
import com.module4.employee_service.entities.EmployeeEntity;

import java.util.List;

public interface EmployeeImpl {
    List<EmployeeDTO> getAllEmployee();

    EmployeeDTO addEmployee(EmployeeDTO employeeData);

}
