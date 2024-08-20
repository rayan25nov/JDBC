package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import io.github.cdimascio.dotenv.Dotenv;

public class Update_Table {
    public static void main(String[] args) {
        Dotenv dotenv = Dotenv.load();
        String url = dotenv.get("DB_URL");
        String user = dotenv.get("DB_USER");
        String password = dotenv.get("DB_PASSWORD");

        String connectionUrl = url + ";"
                + "user=" + user + ";"
                + "password=" + password + ";"
                + "encrypt=true;trustServerCertificate=true;";

        try {
            Connection connection = DriverManager.getConnection(connectionUrl);
            Statement statement = connection.createStatement();
            String sql = "UPDATE Student SET sname = 'Rayan', seid = 'rayan@gmail.com', smob = 8507545405 WHERE sid = 1";
            int rowsUpdated = statement.executeUpdate(sql);
            System.out.println("Rows updated: " + rowsUpdated);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
