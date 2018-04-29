package main;
import databaseTest.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;
import java.time.LocalDate;

import java.time.Month;
import java.util.ArrayList;

public class DatabaseConnector {

    private static final String driver = "org.apache.derby.jdbc.EmbeddedDriver";
    private static final String dbName = "sharkByteDatabase";
    private static final String connectionURL = "jdbc:derby:" + dbName + ";create=true";
    private static final String dbms = "derby";
    //String createString

    private Connection conn = null;

    //Attempt to connect to existing Database.
    //If fails, creates the Database.
    public DatabaseConnector(){
        try {
            conn = DriverManager.getConnection(connectionURL);
            DatabaseMetaData metaData = conn.getMetaData();
            ResultSet theTables = metaData.getTables(null, null, "%", new String[] {"TABLE"});
            if (!theTables.next()) {
                // database was just created, we must create the tables
                // TODO create tables
                System.out.println("There are no tables");

                UserDatabase.createTable(conn, dbName);
                AssetDatabase.createTable(conn, dbName);
                BankDatabase.createTable(conn, dbName);
                CategoryDatabase.createTable(conn, dbName);
                CryptoDatabase.createTable(conn, dbName);
                LabelDatabase.createTable(conn, dbName);
                MonthDatabase.createTable(conn, dbName);
                RecurringDatabase.createTable(conn, dbName);
                StockDatabase.createTable(conn, dbName);
                TransactionDatabase.createTable(conn, dbName);
                YearDatabase.createTable(conn, dbName);
            }

            theTables.close();
        }
        catch (SQLException e) {
            System.out.println("Failed to create database");
            printSQLException(e);
        }
    }

