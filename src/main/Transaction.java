package main;

import java.time.LocalDate;

public class Transaction {
    private LocalDate date;
    private int amount;
    private String label;
    private int id;

    Transaction() {

    }

    Transaction(LocalDate newDate, int newAmount, String newLabel, int newId) {
        date = newDate;
        amount = newAmount;
        label = newLabel;
        id = newId;
    }

    String getLabel() {
        return label;
    }

    int getAmount() {
        return amount;
    }

    int getId() {
        return id;
    }

    LocalDate getDate() {
        return date;
    }
}
