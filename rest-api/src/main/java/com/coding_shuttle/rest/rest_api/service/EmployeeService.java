package com.coding_shuttle.rest.rest_api.service;

import com.coding_shuttle.rest.rest_api.dto.EmployeeDto;
import com.coding_shuttle.rest.rest_api.entity.EmployeeEntity;
import com.coding_shuttle.rest.rest_api.repository.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final ModelMapper modelMapper;

    public EmployeeService(EmployeeRepository employeeRepository, ModelMapper modelMapper) {
        this.employeeRepository = employeeRepository;
        this.modelMapper = modelMapper;
    }

//    methods:-

    public EmployeeDto getEmployeeById(Long id){
        EmployeeEntity employeeEntity =  employeeRepository.findById(id).orElse(null);
        return modelMapper.map(employeeEntity, EmployeeDto.class);
    }

    public List<EmployeeDto> getAllEmployee(){
        List<EmployeeEntity> employeeEntities =  employeeRepository.findAll();
        return employeeEntities
                .stream()
                .map(employeeEntity -> modelMapper.map(employeeEntity, EmployeeDto.class))
                .collect(Collectors.toList());
    }

    public EmployeeDto createEmployee(EmployeeDto inputValue){
        EmployeeEntity toSaveEntity = modelMapper.map(inputValue, EmployeeEntity.class);
        EmployeeEntity savedEntity = employeeRepository.save(toSaveEntity);
        System.out.println("Incoming Request: ");
        System.out.println(
                inputValue.getId() + " | " +
                        inputValue.getName() + " | " +
                        inputValue.getEmail() + " | " +
                        inputValue.getIsActive()
        );

        return modelMapper.map(savedEntity, EmployeeDto.class);
    }
}
