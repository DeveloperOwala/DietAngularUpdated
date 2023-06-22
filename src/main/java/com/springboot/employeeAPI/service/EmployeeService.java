package com.springboot.employeeAPI.service;

import com.springboot.employeeAPI.exception.UserNotFoundException;
import com.springboot.employeeAPI.model.Employee;
import com.springboot.employeeAPI.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee addEmployee(Employee employee){

        return employeeRepository.save(employee);
    }

    public List<Employee> findAllEmployees(){
        return employeeRepository.findAll();
    }
    public Employee updateEmployee(Employee employee){
        return employeeRepository.save(employee);

    }
    public Employee getEmployeeById(Long id){
        return employeeRepository.getEmployeeById(id);

    }
    public  void deleteEmployee(Long id){
         employeeRepository.deleteEmployeeById(id);
    }
}
