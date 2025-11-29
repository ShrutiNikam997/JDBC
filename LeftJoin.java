import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LeftJoin {
    public static void main(String[] args) {
        try {
            // 1. Get connection
            Connection conn = DBConnection.getConnection();
            System.out.println("Connection fetched!");

            // 2. LEFT JOIN query
            String query =
                    "SELECT student.id, student.name, department.dept_name " +
                    "FROM student " +
                    "LEFT JOIN department " +
                    "ON student.dept_id = department.dept_id";

            // 3. Prepare & execute
            PreparedStatement pstmt = conn.prepareStatement(query);
            ResultSet rs = pstmt.executeQuery();

            // 4. Display result
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id"));
                System.out.println("Name: " + rs.getString("name"));
                System.out.println("Department: " + rs.getString("dept_name")); // can be NULL
                System.out.println("------------------------");
            }

            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
