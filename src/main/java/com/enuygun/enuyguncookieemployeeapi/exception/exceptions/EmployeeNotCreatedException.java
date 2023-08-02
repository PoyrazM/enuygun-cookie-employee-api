package com.enuygun.enuyguncookieemployeeapi.exception.exceptions;

import com.enuygun.enuyguncookieemployeeapi.exception.base.BaseException;

public class EmployeeNotCreatedException extends BaseException {
    public EmployeeNotCreatedException(String message) {
        super(message);
        log.error("[EmployeeNotCreatedException] -> message : {}", message);
    }
}
