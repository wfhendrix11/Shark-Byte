package databaseTest;

import java.sql.BatchUpdateException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;

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

    static void createTable(Connection connIn, String dbNameIn) throws SQLException {
        String createString = "create table " + dbNameIn + ".RECURRING " + "(DATE_OF date NOT NULL, " +
                "LAST_DATE date NOT NULL, " + "AMOUNT double NOT NULL, " +
                "LABEL varchar(32) NOT NULL, " + "ID int NOT NULL, " +
                "INTERVAL int NOT NULL, " + "EXECUTIONS int NOT NULL, " +
                "PERPETUAL bit NOT NULL, " + "MERCHANT varchar(32) NOT NULL, " +
                "BANK_ACC varchar(32) NOT NULL, " + "USER_ID int NOT NULL, " +
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
}
