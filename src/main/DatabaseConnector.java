package main;
import java.sql.*;
import java.util.ArrayList;

public class DatabaseConnector {

    String driver = "org.apache.derby.jdbc.EmbeddedDriver";
    String dbName = "sharkByteDatabase";
    String connectionURL = "jdbc:derby:" + dbName + ";create=true";
    //String createString

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

    public void replacePassword(String password) {
        // Add code to change password in the database
        System.out.print("Password Changed!");
    }

    public ArrayList<BankAccount> selectBankAccounts(){
        //TODO
        return new ArrayList<BankAccount>();
    }
}
