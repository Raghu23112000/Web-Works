package com.example.WebWorks.DBoperations;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBconnect {
    private static Connection conn;

    //connection object returned
    public static Connection getConn() {
        try{
            Class.forName("org.mariadb.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost/webworks", "root","");
        }
        catch(Exception ee)
        {
            System.out.println("Connection Error!"+ee);
        }
        return conn;
    }
}
