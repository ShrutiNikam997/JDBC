import java.sql.*;

public class SelectData {
    public static void main(String[] args) {
        try {
            Connection conn4 = DBConnection.getConnection();

            Statement stmt = conn4.createStatement();
            String query = "Select * FROM student";

            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");

                System.out.println(id + "   |   " + name + "   |   " + age + "    |    ");
            }

            conn4.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
