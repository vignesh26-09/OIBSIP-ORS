package main;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;

import util.*;
import model.*;

public class BookingUI {

    public BookingUI() {

        JFrame frame = new JFrame("Book Ticket");
        frame.setSize(400, 400);
        frame.setLayout(new GridLayout(10,2));

        JTextField name = new JTextField();
        JTextField age = new JTextField();
        JTextField gender = new JTextField();
        JTextField trainNo = new JTextField();
        JTextField classType = new JTextField();
        JTextField from = new JTextField();
        JTextField to = new JTextField();
        JTextField date = new JTextField();

        JButton submit = new JButton("Book");

        frame.add(new JLabel("Name")); frame.add(name);
        frame.add(new JLabel("Age")); frame.add(age);
        frame.add(new JLabel("Gender")); frame.add(gender);
        frame.add(new JLabel("Train No")); frame.add(trainNo);
        frame.add(new JLabel("Class")); frame.add(classType);
        frame.add(new JLabel("From")); frame.add(from);
        frame.add(new JLabel("To")); frame.add(to);
        frame.add(new JLabel("Date")); frame.add(date);
        frame.add(submit);

        submit.addActionListener(e -> {
            try {
                String pnr = PNRGenerator.generatePNR();
                String trainName = Train.getTrainName(Integer.parseInt(trainNo.getText()));

                Connection con = DBConnection.getConnection();

                String query = "INSERT INTO reservations VALUES (?,?,?,?,?,?,?,?,?,?)";
                PreparedStatement ps = con.prepareStatement(query);

                ps.setString(1, pnr);
                ps.setString(2, name.getText());
                ps.setInt(3, Integer.parseInt(age.getText()));
                ps.setString(4, gender.getText());
                ps.setInt(5, Integer.parseInt(trainNo.getText()));
                ps.setString(6, trainName);
                ps.setString(7, classType.getText());
                ps.setString(8, from.getText());
                ps.setString(9, to.getText());
                ps.setString(10, date.getText());

                ps.executeUpdate();

                JOptionPane.showMessageDialog(frame, "Booked! PNR: " + pnr);

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(frame, "Error booking ticket");
            }
        });

        frame.setVisible(true);
    }
}