package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.Employee;
import com.example.demo.service.EmployeeService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/employee")
@Validated
public class EmployeeController {

    @Autowired
    EmployeeService service;

    // Create Employee
    @PostMapping
    public Employee saveEmployee( @RequestBody Employee employee) {

        return service.saveEmployee(employee);

    }

    // Display All Employees
    @GetMapping
    public List<Employee> getEmployees() {

        return service.getAllEmployees();

    }
    // Raise Salary
    @PutMapping("/raise")
    public Employee raiseSalary(
            @RequestParam String name,
            @RequestParam int percentage) {

        return service.raiseSalary(name, percentage);

    }

}