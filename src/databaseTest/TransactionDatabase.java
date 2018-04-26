package databaseTest;

import java.sql.BatchUpdateException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;

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

        } finally {
            if (insertStmt != null) {
                insertStmt.close();
            }
        }
    }
}
