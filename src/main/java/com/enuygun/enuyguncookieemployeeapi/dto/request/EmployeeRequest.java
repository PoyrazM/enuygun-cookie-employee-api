package com.enuygun.enuyguncookieemployeeapi.dto.request;

import jakarta.validation.constraints.*;

public record EmployeeRequest(
        @NotNull(message = "First Name should not be null !")
        @Size(min = 2, message = "First Name should not be less than 2 characters !")
        String firstName,

        @NotNull(message = "Last Name should not be null !")
        @Size(min = 2, message = "Last Name should not be less than 2 characters !")
        String lastName,

        @NotNull(message = "Username should not be null !")
        @Size(min = 4, message = "Username should not be less than 4 characters !")
        String username,

        @NotNull(message = "Email should not be null !")
        @Pattern(regexp = "^(.+)@(\\S+)$", message = "Invalid Email Address !")
        String email,

        @NotNull(message = "Password should not be null !")
        String password,

        @NotNull(message = "Phone Number should not be null !")
        @Size(min = 10, message = "Phone Number should not be less than 10 characters !")
        String phone,

        @NotNull(message = "Job should not be null !")
        String job,

        @NotNull(message = "Department should not be null !")
        String department
){}
