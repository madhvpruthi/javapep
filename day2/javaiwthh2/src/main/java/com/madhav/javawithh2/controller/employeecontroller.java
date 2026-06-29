package com.madhav.javawithh2.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.madhav.javawithh2.entity.employee;
import com.madhav.javawithh2.service.employeeservice;

@RestController
@RequestMapping("/employees")
public class employeecontroller {

    @Autowired
    private employeeservice employeeservice;

    @PostMapping
    public employee saveEmployee(@RequestBody employee employee) {
        return employeeservice.saveEmployee(employee);
    }

    @GetMapping
    public List<employee> getAllEmployees() {
        return employeeservice.getAllEmployees();
    }

    @GetMapping("/{id}")
    public employee getEmployee(@PathVariable Long id) {
        return employeeservice.getEmployeeById(id);
    }

    @PutMapping("/{id}")
    public employee updateEmployee(@PathVariable Long id,
                                   @RequestBody employee employee) {
        return employeeservice.updateEmployee(id, employee);
    }

    @DeleteMapping("/{id}")
    public String deleteEmployee(@PathVariable Long id) {
        employeeservice.deleteEmployee(id);
        return "Employee Deleted Successfully";
    }
}