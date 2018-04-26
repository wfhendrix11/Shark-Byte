package databaseTest;

import java.sql.BatchUpdateException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;

public class UserDatabase {

    private String dbName;
    private Connection con;
    private String dbms;

    public UserDatabase(Connection connArg, String dbNameArg, String dbmsArg) {
        super();
        this.con = connArg;
        this.dbName = dbNameArg;
        this.dbms = dbmsArg;

    }

    // This method creates the initial user database table.

    static void createTable(Connection connIn, String dbNameIn) throws SQLException {
        String createString = "create table " + dbNameIn + ".USERS " + "(USERNAME varchar(32) NOT NULL, " +
                "PASSWORD varchar(32) NOT NULL, " + "USER_ID int NOT NULL, " +
                "PRIMARY KEY (USER_ID))";
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

    // This method inserts a new user into the user table

    public void insertRow(String userName, String password, int userID) throws SQLException {
        Statement stmt = null;
        stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        ResultSet uprs = stmt.executeQuery("SELECT * FROM USERS");
        uprs.moveToInsertRow();
        uprs.updateString("USERNAME", userName);
        uprs.updateString("PASSWORD", password);
        uprs.updateInt("USER_ID", userID);
        uprs.insertRow();
        uprs.beforeFirst();
        con.commit();
    }

    // Changes a user's username in the table

    public void updateUserName(String oldName, String newName)  throws SQLException {
        PreparedStatement updateName = null;
        String updateString =
                "update USERS " + "set USERNAME = ? where USERNAME = ?";

        con.setAutoCommit(false);
        updateName = con.prepareStatement(updateString);
        updateName.setString(1, newName);
        updateName.setString(2, oldName);
        updateName.executeUpdate();
        con.commit();
    }

    // Changes a user's password in the table

    public void updatePassword(String newPassword, int userID)  throws SQLException {
        PreparedStatement updatePassword = null;
        String updateString =
                "update USERS " + "set PASSWORD = ? where USER_ID = ?";

        con.setAutoCommit(false);
        updatePassword = con.prepareStatement(updateString);
        updatePassword.setString(1, newPassword);
        updatePassword.setInt(2, userID);
        updatePassword.executeUpdate();
        con.commit();
    }

    // Checks if a submitted password is the correct password from the table

    public boolean correctPassword(String username, String password)  throws SQLException {
        PreparedStatement checkPassword = null;
        String correctPass = null;
        String getPassword = "select PASSWORD " + "from USERS where USERNAME = \'"
                + username + "\'";
        con.setAutoCommit(false);
        checkPassword = con.prepareStatement(getPassword);
        ResultSet rs = checkPassword.executeQuery();
        correctPass = rs.getString(2);
        if(correctPass == null){
            return false;
        }
        else if(correctPass.equals(password)){
            return true;
        }
        else {
            return false;
        }
    }

    // Checks if a submitted name is the correct username from the table

    public boolean correctUsername(String username)  throws SQLException {
        PreparedStatement checkUsername = null;
        String correctName = null;
        String getUsername = "select USERNAME " + "from USERS where USERNAME = \'"
                + username + "\'";
        con.setAutoCommit(false);
        checkUsername = con.prepareStatement(getUsername);
        ResultSet rs = checkUsername.executeQuery();
        correctName = rs.getString(1);
        if(correctName == null){
            return false;
        }
        else {
            return true;
        }
    }
}