public abstract class BankAccount {
    protected String accountHolderName;
    protected String accountNumber;
    protected double balance;

    public BankAccount(String name, String number, double initialBalance) {
        this.accountHolderName = name;
        this.accountNumber = number;
        this.balance = initialBalance;
    }

    public abstract void withdraw(double amount) throws InsufficientBalanceException;

    public void deposit(double amount) {
        if (amount > 0) balance += amount;
        System.out.println("Deposit successful. New balance: " + balance);
    }

    public void displayDetails() {
        System.out.println("Account Holder: " + accountHolderName);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance: " + balance);
    }

    public String getAccountType() {
        return this instanceof SavingsAccount ? "Savings" : "Current";
    }
}

