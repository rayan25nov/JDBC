package jdbc;

import java.sql.Connection;

public class Drop_Table {
    public static void main(String[] args) {
        Connection conn = DatabaseConnection.getConnection();
        String query = "DROP TABLE Student";
        try {
            conn.createStatement().execute(query);
            System.out.println("Table dropped successfully");
            DatabaseConnection.closeConnection();
        } catch (Exception e) {
            System.out.println("An error occurred while dropping the table.");
            e.printStackTrace();
        }
    }
}
