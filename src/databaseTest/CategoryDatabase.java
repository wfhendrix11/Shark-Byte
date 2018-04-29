package databaseTest;

import main.Category;
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

public class CategoryDatabase {

    private String dbName;
    private Connection con;
    private String dbms;

    public CategoryDatabase(Connection connArg, String dbNameArg, String dbmsArg) {
        super();
        this.con = connArg;
        this.dbName = dbNameArg;
        this.dbms = dbmsArg;

    }

    public static void createTable(Connection connIn, String dbNameIn) throws SQLException {
        String createString = "create table " + dbNameIn + ".CATEGORY " +
                "(MONTH_C int NOT NULL, " + "YEAR_C int NOT NULL, " +
                "CATEGORY_LABEL varchar(32) NOT NULL, " +
                "LIMIT double NOT NULL, " + "CA_USER_ID int NOT NULL)";
        Statement stmt = null;
        try {
            stmt = connIn.createStatement();
            stmt.executeUpdate(createString);
        } catch (SQLException d){
            System.out.println("No create Category");
            DatabaseConnector.printSQLException(d);
        } finally {
            if (stmt != null) {
                stmt.close();
            }
        }
    }

    public void insertRow(int mon, int yr, String labelIn, double limitIn,
                          int userID) throws SQLException {
        PreparedStatement insertStmt = null;
        String insertInto = "insert into " + dbName + ".CATEGORY " +
                "values (?, ?, ?, ?, ?)";
        try {
            con.setAutoCommit(false);
            insertStmt = con.prepareStatement(insertInto);
            insertStmt.setInt(1, mon);
            insertStmt.setInt(2, yr);
            insertStmt.setString(3, labelIn);
            insertStmt.setDouble(4, limitIn);
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

    public Iterable<Category> selectRows(int mon, int yr, int userID) {
        PreparedStatement selectStmt = null;
        String selectFrom = "select * from " + dbName
                + ".CATEGORY where MONTH_C = " + mon + " and YEAR_C = " + yr +
                " and CA_USER_ID = " + userID;
        ResultSet rs = null;
        ArrayList<Category> categories = new ArrayList<Category>();
        try {
            con.setAutoCommit(false);
            selectStmt = con.prepareStatement(selectFrom);
            rs = selectStmt.executeQuery();

            while (rs != null && rs.next()) {
                int month = rs.getInt(1);
                int year = rs.getInt(2);
                String label = rs.getString(3);
                double limit = rs.getDouble(4);
                Category cat = new Category(label, limit, month, year);
                categories.add(cat);
            }

            if (rs != null) rs.close();

            selectStmt.close();
            con.commit();
        } catch (SQLException e) {
            DatabaseConnector.printSQLException(e);
        }

        return categories;
    }
}
