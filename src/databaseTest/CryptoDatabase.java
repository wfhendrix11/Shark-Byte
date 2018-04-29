package databaseTest;

import main.Crypto;
import main.DatabaseConnector;
import org.apache.commons.codec.digest.Crypt;

import java.sql.BatchUpdateException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;
import java.util.ArrayList;

public class CryptoDatabase {

    private String dbName;
    private Connection con;
    private String dbms;

    public CryptoDatabase(Connection connArg, String dbNameArg, String dbmsArg) {
        super();
        this.con = connArg;
        this.dbName = dbNameArg;
        this.dbms = dbmsArg;

    }

    public static void createTable(Connection connIn, String dbNameIn) throws SQLException {
        String createString = "create table " + dbNameIn + ".CRYPTO " +
                "(CRYPTO_SYMBOL varchar(10) NOT NULL, " + "OWNED double NOT NULL, "
                + "CR_USER_ID int NOT NULL)";
        Statement stmt = null;
        try {
            stmt = connIn.createStatement();
            stmt.executeUpdate(createString);
        } catch (SQLException d){
            System.out.println("No create Crypto");
            DatabaseConnector.printSQLException(d);
        } finally {
            if (stmt != null) {
                stmt.close();
            }
        }
    }

    public void insertRow(String symbolIn, double ownedIn,
                          int userID) throws SQLException {
        PreparedStatement insertStmt = null;
        String insertInto = "insert into " + dbName + ".CRYPTO " +
                "values (?, ?, ?)";
        try {
            con.setAutoCommit(false);
            insertStmt = con.prepareStatement(insertInto);
            insertStmt.setString(1, symbolIn);
            insertStmt.setDouble(2, ownedIn);
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

    public Iterable<Crypto> selectRows(int userID) {
        PreparedStatement selectStmt = null;
        String selectFrom = "select * from " + dbName
                + ".CRYPTO where CR_USER_ID = " + userID;
        ResultSet rs = null;
        ArrayList<Crypto> cryptos = new ArrayList<Crypto>();
        try {
            con.setAutoCommit(false);
            selectStmt = con.prepareStatement(selectFrom);
            rs = selectStmt.executeQuery();

            while (rs != null && rs.next()) {
                String symbol = rs.getString(1);
                double owned = rs.getDouble(2);
                Crypto crypto = new Crypto(symbol, owned);
                cryptos.add(crypto);
            }

            if (rs != null) rs.close();

            selectStmt.close();
            con.commit();
        } catch (SQLException e) {
            DatabaseConnector.printSQLException(e);
        }

        return cryptos;
    }
}
