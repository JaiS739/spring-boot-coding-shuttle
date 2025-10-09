package com.coding_shuttle.rest.rest_api.controller;

import com.coding_shuttle.rest.rest_api.dto.EmployeeDto;
import com.coding_shuttle.rest.rest_api.entity.EmployeeEntity;
import com.coding_shuttle.rest.rest_api.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(path="/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

//    methods:-
    @GetMapping(path="/{employeeId}")
    public EmployeeDto getEmployeeById(@PathVariable(name = "employeeId") Long id){
        return employeeService.getEmployeeById(id);
    }

    @GetMapping(path="allEmployee")
    public List<EmployeeDto> getAllEmployees(){
        return employeeService.getAllEmployee();
    }

    @PostMapping
    public EmployeeDto createNewEmployee(@RequestBody EmployeeDto inputValue){
        return employeeService.createEmployee(inputValue);
    }

}
