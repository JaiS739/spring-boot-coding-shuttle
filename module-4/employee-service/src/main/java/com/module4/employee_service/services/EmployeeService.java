package com.module4.employee_service.services;

import com.module4.employee_service.dto.EmployeeDTO;
import com.module4.employee_service.entities.EmployeeEntity;
import com.module4.employee_service.repository.EmployeeRepository;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;

import java.util.List;

@Service
public class EmployeeService implements EmployeeImpl {

    private final EmployeeRepository employeeRepository;

    private final ModelMapper modelMapper;

    public EmployeeService(EmployeeRepository employeeRepository, ModelMapper modelMapper){
        this.employeeRepository = employeeRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<EmployeeDTO> getAllEmployee(){
        return employeeRepository.findAll()
                .stream()
                .map((employeeEntity) -> modelMapper.map(employeeEntity, EmployeeDTO.class))
                .toList();
    };

    @Override
    public EmployeeDTO addEmployee(EmployeeDTO employeeData){
        EmployeeEntity employeeEntity = modelMapper.map(employeeData, EmployeeEntity.class);
        EmployeeEntity savedEmployee = employeeRepository.save(employeeEntity);
        return modelMapper.map(savedEmployee, EmployeeDTO.class);
    }
}
