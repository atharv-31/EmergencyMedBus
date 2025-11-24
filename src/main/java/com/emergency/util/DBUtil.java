package com.emergency.util;
import java.sql.*;

public class DBUtil {

    private static final String URL = "jdbc:mysql://localhost:3306/emergency_med_bus";
    private static final String USER = "root";
    private static final String PASSWORD = "Atharv@04";

    public static Connection getConnection() {
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }
}
