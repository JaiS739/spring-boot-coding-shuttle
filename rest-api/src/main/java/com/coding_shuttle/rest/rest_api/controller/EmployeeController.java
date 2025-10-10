package com.coding_shuttle.rest.rest_api.controller;

import com.coding_shuttle.rest.rest_api.dto.EmployeeDto;
import com.coding_shuttle.rest.rest_api.entity.EmployeeEntity;
import com.coding_shuttle.rest.rest_api.service.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(path="/employeeDetails")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

//    methods:-

    @GetMapping
    public List<EmployeeDto> getAllEmployee(){
        return employeeService.getAllEmployee();
    }

    @GetMapping("/{employeeId}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable Long employeeId) {
        EmployeeDto employee = employeeService.getEmployeeById(employeeId);
        if (employee == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(employee);
    }

    @PostMapping
    public EmployeeDto createEmployee(@RequestBody EmployeeDto inputValue){
        return employeeService.createEmployee(inputValue);
    }

    @PutMapping(path="/{employeeId}")
    public EmployeeDto updateEmployee(@RequestBody EmployeeDto inputValue, @PathVariable Long employeeId){
        return employeeService.updateEmployee(employeeId, inputValue);
    }

    @DeleteMapping(path="/{employeeId}")
    public String deleteEmployee(@PathVariable Long employeeId){
        return employeeService.deleteEmployee(employeeId);
    }

}
