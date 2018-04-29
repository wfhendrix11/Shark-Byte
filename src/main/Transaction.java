package main;

import java.time.LocalDate;

public class Transaction {
    private LocalDate date;
    private double amount;
    private String label;
    private int id;
    private String merchant;
    private String account;
    private boolean recurring;

    public Transaction() {

    }

    public Transaction(LocalDate newDate, double newAmount, String newLabel, int newId, String newMerchant, String newAccount, boolean newRecurring) {
        date = newDate;
        amount = newAmount;
        label = newLabel;
        id = newId;
        merchant = newMerchant;
        account = newAccount;
        recurring = newRecurring;
    }

    public String getLabel() {
        return label;
    }

    public double getAmount() {
        return amount;
    }

    public int getId() {
        return id;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getMerchant() {return merchant;}

    public String getAccount() {return account;}

    public boolean isRecurring() {
        return recurring;
    }
}
