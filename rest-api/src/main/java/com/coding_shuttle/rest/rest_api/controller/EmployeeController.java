package com.coding_shuttle.rest.rest_api.controller;

import com.coding_shuttle.rest.rest_api.dto.EmployeeDto;
import com.coding_shuttle.rest.rest_api.entity.EmployeeEntity;
import com.coding_shuttle.rest.rest_api.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Optional;

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
        Optional<EmployeeDto> employeeDto = employeeService.getEmployeeById(employeeId);
        return employeeDto
                .map(employeeDto1 -> ResponseEntity.ok(employeeDto1))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public EmployeeDto createEmployee(@RequestBody @Valid EmployeeDto inputValue){
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

    @PatchMapping(path="/{employeeId}")
    public EmployeeDto updatePartialDataById(@RequestBody Map<String, Object> updates,
                                         @PathVariable Long employeeId){
        return employeeService.updatePartialDataById(employeeId, updates);
    }

}
