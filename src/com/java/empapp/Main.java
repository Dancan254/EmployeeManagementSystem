package com.java.empapp;

import com.java.empapp.dao.EmployeeDaoImpl;
import com.java.empapp.dao.EmployeeDaoInterface;

import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        String name;
        int id;
        //object of employee dao
        EmployeeDaoInterface dao = new EmployeeDaoImpl();
        System.out.println("Welcome to employee management application system");

        int choice = 0;
        do{
            System.out.println("""
                    1. Add employee
                    2. Show All employee
                    3. Show Employee based on id
                    4. Update employee
                    5. Delete employee
                    6. Exit""");
            System.out.println("Input option");
            switch (choice = scanner.nextInt()){
                case 1 -> {
                    Employee employee = new Employee();
                    System.out.println("Enter ID: ");
                    id = scanner.nextInt();
                    System.out.println("Enter name: ");
                    scanner.nextLine();
                    name = scanner.nextLine();
                    System.out.println("Enter salary: ");
                    double salary = scanner.nextDouble();
                    System.out.println("Enter age: ");
                    int age = scanner.nextInt();
//                    employee.setId(id);
//                    employee.setName(name);
//                    employee.setSalary(salary);
//                    employee.setAge(age);
                    employee = new Employee(id, name, salary, age);
                    dao.createEmployee(employee);
                }
                case 2 -> dao.showEmployee();
                case 3 -> {
                    System.out.println("Enter id of user you wish to access: ");
                    id = scanner.nextInt();
                    dao.showEmployeeBasedOnID(id);
                }
                case 4 -> {
                    System.out.println("Enter Id of employee: ");
                    id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Enter new name: ");
                    name = scanner.nextLine();
                    dao.updateEmployee(id, name);
                }
                case 5 -> {
                    System.out.println("Enter Id of user you wish to delete: ");
                    id = scanner.nextInt();
                    dao.deleteEmployee(id);
                }
                case 6 ->{
                    System.out.println("Thank you for using our services!!!");
                    scanner.close();
                }
                default -> System.out.println("Invalid choice!!");
            }
        }while(choice != 6);
    }
}
