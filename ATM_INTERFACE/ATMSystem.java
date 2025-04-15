import java.util.Scanner;

public class ATMSystem {
    private User user;
    private Transaction transaction;
    private BankOperations bankOps;

    public ATMSystem(User user) {
        this.user = user;
        this.transaction = new Transaction();
        this.bankOps = new BankOperations(user, transaction);
    }

    public void showMenu() {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n======= ATM Menu =======");
            System.out.println("1. Transaction History");
            System.out.println("2. Withdraw");
            System.out.println("3. Deposit");
            System.out.println("4. Transfer");
            System.out.println("5. Quit");
            System.out.print("Choose an option: ");

            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    transaction.showHistory();
                    break;
                case 2:
                    System.out.print("Enter amount to withdraw: ₹");
                    double withdrawAmount = scanner.nextDouble();
                    bankOps.withdraw(withdrawAmount);
                    break;
                case 3:
                    System.out.print("Enter amount to deposit: ₹");
                    double depositAmount = scanner.nextDouble();
                    bankOps.deposit(depositAmount);
                    break;
                case 4:
                    System.out.print("Enter recipient User ID: ");
                    String recipient = scanner.next();
                    System.out.print("Enter amount to transfer: ₹");
                    double transferAmount = scanner.nextDouble();
                    bankOps.transfer(recipient, transferAmount);
                    break;
                case 5:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }

        } while (choice != 5);
    }
}
