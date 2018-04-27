package databaseTest;

import main.DatabaseConnector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.DatabaseMetaData;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

import java.util.ArrayList;
import java.util.Properties;


public class DatabaseTest {
    private static final String framework = "embedded";
    private static final String protocol = "jdbc:derby:";
    private static final String databaseName = "sharkByteDB";

    public static void main(String[] args) {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(protocol + databaseName
                    + ";create=true");
            DatabaseMetaData metaData = conn.getMetaData();
            ResultSet theTables = metaData.getTables(null, null, "%", null);
            if (theTables.next()) {
                // database was just created, we must create the tables
                // TODO create tables
            }

            theTables.close();
        }
        catch (SQLException e) {
            DatabaseConnector.printSQLException(e);
        }
    }

}
