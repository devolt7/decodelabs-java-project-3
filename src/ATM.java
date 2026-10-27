import java.util.List;
import java.util.Scanner;

/**
 * Handles the console interface and delegates account operations
 * to BankAccount.
 */
public class ATM {
    private final Scanner scanner;
    private final BankAccount account;
    private static final int MAX_PIN_ATTEMPTS = 3;

    public ATM(Scanner scanner, BankAccount account) {
        this.scanner = scanner;
        this.account = account;
    }

    public void start() {
        printHeader();

        if (!authenticate()) {
            System.out.println("\nToo many incorrect attempts. Your session has been locked.");
            System.out.println("Please contact your bank in a real banking system.");
            return;
        }

        System.out.println("\nWelcome, " + account.getAccountHolder() + "!");
        boolean running = true;

        while (running) {
            printMenu();
            int choice = readInteger("Choose an option (1-5): ");

            switch (choice) {
                case 1:
                    showBalance();
                    break;
                case 2:
                    depositMoney();
                    break;
                case 3:
                    withdrawMoney();
                    break;
                case 4:
                    showTransactionHistory();
                    break;
                case 5:
                    running = false;
                    System.out.println("\nThank you for using the ATM. Please take your card.");
                    break;
                default:
                    System.out.println("Invalid option. Please choose from 1 to 5.");
            }
        }
    }

    private boolean authenticate() {
        System.out.println("Demo account: " + account.getMaskedAccountNumber());
        System.out.println("For this practice project, use demo PIN: 1234");

        for (int attempt = 1; attempt <= MAX_PIN_ATTEMPTS; attempt++) {
            int enteredPin = readInteger("Enter your 4-digit PIN: ");

            if (account.verifyPin(enteredPin)) {
                return true;
            }

            int remaining = MAX_PIN_ATTEMPTS - attempt;
            if (remaining > 0) {
                System.out.println("Incorrect PIN. Attempts remaining: " + remaining);
            }
        }

        return false;
    }

    private void printHeader() {
        System.out.println("==========================================");
        System.out.println("              JAVA ATM SYSTEM             ");
        System.out.println("==========================================");
    }

    private void printMenu() {
        System.out.println("\n--------------- ATM MENU ----------------");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit Money");
        System.out.println("3. Withdraw Money");
        System.out.println("4. Transaction History");
        System.out.println("5. Exit");
        System.out.println("------------------------------------------");
    }

    private void showBalance() {
        System.out.printf("Available balance: Rs. %.2f%n", account.checkBalance());
    }

    private void depositMoney() {
        double amount = readAmount("Enter deposit amount (Rs.): ");

        if (account.deposit(amount)) {
            System.out.printf("Deposit successful. New balance: Rs. %.2f%n", account.checkBalance());
        } else {
            System.out.println("Deposit failed. Amount must be greater than zero.");
        }
    }

    private void withdrawMoney() {
        double amount = readAmount("Enter withdrawal amount (Rs.): ");

        if (amount <= 0) {
            System.out.println("Withdrawal failed. Amount must be greater than zero.");
        } else if (amount > account.checkBalance()) {
            System.out.println("Transaction declined: insufficient balance.");
        } else if (account.withdraw(amount)) {
            System.out.printf("Please collect your cash. New balance: Rs. %.2f%n", account.checkBalance());
        } else {
            System.out.println("Withdrawal failed. Please try again.");
        }
    }

    private void showTransactionHistory() {
        List<String> history = account.getTransactionHistory();
        System.out.println("\n----------- TRANSACTION HISTORY ----------");
        for (int i = 0; i < history.size(); i++) {
            System.out.println((i + 1) + ". " + history.get(i));
        }
        System.out.println("------------------------------------------");
    }

    private int readInteger(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();

            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException exception) {
                System.out.println("Invalid input. Please enter a whole number.");
            }
        }
    }

    private double readAmount(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();

            try {
                double amount = Double.parseDouble(input);
                if (!Double.isFinite(amount)) {
                    System.out.println("Please enter a valid finite amount.");
                    continue;
                }
                return amount;
            } catch (NumberFormatException exception) {
                System.out.println("Invalid amount. Please enter a number, such as 500 or 250.50.");
            }
        }
    }
}
