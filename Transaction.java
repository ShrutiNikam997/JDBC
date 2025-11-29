import java.sql.*;
import java.util.*;



public class Transaction{

    public static void main(String[] args) {

        Connection conn9 = null;
        try {

            conn9=DBConnection.getConnection();
            conn9.setAutoCommit(false);

            Scanner sc = new Scanner(System.in);


           String insertQuery = "INSERT INTO student(name, age, city, email,marks) Values(?,?,?,?,?)";
           PreparedStatement p1 =  conn9.prepareStatement(insertQuery);
           p1.setString(1, "Priya");
           p1.setInt(2, 56);
           p1.setString(3,"Mathura");
           p1.setString(4, "priya@gmail.com");
           p1.setInt(5, 90);
           p1.executeUpdate();


           //Update
             System.out.print("Enter student ID to update: ");
            int id = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter new name: ");
            String name = sc.nextLine();

            System.out.print("Enter new age: ");
            int age = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter new city: ");
            String city = sc.nextLine();

            System.out.print("Enter new marks: ");
            int marks = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter new email: ");
            String email = sc.nextLine();

            String updateQuery =
                    "UPDATE student SET name=?, age=?, city=?, marks=?, email=? WHERE id=?";

            PreparedStatement p2 =conn9.prepareStatement(updateQuery);
            p2.setString(1, name);
            p2.setInt(2, age);
            p2.setString(3, city);
            p2.setInt(4, marks);
            p2.setString(5, email);
            p2.setInt(6, id);

             p2.executeUpdate();



             conn9.commit();
             System.out.println("Transaction Successful! Insert + Update done.");

        }
         catch (Exception e)
          {
            e.printStackTrace();


            try{
                conn9.rollback();
                System.out.println("Transaction roll back due to error");
            }
            catch(Exception ex)
            {
               ex.printStackTrace();
            }
        }


    }

}
