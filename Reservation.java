import java.sql.*;
import java.util.Scanner;

public class Reservation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("===== Reservation Form =====");
        System.out.print("Name: ");
        String name = sc.nextLine();

        System.out.print("Age: ");
        int age = sc.nextInt();
        sc.nextLine(); // Consume newline

        System.out.print("Gender: ");
        String gender = sc.nextLine();

        System.out.print("Train Number: ");
        String trainNumber = sc.nextLine();

        // Simple auto-fill logic
        String trainName = switch (trainNumber) {
            case "12345" -> "Shatabdi Express";
            case "54321" -> "Rajdhani Express";
            case "99999" -> "Duronto Express";
            default -> "Generic Express";
        };

        System.out.print("Class Type (e.g., AC, Sleeper): ");
        String classType = sc.nextLine();

        System.out.print("Date of Journey (YYYY-MM-DD): ");
        String doj = sc.nextLine();

        System.out.print("From: ");
        String source = sc.nextLine();

        System.out.print("To: ");
        String destination = sc.nextLine();

        try {
            Connection conn = DBConnection.getConnection();
            String sql = "INSERT INTO reservations (name, age, gender, train_number, train_name, class_type, date_of_journey, source, destination) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement pst = conn.prepareStatement(sql);

            pst.setString(1, name);
            pst.setInt(2, age);
            pst.setString(3, gender);
            pst.setString(4, trainNumber);
            pst.setString(5, trainName);
            pst.setString(6, classType);
            pst.setDate(7, Date.valueOf(doj));
            pst.setString(8, source);
            pst.setString(9, destination);

            pst.executeUpdate();
            System.out.println(" Reservation done successfully!");

        } catch (Exception e) {
            System.out.println("Reservation Error: " + e.getMessage());
        }
    }
}
