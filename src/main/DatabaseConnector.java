package main;
import java.sql.*;
import java.util.ArrayList;

public class DatabaseConnector {

    //Attempt to connect to existing Database.
    //If fails, creates the Database.
    public DatabaseConnector(){

    }

    public void insertLabel(String label) {
        // TODO not implemented, just stubbed
        System.out.println("Label added");
    }

    public ArrayList<String> selectLabels() {
        // TODO not implemented, just stubbed
        ArrayList<String> labels = new ArrayList<String>();
        labels.add("Label1");
        labels.add("Label2");

        return labels;
    }

    public ArrayList<BankAccount> selectBankAccounts() {
        return new ArrayList<BankAccount>();
    }
}
