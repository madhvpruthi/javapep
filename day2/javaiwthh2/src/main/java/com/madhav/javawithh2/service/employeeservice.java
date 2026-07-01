package com.madhav.javawithh2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.madhav.javawithh2.EmployeeNotFoundException;
import com.madhav.javawithh2.entity.employee;
import com.madhav.javawithh2.repository.employeerepo;

@Service
public class employeeservice {

    @Autowired
    private employeerepo employeerepo;

    public employee saveEmployee(employee employee) {
        return employeerepo.save(employee);
    }

    public List<employee> getAllEmployees() {
        return employeerepo.findAll();
    }

    public employee getEmployeeById(Long id) {

        return employeerepo.findById(id)
                .orElseThrow(() ->
                        new EmployeeNotFoundException(
                                "Employee with id " + id + " does not exist"));
    }

    public employee updateEmployee(Long id, employee employee) {

        if (!employeerepo.existsById(id)) {
            throw new EmployeeNotFoundException(
                    "Employee with id " + id + " does not exist");
        }

        employee.setId(id);
        return employeerepo.save(employee);
    }

    public void deleteEmployee(Long id) {

        if (!employeerepo.existsById(id)) {
            throw new EmployeeNotFoundException(
                    "Employee with id " + id + " does not exist");
        }

        employeerepo.deleteById(id);
    }
}