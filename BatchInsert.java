import java.sql.*;
import java.util.*;

public class BatchInsert{
    public static void main(String[] args) {

        try {

          Connection conn9= DBConnection.getConnection();
          
          String query = "INSERT INTO student (name, age, city, email, marks) VALUES(?,?,?,?,?)";
          PreparedStatement pstmt7 = conn9.prepareStatement(query);


            // Row 1
           pstmt7.setString(1, "Amit");
           pstmt7.setInt(2, 20);
          pstmt7.setString(3, "Pune");
            pstmt7.setString(4, "amit@gmail.com");
           pstmt7.setInt(5, 85);
         
           pstmt7.addBatch();

            // Row 2
           pstmt7.setString(1, "Neha");
          pstmt7.setInt(2, 22);
           pstmt7.setString(3, "Mumbai");
             pstmt7.setString(4, "neha@gmail.com");
           pstmt7.setInt(5, 90);
         
           pstmt7.addBatch();

            // Row 3
           pstmt7.setString(1, "Rahul");
           pstmt7.setInt(2, 21);
           pstmt7.setString(3, "Delhi");
         pstmt7.setString(4, "rahul@gmail.com");
           pstmt7.setInt(5, 75);
         
           pstmt7.addBatch();

            int[] count= pstmt7.executeBatch();

            System.out.println("Batch Executed successfully");
            System.out.println(count.length+"rows Inserted"); 

             conn9.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
