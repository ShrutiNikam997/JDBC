import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class InnerJoin {
public static void main(String[] args) {
try {
Connection con10=DBConnection.getConnection();


        String query =
            "SELECT student.id, student.name, student.age, " +
            "student.city, student.marks, student.email, " +
            "department.dept_name " +
            "FROM student " +
            "INNER JOIN department " +
            "ON student.dept_id = department.dept_id";

        PreparedStatement pstmt =con10.prepareStatement(query);
        ResultSet rs = pstmt.executeQuery();

        while (rs.next()) {
            System.out.println("ID: " + rs.getInt("id"));
            System.out.println("Name: " + rs.getString("name"));
            System.out.println("Age: " + rs.getInt("age"));
            System.out.println("City: " + rs.getString("city"));
            System.out.println("Marks: " + rs.getInt("marks"));
            System.out.println("Email: " + rs.getString("email"));
            System.out.println("Department: " + rs.getString("dept_name"));
            System.out.println("--------------------------------");
        }

       con10.close();

    } catch (Exception e) {
        e.printStackTrace();
    }
}


}
