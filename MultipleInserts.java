import java.sql.*;
import java.util.*;

public class MultipleInserts {
    public static void main(String[] args) {

        try {

            Connection conn3 = DBConnection.getConnection();
            Scanner sc = new Scanner(System.in);

            String query = "Insert into student (name , age) Values(?,?)";
            PreparedStatement pstmt1 = conn3.prepareStatement(query);

            while (true) {
                System.out.println("Enter Name");
                String name = sc.nextLine();

                System.out.println("Enter age");
                int age = sc.nextInt();

                sc.nextLine();

                pstmt1.setString(1, name);
                pstmt1.setInt(2, age);

                pstmt1.executeUpdate();

                System.out.println("Do you want to add another row?(yes/No)");
                String Ans = sc.nextLine();

                if (Ans.equalsIgnoreCase("no")) {
                    break;
                }

            }
            conn3.close();
            System.out.println("All rows inserted");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
