package com.enuygun.enuyguncookieemployeeapi.exception.handler;

import com.enuygun.enuyguncookieemployeeapi.dto.response.ApiResponse;
import com.enuygun.enuyguncookieemployeeapi.dto.response.error.EmployeeValidationsErrorResponse;
import com.enuygun.enuyguncookieemployeeapi.dto.response.error.ExceptionErrorResponse;
import com.enuygun.enuyguncookieemployeeapi.exception.exceptions.*;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

import static com.enuygun.enuyguncookieemployeeapi.mapper.ErrorResponseParser.*;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(EmployeeNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    private ApiResponse<ExceptionErrorResponse> handleEmployeeNotFoundException(EmployeeNotFoundException exception) {
        return ApiResponse.error(exception.getMessage(), exceptionParser(HttpStatus.NOT_FOUND.toString(), HttpStatus.NOT_FOUND.value()));
    }

    @ExceptionHandler(EmployeeNotCreatedException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    private ApiResponse<ExceptionErrorResponse> handleEmployeeNotCreatedException(EmployeeNotCreatedException exception) {
        return ApiResponse.error(exception.getMessage(), exceptionParser(HttpStatus.BAD_REQUEST.toString(), HttpStatus.BAD_REQUEST.value()));
    }

    @ExceptionHandler(EmployeeNotUpdatedException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    private ApiResponse<ExceptionErrorResponse> handleEmployeeNotUpdatedException(EmployeeNotUpdatedException exception) {
        return ApiResponse.error(exception.getMessage(), exceptionParser(HttpStatus.BAD_REQUEST.toString(), HttpStatus.BAD_REQUEST.value()));
    }

    @ExceptionHandler(EmployeeNotDeletedException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    private ApiResponse<ExceptionErrorResponse> handleEmployeeNotDeletedException(EmployeeNotDeletedException exception) {
        return ApiResponse.error(exception.getMessage(), exceptionParser(HttpStatus.BAD_REQUEST.toString(), HttpStatus.BAD_REQUEST.value()));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    private ApiResponse<EmployeeValidationsErrorResponse> handleValidationErrors(MethodArgumentNotValidException exception) {
        Map<String, String> validationErrors = new HashMap<>();
        for (FieldError fieldError : exception.getBindingResult().getFieldErrors()) {
            validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
        }
        return ApiResponse.error("Validation Errors !", validationsErrorParser(validationErrors, HttpStatus.BAD_REQUEST.value()));
    }
}
