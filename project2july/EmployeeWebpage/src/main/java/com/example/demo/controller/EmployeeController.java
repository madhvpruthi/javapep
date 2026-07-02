package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.Employee;
import com.example.demo.service.EmployeeService;

import jakarta.validation.Valid;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    // Home Page
    @GetMapping("/")
    public String home() {
        return "home";
    }

    // Open Add Employee Form
    @GetMapping("/add")
    public String addEmployeeForm(Model model) {
        model.addAttribute("employee", new Employee());
        return "addEmployee";
    }

    // Save Employee
    @PostMapping("/save")
    public String saveEmployee(@Valid @ModelAttribute Employee employee,
                               BindingResult result) {

        System.out.println("========== FORM DATA ==========");
        System.out.println("Name : " + employee.getName());
        System.out.println("Age : " + employee.getAge());
        System.out.println("Designation : " + employee.getDesignation());
        System.out.println("Salary : " + employee.getSalary());

        if(result.hasErrors()) {

            result.getAllErrors().forEach(System.out::println);

            return "addEmployee";
        }

        service.saveEmployee(employee);

        return "redirect:/display";
    }
    // Display Employees
    @GetMapping("/display")
    public String displayEmployees(Model model) {

        model.addAttribute("employees", service.getAllEmployees());

        return "displayEmployees";
    }

    
    @GetMapping("/search")
    public String searchPage() {

        return "searchEmployee";

    }
    
    @PostMapping("/search")
    public String searchEmployee(

            @RequestParam(required = false) Integer id,

            @RequestParam(required = false) String name,

            Model model) {

        Employee employee;

        if (id != null) {

            employee = service.getEmployeeById(id);

        }
        else {

            employee = service.getEmployeeByName(name);

        }

        model.addAttribute("employee", employee);

        return "displayOneEmployee";

    }
    
    @GetMapping("/exit")

    public String exit(Model model){

        model.addAttribute("message",

                "Thank You For Using Employee Management System");

        return "success";

    }
    
    // Raise Salary Page
    @GetMapping("/raise")
    public String raiseSalaryPage() {
        return "raiseSalary";
    }
    
    

    // Update Salary
    @PostMapping("/raise")
    public String raiseSalary(

            @RequestParam(required = false) Integer id,

            @RequestParam(required = false) String name,

            @RequestParam int percentage,

            Model model) {

        service.raiseSalary(id,name, percentage);

        model.addAttribute("message", "Salary Updated Successfully");

        return "success";

    }

}