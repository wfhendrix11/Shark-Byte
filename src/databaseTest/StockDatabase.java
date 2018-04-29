package databaseTest;

import main.DatabaseConnector;
import main.Stock;

import java.sql.BatchUpdateException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;
import java.util.ArrayList;

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
        String createString = "create table " + dbNameIn + ".STOCKS " +
                "(STOCK_SYMBOL varchar(10) NOT NULL, " + "SHARES int NOT NULL, "
                + "S_USER_ID int NOT NULL)";
        Statement stmt = null;
        try {
            stmt = connIn.createStatement();
            stmt.executeUpdate(createString);
        } catch (SQLException d){
            System.out.println("No create Stock");
            DatabaseConnector.printSQLException(d);
        } finally {
            if (stmt != null) {
                stmt.close();
            }
        }
    }

    public void insertRow(String symbolIn, int sharesIn,
                          int userID) throws SQLException {
        PreparedStatement insertStmt = null;
        String insertInto = "insert into " + dbName + ".STOCKS " +
                "values (?, ?, ?, ?)";
        try {
            con.setAutoCommit(false);
            insertStmt = con.prepareStatement(insertInto);
            insertStmt.setString(1, symbolIn);
            insertStmt.setInt(2, sharesIn);
            insertStmt.setInt(3, userID);
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

    public Iterable<Stock> selectRows(int userID) {
        PreparedStatement selectStmt = null;
        String selectFrom = "select * from " + dbName
                + ".STOCKS where S_USER_ID = " + userID;
        ResultSet rs = null;
        ArrayList<Stock> stocks = new ArrayList<Stock>();
        try {
            con.setAutoCommit(false);
            selectStmt = con.prepareStatement(selectFrom);
            rs = selectStmt.executeQuery();

            while (rs != null && rs.next()) {
                String symbol = rs.getString(1);
                int shares = rs.getInt(2);
                Stock stock = new Stock(symbol, shares);
                stocks.add(stock);
            }

            if (rs != null) rs.close();

            selectStmt.close();
            con.commit();
        } catch (SQLException e) {
            DatabaseConnector.printSQLException(e);
        }

        return stocks;
    }
}
