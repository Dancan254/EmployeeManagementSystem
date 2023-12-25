package com.java.empapp.dao;

import com.java.empapp.DBC.DBConnection;
import com.java.empapp.Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

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
                System.out.println("Employee added successfully");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void showEmployee() {
        con = DBConnection.createDbConnection();
        String query = "select * from employee";
        try{
            Statement statement = con.createStatement();
            ResultSet set = statement.executeQuery(query);
            System.out.println("Id\tName\t\tSalary\t\t\tAge");
            System.out.println("_ _ ".repeat(10));
            while(set.next()){
                System.out.printf("%d\t%-10s\t%.2f\t\t%d%n", set.getInt(1),
                        set.getString(2), set.getDouble(3),
                        set.getInt(4)
                );
                System.out.println("_ _ ".repeat(10));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void showEmployeeBasedOnID(int id) {
        con = DBConnection.createDbConnection();
        String query = "select * from employee where id = ?";
        try{
            PreparedStatement statement = con.prepareStatement(query);
            statement.setInt(1, id);
            ResultSet set = statement.executeQuery();
            System.out.println("Id\tName\t\tSalary\t\t\tAge");
            System.out.println("_ _ ".repeat(10));
            while(set.next()) {
                System.out.printf("%d\t%-10s\t%.2f\t\t%d%n", set.getInt(1),
                        set.getString(2), set.getDouble(3),
                        set.getInt(4)
                );
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void updateEmployee(int id, String name) {
        con = DBConnection.createDbConnection();
        String query = "update employee set name = ? where id = ?";
        try{
        PreparedStatement statement = con.prepareStatement(query);
        statement.setString(1, name);
        statement.setInt(2, id);
        int count = statement.executeUpdate();
        if (count != 0){
            System.out.println("Successfully updated employee");
        }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void deleteEmployee(int id) {
        con = DBConnection.createDbConnection();
        String query = "delete from employee where id = ?";
        try{
            PreparedStatement statement = con.prepareStatement(query);
            statement.setInt(1,id);
            int count = statement.executeUpdate();
            if (count != 0){
                System.out.println("Successfully deleted employee");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
