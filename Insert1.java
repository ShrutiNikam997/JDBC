import java.sql.*;

public class Insert1 {
    public static void main(String[] args) {
        try {

            Connection conn1 = DBConnection.getConnection();

            Statement smt = conn1.createStatement();

            String query = "Insert Into Student ( id, name , age) VALUES( 1, 'Shruti', 20)";

            int rows = smt.executeUpdate(query);

            System.out.println(rows + "Row added successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
