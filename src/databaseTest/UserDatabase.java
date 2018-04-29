package databaseTest;

import main.DatabaseConnector;

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

    public static void createTable(Connection connIn, String dbNameIn) throws SQLException {
        String createString = "create table " + dbNameIn + ".USERS " + "(USERNAME varchar(32) NOT NULL, " +
                "PASSWORD varchar(32) NOT NULL, " + "USER_ID int NOT NULL, " +
                "PRIMARY KEY (USER_ID))";
        Statement stmt = null;
        try {
            stmt = connIn.createStatement();
            stmt.executeUpdate(createString);
        } catch (SQLException d){
            System.out.println("No create User");
        } finally {
            if (stmt != null) {
                stmt.close();
            }
        }
    }

    // This method inserts a new user into the user table

    public void insertRow(String userName, String password, int userID) throws SQLException {
        PreparedStatement insertStmt = null;
        String insertInto = "insert into " + dbName + ".USERS " +
                "values (?, ?, ?)";
        try {
            con.setAutoCommit(false);
            insertStmt = con.prepareStatement(insertInto);
            insertStmt.setString(1, userName);
            insertStmt.setString(2, password);
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

    // Changes a user's username in the table

    public void updateUserName(String oldName, String newName)  throws SQLException {
        PreparedStatement updateName = null;
        String updateString =
                "update " + dbName + ".USERS " + "set USERNAME = ? where USERNAME = ?";
        try {
            con.setAutoCommit(false);
            updateName = con.prepareStatement(updateString);
            updateName.setString(1, newName);
            updateName.setString(2, oldName);
            updateName.executeUpdate();
            con.commit();
        } catch (SQLException d) {
            DatabaseConnector.printSQLException(d);
        } finally {
            if (updateName != null) {
                updateName.close();
            }
        }
    }

    // Changes a user's password in the table

    public void updatePassword(String newPassword, int userID)  throws SQLException {
        PreparedStatement updatePassword = null;
        String updateString =
                "update " + dbName + ".USERS " + "set PASSWORD = ? where USER_ID = ?";
        try {
            con.setAutoCommit(false);
            updatePassword = con.prepareStatement(updateString);
            updatePassword.setString(1, newPassword);
            updatePassword.setInt(2, userID);
            updatePassword.executeUpdate();
            con.commit();
        } catch (SQLException d) {
            DatabaseConnector.printSQLException(d);
        } finally {
            if (updatePassword != null) {
                updatePassword.close();
            }
        }
    }

    // Checks if a submitted password is the correct password from the table

    public boolean correctPassword(String username, String password)  throws SQLException {
        PreparedStatement checkPassword = null;
        String correctPass = null;
        String getPassword = "select PASSWORD " + "from " + dbName + ".USERS where USERNAME = \'"
                + username + "\'";
        try {
            con.setAutoCommit(false);
            checkPassword = con.prepareStatement(getPassword);
            ResultSet rs = checkPassword.executeQuery();
            correctPass = rs.getString(2);
            con.commit();
        } catch (SQLException d) {
            DatabaseConnector.printSQLException(d);
        } finally {
            if (checkPassword != null) {
                checkPassword.close();
            }
        }
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

    public boolean usernameAvailable(String username)  throws SQLException {
        PreparedStatement checkUsername = null;
        String correctName = null;
        String getUsername = "select * " + "from " + dbName + ".USERS where USERNAME = \'"
                + username + "\'";
        boolean ret = false;
        try {
            con.setAutoCommit(false);
            checkUsername = con.prepareStatement(getUsername);
            ResultSet rs = checkUsername.executeQuery();
            if (!rs.next()) ret = true;
            con.commit();
        } catch (SQLException d) {
            DatabaseConnector.printSQLException(d);
        } finally {
            if (checkUsername != null) {
                checkUsername.close();
            }
        }

        return ret;
        /*
        if(correctName == null){
            return true;
        }
        else {
            return false;
        } */
    }

    public String selectUsername(int userID) {
        PreparedStatement selectStmt = null;
        String selectFrom = "select USERNAME from " + dbName
                + ".USERS where USER_ID = " + userID;
        ResultSet rs = null;
        String ret = null;
        try {
            con.setAutoCommit(false);
            selectStmt = con.prepareStatement(selectFrom);
            rs = selectStmt.executeQuery();

            ret = rs.getString(1);

            if (rs != null) rs.close();

            selectStmt.close();
            con.commit();
        } catch (SQLException e) {
            DatabaseConnector.printSQLException(e);
        }

        return ret;
    }

    public int getUserID(String username) {
        PreparedStatement selectStmt = null;
        String selectFrom = "select USER_ID from " + dbName
                + ".USERS where USERNAME = \'" + username + "\'";
        ResultSet rs = null;
        int ret = 0;
        try {
            con.setAutoCommit(false);
            selectStmt = con.prepareStatement(selectFrom);
            rs = selectStmt.executeQuery();

            ret = rs.getInt(1);

            if (rs != null) rs.close();

            selectStmt.close();
            con.commit();
        } catch (SQLException e) {
            DatabaseConnector.printSQLException(e);
        }

        return ret;
    }

    public int currentMaxID() throws SQLException {
        PreparedStatement maxStmt = null;
        String findMax = "select max(USER_ID) from " + dbName + ".USERS ";
        int max = 0;
        ResultSet rs = null;
        try {
            con.setAutoCommit(false);
            maxStmt = con.prepareStatement(findMax);
            rs = maxStmt.executeQuery();
            if(rs.next()) {
                max = rs.getInt(1);
            }
            con.commit();
        } catch (SQLException d) {
            DatabaseConnector.printSQLException(d);
        } finally {
            if (maxStmt != null) {
                maxStmt.close();
            }
        }
        return max;
    }
}