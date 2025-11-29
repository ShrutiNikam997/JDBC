import java.sql.*;

public class DBConnection {
    public static Connection getConnection() {
        Connection conn = null;
        try {

            // Load MySQL Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Connect to database
            conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/testDB",
                    "root",
                    "Shruti@997");

            System.out.println("Connected!");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return conn;
    }
}
