package main;

import java.time.LocalDate;

public class Transaction {
    private LocalDate date;
    private double amount;
    private String label;
    private int id;
    private String merchant;
    private String account;

    Transaction() {

    }

    Transaction(LocalDate newDate, double newAmount, String newLabel, int newId, String newMerchant, String newAccount) {
        date = newDate;
        amount = newAmount;
        label = newLabel;
        id = newId;
        merchant = newMerchant;
        account = newAccount;
    }

    String getLabel() {
        return label;
    }

    double getAmount() {
        return amount;
    }

    int getId() {
        return id;
    }

    LocalDate getDate() {
        return date;
    }
}
