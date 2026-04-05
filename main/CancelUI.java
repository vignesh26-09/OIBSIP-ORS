package main;

import javax.swing.*;
import java.awt.*;
import java.sql.*;

import util.DBConnection;

public class CancelUI {

    public CancelUI() {

        JFrame frame = new JFrame("Cancel Ticket");
        frame.setSize(300, 200);
        frame.setLayout(new GridLayout(3,2));

        JTextField pnrField = new JTextField();
        JButton cancelBtn = new JButton("Cancel");

        frame.add(new JLabel("Enter PNR"));
        frame.add(pnrField);
        frame.add(cancelBtn);

        cancelBtn.addActionListener(e -> {
            try {
                Connection con = DBConnection.getConnection();

                String query = "DELETE FROM reservations WHERE pnr=?";
                PreparedStatement ps = con.prepareStatement(query);
                ps.setString(1, pnrField.getText());

                int rows = ps.executeUpdate();

                if (rows > 0) {
                    JOptionPane.showMessageDialog(frame, "Cancelled");
                } else {
                    JOptionPane.showMessageDialog(frame, "PNR Not Found");
                }

            } catch (Exception ex) {
                System.out.println("Error");
            }
        });

        frame.setVisible(true);
    }
}