package Electricity.Billing.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Login extends JFrame implements ActionListener {
    JButton Login, Cancel, SignUp;
    JTextField tfUsername, tfPassword;
    Choice loginIn;

    Login() {
        super("Login Page");
        getContentPane().setBackground(Color.white);
        setLayout(null);

        JLabel lblUsername = new JLabel("Username");
        lblUsername.setBounds(210, 20, 100, 20);
        add(lblUsername);

        tfUsername = new JTextField();
        tfUsername.setBounds(310, 20, 150, 20);
        add(tfUsername);

        JLabel lblPassword = new JLabel("Password");
        lblPassword.setBounds(210, 60, 100, 20);
        add(lblPassword);

        tfPassword = new JPasswordField();
        tfPassword.setBounds(310, 60, 150, 20);
        add(tfPassword);

        JLabel loginAs = new JLabel("Login in as");
        loginAs.setBounds(210, 100, 100, 20);
        add(loginAs);

        loginIn = new Choice();
        loginIn.add("Admin");
        loginIn.add("Customer");
        loginIn.setBounds(310, 100, 150, 20);
        add(loginIn);

        // Login button
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/login.png"));
        Image i2 = i1.getImage().getScaledInstance(12, 12, Image.SCALE_DEFAULT);
        Login = new JButton("Login", new ImageIcon(i2));
        Login.setBounds(220, 160, 100, 20);
        Login.addActionListener(this);
        add(Login);

        // Cancel button
        ImageIcon i3 = new ImageIcon(ClassLoader.getSystemResource("icon/cancel.jpg"));
        Image i4 = i3.getImage().getScaledInstance(12, 12, Image.SCALE_DEFAULT);
        Cancel = new JButton("Cancel", new ImageIcon(i4));
        Cancel.setBounds(350, 160, 100, 20);
        Cancel.addActionListener(this);
        add(Cancel);

        // SignUp button
        ImageIcon i5 = new ImageIcon(ClassLoader.getSystemResource("icon/signup.png"));
        Image i6 = i5.getImage().getScaledInstance(12, 12, Image.SCALE_DEFAULT);
        SignUp = new JButton("SignUp", new ImageIcon(i6));
        SignUp.setBounds(270, 200, 100, 20);
        SignUp.addActionListener(this);
        add(SignUp);

        // Image
        ImageIcon i7 = new ImageIcon(ClassLoader.getSystemResource("icon/second.jpg"));
        Image i8 = i7.getImage().getScaledInstance(250, 230, Image.SCALE_DEFAULT);
        JLabel image = new JLabel(new ImageIcon(i8));
        image.setBounds(0, 0, 200, 200);
        add(image);

        setSize(500, 300);
        setLocation(300, 200);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == Login) {
            String username = tfUsername.getText();
            String password = tfPassword.getText();
            String userType = loginIn.getSelectedItem();

            try {
                Conn c = new Conn();
                String query = "SELECT * FROM login WHERE username = '" + username + "' AND password = '" + password + "' AND user_type = '" + userType + "'";
                ResultSet rs = c.s.executeQuery(query);

                if (rs.next()) {
                    String meter = rs.getString("meter_no");
                    setVisible(false);
                    new Project(userType, meter);
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid Login");
                    tfUsername.setText("");
                    tfPassword.setText("");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == Cancel) {
            setVisible(false);
        } else if (ae.getSource() == SignUp) {
            setVisible(false);
            new Signup();
        }
    }

    public static void main(String[] args) {
        new Login();
    }
}