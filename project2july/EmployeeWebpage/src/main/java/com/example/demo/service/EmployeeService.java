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

	    switch(employee.getDesignation()) {

	        case "Programmer":
	            employee.setSalary(60000);
	            break;

	        case "Tester":
	            employee.setSalary(70000);
	            break;

	        case "Manager":
	            employee.setSalary(50000);
	            break;

	        default:
	            throw new IllegalArgumentException("Invalid Designation");
	    }

	    return repository.save(employee);
	}

	public Employee getEmployeeById(Integer id){

	    return repository.findById(id)

	            .orElseThrow(() ->

	                    new ResourceNotFoundException("Employee does not exist"));

	}

	public Employee getEmployeeByName(String name){

	    return repository.findByName(name)

	            .orElseThrow(() ->

	                    new ResourceNotFoundException("Employee does not exist"));

	}
	
	// Display Employees
	public List<Employee> getAllEmployees() {

		return repository.findAll();

	}

	// Raise Salary
	public Employee raiseSalary(Integer id, String name, int percentage) {

		if (percentage < 1 || percentage > 10) {

			throw new IllegalArgumentException("Percentage should be between 1 and 10");

		}

		Employee employee;

		if (id != null) {

			employee = repository.findById(id)

					.orElseThrow(() -> new ResourceNotFoundException("Employee does not exist"));

		}

		else {

			employee = repository.findByName(name)

					.orElseThrow(() -> new ResourceNotFoundException("Employee does not exist"));

		}

		employee.setSalary(

				employee.getSalary()

						+ employee.getSalary() * percentage / 100

		);

		return repository.save(employee);

	}

}