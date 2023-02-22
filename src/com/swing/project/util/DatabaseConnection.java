package com.swing.project.util;

import java.sql.*;

public class DatabaseConnection {
    public static Connection getDBConnection(){
        Connection con = null;
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/organization_management", "root", "root");
        } catch (Exception e) {
        }
        return con;
    }
}
