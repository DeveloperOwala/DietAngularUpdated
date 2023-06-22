package com.springboot.employeeAPI.repository;

import com.springboot.employeeAPI.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepository  extends JpaRepository<Employee, Long> {
    void deleteEmployeeById(Long id);

    Employee getEmployeeById(Long id);
}
