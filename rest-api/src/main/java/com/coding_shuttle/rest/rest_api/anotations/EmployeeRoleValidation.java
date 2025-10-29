package com.coding_shuttle.rest.rest_api.anotations;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})  // I want this to work on fields like role in DTO
@Constraint(validatedBy = {EmployeeRoleValidator.class})
public @interface EmployeeRoleValidation {
    String message() default "Role of employee can be either User or Admin";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
