import java.util.Scanner;

public class ATM {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Hardcoded user for demo
        User user = new User("user123", "1234", 1000.00);

        System.out.println("====== Welcome to the ATM Interface ======");

        System.out.print("Enter User ID: ");
        String enteredId = scanner.nextLine();

        System.out.print("Enter PIN: ");
        String enteredPin = scanner.nextLine();

        if (user.validate(enteredId, enteredPin)) {
            System.out.println("\nLogin Successful!\n");
            ATMSystem system = new ATMSystem(user);
            system.showMenu();
        } else {
            System.out.println("\nInvalid credentials. Exiting...");
        }

        scanner.close();
    }
}
