package com.enuygun.enuyguncookieemployeeapi.mapper;

import com.enuygun.enuyguncookieemployeeapi.dto.response.error.EmployeeValidationsErrorResponse;
import com.enuygun.enuyguncookieemployeeapi.dto.response.error.ExceptionErrorResponse;
import java.util.Map;

public class ErrorResponseParser {
    private ErrorResponseParser() {}

    public static ExceptionErrorResponse exceptionParser(String error, int statusCode) {
        return ExceptionErrorResponse.builder()
                .error(error)
                .statusCode(statusCode)
                .build();
    }

    public static EmployeeValidationsErrorResponse validationsErrorParser(Map<String, String> error, int statusCode) {
        return EmployeeValidationsErrorResponse.builder()
                .validationErrors(error)
                .statusCode(statusCode)
                .build();
    }
}
