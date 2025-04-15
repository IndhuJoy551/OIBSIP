import java.util.ArrayList;

public class Transaction {
    private ArrayList<String> history;

    public Transaction() {
        history = new ArrayList<>();
    }

    public void log(String detail) {
        history.add(detail);
    }

    public void showHistory() {
        if (history.isEmpty()) {
            System.out.println("No transactions yet.");
        } else {
            System.out.println("\n--- Transaction History ---");
            for (String record : history) {
                System.out.println(record);
            }
        }
    }
}
