public class SavingsAccount extends Account {

    private double interestRate;

    public SavingsAccount(int accountNumber, String accountHolder,
                          double balance, double interestRate) {
        super(accountNumber, accountHolder, balance);
        this.interestRate = interestRate;
    }

    // Method Overriding
    @Override
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            transactionHistory.add("Savings Withdrawn: " + amount);
            System.out.println("Amount withdrawn from Savings Account.");
        } else {
            System.out.println("Insufficient balance in Savings Account.");
        }
    }

    public void addInterest() {
        double interest = balance * interestRate / 100;
        balance += interest;
        transactionHistory.add("Interest Added: " + interest);
        System.out.println("Interest added successfully.");
    }
}
