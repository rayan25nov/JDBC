package jdbc;

import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;

public class Insert_Table {
    public static void main(String[] args) {

        try {
            Connection conn = DatabaseConnection.getConnection();
            Statement stmt = conn.createStatement();
            stmt.execute("INSERT INTO Student " +
                    "(sname, seid, smob) VALUES " +
                    "('Abhishek', 'SE001', 1234567890), " +
                    "('Rahul', 'SE002', 9876543210), " +
                    "('Sneha', 'SE003', 5555555555), " +
                    "('Amit', 'SE004', 9999999999), " +
                    "('Ankit', 'SE005', 8888888888)");
            System.out.println("Record inserted successfully!");
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println("An error occurred while connecting to the database.");
            e.printStackTrace();
        }
    }
}
