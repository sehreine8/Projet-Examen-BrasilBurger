package rss.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {

    private static final String URL =
            "jdbc:postgresql://ep-misty-king-af14died-pooler.c-2.us-west-2.aws.neon.tech:5432/neondb?sslmode=require";

    private static final String USER = "neondb_owner";

    private static final String PASSWORD = "npg_gSCYO7yaGTJ6";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
