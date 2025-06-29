
package ElectricityBillingSystem;

import javax.swing.*;
import java.awt.*;

public class Splash extends JFrame {
    Splash(){
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/elect.jpg"));
        Image i2 = i1.getImage().getScaledInstance(400,400,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        add(image);

        setVisible(true);

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = screenSize.width;
        int screenHeight = screenSize.height;

        int x = 1;
        for (int i = 2; i < 400; i += 2, x += 1){
            setSize(i, i);
            setLocation((screenWidth - i) / 2, (screenHeight - i) / 2); // Center dynamically
            try {
                Thread.sleep(5); // Adjust animation speed
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Using a separate thread with a Thread object for delay and disposal
        Thread delayThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(6000); // Wait for 6 seconds

                    new Login();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                dispose(); // Close splash screen
            }
        });

        delayThread.start(); // Start the thread
    }

    public static void main(String[] args) {
        new Splash();
    }
}