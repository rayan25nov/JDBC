package jdbc;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;

public class Create_Table {
    public static void main(String[] args) {

        try {
            Connection conn = DatabaseConnection.getConnection();
            Statement stmt = conn.createStatement();
            stmt.execute("CREATE TABLE Student ("
                    + "sid INT PRIMARY KEY IDENTITY(1,1),"
                    + "sname VARCHAR(50) NOT NULL,"
                    + "seid VARCHAR(50) NOT NULL,"
                    + "smob BIGINT NOT NULL)");
            System.out.println("Table created successfully!");
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println("An error occurred while creating the table.");
            e.printStackTrace();
        }
    }
}
