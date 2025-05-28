package Electricity.Billing.System;

import javax.swing.*;
        import java.awt.*;
        import java.awt.event.ActionEvent;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

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
        NewCustomer.setFont(new Font("monospaced", Font.PLAIN, 12));
        NewCustomer.setBackground(Color.WHITE);
        ImageIcon icon1 = new ImageIcon(ClassLoader.getSystemResource("icon/icon1.png"));
        Image image1 = icon1.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        NewCustomer.setIcon(new ImageIcon(image1));
        NewCustomer.setMnemonic('D');
        NewCustomer.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, InputEvent.CTRL_MASK));
        master.add(NewCustomer);

        JMenuItem Customerdetails = new JMenuItem("Customer Details");
        Customerdetails.setFont(new Font("monospaced", Font.PLAIN, 12));
        Customerdetails.setBackground(Color.WHITE);
        ImageIcon icon2 = new ImageIcon(ClassLoader.getSystemResource("icon/icon2.png"));
        Image image2 = icon2.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        Customerdetails.setIcon(new ImageIcon(image2));
        Customerdetails.setMnemonic('M');
        Customerdetails.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M, ActionEvent.CTRL_MASK));
        master.add(Customerdetails);

        JMenuItem Depositdetails = new JMenuItem("Deposit Details");
        Depositdetails.setFont(new Font("monospaced", Font.PLAIN, 12));
        Depositdetails.setBackground(Color.WHITE);
        ImageIcon icon3 = new ImageIcon(ClassLoader.getSystemResource("icon/icon3.png"));
        Image image3 = icon3.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        Depositdetails.setIcon(new ImageIcon(image3));
        Depositdetails.setMnemonic('N');
        Depositdetails.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
        master.add(Depositdetails);

        JMenuItem calculateBill = new JMenuItem("Calculate Bill");
        calculateBill.setFont(new Font("monospaced", Font.PLAIN, 12));
        calculateBill.setBackground(Color.WHITE);
        ImageIcon icon4 = new ImageIcon(ClassLoader.getSystemResource("icon/icon5.png"));
        Image image4 = icon4.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        calculateBill.setIcon(new ImageIcon(image4));
        calculateBill.setMnemonic('B');
        calculateBill.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B, ActionEvent.CTRL_MASK));
        master.add(calculateBill);

        // Information Menu
        JMenu Info = new JMenu("Information");
        Info.setForeground(Color.RED);
        mb.add(Info);

        JMenuItem UpdateInformation = new JMenuItem("Update Information");
        UpdateInformation.setFont(new Font("monospaced", Font.PLAIN, 12));
        UpdateInformation.setBackground(Color.WHITE);
        ImageIcon icon5 = new ImageIcon(ClassLoader.getSystemResource("icon/icon4.png"));
        Image image5 = icon5.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        UpdateInformation.setIcon(new ImageIcon(image5));
        UpdateInformation.setMnemonic('P');
        UpdateInformation.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.CTRL_MASK));
        Info.add(UpdateInformation);

        JMenuItem ViewInformation = new JMenuItem("View Information");
        ViewInformation.setFont(new Font("monospaced", Font.PLAIN, 12));
        ViewInformation.setBackground(Color.WHITE);
        ImageIcon icon6 = new ImageIcon(ClassLoader.getSystemResource("icon/icon6.png"));
        Image image6 = icon6.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        ViewInformation.setIcon(new ImageIcon(image6));
        ViewInformation.setMnemonic('Q');
        ViewInformation.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, ActionEvent.CTRL_MASK));
        Info.add(ViewInformation);

        // User Menu
        JMenu User = new JMenu("User");
        User.setForeground(Color.BLUE);
        mb.add(User);

        JMenuItem PayBill = new JMenuItem("Pay Bill");
        PayBill.setFont(new Font("monospaced", Font.PLAIN, 12));
        PayBill.setBackground(Color.WHITE);
        ImageIcon icon7 = new ImageIcon(ClassLoader.getSystemResource("icon/icon4.png"));
        Image image7 = icon7.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        PayBill.setIcon(new ImageIcon(image7));
        PayBill.setMnemonic('K');
        PayBill.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_K, ActionEvent.CTRL_MASK));
        User.add(PayBill);

        JMenuItem BillDetails = new JMenuItem("Bill Details");
        BillDetails.setFont(new Font("monospaced", Font.PLAIN, 12));
        BillDetails.setBackground(Color.WHITE);
        ImageIcon icon8 = new ImageIcon(ClassLoader.getSystemResource("icon/icon6.png"));
        Image image8 = icon8.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        BillDetails.setIcon(new ImageIcon(image8));
        BillDetails.setMnemonic('R');
        BillDetails.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, ActionEvent.CTRL_MASK));
        User.add(BillDetails);

        // Report Menu
        JMenu report = new JMenu("Report");
        report.setForeground(Color.RED);
        mb.add(report);

        JMenuItem generateBill = new JMenuItem("Generate Bill");
        generateBill.setFont(new Font("monospaced", Font.PLAIN, 12));
        generateBill.setBackground(Color.WHITE);
        ImageIcon icon9 = new ImageIcon(ClassLoader.getSystemResource("icon/icon7.png"));
        Image image9 = icon9.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        generateBill.setIcon(new ImageIcon(image9));
        generateBill.setMnemonic('L');
        generateBill.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, ActionEvent.CTRL_MASK));
        report.add(generateBill);

        // Utility Menu
        JMenu utility = new JMenu("Utility");
        utility.setForeground(Color.BLUE);
        mb.add(utility);

        JMenuItem notepad = new JMenuItem("Notepad");
        notepad.setFont(new Font("monospaced", Font.PLAIN, 12));
        notepad.setBackground(Color.WHITE);
        ImageIcon icon10 = new ImageIcon(ClassLoader.getSystemResource("icon/icon12.png"));
        Image image10 = icon10.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        notepad.setIcon(new ImageIcon(image10));
        notepad.setMnemonic('N');
        notepad.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
        utility.add(notepad);

        JMenuItem calculator = new JMenuItem("Calculator");
        calculator.setFont(new Font("monospaced", Font.PLAIN, 12));
        calculator.setBackground(Color.WHITE);
        ImageIcon icon11 = new ImageIcon(ClassLoader.getSystemResource("icon/icon9.png"));
        Image image11 = icon11.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        calculator.setIcon(new ImageIcon(image11));
        calculator.setMnemonic('C');
        calculator.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));
        utility.add(calculator);

        // Exit Menu
        JMenu exitMenu = new JMenu("Exit");
        exitMenu.setForeground(Color.RED);
        mb.add(exitMenu);

        JMenuItem exit = new JMenuItem("Exit");
        exit.setFont(new Font("monospaced", Font.PLAIN, 12));
        exit.setBackground(Color.WHITE);
        ImageIcon icon12 = new ImageIcon(ClassLoader.getSystemResource("icon/icon11.png"));
        Image image12 = icon12.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        exit.setIcon(new ImageIcon(image12));
        exit.setMnemonic('X');
        exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK));

// Exit Action
        exit.addActionListener(e -> {
            int confirm = JOptionPane.showConfirmDialog(
                    this,
                    "Are you sure you want to exit?",
                    "Exit Confirmation",
                    JOptionPane.YES_NO_OPTION
            );

            if (confirm == JOptionPane.YES_OPTION) {
                System.exit(0);
            }
        });

        exitMenu.add(exit);
        setLayout(new FlowLayout());
        setVisible(true);
    }

    public Project(String userType, String meter) {
    }

    public static void main(String[] args) {
        new Project();
    }
}