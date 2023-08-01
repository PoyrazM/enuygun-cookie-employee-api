package com.enuygun.enuyguncookieemployeeapi.exception.enums;

public enum EmployeeExceptionTypes implements IExceptionTypes {

    EMPLOYEE_NOT_FOUND_USERNAME("Employee NOT Found With This Username : "),
    EMPLOYEES_NOT_FOUND("Any Employee NOT Found In The Database !"),
    EMPLOYEE_NOT_CREATED("Employee NOT Created , Username or Email NOT Unique!"),
    EMPLOYEE_NOT_UPDATED("Employee NOT Updated With This Username : "),
    EMPLOYEE_NOT_DELETED("Employee NOT Deleted With This Username : ");

    private final String value;

    EmployeeExceptionTypes(String value) {
        this.value = value;
    }

    @Override
    public String getValue() {
        return this.value;
    }
}
