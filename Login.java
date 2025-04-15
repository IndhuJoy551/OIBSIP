import java.sql.*;
import java.util.Scanner;

public class Login {
    public static boolean authenticateUser(String username, String password) {
        try {
            Connection conn = DBConnection.getConnection();
            if (conn == null) return false;

            String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, username);
            pst.setString(2, password);

            ResultSet rs = pst.executeQuery();
            return rs.next();
        } catch (Exception e) {
            System.out.println("Login Error: " + e.getMessage());
            return false;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("===== Online Reservation System Login =====");
        System.out.print("Enter Username: ");
        String user = sc.nextLine();

        System.out.print("Enter Password: ");
        String pass = sc.nextLine();

        if (authenticateUser(user, pass)) {
            System.out.println(" Login successful! Welcome, " + user);
        } else {
            System.out.println(" Invalid login credentials.");
        }
    }
}
