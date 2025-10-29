package com.coding_shuttle.rest.rest_api.dto;

import com.coding_shuttle.rest.rest_api.anotations.EmployeeRoleValidation;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDto {
    private Long id;
    @NotNull(message = "Name field is required.")
    @NotBlank(message = "Name can not be empty spaces")
    private String name;

    @NotEmpty(message = "Email can not be empty.")
    @Email(message = "Email is not valid.")
    private String email;
    private Boolean isActive;

    @EmployeeRoleValidation
    private String role;
}
