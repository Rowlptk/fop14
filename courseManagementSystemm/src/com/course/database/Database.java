package com.course.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {

    private final static String className = "com.mysql.cj.jdbc.Driver";
    private final static String url = "jdbc:mysql://localhost:3306/course_manager";
    private final static String user = "courseManager";
    private final static String password = "courseManager";
    private static Connection connection;

    public static Connection getConnection() {
        if(connection == null) {
            try {
                Class.forName(className);
                connection = DriverManager.getConnection(url, user, password);
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return connection;
    }
}
