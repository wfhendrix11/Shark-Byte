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

    public void createTable() throws SQLException {
        String createString = "create table CATEGORY " +
                "(MONTH int NOT NULL, " + "YEAR_OF int NOT NULL, " +
                "LABEL varchar(32) NOT NULL, " +
                "LIMIT double NOT NULL, " + "USER_ID int NOT NULL, " +
                "FOREIGN KEY (USER_ID) REFERENCES USERS(USER_ID))";
        Statement stmt = null;
        stmt = con.createStatement();
        stmt.executeUpdate(createString);
    }
}
