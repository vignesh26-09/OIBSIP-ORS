package service;

import model.*;
import util.*;

import java.sql.*;
import java.util.Scanner;

public class ReservationService {

    public void bookTicket(Scanner sc) {

        sc.nextLine();

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        int age;
        while (true) {
            System.out.print("Enter Age: ");
            age = sc.nextInt();
            if (age > 0) break;
            else System.out.println("❌ Invalid age");
        }

        sc.nextLine();
        System.out.print("Enter Gender: ");
        String gender = sc.nextLine();

        Passenger passenger = new Passenger(name, age, gender);

        System.out.print("Enter Train Number: ");
        int trainNo = sc.nextInt();

        String trainName = Train.getTrainName(trainNo);
        if (trainName.equals("Unknown Train")) {
            System.out.println("❌ Invalid Train Number");
            return;
        }

        System.out.println("Train: " + trainName);

        sc.nextLine();
        System.out.print("Enter Class Type: ");
        String classType = sc.nextLine();

        System.out.print("From: ");
        String from = sc.nextLine();

        System.out.print("To: ");
        String to = sc.nextLine();

        System.out.print("Date: ");
        String date = sc.nextLine();

        String pnr = PNRGenerator.generatePNR();

        try {
            Connection con = DBConnection.getConnection();

            String query = "INSERT INTO reservations VALUES (?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1, pnr);
            ps.setString(2, name);
            ps.setInt(3, age);
            ps.setString(4, gender);
            ps.setInt(5, trainNo);
            ps.setString(6, trainName);
            ps.setString(7, classType);
            ps.setString(8, from);
            ps.setString(9, to);
            ps.setString(10, date);

            ps.executeUpdate();

            System.out.println("\n✅ BOOKING CONFIRMED");
            System.out.println("PNR: " + pnr);

        } catch (Exception e) {
            System.out.println("❌ Error saving reservation");
        }
    }

    // 🔍 SEARCH FEATURE
    public void searchTicket(Scanner sc) {

        sc.nextLine();
        System.out.print("Enter PNR: ");
        String pnr = sc.nextLine();

        try {
            Connection con = DBConnection.getConnection();

            String query = "SELECT * FROM reservations WHERE pnr=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, pnr);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                System.out.println("\n===== BOOKING DETAILS =====");
                System.out.println("PNR: " + rs.getString(1));
                System.out.println("Name: " + rs.getString(2));
                System.out.println("Train: " + rs.getString(6));
                System.out.println("From: " + rs.getString(8) + " → " + rs.getString(9));
                System.out.println("Date: " + rs.getString(10));
            } else {
                System.out.println("❌ No record found");
            }

        } catch (Exception e) {
            System.out.println("❌ Search error");
        }
    }
}