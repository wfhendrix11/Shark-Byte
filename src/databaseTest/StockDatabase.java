package databaseTest;

import java.sql.BatchUpdateException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;

public class StockDatabase {

    private String dbName;
    private Connection con;
    private String dbms;

    public StockDatabase(Connection connArg, String dbNameArg, String dbmsArg) {
        super();
        this.con = connArg;
        this.dbName = dbNameArg;
        this.dbms = dbmsArg;

    }

    public static void createTable(Connection connIn, String dbNameIn) throws SQLException {
        String createString = "create table " +dbNameIn+ ".STOCKS " +
                "(STOCK_SYMBOL varchar(10) NOT NULL, " + "SHARES int NOT NULL, " +
                "STOCK_TOTAL double NOT NULL, " + "S_USER_ID int NOT NULL)";
        Statement stmt = null;
        try {
            stmt = connIn.createStatement();
            stmt.executeUpdate(createString);
        } catch (SQLException d){
            System.out.println("No create Stock");
        } finally {
            if (stmt != null) {
                stmt.close();
            }
        }
    }

    public void insertRow(String symbolIn, int sharesIn, double totalIn,
                          int userID) throws SQLException {
        PreparedStatement insertStmt = null;
        String insertInto = "insert into " + dbName + ".STOCKS " +
                "values (?, ?, ?, ?)";
        try {
            con.setAutoCommit(false);
            insertStmt = con.prepareStatement(insertInto);
            insertStmt.setString(1, symbolIn);
            insertStmt.setInt(2, sharesIn);
            insertStmt.setDouble(3, totalIn);
            insertStmt.setInt(4, userID);
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
