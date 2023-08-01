package com.enuygun.enuyguncookieemployeeapi.business.service;

import com.enuygun.enuyguncookieemployeeapi.dto.request.EmployeeRequest;
import com.enuygun.enuyguncookieemployeeapi.dto.response.EmployeeResponse;
import java.util.List;

public interface IEmployeeService {

    EmployeeResponse createAnEmployee(EmployeeRequest request);
    List<EmployeeResponse> receiveEmployees();
    EmployeeResponse receiveAnEmployeeByUsername(String username);
    EmployeeResponse updateEmployeeByUsername(EmployeeRequest request, String username);
    void deleteEmployeeByUsername(String username);
}
