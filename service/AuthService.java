package service;

import util.DBConnection;
import java.sql.*;

public class AuthService {

    public boolean login(String user, String pass) {

        try {
            Connection con = DBConnection.getConnection();

            String query = "SELECT * FROM users WHERE username=? AND password=?";
            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1, user);
            ps.setString(2, pass);

            ResultSet rs = ps.executeQuery();

            return rs.next();

        } catch (Exception e) {
            System.out.println("❌ Login Error");
        }

        return false;
    }
}