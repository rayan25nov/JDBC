package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;

import io.github.cdimascio.dotenv.Dotenv;

public class App {
    public static void main(String[] args) {
        // Database connection details
        Dotenv dotenv = Dotenv.load();
        String url = dotenv.get("DB_URL");
        String user = dotenv.get("DB_USER");
        String password = dotenv.get("DB_PASSWORD");

        String connectionUrl = url + ";"
                + "user=" + user + ";"
                + "password=" + password + ";"
                + "encrypt=true;trustServerCertificate=true;";

        // Establishing the connection
        try {
            Connection conn = DriverManager.getConnection(connectionUrl);
            Statement stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery("SELECT * FROM Student");
            System.out.println("sname" + " | " + "seid" + " | " + "smob");
            while (rs.next()) {
                System.out.println(rs.getString("sname") + " | " + rs.getInt("seid") + " | " + rs.getString("smob"));
            }

            rs.close();
            stmt.close();
            conn.close();

        } catch (SQLException e) {
            System.out.println("An error occurred while connecting to the database.");
            e.printStackTrace();
        }
    }
}
