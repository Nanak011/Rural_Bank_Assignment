public class CurrentAccount extends BankAccount {
    private static final double OVERDRAFT_LIMIT = 1000.0;

    public CurrentAccount(String name, String number, double initialBalance) {
        super(name, number, initialBalance);
    }

    @Override
    public void withdraw(double amount) throws InsufficientBalanceException {
        if (amount > (balance + OVERDRAFT_LIMIT))
            throw new InsufficientBalanceException("Overdraft limit exceeded!");
        balance -= amount;
        System.out.println("Withdrawal successful. New balance: " + balance);
    }
}

