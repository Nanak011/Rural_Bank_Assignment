public class SavingsAccount extends BankAccount {
    private static final double INTEREST_RATE = 0.05;

    public SavingsAccount(String name, String number, double initialBalance) {
        super(name, number, initialBalance);
    }

    public void addInterest() {
        double interest = balance * INTEREST_RATE;
        balance += interest;
        System.out.println("Interest added: " + interest + ", New balance: " + balance);
    }

    @Override
    public void withdraw(double amount) throws InsufficientBalanceException {
        if (amount > balance)
            throw new InsufficientBalanceException("Insufficient balance!");
        balance -= amount;
        System.out.println("Withdrawal successful. New balance: " + balance);
    }
}
