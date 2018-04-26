package databaseTest;

import java.sql.BatchUpdateException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;

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

    static void createTable(Connection connIn, String dbNameIn) throws SQLException {
        String createString = "create table " + dbNameIn + ".BANKACCOUNTS " +
                "(ACCOUNT_NAME varchar(32) NOT NULL, " +
                "BALANCE double NOT NULL, " + "FROZEN bit NOT NULL, " +
                "INTEREST_RATE double NOT NULL, " + "USER_ID int NOT NULL, " +
                "FOREIGN KEY (USER_ID) REFERENCES USERS(USER_ID))";
        Statement stmt = null;
        try {
            stmt = connIn.createStatement();
            stmt.executeUpdate(createString);
        } catch (SQLException d){

        } finally {
            if (stmt != null) {
                stmt.close();
            }
            if (connIn != null) {
                connIn.close();
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
            insertStmt.setDouble(2, rateIn);
            insertStmt.setInt(5, userID);
            insertStmt.executeUpdate();
            con.commit();
        } catch (SQLException d) {

        } finally {
            if (insertStmt != null) {
                insertStmt.close();
            }
            if (con != null) {
                con.close();
            }
        }
    }
}
