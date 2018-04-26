package databaseTest;

import java.sql.BatchUpdateException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;

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
                "LIMIT double NOT NULL, " + "USER_ID int NOT NULL, " +
                "foreign key(USER_ID) references "+ dbNameIn + ".USERS (USER_ID))";
        Statement stmt = null;
        try {
            stmt = connIn.createStatement();
            stmt.executeUpdate(createString);
        } catch (SQLException d){
            System.out.println("No create Category");
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

        } finally {
            if (insertStmt != null) {
                insertStmt.close();
            }
        }
    }
}
