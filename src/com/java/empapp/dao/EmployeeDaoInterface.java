package com.java.empapp.dao;

import com.java.empapp.Employee;

public interface EmployeeDaoInterface {
    //crud operations to be performed
    //create employee
    void createEmployee(Employee employee);
    //show all employee
    void showEmployee();
    //show employee based on id
    void showEmployeeBasedOnID(int id);
    //update employee
    void updateEmployee(int id, String name);
    //delete employee
    void deleteEmployee(int id);


}
