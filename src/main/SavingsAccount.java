package main;

public class SavingsAccount extends BankAccount {
    private double interestRate;

    public SavingsAccount(String newName, double newInterestRate) {
        super(newName, 0);
        interestRate = newInterestRate;
    }

    public void setInterestRate(double newInterestRate) {
        interestRate = newInterestRate;
        System.out.print("New intereest rate set!");
    }

    public double getInterestRate() {
        return interestRate;
    }
}
