import java.sql.*;
import java.util.*;

public class Updated_Insert{
    public static void main(String[] args) {

        try {

            Connection conn7= DBConnection.getConnection();
            Scanner sc = new Scanner(System.in);

            String query = "Insert into student (name , age, city, email, marks) values (?,?,?,?,?)";
            PreparedStatement pstmt1 = conn7.prepareStatement(query);

            while (true) {
                System.out.println("Enter Name");
                String name = sc.nextLine();

                System.out.println("Enter age");
                int age = sc.nextInt();

                System.out.println("Enter city");
                String city = sc.nextLine();

                System.out.println("Enter email");
                String email = sc.nextLine();

                System.out.println("Enter marks");
                int marks = sc.nextInt();

                sc.nextLine();

                pstmt1.setString(1, name);
                pstmt1.setInt(2, age);
                pstmt1.setString(3,city);
                pstmt1.setString(4,email);
                pstmt1.setInt(5,marks);

                pstmt1.executeUpdate();

                System.out.println("Do you want to add another row?(yes/No)");
                String Ans = sc.nextLine();

                if (Ans.equalsIgnoreCase("no")) {
                    break;
                }

            }
            conn7.close();
            System.out.println("All rows inserted");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
