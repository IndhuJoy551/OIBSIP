import java.sql.*;
import java.util.Scanner;

public class Cancellation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("===== Ticket Cancellation =====");
        System.out.print("Enter PNR Number: ");
        int pnr = sc.nextInt();

        try {
            Connection conn = DBConnection.getConnection();
            String sql = "SELECT * FROM reservations WHERE pnr = ?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, pnr);

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                System.out.println("Ticket Found:");
                System.out.println("Name: " + rs.getString("name"));
                System.out.println("Train: " + rs.getString("train_name"));
                System.out.println("From: " + rs.getString("source") + " To: " + rs.getString("destination"));

                System.out.print("Do you want to cancel this ticket? (yes/no): ");
                sc.nextLine(); // consume newline
                String confirm = sc.nextLine();

                if (confirm.equalsIgnoreCase("yes")) {
                    String deleteSQL = "DELETE FROM reservations WHERE pnr = ?";
                    PreparedStatement delPst = conn.prepareStatement(deleteSQL);
                    delPst.setInt(1, pnr);
                    delPst.executeUpdate();
                    System.out.println(" Ticket canceled successfully.");
                } else {
                    System.out.println(" Cancellation aborted.");
                }
            } else {
                System.out.println("❌ No reservation found with that PNR.");
            }
        } catch (Exception e) {
            System.out.println("Cancellation Error: " + e.getMessage());
        }
    }
}
