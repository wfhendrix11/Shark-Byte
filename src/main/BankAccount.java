package main;

public class BankAccount {

    private String name;

    BankAccount() {

    }

    BankAccount(String newName) {
        name = newName;
    }

    public String toString() {
        return name;
    }
}
