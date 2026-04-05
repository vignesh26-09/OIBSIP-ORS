package service;

import util.DBConnection;
import java.sql.*;
import java.util.Scanner;

public class CancellationService {

    public void cancelTicket(Scanner sc) {

        sc.nextLine();
        System.out.print("Enter PNR: ");
        String pnr = sc.nextLine();

        try {
            Connection con = DBConnection.getConnection();

            // Check if exists
            String checkQuery = "SELECT * FROM reservations WHERE pnr=?";
            PreparedStatement checkPs = con.prepareStatement(checkQuery);
            checkPs.setString(1, pnr);

            ResultSet rs = checkPs.executeQuery();

            if (!rs.next()) {
                System.out.println("❌ PNR not found");
                return;
            }

            System.out.println("Booking found for: " + rs.getString(2));

            System.out.print("Confirm cancellation (yes/no): ");
            String confirm = sc.nextLine();

            if (confirm.equalsIgnoreCase("yes")) {

                String deleteQuery = "DELETE FROM reservations WHERE pnr=?";
                PreparedStatement ps = con.prepareStatement(deleteQuery);
                ps.setString(1, pnr);

                ps.executeUpdate();

                System.out.println("✅ Ticket Cancelled");
            }

        } catch (Exception e) {
            System.out.println("❌ Cancellation error");
        }
    }
}