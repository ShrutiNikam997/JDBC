import java.sql.*;

public class Insert_Prepared {
    public static void main(String[] args) {
        try {
            Connection conn2 = DBConnection.getConnection();

            String query = "Insert Into student (name, age) values(?, ?)";

            PreparedStatement pstmt = conn2.prepareStatement(query);

            pstmt.setString(1, "Shruti");
            pstmt.setInt(2, 21);

            int rows = pstmt.executeUpdate();
            System.out.println(rows + "row inserted");

            conn2.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
