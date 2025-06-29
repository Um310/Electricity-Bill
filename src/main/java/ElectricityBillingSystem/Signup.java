package ElectricityBillingSystem;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Signup extends JFrame implements ActionListener {
    JButton create,Back;
    Choice  accountType;
    JTextField meter,Username,Name,Password;
    Signup() {
        setBounds(400, 200, 550, 300);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JPanel panel = new JPanel();
        panel.setBounds(25, 25, 500, 220);
        panel.setBorder(new TitledBorder(new LineBorder(new Color(173, 216, 230), 2), "Create Account", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(173, 216, 230)));
        panel.setBackground(Color.WHITE);
        panel.setForeground(new Color(95, 139, 34));
        panel.setLayout(null);
        add(panel);

        // Left side components (form fields)
        JLabel heading = new JLabel("Create Account As");
        heading.setBounds(22, 22, 140, 20);
        heading.setForeground(Color.gray);
        heading.setFont(new Font("Arial", Font.BOLD, 14));
        panel.add(heading);

        accountType = new Choice();
        accountType.add("Admin");
        accountType.add("Customer");
        accountType.setBounds(173, 22, 140, 20);
        panel.add(accountType);

        JLabel lblmeter = new JLabel("Meter Number ");
        lblmeter.setBounds(22, 52, 140, 20);
        lblmeter.setForeground(Color.gray);
        lblmeter.setFont(new Font("Arial", Font.BOLD, 14));
        panel.add(lblmeter);

        meter = new JTextField();
        meter.setBounds(173, 52, 140, 20);
        panel.add(meter);

        JLabel lblUsername = new JLabel("Username ");
        lblUsername.setBounds(22, 82, 140, 20);
        lblUsername.setForeground(Color.gray);
        lblUsername.setFont(new Font("Arial", Font.BOLD, 14));
        panel.add(lblUsername);

        Username = new JTextField();
        Username.setBounds(173, 82, 140, 20);
        panel.add(Username);

        JLabel lblname = new JLabel("Name ");
        lblname.setBounds(22, 112, 140, 20);
        lblname.setForeground(Color.gray);
        lblname.setFont(new Font("Arial", Font.BOLD, 14));
        panel.add(lblname);

        Name = new JTextField();
        Name.setBounds(173, 112, 140, 20);
        panel.add(Name);

        JLabel lblPassword = new JLabel("Password ");
        lblPassword.setBounds(22, 142, 140, 20);
        lblPassword.setForeground(Color.gray);
        lblPassword.setFont(new Font("Arial", Font.BOLD, 14));
        panel.add(lblPassword);

        Password = new JTextField();
        Password.setBounds(173, 142, 140, 20);
        panel.add(Password);

        // Buttons
        create = new JButton("Create");
        create.setBackground(Color.BLACK);
        create.setForeground(Color.white);
        create.setBounds(50, 175, 120, 25);
        create.addActionListener(this);
        panel.add(create);

        Back = new JButton("Back ");
        Back.setBackground(Color.BLACK);
        Back.setForeground(Color.white);
        Back.setBounds(200, 175, 120, 25);
        Back.addActionListener(this);
        panel.add(Back);

        // Image - Right side placement
//        try {
//            ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/signupImage.png.png"));
//            Image i2 = i1.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
//            ImageIcon i3 = new ImageIcon(i2);
//            JLabel image = new JLabel(i3);
//
//            image.setBounds(330, 30, 150, 150);
//            panel.add(image);
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, "Signup image not found");
//        }


        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == create) {
            String atype = accountType.getSelectedItem();
            String susername = Username.getText();
            String sname = Name.getText();
            String spassword = Password.getText();
            String smeter = meter.getText();

            try {
                Conn c = new Conn();
                String query = "insert into login values('"+smeter+"','"+susername+"','"+sname+"','"+spassword+"','"+atype+"')";

                // Execute the query
                int rows = c.s.executeUpdate(query);

                if (rows > 0) {
                    JOptionPane.showMessageDialog(null, "Account Created Successfully");
                    setVisible(false);
                    new Login();
                }
            } catch (Exception e) {
                // Show specific error message
                JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else if (ae.getSource() == Back) {
            setVisible(false);
            new Login();
        }
    }
    public static void main(String[] args) {
        new Signup();
    }


}