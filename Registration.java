import java.sql.*;
import java.util.Scanner;

public class Registration {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("===== User Registration =====");

        System.out.print("Choose a Username: ");
        String username = sc.nextLine();

        System.out.print("Choose a Password: ");
        String password = sc.nextLine();

        try {
            Connection conn = DBConnection.getConnection();

            if (conn == null) {
                System.out.println(" Unable to connect to database.");
                return;
            }

            // Check if username exists
            String checkSql = "SELECT * FROM users WHERE username = ?";
            PreparedStatement checkStmt = conn.prepareStatement(checkSql);
            checkStmt.setString(1, username);
            ResultSet rs = checkStmt.executeQuery();

            if (rs.next()) {
                System.out.println(" Username already taken. Try another.");
                return;
            }

            // Insert new user
            String sql = "INSERT INTO users (username, password) VALUES (?, ?)";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, username);
            pst.setString(2, password);

            int rows = pst.executeUpdate();
            if (rows > 0) {
                System.out.println(" Registration successful! You can now log in.");
            } else {
                System.out.println(" Registration failed. Try again.");
            }

        } catch (Exception e) {
            System.out.println("Registration Error: " + e.getMessage());
        }
    }
}
