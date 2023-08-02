package com.enuygun.enuyguncookieemployeeapi.dto.request;

import jakarta.validation.constraints.*;

public record EmployeeRequest(
        @NotNull(message = "{enuygun-first-name-null-message}")
        @Size(min = 2, message = "{enuygun-first-name-size-message}")
        String firstName,

        @NotNull(message = "{enuygun-last-name-null-message}")
        @Size(min = 2, message = "{enuygun-last-name-size-message}")
        String lastName,

        @NotNull(message = "{enuygun-username-null-message}")
        @Size(min = 4, message = "{enuygun-username-size-message}")
        String username,

        @NotNull(message = "{enuygun-email-size-message}")
        @Pattern(regexp = "^(.+)@(\\S+)$", message = "{enuygun-invalid-email-message}")
        String email,

        @NotNull(message = "{enuygun-password-null-message}")
        @Size(min = 6, message = "{enuygun-password-size-message}")
        @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).*$", message = "{enuygun-password-pattern-message}")
        String password,

        @NotNull(message = "{enuygun-phone-number-null-message}")
        @Size(min = 10, message = "{enuygun-phone-number-size-message}")
        String phone,

        @NotNull(message = "{enuygun-job-null-message}")
        String job,

        @NotNull(message = "{enuygun-department-null-message}")
        String department
){}
