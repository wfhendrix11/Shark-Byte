package databaseTest;

import java.sql.BatchUpdateException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;

public class LabelDatabase {

    private String dbName;
    private Connection con;
    private String dbms;

    public LabelDatabase(Connection connArg, String dbNameArg, String dbmsArg) {
        super();
        this.con = connArg;
        this.dbName = dbNameArg;
        this.dbms = dbmsArg;

    }

    static void createTable(Connection connIn, String dbNameIn) throws SQLException {
        String createString = "create table " + dbNameIn + ".LABELS " +
                "(LABEL varchar(32) NOT NULL, " +  "USER_ID int NOT NULL, " +
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

    public void insertRow(String labelIn, int userID) throws SQLException {
        PreparedStatement insertStmt = null;
        String insertInto = "insert into " + dbName + ".LABELS " +
                "values (?, ?)";
        try {
            con.setAutoCommit(false);
            insertStmt = con.prepareStatement(insertInto);
            insertStmt.setString(1, labelIn);
            insertStmt.setInt(2, userID);
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
