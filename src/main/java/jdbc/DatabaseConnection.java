package jdbc;

import io.github.cdimascio.dotenv.Dotenv;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static Connection connection = null;

    // Private constructor to prevent instantiation
    private DatabaseConnection() {
    }

    // Method to establish and return a connection
    public static Connection getConnection() {
        if (connection == null) {
            try {
                Dotenv dotenv = Dotenv.load();
                String url = dotenv.get("DB_URL");
                String user = dotenv.get("DB_USER");
                String password = dotenv.get("DB_PASSWORD");

                String connectionUrl = url + ";"
                        + "user=" + user + ";"
                        + "password=" + password + ";"
                        + "encrypt=true;trustServerCertificate=true;";

                connection = DriverManager.getConnection(connectionUrl);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }

    // Method to close the connection
    public static void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
                connection = null;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
