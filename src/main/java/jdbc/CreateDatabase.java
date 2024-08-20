package jdbc;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;

public class CreateDatabase {
    public static void main(String[] args) {

        try {
            Connection conn = DatabaseConnection.getConnection();
            Statement stmt = conn.createStatement();
            stmt.execute("CREATE DATABASE Abhishek");
            System.out.println("Database created successfully!");
            stmt.close();
            DatabaseConnection.closeConnection();
        } catch (SQLException e) {
            System.out.println("An error occurred while connecting to the database.");
            e.printStackTrace();
        }
    }
}
