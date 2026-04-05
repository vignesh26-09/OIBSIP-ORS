package util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // 🔥 IMPORTANT

            return DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/reservation_db",
                "root",
                "Vignesh_26"   // ⚠️ change this
            );

        } catch (Exception e) {
            e.printStackTrace(); // 🔥 shows real error
            return null;
        }
    }
}