package com.enuygun.enuyguncookieemployeeapi.presentation;

import com.enuygun.enuyguncookieemployeeapi.business.service.IEmployeeService;
import com.enuygun.enuyguncookieemployeeapi.dto.request.EmployeeRequest;
import com.enuygun.enuyguncookieemployeeapi.dto.response.ApiResponse;
import com.enuygun.enuyguncookieemployeeapi.dto.response.EmployeeResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/employees")
@RequiredArgsConstructor
public class EmployeeController {

    private final IEmployeeService employeeService;

    @PostMapping
    ResponseEntity<ApiResponse<EmployeeResponse>> createEmployee(@RequestBody EmployeeRequest request) {
        var createdEmployee = employeeService.createAnEmployee(request);

        return ResponseEntity
                .status(HttpStatus.CREATED.value())
                .body(ApiResponse.of("Employee Created is Successfully.", createdEmployee));
    }

    @GetMapping
    ResponseEntity<List<EmployeeResponse>> getAllEmployees() {
        var allEmployees = employeeService.receiveEmployees();
        return ResponseEntity.ok(allEmployees);
    }

    @GetMapping(value = "/{username}")
    ResponseEntity<EmployeeResponse> getEmployeeByUsername(@PathVariable String username) {
        var employee = employeeService.receiveAnEmployeeByUsername(username);
        return ResponseEntity.ok(employee);
    }

    @PutMapping(value = "/{username}")
    ResponseEntity<EmployeeResponse> getEmployeeByUsername(@PathVariable String username, @RequestBody EmployeeRequest request) {
        var updatedEmployee = employeeService.updateEmployeeByUsername(request, username);
        return ResponseEntity.ok(updatedEmployee);
    }

    @DeleteMapping(value = "/{username}")
    void deleteEmployeeByUsername(@PathVariable String username) {
        employeeService.deleteEmployeeByUsername(username);
    }
}
