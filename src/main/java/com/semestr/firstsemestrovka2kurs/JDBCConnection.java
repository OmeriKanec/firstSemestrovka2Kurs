package com.semestr.firstsemestrovka2kurs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConnection {
    private static Connection conn = null;
    private final static String URL = "jdbc:postgresql://localhost:5432/SemestrWorkOnServlets";
    private final static String USERNAME = "postgres";
    private final static String PASSWORD = "3009";

    public static Connection getConn() {
        if (conn == null) {
            try {
                Class.forName("org.postgresql.Driver");
                conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
        return conn;
    }
}