package com.example.fitnesstracker.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    public static Connection getConnection() throws Exception {
        return DriverManager.getConnection("jdbc:mysql://localhost:8889/fitness_tracker", "root", "root");
    }
}