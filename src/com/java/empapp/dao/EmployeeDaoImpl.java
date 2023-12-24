package com.java.empapp.dao;

import com.java.empapp.DBC.DBConnection;
import com.java.empapp.Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class EmployeeDaoImpl implements EmployeeDaoInterface{
    Connection con;
    @Override
    public void createEmployee(Employee employee) {
        //get connection
        con = DBConnection.createDbConnection();
        String query ="insert into employee values(?, ?, ?, ?)";
        try {
            PreparedStatement pstm = con.prepareStatement(query);
            pstm.setInt(1, employee.getId());
            pstm.setString(2, employee.getName());
            pstm.setDouble(3, employee.getSalary());
            pstm.setInt(4, employee.getAge());
            int count = pstm.executeUpdate();
            if (count != 0){
                System.out.println("Employee inserted successfully");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void showEmployee() {

    }

    @Override
    public void showEmployeeBasedOnID(int id) {

    }

    @Override
    public void updateEmployee(int id, String name) {

    }

    @Override
    public void deleteEmployee(int id) {

    }
}
