package ElectricityBillingSystem.java;

import javax.swing.*;
import java.awt.*;

public class Login extends JFrame {
    Login(){
        getContentPane().setBackground(Color.white);
        setLayout(null);

        JLabel lblUsernme = new JLabel("Username");
        lblUsernme.setBounds(210,20,100,20);
        add(lblUsernme);

        JTextField Username = new JTextField();
        Username.setBounds(310,20,150,20);
        add(Username);

        JLabel lblPassword = new JLabel("Password");
        lblPassword.setBounds(210,60,100,20);
        add(lblPassword);

        JTextField Password = new JTextField();
        Password.setBounds(310,60,150,20);
        add(Password);

        JLabel Logininas = new JLabel("Login in as");
       Logininas.setBounds(210,100,100,20);
        add( Logininas);

        Choice Loginin = new Choice();
        Loginin.add("Admin");
        Loginin.add("custumer");
        Loginin.setBounds(310,100,150,20);
        add(Loginin);



        // buuttons for login page


        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/login.png"));
        Image i2 = i1.getImage().getScaledInstance(12,12,Image.SCALE_DEFAULT) ;
        JButton Login = new JButton("Login",new ImageIcon(i2));
        Login.setBounds(220,160,100,20);
        add(Login);

     ImageIcon i3 = new ImageIcon(ClassLoader.getSystemResource("icon/cancel.jpg"));
     Image i4 = i3.getImage().getScaledInstance(12,12,Image.SCALE_DEFAULT);
     JButton Cancel = new JButton("Cancel",new ImageIcon(i4));

        Cancel.setBounds(350,160,100,20);
        add(Cancel);


        ImageIcon i5 = new ImageIcon(ClassLoader.getSystemResource("icon/signup.png"));
        Image i6 = i5.getImage().getScaledInstance(12,12,Image.SCALE_DEFAULT);
        JButton SignUp  = new JButton("SignUp",new ImageIcon(i6));
        SignUp.setBounds(270,200,100,20);
        add(SignUp);

        ImageIcon i7 = new ImageIcon(ClassLoader.getSystemResource("icon/second.jpg"));
        Image i8 = i7.getImage().getScaledInstance(250,230,Image.SCALE_DEFAULT);
        ImageIcon i9 = new ImageIcon(i8);
        JLabel image = new JLabel(i9);
        image.setBounds(0,0,200,200);
        add(image);

        setSize(500,300);
   setLocation(300,200);
   setVisible(true);


    }

    public static void main(String[] args) {
        new Login();
    }
}
