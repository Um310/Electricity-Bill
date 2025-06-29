package ElectricityBillingSystem;

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

        // Load images safely
        ImageIcon loginIcon = loadImageIcon("/icon/login.png", 12, 12);
        ImageIcon cancelIcon = loadImageIcon("/icon/cancel.jpg", 12, 12);
        ImageIcon signupIcon = loadImageIcon("/icon/signup.png", 12, 12);
        ImageIcon mainImage = loadImageIcon("/icon/second.jpg", 250, 230);

        // Login button
        Login = new JButton("Login", loginIcon);
        Login.setBounds(220, 160, 100, 20);
        Login.addActionListener(this);
        add(Login);

        // Cancel button
        Cancel = new JButton("Cancel", cancelIcon);
        Cancel.setBounds(350, 160, 100, 20);
        Cancel.addActionListener(this);
        add(Cancel);

        // SignUp button
        SignUp = new JButton("SignUp", signupIcon);
        SignUp.setBounds(270, 200, 100, 20);
        SignUp.addActionListener(this);
        add(SignUp);

        // Image
        if (mainImage != null) {
            JLabel image = new JLabel(mainImage);
            image.setBounds(0, 0, 200, 200);
            add(image);
        }

        setSize(500, 300);
        setLocation(300, 200);
        setVisible(true);
    }

    private ImageIcon loadImageIcon(String path, int width, int height) {
        try {
            ImageIcon icon = new ImageIcon(getClass().getResource(path));
            if (icon.getImage() == null) {
                System.err.println("Image not found: " + path);
                return null;
            }
            Image image = icon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
            return new ImageIcon(image);
        } catch (Exception e) {
            System.err.println("Error loading image: " + path);
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == Login) {
            String username = tfUsername.getText();
            String password = tfPassword.getText();
            String userType = loginIn.getSelectedItem();

            try {
                Conn c = new Conn();
                String query = "SELECT * FROM login WHERE username = '" + username +
                        "' AND password = '" + password + "' AND user_type = '" + userType + "'";
                ResultSet rs = c.s.executeQuery(query);

                if (rs.next()) {
                    String meter = rs.getString("meter_no");
                    setVisible(false);
                    new Project();
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
        SwingUtilities.invokeLater(() -> new Login());
    }
}