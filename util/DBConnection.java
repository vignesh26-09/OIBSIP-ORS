package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    public static Connection getConnection() throws SQLException {
        String password = System.getenv("DB_PASSWORD");
        if (password == null || password.isBlank()) {
            throw new IllegalStateException("Set the DB_PASSWORD environment variable before starting the application.");
        }

        String url = System.getenv().getOrDefault("DB_URL", "jdbc:mysql://localhost:3306/reservation_db");
        String username = System.getenv().getOrDefault("DB_USER", "root");
        return DriverManager.getConnection(url, username, password);
    }
}