# 🏧 ATM Interface — Java OOP

A console-based ATM Interface developed as **Project 3** for the DecodeLabs Java Programming Internship.

The application demonstrates Object-Oriented Programming by separating the ATM menu and user interaction from the bank account's data and transaction rules.

## 🚀 Features

- Demo PIN-based login with a maximum of 3 attempts
- Check account balance
- Deposit money with amount validation
- Withdraw money with insufficient-balance checks
- View transaction history
- Handles non-numeric input without crashing
- Masks the account number in the interface
- Encapsulates account balance and PIN in private fields
- Separates interface logic from account/business logic

## 🛠️ Technologies Used

- Java
- Visual Studio Code
- Git & GitHub

## 📁 Project Structure

```text
decodelabs-java-project-3/
├── src/
│   ├── Main.java
│   ├── ATM.java
│   └── BankAccount.java
├── sample-output.txt
├── .gitignore
└── README.md
```

## ▶️ How to Run in VS Code

### Requirements
1. Install a JDK (Java Development Kit).
2. Install Visual Studio Code.
3. Install the **Extension Pack for Java** in VS Code.

### Run from the terminal

Open this project folder in VS Code and run:

```bash
javac -d out src/Main.java src/ATM.java src/BankAccount.java
java -cp out Main
```

Demo PIN: `1234`

The initial demo balance is Rs. 5,000.00. You can change the demo account details in `src/Main.java` for local practice.

## 🧪 Sample Output

```text
==========================================
              JAVA ATM SYSTEM
==========================================
Demo account: XXXXXX9012
For this practice project, use demo PIN: 1234
Enter your 4-digit PIN: 1234

Welcome, Devkant Prajapati!

--------------- ATM MENU ----------------
1. Check Balance
2. Deposit Money
3. Withdraw Money
4. Transaction History
5. Exit
------------------------------------------
Choose an option (1-5): 1
Available balance: Rs. 5000.00

--------------- ATM MENU ----------------
1. Check Balance
2. Deposit Money
3. Withdraw Money
4. Transaction History
5. Exit
------------------------------------------
Choose an option (1-5): 2
Enter deposit amount (Rs.): 1500
Deposit successful. New balance: Rs. 6500.00

--------------- ATM MENU ----------------
1. Check Balance
2. Deposit Money
3. Withdraw Money
4. Transaction History
5. Exit
------------------------------------------
Choose an option (1-5): 3
Enter withdrawal amount (Rs.): 7000
Transaction declined: insufficient balance.

--------------- ATM MENU ----------------
1. Check Balance
2. Deposit Money
3. Withdraw Money
4. Transaction History
5. Exit
------------------------------------------
Choose an option (1-5): 5

Thank you for using the ATM. Please take your card.
```

## 🧠 OOP Concepts Demonstrated

- **Classes and objects:** `ATM`, `BankAccount`, and `Main`
- **Encapsulation:** Account state is private and accessed through methods
- **Methods:** `deposit()`, `withdraw()`, `checkBalance()`, and `verifyPin()`
- **Separation of concerns:** `ATM` manages the interface; `BankAccount` manages account rules
- **Input validation:** Invalid numbers, non-positive amounts, and insufficient funds are handled

## 🔐 Important Note

This is an educational console simulation, **not a real banking system**. The PIN and account data are hard-coded demo values, and the balance is stored only in memory. Do not use real account details or PINs.

## 👨‍💻 Developed By

**Devkant Prajapati**  
DecodeLabs Java Programming Internship — Project 3
