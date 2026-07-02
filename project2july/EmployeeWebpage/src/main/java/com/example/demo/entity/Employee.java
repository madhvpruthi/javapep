package com.example.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "Name cannot be empty")
    @Pattern(
            regexp = "^[A-Za-z]+( [A-Za-z]+){0,2}$",
            message = "Name should contain only letters and maximum 2 spaces"
    )
    private String name;

    @Min(value = 18, message = "Age must be at least 18")
    @Max(value = 60, message = "Age cannot exceed 60")
    private int age;

    
    private double salary;

    @NotBlank(message = "Designation cannot be empty")
    private String designation;

    public Employee() {
    }

    public Employee(Integer id, String name, int age, double salary, String designation) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.designation = designation;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }
}

