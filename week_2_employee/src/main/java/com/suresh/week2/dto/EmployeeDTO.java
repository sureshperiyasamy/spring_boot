package com.suresh.week2.dto;

import com.suresh.week2.validations.EmployeeRoleValidation;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
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
public class EmployeeDTO {

    private Long id;
    @NotNull(message = "Name must not be null")
    private String name;

    @Min(value = 18,message = "Minimum Age should be 18")
    @Max(value = 30,message = "Maximum Age should be 30")
    private Integer age;

    @Email(message = "Enter valid email address")
    private String email;


    @NotNull(message = "Role must not be null")
    @EmployeeRoleValidation
    private String role;


    private LocalDate doj;
    private Boolean active;

}
