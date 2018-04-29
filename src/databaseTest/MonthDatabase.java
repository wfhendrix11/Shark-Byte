package databaseTest;

import main.DatabaseConnector;
import main.MonthlyBudget;

import java.sql.BatchUpdateException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;
import java.util.ArrayList;

public class MonthDatabase {

    private String dbName;
    private Connection con;
    private String dbms;

    public MonthDatabase(Connection connArg, String dbNameArg, String dbmsArg) {
        super();
        this.con = connArg;
        this.dbName = dbNameArg;
        this.dbms = dbmsArg;

    }

    public static void createTable(Connection connIn, String dbNameIn) throws SQLException {
        String createString = "create table " + dbNameIn + ".MONTHS " +
                "(BUDGET_MONTH int NOT NULL, " +  "BUDGET_YEAR int NOT NULL, " +
                "M_USER_ID int NOT NULL)";
        Statement stmt = null;
        try {
            stmt = connIn.createStatement();
            stmt.executeUpdate(createString);
        } catch (SQLException d){
            System.out.println("No create Month");
            DatabaseConnector.printSQLException(d);
        } finally {
            if (stmt != null) {
                stmt.close();
            }
        }
    }

    public void insertRow(int mon, int yr, int userID) throws SQLException {
        PreparedStatement insertStmt = null;
        String insertInto = "insert into " + dbName + ".MONTHS " +
                "values (?, ?, ?)";
        try {
            con.setAutoCommit(false);
            insertStmt = con.prepareStatement(insertInto);
            insertStmt.setInt(1, mon);
            insertStmt.setInt(2, yr);
            insertStmt.setInt(3, userID);
            insertStmt.executeUpdate();
            con.commit();
        } catch (SQLException d) {
            DatabaseConnector.printSQLException(d);
        } finally {
            if (insertStmt != null) {
                insertStmt.close();
            }
            if (con != null) {
                con.close();
            }
        }
    }

    public Iterable<MonthlyBudget> selectRows(int userID) {
        PreparedStatement selectStmt = null;
        String selectFrom = "select * from " + dbName
                + ".Months where M_USER_ID = " + userID;
        ResultSet rs = null;
        ArrayList<MonthlyBudget> months = new ArrayList<MonthlyBudget>();
        try {
            con.setAutoCommit(false);
            selectStmt = con.prepareStatement(selectFrom);
            rs = selectStmt.executeQuery();

            while (rs != null && rs.next()) {
                int mon = rs.getInt(1);
                int yr = rs.getInt(2);
                MonthlyBudget month = new MonthlyBudget(mon, yr);
                months.add(month);
            }

            if (rs != null) rs.close();

            selectStmt.close();
            con.commit();
        } catch (SQLException e) {
            DatabaseConnector.printSQLException(e);
        }

        return months;
    }
}
