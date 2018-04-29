package databaseTest;

import main.CustomAsset;
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

public class AssetDatabase {

    private String dbName;
    private Connection con;
    private String dbms;

    public AssetDatabase(Connection connArg, String dbNameArg, String dbmsArg) {
        super();
        this.con = connArg;
        this.dbName = dbNameArg;
        this.dbms = dbmsArg;

    }

    public static void createTable(Connection connIn, String dbNameIn) throws SQLException {
        String createString = "create table " + dbNameIn + ".ASSETS " +
                "(ASSET_NAME varchar(32) NOT NULL, " + "ASSET_VALUE double NOT NULL, " +
                "INTEREST_RATE double NOT NULL, " + "QUANTITY double NOT NULL, " + "A_USER_ID int NOT NULL)";
        Statement stmt = null;
        try {
            stmt = connIn.createStatement();
            stmt.executeUpdate(createString);
        } catch (SQLException d){
            System.out.println("No create Asset");
            DatabaseConnector.printSQLException(d);
        } finally {
            if (stmt != null) {
                stmt.close();
            }
        }
    }

    public void insertRow(String nameIn, double valueIn, double rateIn,
                          int quantityIn, int userID) throws SQLException {
        PreparedStatement insertStmt = null;
        String insertInto = "insert into " + dbName + ".ASSETS " +
                "values (?, ?, ?, ?)";
        try {
            con.setAutoCommit(false);
            insertStmt = con.prepareStatement(insertInto);
            insertStmt.setString(1, nameIn);
            insertStmt.setDouble(2, valueIn);
            insertStmt.setDouble(3, rateIn);
            insertStmt.setInt(4, quantityIn);
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

    public Iterable<CustomAsset> selectRows(int userID) {
        PreparedStatement selectStmt = null;
        String selectFrom = "select * from " + dbName
                + ".ASSETS where A_USER_ID = " + userID;
        ResultSet rs = null;
        ArrayList<CustomAsset> assets = new ArrayList<CustomAsset>();
        try {
            con.setAutoCommit(false);
            selectStmt = con.prepareStatement(selectFrom);
            rs = selectStmt.executeQuery();

            while (rs != null && rs.next()) {
                String name = rs.getString(1);
                double value = rs.getDouble(2);
                double interest = rs.getDouble(3);
                int quantity = rs.getInt(4);
                CustomAsset asset = new CustomAsset(name, quantity, interest, value);
                assets.add(asset);
            }

            if (rs != null) rs.close();

            selectStmt.close();
            con.commit();
        } catch (SQLException e) {
            DatabaseConnector.printSQLException(e);
        }

        return assets;
    }
}
