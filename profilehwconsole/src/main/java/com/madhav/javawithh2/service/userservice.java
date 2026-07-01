package com.madhav.javawithh2.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.madhav.javawithh2.entity.employee;
import com.madhav.javawithh2.repository.userrepository;

@Service
public class userservice {

    @Autowired
    private userrepository repository;

    // Create Employee
    public employee createEmployee(String name, int age, String designation) {

        employee employee = new employee();

        employee.setName(name);
        employee.setAge(age);
        employee.setDesignation(designation);

        switch (designation.toLowerCase()) {

        case "programmer":
            employee.setSalary(60000);
            break;

        case "manager":
            employee.setSalary(50000);
            break;

        case "tester":
            employee.setSalary(55000);
            break;

        default:
            employee.setSalary(0);
        }

        return repository.save(employee);
    }

    // Display All Employees
    public List<employee> displayEmployees() {

        return repository.findAll();

    }

    // Display Employee by ID
    public employee displayEmployee(Long id) {

        Optional<employee> emp = repository.findById(id);

        if (emp.isPresent()) {
            return emp.get();
        }

        return null;
    }

    // Raise Salary
    public employee raiseSalary(Long id) {

        Optional<employee> emp = repository.findById(id);

        if (emp.isPresent()) {

            employee employee = emp.get();

            employee.setSalary(employee.getSalary() + 5000);

            return repository.save(employee);

        }

        return null;
    }

    // Delete Employee
    public boolean deleteEmployee(Long id) {

        Optional<employee> emp = repository.findById(id);

        if (emp.isPresent()) {

            repository.deleteById(id);

            return true;
        }

        return false;
    }

}