

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Account {
    String accountHolderName;
    String accNumber;
    double balance;

    // Static list of all accounts
    static List<Account> allAccounts = new ArrayList<>();

    public Account(String accountHolderName, String accNumber, double balance) {
        this.accountHolderName = accountHolderName;
        this.accNumber = accNumber;
        this.balance = balance;
        allAccounts.add(this);
    }

    // Deposit
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("₹" + amount + " deposited successfully.");
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    // Withdraw
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("₹" + amount + " withdrawn successfully.");
        } else {
            System.out.println("Insufficient balance or invalid amount.");
        }
    }

    // Display account
    public void displayAccount() {
        System.out.println("Account Holder: " + accountHolderName);
        System.out.println("Account Number: " + accNumber);
        System.out.println("Balance: ₹" + balance);
        System.out.println("----------------------------");
    }

    // Find account by name
    public static Account findAccountByName(String name) {
        for (Account acc : allAccounts) {
            if (acc.accountHolderName.equalsIgnoreCase(name)) {
                return acc;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        new Account("John Doe", "A123", 5000);
        new Account("Jane Smith", "B456", 8000);

        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Bank Menu ---");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. View Account");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.print("Enter account holder name: ");
                    String nameToDeposit = sc.nextLine();
                    Account acc1 = findAccountByName(nameToDeposit);
                    if (acc1 != null) {
                        System.out.print("Enter amount to deposit: ");
                        double depositAmt = sc.nextDouble();
                        acc1.deposit(depositAmt);
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;

                case 2:
                    System.out.print("Enter account holder name: ");
                    String nameToWithdraw = sc.nextLine();
                    Account acc2 = findAccountByName(nameToWithdraw);
                    if (acc2 != null) {
                        System.out.print("Enter amount to withdraw: ");
                        double withdrawAmt = sc.nextDouble();
                        acc2.withdraw(withdrawAmt);
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;

                case 3:
                    System.out.print("Enter account holder name: ");
                    String nameToView = sc.nextLine();
                    Account acc3 = findAccountByName(nameToView);
                    if (acc3 != null) {
                        acc3.displayAccount();
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;

                case 4:
                    System.out.println("Exiting. Thank you!");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 4);

        sc.close();
    }
}
