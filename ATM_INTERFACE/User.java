public class User {
    private String userId;
    private String pin;
    private double balance;

    public User(String userId, String pin, double balance) {
        this.userId = userId;
        this.pin = pin;
        this.balance = balance;
    }

    public boolean validate(String enteredId, String enteredPin) {
        return userId.equals(enteredId) && pin.equals(enteredPin);
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double amount) {
        this.balance = amount;
    }

    public String getUserId() {
        return userId;
    }
}
