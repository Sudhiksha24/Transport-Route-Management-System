package com.wipro.route.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtil {

    public static Connection getDBConnection() {
        Connection con = null;
        try {
            Class.forName("oracle.jdbc.OracleDriver");

            con = DriverManager.getConnection(
                "jdbc:oracle:thin:@//localhost:1521/XEPDB1",
                "system",
                "admin"
            );

            System.out.println("Connection Successful");

        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }
}
