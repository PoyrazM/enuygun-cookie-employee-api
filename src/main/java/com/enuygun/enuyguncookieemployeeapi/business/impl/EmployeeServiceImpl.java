package com.enuygun.enuyguncookieemployeeapi.business.impl;

import com.enuygun.enuyguncookieemployeeapi.business.service.IEmployeeService;
import com.enuygun.enuyguncookieemployeeapi.dto.request.EmployeeRequest;
import com.enuygun.enuyguncookieemployeeapi.dto.response.EmployeeResponse;
import com.enuygun.enuyguncookieemployeeapi.entity.Employee;
import com.enuygun.enuyguncookieemployeeapi.exception.enums.EmployeeExceptionTypes;
import com.enuygun.enuyguncookieemployeeapi.exception.exceptions.*;
import com.enuygun.enuyguncookieemployeeapi.jpa.IEmployeeRepository;
import com.enuygun.enuyguncookieemployeeapi.mapper.IEmployeeMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements IEmployeeService {

    private final IEmployeeRepository employeeRepository;
    private final IEmployeeMapper mapper;
    private final PasswordEncoder passwordEncoder;

    @Override
    public EmployeeResponse createAnEmployee(EmployeeRequest request) {

        boolean isNotUsernameOrEmailExist = !employeeRepository.existsEmployeeByUsernameOrEmail(request.username(), request.email());

        if (isNotUsernameOrEmailExist) {
            Employee employee = mapper.dtoToEntity(request);
            employee.setPassword(passwordEncoder.encode(request.password()));
            employeeRepository.save(employee);
            return mapper.entityToDto(employee);
        } else throw new EmployeeNotCreatedException(EmployeeExceptionTypes.EMPLOYEE_NOT_CREATED.getValue());
    }

    @Override
    public List<EmployeeResponse> receiveEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        List<EmployeeResponse> employeeResponse = mapper.entityListToDtoList(employees);
        if (!employeeResponse.isEmpty()) return employeeResponse;
        else throw new EmployeeNotFoundException(EmployeeExceptionTypes.EMPLOYEES_NOT_FOUND.getValue());
    }

    @Override
    public EmployeeResponse receiveAnEmployeeByUsername(String username) {
        Optional<Employee> employee = employeeRepository.findEmployeeByUsername(username);
        boolean isEmployeeExist = employee.isPresent();
        if (isEmployeeExist) return mapper.entityToDto(employee.get());
        else throw new EmployeeNotFoundException(EmployeeExceptionTypes.EMPLOYEE_NOT_FOUND_USERNAME.getValue() + username);
    }

    @Override
    public EmployeeResponse updateEmployeeByUsername(EmployeeRequest request, String username) {
        Optional<Employee> employee = employeeRepository.findEmployeeByUsername(username);
        boolean isEmployeeExist = employee.isPresent();
        if (isEmployeeExist) {
            Employee updatedEmployee = employee.get();
            mapper.updateDtoToEntity(request, updatedEmployee);
            employeeRepository.save(updatedEmployee);
            return mapper.entityToDto(updatedEmployee);
        } else throw new EmployeeNotFoundException(EmployeeExceptionTypes.EMPLOYEE_NOT_UPDATED.getValue());
    }

    @Override
    public void deleteEmployeeByUsername(String username) {
        Optional<Employee> employee = employeeRepository.findEmployeeByUsername(username);
        boolean isEmployeeExist = employee.isPresent();
        if (isEmployeeExist) employeeRepository.delete(employee.get());
        else throw new EmployeeNotDeletedException(EmployeeExceptionTypes.EMPLOYEE_NOT_DELETED.getValue());
    }
}
