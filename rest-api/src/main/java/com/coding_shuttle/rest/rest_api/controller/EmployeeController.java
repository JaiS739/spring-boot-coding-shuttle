package com.coding_shuttle.rest.rest_api.controller;

import com.coding_shuttle.rest.rest_api.dto.EmployeeDto;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping(path="/employee")
public class EmployeeController {
    @GetMapping(path="/{employeeId}")
    public EmployeeDto getEmployeeById(@PathVariable(name = "employeeId") Long id){
        return new EmployeeDto(id, "John Doe", "johndoe@email.com", 39, LocalDate.of(2021, 9, 21), true);
    }

    @GetMapping()
    public String getEmployee(@RequestParam(required = false) Integer age,
                              @RequestParam(required = false) String sortBy){

        if(age!=null && sortBy!=null){

            return "Hi age " + age + " sortBy " + sortBy;
        }
        return "Here is the employee list";
    }

    @PostMapping
    public String createNewEmployee(){
        return "Hello from post";
    }

    @PostMapping("/all")
    public EmployeeDto getRealEmployeeData(@RequestBody EmployeeDto employeeData){
        employeeData.setId(10L);
        return employeeData;
    }
}
