package databaseTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

import java.util.ArrayList;
import java.util.Properties;


public class DatabaseTest {
    private final String framework = "embedded";
    private final String protocol = "jdbc:derby:";
    private final String databaseName = "sharkByteDB";

    public static void main(String[] args) {
        System.out.println("Test");
    }
}
