import java.sql.BatchUpdateException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;

public class BankDatabase {

    private String dbName;
    private Connection con;
    private String dbms;

    public BankDatabase(Connection connArg, String dbNameArg, String dbmsArg) {
        super();
        this.con = connArg;
        this.dbName = dbNameArg;
        this.dbms = dbmsArg;

    }

    public void createTable() throws SQLException {
        String createString = "create table BANKACCOUNTS " +
                "(ACCOUNT_NAME varchar(32) NOT NULL, " +
                "BALANCE double NOT NULL, " + "FROZEN bit NOT NULL, " +
                "INTEREST_RATE double NOT NULL, " + "USER_ID int NOT NULL, " +
                "FOREIGN KEY (USER_ID) REFERENCES USERS(USER_ID))";
        Statement stmt = null;
        stmt = con.createStatement();
        stmt.executeUpdate(createString);
    }
}
