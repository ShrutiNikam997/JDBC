import java.sql.Connection;
import java.sql.Statement;

public class CreateTable {

    public static void main(String[] args) {
        try {
            // Get connection from DBConnection class
            Connection conn = DBConnection.getConnection();

            // Create Statement object
            Statement stmt = conn.createStatement();

            // SQL query to create table
            String query = "CREATE TABLE student (" +
                    "id INT PRIMARY KEY AUTO_INCREMENT, " +
                    "name VARCHAR(50), " +
                    "age INT)";

            // Execute query
            stmt.executeUpdate(query);

            System.out.println("Table created successfully!");

            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
