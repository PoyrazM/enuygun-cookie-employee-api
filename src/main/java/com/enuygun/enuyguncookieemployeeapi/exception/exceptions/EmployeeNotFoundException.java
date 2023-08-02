package com.enuygun.enuyguncookieemployeeapi.exception.exceptions;

import com.enuygun.enuyguncookieemployeeapi.exception.base.BaseException;

public class EmployeeNotFoundException extends BaseException {
    public EmployeeNotFoundException(String message) {
        super(message);
        log.error("[EmployeeNotFoundException] -> message : {}", message);
    }
}
