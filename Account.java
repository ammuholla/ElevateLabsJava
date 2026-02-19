import java.util.ArrayList;

public class Account {

    protected int accountNumber;
    protected String accountHolder;
    protected double balance;
    protected ArrayList<String> transactionHistory;

    public Account(int accountNumber, String accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
        this.transactionHistory = new ArrayList<>();
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            transactionHistory.add("Deposited: " + amount);
            System.out.println("Amount deposited successfully.");
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            transactionHistory.add("Withdrawn: " + amount);
            System.out.println("Amount withdrawn successfully.");
        } else {
            System.out.println("Insufficient balance or invalid amount.");
        }
    }

    public void displayBalance() {
        System.out.println("Current Balance: " + balance);
    }

    public void showTransactions() {
        System.out.println("\n--- Transaction History ---");
        for (String transaction : transactionHistory) {
            System.out.println(transaction);
        }
    }
  }
