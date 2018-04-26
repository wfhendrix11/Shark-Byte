package main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.time.LocalDate;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.DatabaseMetaData;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

import java.util.ArrayList;

public class DatabaseConnector {

    private static final String driver = "org.apache.derby.jdbc.EmbeddedDriver";
    private static final String dbName = "sharkByteDatabase";
    private static final String connectionURL = "jdbc:derby:" + dbName + ";create=true";
    //String createString

    private Connection conn = null;

    //Attempt to connect to existing Database.
    //If fails, creates the Database.
    public DatabaseConnector(){
        try {
            conn = DriverManager.getConnection(connectionURL);
            DatabaseMetaData metaData = conn.getMetaData();
            ResultSet theTables = metaData.getTables(null, null, "%", null);
            if (theTables.next()) {
                // database was just created, we must create the tables
                // TODO create tables
            }

            theTables.close();
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void close() {
        // shutdown connection to the database
        try {
            // the shutdown=true attribute shuts down Derby
            DriverManager.getConnection("jdbc:derby:;shutdown=true");
        }
        catch (SQLException se) {
            if (( (se.getErrorCode() == 50000)
                    && ("XJ015".equals(se.getSQLState()) ))) {
                // we got the expected exception
                System.out.println("Derby shut down normally");
                // Note that for single database shutdown, the expected
                // SQL state is "08006", and the error code is 45000.
            }
            else {
                // if the error code or SQLState is different, we have
                // an unexpected exception (shutdown failed)
                System.err.println("Derby did not shut down normally");
            }
        }

        try {
            conn.close();
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
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

    public ArrayList<BankAccount> selectBankAccounts() {
        ArrayList<BankAccount> accounts = new ArrayList<BankAccount>();
        accounts.add(new BankAccount("Account1", 0));
        accounts.add(new BankAccount("Account2", 0));
        return accounts;
    }

    public int getNextTransactionId() {
        return 0;
    }

    public void insertTransaction(Transaction transaction) {
        System.out.println("Transaction inserted");
    }

    public void insertRecurringTransaction(RecurringTransaction recurringTransaction) {
        System.out.println("RecurringTransaction inserted");
    }

    public void insertInvestment(Investment newInvestment){
        //TODO
    }

    public ObservableList<Investment> getPortfolio(){
        //Some dummy investments
        Stock stock1 = new Stock("TSLA", 10);
        Crypto crypto1 = new Crypto("ETH", 3.6200);
        CustomAsset asset1 = new CustomAsset("Boy with a Pipe", 1, 1, 104000000);

        ObservableList<Investment> portfolio = FXCollections.observableArrayList();

        //Add dummies to portfolio
        portfolio.add(stock1);
        portfolio.add(crypto1);
        portfolio.add(asset1);
        return portfolio;
    }

    public ObservableList<Transaction> getRecentTransactions(){
        //Some dummy transactions
        Transaction x1 = new Transaction(LocalDate.now(), 20, "Label", 001, "Wally World", "Checking");
        Transaction x2 = new Transaction(LocalDate.now(), 23, "Label", 002, "Moe's", "Savings");
        Transaction x3 = new Transaction(LocalDate.now(), 40, "Label", 003, "AU Bookstore", "Checking");
        Transaction x4 = new RecurringTransaction(LocalDate.now(), 69, "Entertainment", 004, "Love Stuff", "Checking", 30, 4, false);
        Transaction x5 = new RecurringTransaction(LocalDate.now(), 42, "Grocery", 005, "Kroger", "Checking", 30, 0, true);

        ObservableList<Transaction> recentTransactions = FXCollections.observableArrayList();
        recentTransactions.add(x1);
        recentTransactions.add(x2);
        recentTransactions.add(x3);
        recentTransactions.add(x4);
        recentTransactions.add(x5);
        return recentTransactions;
    }

    public ObservableList<Transaction> getBankAccountTransactions(String accountName){
        return null;
    }

}
