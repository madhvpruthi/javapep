package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Employee;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.EmployeeRepository;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository repository;

    // Create Employee
    public Employee saveEmployee(Employee employee) {

        String designation = employee.getDesignation();

        if(designation.equalsIgnoreCase("Programmer")) {
            employee.setSalary(60000.0);
        }
        else if(designation.equalsIgnoreCase("Tester")) {
            employee.setSalary(70000.0);
        }
        else if(designation.equalsIgnoreCase("Manager")) {
            employee.setSalary(50000.0);
        }
        else {
            throw new IllegalArgumentException("Invalid Designation");
        }

        return repository.save(employee);
    }

    // Display Employees
    public List<Employee> getAllEmployees() {

        return repository.findAll();

    }

    // Raise Salary
    public Employee raiseSalary(String name, int percentage) {

        if (percentage < 1 || percentage > 10) {

            throw new IllegalArgumentException("Percentage should be between 1 and 10");

        }

        Employee employee = repository.findByName(name)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found"));

        double updatedSalary = employee.getSalary()
                + (employee.getSalary() * percentage / 100);

        employee.setSalary(updatedSalary);

        return repository.save(employee);

    }

}