    public void close() {
        // shutdown connection to the database
        /*
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
        } */

        try {
            conn.close();
        }
        catch (NullPointerException e){
            System.out.println("No connection to close");
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void insertLabel(String label) {
        // TODO not implemented, just stubbed
        LabelDatabase db = new LabelDatabase(conn, dbName, dbms);
        try {
            db.insertRow(label, Main.userID);
            System.out.println("Label added");
        } catch (SQLException e) {
            System.out.println("Could not close statement");
        }
    }

    public ObservableList<String> selectLabels() {
        // TODO not implemented, just stubbed
        ObservableList<String> labels = FXCollections.observableArrayList();
        LabelDatabase db = new LabelDatabase(conn, dbName, dbms);
        Iterable<String> selection = db.selectRows(Main.userID);

        for (String s : selection) {
            labels.add(s);
        }

        return labels;
    }

    public void replacePassword(String password) {
        // Add code to change password in the database
        UserDatabase db = new UserDatabase(conn, dbName, dbms);
        try {
            db.updatePassword(password, Main.userID);
            System.out.println("Password Changed!");
        } catch(SQLException e) {
            System.out.println("Password update failed");
            printSQLException(e);
        }
    }

    public boolean verifyPassword(String password) {
        UserDatabase db = new UserDatabase(conn, dbName, dbms);
        boolean ret = false;
        try {
            String username = db.selectUsername(Main.userID);
            ret = db.correctPassword(username, password);
        } catch (SQLException e) {
            System.out.println("Verify password failed");
            printSQLException(e);
        }
        return ret;
    }

    public ArrayList<BankAccount> selectBankAccounts() {
        ArrayList<BankAccount> accounts = new ArrayList<BankAccount>();
        accounts.add(new BankAccount("Account1", 0));
        accounts.add(new BankAccount("Account2", 0));
        return accounts;
    }

    public int getNextTransactionId() {
        TransactionDatabase db = new TransactionDatabase(conn, dbName, dbms);
        int max = 0;
        try {
            max = db.currentMaxID(Main.userID);
        } catch (SQLException e) {
            System.out.println("Could not read max ID");
            printSQLException(e);
        }
        /* Iterable<Transaction> selection = db.selectRows(Main.userID);
        int max = 0;
        for (Transaction t : selection) {
            max = Math.max(t.getId(), max);
        } */

        return max + 1;
    }

    public void insertTransaction(Transaction transaction) {
        TransactionDatabase tDb = new TransactionDatabase(conn, dbName, dbms);
        Date date = Date.valueOf(transaction.getDate());
        double amount = transaction.getAmount();
        String label = transaction.getLabel();
        int id = transaction.getId();
        boolean recurring = false;
        String merchant = transaction.getMerchant();
        String account = transaction.getAccount();

        try {
            tDb.insertRow(date, amount, label, id, recurring, merchant, account, Main.userID);
            System.out.println("Transaction inserted");
        } catch (SQLException e) {
            System.out.println("Failed to insert transaction");
            printSQLException(e);
        }
    }

    public void insertRecurringTransaction(RecurringTransaction recurringTransaction) {
        RecurringDatabase rDb = new RecurringDatabase(conn, dbName, dbms);
        Date date = Date.valueOf(recurringTransaction.getDate());
        double amount = recurringTransaction.getAmount();
        String label = recurringTransaction.getLabel();
        int id = recurringTransaction.getId();
        String merchant = recurringTransaction.getMerchant();
        String account = recurringTransaction.getAccount();
        int interval = recurringTransaction.getIntervalInDays();
        int executions = recurringTransaction.getNumberOfExecutions();
        boolean perpetual = recurringTransaction.isPerpetual();

        try {
            rDb.insertRow(date, date, amount, label, id, interval, executions, perpetual, merchant,
                    account, Main.userID);
            System.out.println("RecurringTransaction inserted");
        } catch (SQLException e) {
            System.out.println("Failed to insert transaction");
            printSQLException(e);
        }
    }

    public void insertInvestment(Investment newInvestment){
        //TODO
        if (newInvestment instanceof CustomAsset) {
            AssetDatabase db = new AssetDatabase(conn, dbName, dbms);
            String name = newInvestment.getName();
            double value = ((CustomAsset) newInvestment).getCurrentValue();
            double rate = ((CustomAsset) newInvestment).getInterestRate();
            int quantity = ((CustomAsset) newInvestment).getQuantity();

            try {
                db.insertRow(name, value, rate, quantity, Main.userID);
            } catch (SQLException e) {
                System.out.println("Could not insert custom asset");
                printSQLException(e);
            }
        }
        else if (newInvestment instanceof Crypto) {
            CryptoDatabase db = new CryptoDatabase(conn, dbName, dbms);
            String symbol = newInvestment.getName();
            double owned = ((Crypto) newInvestment).getNumberOwned();

            try {
                db.insertRow(symbol, owned, Main.userID);
            } catch (SQLException e) {
                System.out.println("Could not insert crypto asset");
                printSQLException(e);
            }
        }
        else if (newInvestment instanceof Stock) {
            StockDatabase db = new StockDatabase(conn, dbName, dbms);
            String symbol = newInvestment.getName();
            int owned = ((Stock) newInvestment).getNumberOfShares();

            try {
                db.insertRow(symbol, owned, Main.userID);
            } catch (SQLException e) {
                System.out.println("Could not insert crypto asset");
                printSQLException(e);
            }
        }
    }

    public ObservableList<Investment> getPortfolio(){
        /*
        //Some dummy investments
        Stock stock1 = new Stock("TSLA", 10);
        Crypto crypto1 = new Crypto("ETH", 3.6200);
        CustomAsset asset1 = new CustomAsset("Boy with a Pipe", 1, 1, 104000000);
        CustomAsset asset1 = new CustomAsset("Boy with a Pipe", 1, 1, 104000000); */
        ObservableList<Investment> portfolio = FXCollections.observableArrayList();
        StockDatabase sDb = new StockDatabase(conn, dbName, dbms);
        Iterable<Stock> stocks = sDb.selectRows(Main.userID);
        for (Stock s : stocks) {
            portfolio.add(s);
        }
        CryptoDatabase cDb = new CryptoDatabase(conn, dbName, dbms);
        Iterable<Crypto> cryptos = cDb.selectRows(Main.userID);
        for (Crypto c : cryptos) {
            portfolio.add(c);
        }
        AssetDatabase aDb = new AssetDatabase(conn, dbName, dbms);
        Iterable<CustomAsset> assets = aDb.selectRows(Main.userID);
        for (CustomAsset a : assets) {

            portfolio.add(a);

        }
        /*
        //Add dummies to portfolio
        portfolio.add(stock1);
        portfolio.add(crypto1);
        portfolio.add(asset1);
        portfolio.add(asset1); */
        return portfolio;
    }


    public ObservableList<Transaction> getRecentTransactions(){
        //Some dummy transactions
        /*
        Transaction x1 = new Transaction(LocalDate.now(), 20, "Label", 001, "Wally World", "Checking");
        Transaction x2 = new Transaction(LocalDate.now(), 23, "Label", 002, "Moe's", "Savings");
        Transaction x3 = new Transaction(LocalDate.now(), 40, "Label", 003, "AU Bookstore", "Checking");
        Transaction x4 = new RecurringTransaction(LocalDate.now(), 69, "Entertainment", 004, "Love Stuff", "Checking", 30, 4, false);
        Transaction x5 = new RecurringTransaction(LocalDate.now(), 42, "Grocery", 005, "Kroger", "Checking", 30, 0, true);
        */
        TransactionDatabase db = new TransactionDatabase(conn, dbName, dbms);
        ObservableList<Transaction> recentTransactions = FXCollections.observableArrayList();
        Iterable<Transaction> selection = db.selectRows(Main.userID);

        for (Transaction t : selection) {
            LocalDate date = t.getDate();
            LocalDate now = LocalDate.now();

            if (date.getMonthValue() == now.getMonthValue() && date.getYear() == now.getYear()) {
                recentTransactions.add(t);
            }

        }

        return recentTransactions;
    }

    public ObservableList<Transaction> getBankAccountTransactions(String accountName){
        return null;
    }

    public ObservableList<BankAccount> getBankAccounts(){
        ObservableList<BankAccount> bankAccounts = FXCollections.observableArrayList();
        //bankAccounts.add(new BankAccount("Checking", 22)); //DUMMY ACCOUNT
        BankDatabase bDb = new BankDatabase(conn, dbName, dbms);
        Iterable<BankAccount> bankAccountIterable = bDb.selectRows(Main.userID);
        for (BankAccount b : bankAccountIterable) {
           bankAccounts.add(b);
        }
        return bankAccounts;
    }

    public ObservableList<MonthlyBudget> getMonthlyBudgets(){
        MonthlyBudget budget = new MonthlyBudget(4,2018);
        ObservableList<MonthlyBudget>  list = FXCollections.observableArrayList();
        list.add(budget);
        return list;
    }

    public double getCategorySpending(String label, int month, int year){
        return 0.0;
    }


    public void insertCategory(Category c){
        //Todo
    }

    public ObservableList<Transaction> getThisMonthTransactions(){
        Transaction t1 = new Transaction(LocalDate.now(), 22, "Grocery", 003, "Kroger", "Checking");
        ObservableList<Transaction> transactions = FXCollections.observableArrayList();
        transactions.add(t1);
        return transactions;

        //todo actually implement
    }

    public static void printSQLException(SQLException e) {
        do {
            System.out.println(e.getMessage());
            e = e.getNextException();
        } while(e != null);
    }
}

