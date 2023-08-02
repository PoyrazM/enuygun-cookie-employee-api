package com.enuygun.enuyguncookieemployeeapi.exception.exceptions;

import com.enuygun.enuyguncookieemployeeapi.exception.base.BaseException;

public class EmployeeNotDeletedException extends BaseException {
    public EmployeeNotDeletedException(String message) {
        super(message);
        log.error("[EmployeeNotDeletedException] -> message : {}", message);
    }
}
