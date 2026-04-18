package com.module4.employee_service.controllers;

import com.module4.employee_service.dto.EmployeeDTO;
import com.module4.employee_service.entities.EmployeeEntity;
import com.module4.employee_service.services.EmployeeImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")

public class EmployeeController {
    private final EmployeeImpl employeeImpl;

    public EmployeeController (EmployeeImpl employeeImpl){
        this.employeeImpl = employeeImpl;
    }

    @GetMapping
    public List<EmployeeDTO> getAllEmployee(){
        return employeeImpl.getAllEmployee();
    }

    @PostMapping
    public EmployeeDTO addEmployee(@RequestBody EmployeeDTO employeeData){
        return employeeImpl.addEmployee(employeeData);
    }
}
