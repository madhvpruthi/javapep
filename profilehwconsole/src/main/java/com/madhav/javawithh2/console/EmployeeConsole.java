package com.madhav.javawithh2.console;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.madhav.javawithh2.entity.employee;
import com.madhav.javawithh2.service.userservice;

@Component
public class EmployeeConsole {

    @Autowired
    private userservice service;

    public void start() {

        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\n===================================");
            System.out.println(" EMPLOYEE MANAGEMENT SYSTEM ");
            System.out.println("===================================");
            System.out.println("1. Create Employee");
            System.out.println("2. Display Employees");
            System.out.println("3. Raise Salary");
            System.out.println("4. Delete Employee");
            System.out.println("5. Exit");
            System.out.print("Enter Choice : ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

            case 1:

                System.out.print("Enter Name : ");
                String name = sc.nextLine();

                System.out.print("Enter Age : ");
                int age = sc.nextInt();
                sc.nextLine();

                System.out.println("\nDesignation");
                System.out.println("1. Programmer");
                System.out.println("2. Manager");
                System.out.println("3. Tester");

                System.out.print("Enter Choice : ");

                int d = sc.nextInt();
                sc.nextLine();

                String designation = "";

                switch (d) {

                case 1:
                    designation = "Programmer";
                    break;

                case 2:
                    designation = "Manager";
                    break;

                case 3:
                    designation = "Tester";
                    break;

                default:
                    System.out.println("Invalid Designation");
                    continue;

                }

                double salary = 0;

                if (designation.equalsIgnoreCase("Programmer"))
                    salary = 60000;

                else if (designation.equalsIgnoreCase("Manager"))
                    salary = 50000;

                else
                    salary = 55000;

                System.out.println("\n-------------DETAILS-------------");
                System.out.println("Name : " + name);
                System.out.println("Age : " + age);
                System.out.println("Designation : " + designation);
                System.out.println("Salary : " + salary);

                System.out.print("\nConfirm (Yes/No) : ");

                String confirm = sc.nextLine();

                if (confirm.equalsIgnoreCase("Yes")) {

                    employee emp = service.createEmployee(name, age, designation);

                    System.out.println("\nEmployee Created Successfully.");
                    System.out.println("Employee ID : " + emp.getId());

                } else {

                    System.out.println("Cancelled.");

                }

                break;

            case 2:

                List<employee> employees = service.displayEmployees();

                if (employees.isEmpty()) {

                    System.out.println("No Employees.");

                } else {

                    System.out.println();

                    System.out.printf("%-5s %-15s %-10s %-15s %-10s%n",
                            "ID", "NAME", "AGE", "DESIGNATION", "SALARY");

                    for (employee e : employees) {

                        System.out.printf("%-5d %-15s %-10d %-15s %-10.2f%n",
                                e.getId(),
                                e.getName(),
                                e.getAge(),
                                e.getDesignation(),
                                e.getSalary());

                    }

                }

                break;

            case 3:

                System.out.print("Enter Employee ID : ");

                Long id = sc.nextLong();

                employee employee = service.raiseSalary(id);

                if (employee == null) {

                    System.out.println("Employee Not Found");

                } else {

                    System.out.println("Salary Raised.");
                    System.out.println("New Salary : " + employee.getSalary());

                }

                break;

            case 4:

                System.out.print("Enter Employee ID : ");

                Long deleteId = sc.nextLong();

                boolean deleted = service.deleteEmployee(deleteId);

                if (deleted)

                    System.out.println("Deleted Successfully.");

                else

                    System.out.println("Employee Not Found.");

                break;

            case 5:

                System.out.println("Thank You");
                System.exit(0);

            default:

                System.out.println("Invalid Choice.");

            }

        }

    }

}