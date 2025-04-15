public class BankOperations {
    private User user;
    private Transaction transaction;

    public BankOperations(User user, Transaction transaction) {
        this.user = user;
        this.transaction = transaction;
    }

    public void withdraw(double amount) {
        if (amount > user.getBalance()) {
            System.out.println("Insufficient balance.");
        } else {
            user.setBalance(user.getBalance() - amount);
            transaction.log("Withdrawn: ₹" + amount);
            System.out.println("₹" + amount + " withdrawn successfully.");
        }
    }

    public void deposit(double amount) {
        user.setBalance(user.getBalance() + amount);
        transaction.log("Deposited: ₹" + amount);
        System.out.println("₹" + amount + " deposited successfully.");
    }

    public void transfer(String recipientId, double amount) {
        if (amount > user.getBalance()) {
            System.out.println("Insufficient balance.");
        } else {
            user.setBalance(user.getBalance() - amount);
            transaction.log("Transferred ₹" + amount + " to User ID: " + recipientId);
            System.out.println("₹" + amount + " transferred to " + recipientId);
        }
    }
}
