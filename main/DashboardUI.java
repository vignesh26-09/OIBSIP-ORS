package main;

import javax.swing.*;
import java.awt.*;

public class DashboardUI {

    public DashboardUI() {

        JFrame frame = new JFrame("Dashboard");
        frame.setSize(400, 300);
        frame.setLayout(new GridLayout(4,1));

        JButton bookBtn = new JButton("Book Ticket");
        JButton searchBtn = new JButton("Search Ticket");
        JButton cancelBtn = new JButton("Cancel Ticket");
        JButton exitBtn = new JButton("Exit");

        frame.add(bookBtn);
        frame.add(searchBtn);
        frame.add(cancelBtn);
        frame.add(exitBtn);

        bookBtn.addActionListener(e -> new BookingUI());
        searchBtn.addActionListener(e -> new SearchUI());
        cancelBtn.addActionListener(e -> new CancelUI());
        exitBtn.addActionListener(e -> System.exit(0));

        frame.setVisible(true);
    }
}