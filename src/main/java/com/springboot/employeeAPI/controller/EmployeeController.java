package com.springboot.employeeAPI.controller;

import com.springboot.employeeAPI.model.Employee;
import com.springboot.employeeAPI.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
 private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    @GetMapping("/all")
    public ResponseEntity<List<Employee>> getAllEmployees(){
        List<Employee> employees = employeeService.findAllEmployees();

        return new ResponseEntity<>(employees, HttpStatus.OK);
    }
    // get employee by id rest API
    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") Long id){
        Employee employee = employeeService.getEmployeeById(id);

        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee){
        Employee newEmployee = employeeService.addEmployee(employee);
        return  new ResponseEntity<>(newEmployee, HttpStatus.CREATED);
    }
    @PutMapping("/update")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee){
        Employee updateEmployee = employeeService.updateEmployee(employee);
        return  new ResponseEntity<>(updateEmployee, HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable("id") Long id){
       employeeService.deleteEmployee(id);
        return  new ResponseEntity<>(HttpStatus.OK);
    }


//    @Autowired
//    private EmployeeService employeeService;
//
//    // get all employees
//
//    @GetMapping("/all")
//    public List<Employee> getAllEmployees(){
//        return employeeRepository.findAll();
//    }
//
//    // create employee rest API
//    @PostMapping("/employees")
//    public Employee createEmployee( @RequestBody Employee employee){
//        return employeeRepository.save(employee);
//    }

}
