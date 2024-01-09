package com.java.empapp.dbc;

import java.sql.Connection;
import java.sql.DriverManager;
public class DBConnection {
    private static Connection connection;

    public static Connection createDbConnection(){
        //load driver
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            //get connection
            String url = "jdbc:mysql://localhost:3306/employeeDb";
            String username = "root";
            String password = "password";
            connection = DriverManager.getConnection(url, username, password);
        }catch (Exception e){
            e.printStackTrace();
        }
        return connection;
    }
}
