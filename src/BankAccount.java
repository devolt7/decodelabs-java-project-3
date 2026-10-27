import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Stores account data and enforces banking rules.
 * The balance and account details are private (encapsulation).
 */
public class BankAccount {
    private final String accountHolder;
    private final String accountNumber;
    private final int pin;
    private double balance;
    private final List<String> transactionHistory;

    public BankAccount(String accountHolder, String accountNumber, int pin, double openingBalance) {
        if (accountHolder == null || accountHolder.trim().isEmpty()) {
            throw new IllegalArgumentException("Account holder name cannot be empty.");
        }
        if (accountNumber == null || accountNumber.trim().isEmpty()) {
            throw new IllegalArgumentException("Account number cannot be empty.");
        }
        if (openingBalance < 0) {
            throw new IllegalArgumentException("Opening balance cannot be negative.");
        }

        this.accountHolder = accountHolder;
        this.accountNumber = accountNumber;
        this.pin = pin;
        this.balance = openingBalance;
        this.transactionHistory = new ArrayList<>();
        transactionHistory.add(String.format("Account opened with balance: Rs. %.2f", openingBalance));
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public String getMaskedAccountNumber() {
        if (accountNumber.length() <= 4) {
            return accountNumber;
        }
        return "XXXXXX" + accountNumber.substring(accountNumber.length() - 4);
    }

    public boolean verifyPin(int enteredPin) {
        return pin == enteredPin;
    }

    public double checkBalance() {
        return balance;
    }

    public boolean deposit(double amount) {
        if (!Double.isFinite(amount) || amount <= 0) {
            return false;
        }

        balance += amount;
        transactionHistory.add(String.format("Deposit: +Rs. %.2f | Balance: Rs. %.2f", amount, balance));
        return true;
    }

    public boolean withdraw(double amount) {
        if (!Double.isFinite(amount) || amount <= 0 || amount > balance) {
            return false;
        }

        balance -= amount;
        transactionHistory.add(String.format("Withdrawal: -Rs. %.2f | Balance: Rs. %.2f", amount, balance));
        return true;
    }

    public List<String> getTransactionHistory() {
        return Collections.unmodifiableList(transactionHistory);
    }
}
