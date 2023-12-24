package com.java.empapp;

import com.java.empapp.dao.EmployeeDaoImpl;
import com.java.empapp.dao.EmployeeDaoInterface;

import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        //object of employee dao
        EmployeeDaoInterface dao = new EmployeeDaoImpl();
        System.out.println("Welcome to employee management application");

        do{
            System.out.println("""
                    1. Add employee
                    2. Show All employee
                    3. Show Employee based on id
                    4. Update employee
                    5. Delete employee""");
            System.out.println("Input option");
            int choice = scanner.nextInt();
            switch (choice){
                case 1 -> {
                    Employee employee = new Employee();
                    System.out.println("Enter ID: ");
                    int id = scanner.nextInt();
                    System.out.println("Enter name: ");
                    scanner.nextLine();
                    String name = scanner.nextLine();
                    System.out.println("Enter salary: ");
                    double salary = scanner.nextDouble();
                    System.out.println("Enter age: ");
                    int age = scanner.nextInt();
                    employee.setId(id);
                    employee.setName(name);
                    employee.setSalary(salary);
                    employee.setAge(age);
                    dao.createEmployee(employee);
                }
                case 2 -> dao.showEmployee();
                default -> System.out.println("Invalid choice!!!");
            }
        }while(true);
    }
}
