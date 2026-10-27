import java.util.Scanner;

/**
 * Entry point for DecodeLabs Java Programming Internship - Project 3.
 */
public class Main {
    public static void main(String[] args) {
        // Demo data for local practice only. Do not use hard-coded PINs in real banking software.
        BankAccount account = new BankAccount(
                "Devkant Prajapati",
                "16218002724",
                1234,
                5000.00
        );

        Scanner scanner = new Scanner(System.in);
        ATM atm = new ATM(scanner, account);
        atm.start();
        scanner.close();
    }
}
