package main;

import java.util.ArrayList;

public class BankAccount {

    private String name;
    private double balance;
    private boolean isFrozen;
    private ArrayList<Transaction> transactionList;

    BankAccount(String newName, double newBalance) {
        name = newName;
        balance = newBalance;
        isFrozen = false;
        transactionList = new ArrayList<Transaction>();
    }

    public void addTransaction(Transaction t) {
        transactionList.add(t);
        System.out.print("Transaction added!");
    }

    public void freeze() {
        isFrozen = true;
        System.out.print("Account Frozen!");
    }

    public void unFreeze() {
        isFrozen = false;
        System.out.print("Account unfrozen!");
    }

    public String getName()
    {
        return name;
    }

    public String toString() {
        return name;
    }

    public double getBalance(){
        return balance;
    }
}
