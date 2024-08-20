package jdbc;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.SQLException;

public class Alter_Table {
    public static void main(String[] args) throws SQLException {
        Connection conn = DatabaseConnection.getConnection();
        Statement stmt = conn.createStatement();
        String query = "ALTER TABLE Student ADD s_address VARCHAR(30)";
        stmt.execute(query);
        stmt.close();
        System.out.println("Table altered successfully");
        // Write your code here to alter the table
        DatabaseConnection.closeConnection();
    }
}
