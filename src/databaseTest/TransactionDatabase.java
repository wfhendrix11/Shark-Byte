package databaseTest;

import main.Transaction;
import main.DatabaseConnector;

import javax.xml.crypto.Data;
import java.awt.image.DataBuffer;
import java.sql.BatchUpdateException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

public class TransactionDatabase {

    private String dbName;
    private Connection con;
    private String dbms;

    public TransactionDatabase(Connection connArg, String dbNameArg, String dbmsArg) {
        super();
        this.con = connArg;
        this.dbName = dbNameArg;
        this.dbms = dbmsArg;

    }

    public static void createTable(Connection connIn, String dbNameIn) throws SQLException {
        String createString = "create table " + dbNameIn + ".TRANSACTIONS " + "(TRANS_DATE_OF date NOT NULL, " +
                "TRANS_AMOUNT double NOT NULL, " + "TRANS_LABEL varchar(32) NOT NULL, " +
                "TRANS_ID int NOT NULL, " + "RECURRING boolean NOT NULL, " +
                "TRANS_MERCHANT varchar(32) NOT NULL, " + "TRANS_BANK_ACC varchar(32) NOT NULL, " +
                "T_USER_ID int NOT NULL)";
        Statement stmt = null;
        try {
            stmt = connIn.createStatement();
            stmt.executeUpdate(createString);
        } catch (SQLException d){
            System.out.println("No create Transaction");
            do {
                System.out.println(d.getMessage());
                d = d.getNextException();
            } while(d != null);
        } finally {
            if (stmt != null) {
                stmt.close();
            }
        }
    }

    public void insertRow(java.sql.Date dateIn, double amountIn,
                          String labelIn, int IDIn,
                          boolean recurringIn, String merchantIn,
                          String bankAccountIn, int userID) throws SQLException {
        PreparedStatement insertStmt = null;
        String insertInto = "insert into " + dbName + ".TRANSACTIONS " +
                "values (?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            con.setAutoCommit(false);
            insertStmt = con.prepareStatement(insertInto);
            insertStmt.setDate(1, dateIn);
            insertStmt.setDouble(2, amountIn);
            insertStmt.setString(3, labelIn);
            insertStmt.setInt(4, IDIn);
            insertStmt.setBoolean(5, recurringIn);
            insertStmt.setString(6, merchantIn);
            insertStmt.setString(7, bankAccountIn);
            insertStmt.setInt(8, userID);
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

    public Iterable<Transaction> selectRows(int userID) {
        PreparedStatement selectStmt = null;
        String selectFrom = "select * from " + dbName
                + ".TRANSACTIONS where T_USER_ID = " + userID;
        ResultSet rs = null;
        ArrayList<Transaction> transactions = new ArrayList<Transaction>();
        try {
            con.setAutoCommit(false);
            selectStmt = con.prepareStatement(selectFrom);
            rs = selectStmt.executeQuery();

            while (rs != null && rs.next()) {
                LocalDate date = rs.getDate(1).toLocalDate();
                double amount = rs.getDouble(2);
                String label = rs.getString(3);
                int id = rs.getInt(4);
                boolean recurring = rs.getBoolean(5);
                String merchant = rs.getString(6);
                String account = rs.getString(7);
                Transaction transaction = new Transaction(date, amount, label, id, merchant, account, recurring);
                transactions.add(transaction);
            }

            if (rs != null) rs.close();

            selectStmt.close();
            con.commit();
        } catch (SQLException e) {
            DatabaseConnector.printSQLException(e);
        }

        return transactions;
    }

    public Iterable<Transaction> selectRows(String bankAccount, int userID) {
        PreparedStatement selectStmt = null;
        String selectFrom = "select * from " + dbName
                + ".TRANSACTIONS where TRANS_BANK_ACC = \'" + bankAccount
                + "\' and T_USER_ID = " + userID;
        ResultSet rs = null;
        ArrayList<Transaction> transactions = new ArrayList<Transaction>();
        try {
            con.setAutoCommit(false);
            selectStmt = con.prepareStatement(selectFrom);
            rs = selectStmt.executeQuery();

            while (rs != null && rs.next()) {
                LocalDate date = rs.getDate(1).toLocalDate();
                double amount = rs.getDouble(2);
                String label = rs.getString(3);
                int id = rs.getInt(4);
                boolean recurring = rs.getBoolean(5);
                String merchant = rs.getString(6);
                String account = rs.getString(7);
                Transaction transaction = new Transaction(date, amount, label, id, merchant, account, recurring);
                transactions.add(transaction);
            }

            if (rs != null) rs.close();

            selectStmt.close();
            con.commit();
        } catch (SQLException e) {
            DatabaseConnector.printSQLException(e);
        }

        return transactions;
    }

    public Iterable<Transaction> selectRowsByLabel(String labelIn, int userID) {
        PreparedStatement selectStmt = null;
        String selectFrom = "select * from " + dbName
                + ".TRANSACTIONS where TRANS_LABEL = \'" + labelIn
                + "\' and T_USER_ID = " + userID;
        ResultSet rs = null;
        ArrayList<Transaction> transactions = new ArrayList<Transaction>();
        try {
            con.setAutoCommit(false);
            selectStmt = con.prepareStatement(selectFrom);
            rs = selectStmt.executeQuery();

            while (rs != null && rs.next()) {
                LocalDate date = rs.getDate(1).toLocalDate();
                double amount = rs.getDouble(2);
                String label = rs.getString(3);
                int id = rs.getInt(4);
                boolean recurring = rs.getBoolean(5);
                String merchant = rs.getString(6);
                String account = rs.getString(7);
                Transaction transaction = new Transaction(date, amount, label, id, merchant, account, recurring);
                transactions.add(transaction);
            }

            if (rs != null) rs.close();

            selectStmt.close();
            con.commit();
        } catch (SQLException e) {
            DatabaseConnector.printSQLException(e);
        }

        return transactions;
    }

    public int currentMaxID(int userID) throws SQLException {
        PreparedStatement maxStmt = null;
        String findMax = "select max(TRANS_ID) from " + dbName + ".TRANSACTIONS " +
                "where T_USER_ID = " + userID;
        int max = 0;
        ResultSet rs = null;
        try {
            con.setAutoCommit(false);
            maxStmt = con.prepareStatement(findMax);
            rs = maxStmt.executeQuery();
            if (!rs.next()) return max;
            max = rs.getInt(1);
            con.commit();
        } catch (SQLException d) {
            DatabaseConnector.printSQLException(d);
        } finally {
            if (maxStmt != null) {
                maxStmt.close();
            }
        }
        return max;
    }
}
