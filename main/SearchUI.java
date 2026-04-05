package main;

import javax.swing.*;
import java.awt.*;
import java.sql.*;

import util.DBConnection;

public class SearchUI {

    public SearchUI() {

        JFrame frame = new JFrame("Search Ticket");
        frame.setSize(300, 200);
        frame.setLayout(new GridLayout(3,2));

        JTextField pnrField = new JTextField();
        JButton searchBtn = new JButton("Search");

        frame.add(new JLabel("Enter PNR"));
        frame.add(pnrField);
        frame.add(searchBtn);

        searchBtn.addActionListener(e -> {
            try {
                Connection con = DBConnection.getConnection();

                String query = "SELECT * FROM reservations WHERE pnr=?";
                PreparedStatement ps = con.prepareStatement(query);
                ps.setString(1, pnrField.getText());

                ResultSet rs = ps.executeQuery();

                if (rs.next()) {
                    JOptionPane.showMessageDialog(frame,
                        "Name: " + rs.getString(2) +
                        "\nTrain: " + rs.getString(6) +
                        "\nFrom: " + rs.getString(8) +
                        "\nTo: " + rs.getString(9)
                    );
                } else {
                    JOptionPane.showMessageDialog(frame, "Not Found");
                }

            } catch (Exception ex) {
                System.out.println("Error");
            }
        });

        frame.setVisible(true);
    }
}