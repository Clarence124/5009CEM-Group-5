package apartment_test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class DBConnect {

    public static Connection connect() {
        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/apartment", "root", "");
            JOptionPane.showMessageDialog(null, "Connected to the database");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e);
        }
        return con;
    }

    public static void createTable() {
        String sql = "CREATE TABLE IF NOT EXISTS visitor (" +
                "reason TEXT NOT NULL AUTO_INCREMENT, " +
                "type CHAR(10) NOT NULL, " +
                "name CHAR(20) NOT NULL, " +
                "vehicleno VARCHAR(7) NOT NULL, " +
                "apartmentno VARCHAR(4) NOT NULL, " +
                "timein TIME NOT NULL, " +
                "timeout TIME NOT NULL, " +
                "date DATE NOT NULL, " +
                "PRIMARY KEY (name))";

        try (Connection con = DBConnect.connect();
             PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.executeUpdate();
            System.out.println("Table 'visitor' created successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
