package com.coding_shuttle.rest.rest_api.anotations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.List;

public class EmployeeRoleValidator implements ConstraintValidator<EmployeeRoleValidation, String> {

    @Override
    public boolean isValid(String inputRole , ConstraintValidatorContext constraintValidatorContext) {
        List<String> roles = List.of("User", "Admin");
        return roles.contains(inputRole);
    }
}
