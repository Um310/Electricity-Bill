package ElectricityBillingSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class PayBill extends JFrame implements ActionListener {

    Choice cmonth;
    JTextField tfunits;
    JButton submit, cancel;
    String meter;

    PayBill(String meter) {
        this.meter = meter;

        setLayout(null);
        setBounds(300, 150, 600, 400);

        JLabel heading = new JLabel("Generate Bill");
        heading.setFont(new Font("Tahoma", Font.BOLD, 20));
        heading.setBounds(200, 10, 200, 30);
        add(heading);

        JLabel lblmeternumber = new JLabel("Meter Number:");
        lblmeternumber.setBounds(50, 70, 150, 20);
        add(lblmeternumber);

        JLabel meternumber = new JLabel(meter);
        meternumber.setBounds(200, 70, 150, 20);
        add(meternumber);

        JLabel lblmonth = new JLabel("Month:");
        lblmonth.setBounds(50, 110, 150, 20);
        add(lblmonth);

        cmonth = new Choice();
        cmonth.setBounds(200, 110, 150, 20);
        String[] months = {"January", "February", "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December"};
        for (String m : months) cmonth.add(m);
        add(cmonth);

        JLabel lblunits = new JLabel("Units Consumed:");
        lblunits.setBounds(50, 150, 150, 20);
        add(lblunits);

        tfunits = new JTextField();
        tfunits.setBounds(200, 150, 150, 20);
        add(tfunits);

        submit = new JButton("Generate");
        submit.setBounds(100, 250, 100, 30);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setBounds(250, 250, 100, 30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        add(cancel);

        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
    }

    public PayBill() {

    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == submit) {
            String month = cmonth.getSelectedItem();
            String units = tfunits.getText();
            int unit = 0;
            try {
                unit = Integer.parseInt(units);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Please enter a valid number of units.");
                return;
            }

            int totalbill = unit * 7; // Example: 7 Rs/unit
            String status = "Not Paid";

            try {
                Conn c = new Conn();
                String query = "insert into bill values('" + meter + "', '" + month + "', '" + units + "', '" + totalbill + "', '" + status + "')";
                c.s.executeUpdate(query);

                JOptionPane.showMessageDialog(null, "Bill Generated Successfully");
                setVisible(false);
            } catch (SQLIntegrityConstraintViolationException e) {
                JOptionPane.showMessageDialog(null, "Bill already exists for this month.");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new GenerateBill("123456"); // Replace with real meter number
    }
}
