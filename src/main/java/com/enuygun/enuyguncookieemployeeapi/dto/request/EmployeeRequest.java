package com.enuygun.enuyguncookieemployeeapi.dto.request;

public record EmployeeRequest(
        String firstName,
        String lastName,
        String username,
        String email,
        String password,
        String phone,
        String job,
        String department
){}
