package com.suresh.week2.validations;


import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.CONSTRUCTOR, ElementType.PARAMETER, ElementType.TYPE_USE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(
        validatedBy = {EmployeeRoleValidator.class}
)
public @interface EmployeeRoleValidation {

    String message() default "{Role of user has to be either USER or ADMIN}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
