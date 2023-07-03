package com.raven.login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.Statement;


public class DBConnect {

    public static Connection connect() {
        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/apartment", "root", "");
            JOptionPane.showMessageDialog(null, "Connected to the database");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e);
        }
        return con;
    }

    public static void createTable(){
    try (Connection con = DBConnect.connect();
         Statement stmt = con.createStatement()) {
        // Create table for residents
        String residentTableSql = "CREATE TABLE IF NOT EXISTS resident (" +
                "email VARCHAR(100) NOT NULL, " +
                "password VARCHAR(100) NOT NULL, " +
                "type VARCHAR(50) NOT NULL, " +
                "PRIMARY KEY (email))";
        stmt.executeUpdate(residentTableSql);
        System.out.println("Table 'resident' created successfully.");
    } catch (SQLException e) {
        e.printStackTrace();
    }
  }

}

