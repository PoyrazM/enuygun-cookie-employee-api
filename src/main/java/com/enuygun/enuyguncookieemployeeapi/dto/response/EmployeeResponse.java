package com.enuygun.enuyguncookieemployeeapi.dto.response;

public record EmployeeResponse (
    String firstName,
    String lastName,
    String username,
    String email,
    String phone,
    String job,
    String department
){}

