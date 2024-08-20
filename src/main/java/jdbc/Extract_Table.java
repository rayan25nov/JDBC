package jdbc;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Extract_Table {
    public static void main(String[] args) {
        try {
            Connection conn = DatabaseConnection.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Student");
            while (rs.next()) {
                System.out.println(
                        rs.getInt("sid") + " | " +
                                rs.getString("sname") + " | " +
                                rs.getString("seid") + " | " +
                                rs.getInt("smob"));
            }
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println("An error occurred while connecting to the database.");
            e.printStackTrace();
        }
    }
}
