package ElectricityBillingSystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Conn {
    private Connection c;
    protected Statement s;

    public Conn() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/ electricity_billing_system", "root", "12345");
            s = c.createStatement();
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println("Database connection error: " + e.getMessage());
        }
    }

    // Getter methods for connection and statement
    public Connection getConnection() {
        return c;
    }

    public Statement getStatement() {
        return s;
    }

    // Method to close resources properly
    public void closeConnection() {
        try {
            if (s != null) s.close();
            if (c != null) c.close();
        } catch (SQLException e) {
            System.err.println("Error closing database resources: " + e.getMessage());
        }
    }
}