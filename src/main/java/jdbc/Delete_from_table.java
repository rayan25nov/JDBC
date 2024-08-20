package jdbc;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.SQLException;

public class Delete_from_table {
    public static void main(String[] args) throws SQLException {
        Connection conn = DatabaseConnection.getConnection();
        Statement stmt = conn.createStatement();
        String query = "DELETE FROM Student WHERE sid = 1";
        stmt.execute(query);
        stmt.close();
        DatabaseConnection.closeConnection();
    }
}
