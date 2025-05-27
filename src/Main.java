// Main.java: Entry point of RBAMS - Rural Bank Account Management System

import java.util.*;

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Welcome to Rural Bank of Nepal");
        System.out.print("Enter customer name: ");
        String name = scanner.nextLine();
        Customer customer = new Customer(name);

        // Create accounts
        BankAccount savings = new SavingsAccount(name, "SAV123", 0);
        BankAccount current = new CurrentAccount(name, "CUR123", 0);
        customer.addAccount(savings);
        customer.addAccount(current);

        int choice;
        do {
            System.out.println("\nChoose operation:");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Add Interest to Savings");
            System.out.println("4. View Accounts");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number between 1 and 5.");
                scanner.next();
            }
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    BankAccount acc1 = selectAccount(customer);
                    if (acc1 != null) {
                        System.out.print("Enter amount to deposit: ");
                        double depositAmount = getValidDouble();
                        acc1.deposit(depositAmount);
                    }
                    break;
                case 2:
                    BankAccount acc2 = selectAccount(customer);
                    if (acc2 != null) {
                        System.out.print("Enter amount to withdraw: ");
                        double withdrawAmount = getValidDouble();
                        try {
                            acc2.withdraw(withdrawAmount);
                        } catch (InsufficientBalanceException e) {
                            System.out.println("Withdrawal failed: " + e.getMessage());
                        }
                    }
                    break;
                case 3:
                    for (BankAccount acc : customer.getAccounts()) {
                        if (acc instanceof SavingsAccount) {
                            ((SavingsAccount) acc).addInterest();
                        }
                    }
                    break;
                case 4:
                    for (BankAccount acc : customer.getAccounts()) {
                        System.out.println("\n--- " + acc.getAccountType() + " Account ---");
                        acc.displayDetails();
                    }
                    break;
                case 5:
                    System.out.println("Thank you for using RBAMS.");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 5);
    }

    private static double getValidDouble() {
        while (!scanner.hasNextDouble()) {
            System.out.print("Invalid input. Please enter a valid number: ");
            scanner.next();
        }
        return scanner.nextDouble();
    }

    private static BankAccount selectAccount(Customer customer) {
        System.out.println("Select account (1: Savings, 2: Current): ");
        while (!scanner.hasNextInt()) {
            System.out.print("Invalid input. Please enter 1 or 2: ");
            scanner.next();
        }
        int type = scanner.nextInt();
        for (BankAccount acc : customer.getAccounts()) {
            if ((type == 1 && acc instanceof SavingsAccount) || (type == 2 && acc instanceof CurrentAccount)) {
                return acc;
            }
        }
        System.out.println("Invalid selection.");
        return null;
    }
}
