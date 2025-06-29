package ElectricityBillingSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Project extends JFrame {
    Project() {
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setTitle("Electricity Billing System");

        // Background Image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/elect1.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1500, 850, Image.SCALE_DEFAULT);
        JLabel background = new JLabel(new ImageIcon(i2));
        add(background);

        // Menu Bar
        JMenuBar mb = new JMenuBar();
        setJMenuBar(mb);

        // Master Menu
        JMenu master = new JMenu("Master");
        master.setForeground(Color.BLUE);
        mb.add(master);

        JMenuItem NewCustomer = new JMenuItem("New Customer");
        JMenuItem Customerdetails = new JMenuItem("Customer Details");
        JMenuItem Depositdetails = new JMenuItem("Deposit Details");
        JMenuItem calculateBill = new JMenuItem("Calculate Bill");

        master.add(NewCustomer);
        master.add(Customerdetails);
        master.add(Depositdetails);
        master.add(calculateBill);

        // Information Menu
        JMenu Info = new JMenu("Information");
        Info.setForeground(Color.RED);
        mb.add(Info);

        JMenuItem UpdateInformation = new JMenuItem("Update Information");
        JMenuItem ViewInformation = new JMenuItem("View Information");

        Info.add(UpdateInformation);
        Info.add(ViewInformation);

        // User Menu
        JMenu User = new JMenu("User");
        User.setForeground(Color.BLUE);
        mb.add(User);

        JMenuItem PayBill = new JMenuItem("Pay Bill");
        JMenuItem BillDetails = new JMenuItem("Bill Details");

        User.add(PayBill);
        User.add(BillDetails);

        // Report Menu
        JMenu report = new JMenu("Report");
        report.setForeground(Color.RED);
        mb.add(report);

        JMenuItem generateBill = new JMenuItem("Generate Bill");
        report.add(generateBill);

        // Utility Menu
        JMenu utility = new JMenu("Utility");
        utility.setForeground(Color.BLUE);
        mb.add(utility);

        JMenuItem notepad = new JMenuItem("Notepad");
        JMenuItem calculator = new JMenuItem("Calculator");

        utility.add(notepad);
        utility.add(calculator);

        // Exit Menu
        JMenu exitMenu = new JMenu("Exit");
        exitMenu.setForeground(Color.RED);
        mb.add(exitMenu);

        JMenuItem exit = new JMenuItem("Exit");
        exit.addActionListener(e -> {
            int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to exit?", "Exit Confirmation", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                System.exit(0);
            }
        });
        exitMenu.add(exit);

        // === ACTIONS TO OPEN CLASSES ===
        NewCustomer.addActionListener(e -> new NewCustomer());
        Customerdetails.addActionListener(e -> new CustomerDetails());
        Depositdetails.addActionListener(e -> new DepositDetails());
        calculateBill.addActionListener(e -> new CalculateBill());
        UpdateInformation.addActionListener(e -> new UpdateInformation("123456")); // Replace with actual meterNo if needed
        ViewInformation.addActionListener(e -> new ViewInformation());
        PayBill.addActionListener(e -> new PayBill());
        BillDetails.addActionListener(e -> new BillDetails());
        generateBill.addActionListener(e -> new GenerateBill());

        notepad.addActionListener(e -> {
            try {
                Runtime.getRuntime().exec("notepad.exe");
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        calculator.addActionListener(e -> {
            try {
                Runtime.getRuntime().exec("calc.exe");
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        setLayout(new FlowLayout());
        setVisible(true);
    }

    public static void main(String[] args) {
        new Project();
    }

    private class CalculateBill {
    }
}
