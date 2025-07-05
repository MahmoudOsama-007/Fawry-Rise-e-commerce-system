package model;

public class Customer {
    private String name;
    private double balance;

    public Customer(String name, double balance) {
        this.name = name;
        this.balance = balance;
    }

    public void pay(double amount) {
        if (amount > balance) throw new RuntimeException("Insufficient funds");
        balance -= amount;
    }

    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setName(String name) {
        this.name = name;
    }
}
