package com.enuygun.enuyguncookieemployeeapi.jpa;

import com.enuygun.enuyguncookieemployeeapi.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IEmployeeRepository extends JpaRepository<Employee, Long> {

    Optional<Employee> findEmployeeByUsername(String username);

    boolean existsEmployeeByUsernameOrEmail(String username, String email);

}
