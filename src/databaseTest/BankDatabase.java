package databaseTest;


import main.BankAccount;
import main.DatabaseConnector;

import java.sql.BatchUpdateException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;
import java.util.ArrayList;

public class BankDatabase {

    private String dbName;
    private Connection con;
    private String dbms;

    public BankDatabase(Connection connArg, String dbNameArg, String dbmsArg) {
        super();
        this.con = connArg;
        this.dbName = dbNameArg;
        this.dbms = dbmsArg;

    }

    public static void createTable(Connection connIn, String dbNameIn) throws SQLException {
        String createString = "create table " + dbNameIn + ".BANKACCOUNTS " +
                "(ACCOUNT_NAME varchar(32) NOT NULL, " +
                "BALANCE double NOT NULL, " + "FROZEN boolean NOT NULL, " +
                "BANK_INTEREST double NOT NULL, " + "B_USER_ID int NOT NULL)";
        Statement stmt = null;
        try {
            stmt = connIn.createStatement();
            stmt.executeUpdate(createString);
        } catch (SQLException d){
            System.out.println("No create Bank Account");
            DatabaseConnector.printSQLException(d);
        } finally {
            if (stmt != null) {
                stmt.close();
            }
        }
    }

    public void insertRow(String accountIn, double balanceIn, boolean frozenIn,
                          double rateIn, int userID) throws SQLException {
        PreparedStatement insertStmt = null;
        String insertInto = "insert into " + dbName + ".BANKACCOUNTS " +
                "values (?, ?, ?, ?, ?)";
        try {
            con.setAutoCommit(false);
            insertStmt = con.prepareStatement(insertInto);
            insertStmt.setString(1, accountIn);
            insertStmt.setDouble(2, balanceIn);
            insertStmt.setBoolean(3, frozenIn);
            insertStmt.setDouble(4, rateIn);
            insertStmt.setInt(5, userID);
            insertStmt.executeUpdate();
            con.commit();
        } catch (SQLException d) {
            DatabaseConnector.printSQLException(d);
        } finally {
            if (insertStmt != null) {
                insertStmt.close();
            }
        }
    }

    public Iterable<BankAccount> selectRows(int userID) {
        PreparedStatement selectStmt = null;
        String selectFrom = "select * from " + dbName
                + ".BANKACCOUNTS where B_USER_ID = " + userID;
        ResultSet rs = null;
        ArrayList<BankAccount> bankAccounts = new ArrayList<BankAccount>();
        try {
            con.setAutoCommit(false);
            selectStmt = con.prepareStatement(selectFrom);
            rs = selectStmt.executeQuery();

            while (rs != null && rs.next()) {
                String name = rs.getString(1);
                double balance = rs.getDouble(2);
                BankAccount bankAccount = new BankAccount(name, balance);
                bankAccounts.add(bankAccount);
            }

            if (rs != null) rs.close();

            selectStmt.close();
            con.commit();
        } catch (SQLException e) {
            DatabaseConnector.printSQLException(e);
        }

        return bankAccounts;
    }

    public void updateRow(String account, double amount, int userID) {
        PreparedStatement selectStmt = null;
        PreparedStatement updateStmt = null;
        String selectFrom = "select * from " + dbName
                + ".BANKACCOUNTS where B_USER_ID = " + userID
                + " and ACCOUNT_NAME = \'" + account + "\'";
        ResultSet rs = null;
        try {
            con.setAutoCommit(false);
            selectStmt = con.prepareStatement(selectFrom);
            rs = selectStmt.executeQuery();
            rs.next();
            double current = rs.getDouble(2);
            current += amount;

            String update = "update " + dbName + ".BANKACCOUNTS set BALANCE = " + current
                    + " where ACCOUNT_NAME = \'" + account + "\'";
            updateStmt = con.prepareStatement(update);
            updateStmt.executeUpdate();

            rs.close();
            updateStmt.close();
            selectStmt.close();
            con.commit();
        } catch (SQLException e) {
            System.out.println("Failed to update account row");
            DatabaseConnector.printSQLException(e);
        }
    }
}
