package com.enuygun.enuyguncookieemployeeapi.exception.exceptions;

import com.enuygun.enuyguncookieemployeeapi.exception.base.BaseException;

public class EmployeeNotUpdatedException extends BaseException {
    protected EmployeeNotUpdatedException(String message) {
        super(message);
        log.error("[EmployeeNotUpdatedException] -> message : {}", message);
    }
}
