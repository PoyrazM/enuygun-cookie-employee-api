package com.enuygun.enuyguncookieemployeeapi.exception.handler;

import com.enuygun.enuyguncookieemployeeapi.dto.response.error.ExceptionErrorResponse;
import com.enuygun.enuyguncookieemployeeapi.exception.exceptions.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;

import static com.enuygun.enuyguncookieemployeeapi.mapper.ErrorResponseParser.exceptionParser;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(EmployeeNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    private ExceptionErrorResponse handleEmployeeNotFoundException(EmployeeNotFoundException exception) {
        return exceptionParser(exception.getMessage(), LocalDateTime.now(), HttpStatus.NOT_FOUND.value());
    }

    @ExceptionHandler(EmployeeNotCreatedException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    private ExceptionErrorResponse handleEmployeeNotCreatedException(EmployeeNotCreatedException exception) {
        return exceptionParser(exception.getMessage(), LocalDateTime.now(), HttpStatus.BAD_REQUEST.value());
    }

    @ExceptionHandler(EmployeeNotUpdatedException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    private ExceptionErrorResponse handleEmployeeNotUpdatedException(EmployeeNotUpdatedException exception) {
        return exceptionParser(exception.getMessage(), LocalDateTime.now(), HttpStatus.BAD_REQUEST.value());
    }

    @ExceptionHandler(EmployeeNotDeletedException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    private ExceptionErrorResponse handleEmployeeNotDeletedException(EmployeeNotDeletedException exception) {
        return exceptionParser(exception.getMessage(), LocalDateTime.now(), HttpStatus.BAD_REQUEST.value());
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    private ExceptionErrorResponse handleJsonParseException() {
        return exceptionParser("Missing Request Params", LocalDateTime.now(), HttpStatus.BAD_REQUEST.value());
    }
}
