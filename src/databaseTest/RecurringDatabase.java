package databaseTest;

import java.sql.BatchUpdateException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;
import java.sql.Date;

public class RecurringDatabase {

    private String dbName;
    private Connection con;
    private String dbms;

    public RecurringDatabase(Connection connArg, String dbNameArg, String dbmsArg) {
        super();
        this.con = connArg;
        this.dbName = dbNameArg;
        this.dbms = dbmsArg;

    }

    public static void createTable(Connection connIn, String dbNameIn) throws SQLException {
        String createString = "create table " + dbNameIn + ".RECURRING " + "(REC_DATE_OF date NOT NULL, " +
                "LAST_DATE date NOT NULL, " + "REC_AMOUNT double NOT NULL, " +
                "REC_LABEL varchar(32) NOT NULL, " + "REC_ID int NOT NULL, " +
                "INTERVAL_OF int NOT NULL, " + "EXECUTIONS int NOT NULL, " +
                "PERPETUAL boolean NOT NULL, " + "REC_MERCHANT varchar(32) NOT NULL, " +
                "REC_BANK_ACC varchar(32) NOT NULL, " + "R_USER_ID int NOT NULL)";
        Statement stmt = null;
        try {
            stmt = connIn.createStatement();
            stmt.executeUpdate(createString);
        } catch (SQLException d){
            System.out.println("No create Recurring");
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

    public void insertRow(java.sql.Date dateIn, java.sql.Date lastDateIn, double amountIn,
                          String labelIn, int IDIn, int intervalIn,
                          int executionsIn, boolean perpetualIn, String merchantIn,
                          String bankAccountIn, int userID) throws SQLException {
        PreparedStatement insertStmt = null;
        String insertInto = "insert into " + dbName + ".RECURRING " +
                "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            con.setAutoCommit(false);
            insertStmt = con.prepareStatement(insertInto);
            insertStmt.setDate(1, dateIn);
            insertStmt.setDate(2, lastDateIn);
            insertStmt.setDouble(3, amountIn);
            insertStmt.setString(4, labelIn);
            insertStmt.setInt(5, IDIn);
            insertStmt.setInt(6, intervalIn);
            insertStmt.setInt(7, executionsIn);
            insertStmt.setBoolean(8, perpetualIn);
            insertStmt.setString(9, merchantIn);
            insertStmt.setString(10, bankAccountIn);
            insertStmt.setInt(11, userID);
            insertStmt.executeUpdate();
            con.commit();
        } catch (SQLException d) {

        } finally {
            if (insertStmt != null) {
                insertStmt.close();
            }
        }
    }

    public int currentMaxID(int userID) throws SQLException {
        PreparedStatement maxStmt = null;
        String findMax = "select max(REC_ID) from " + dbName + ".RECURRING " +
                "where R_USER_ID = " + userID;
        int max = 0;
        ResultSet rs = null;
        try {
            con.setAutoCommit(false);
            maxStmt = con.prepareStatement(findMax);
            rs = maxStmt.executeQuery();
            max = rs.getInt(1);
            con.commit();
        } catch (SQLException d) {

        } finally {
            if (maxStmt != null) {
                maxStmt.close();
            }
        }
        return max;
    }
}
