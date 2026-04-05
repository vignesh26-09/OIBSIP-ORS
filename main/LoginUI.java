package main;

import javax.swing.*;
import java.awt.*;
import service.AuthService;

public class LoginUI {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Login");
        frame.setSize(300, 200);
        frame.setLayout(new GridLayout(3,2));

        JTextField userField = new JTextField();
        JPasswordField passField = new JPasswordField();

        JButton loginBtn = new JButton("Login");

        frame.add(new JLabel("Username"));
        frame.add(userField);
        frame.add(new JLabel("Password"));
        frame.add(passField);
        frame.add(loginBtn);

        loginBtn.addActionListener(e -> {
            String user = userField.getText();
            String pass = new String(passField.getPassword());

            if (new AuthService().login(user, pass)) {
                frame.dispose();
                new DashboardUI();
            } else {
                JOptionPane.showMessageDialog(frame, "Invalid Login");
            }
        });

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}