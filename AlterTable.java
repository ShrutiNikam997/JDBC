import java.sql.*;


public class AlterTable{

    public static void main(String[] args) {
        try {

            Connection conn6=DBConnection.getConnection();

            Statement stmt= conn6.createStatement();

             String query = "ALTER TABLE student " +
                           "ADD COLUMN city VARCHAR(50), " +
                           "ADD COLUMN marks INT, " +
                           "ADD COLUMN email VARCHAR(100)";

           stmt.executeUpdate(query);
           System.out.println("Table altered sucessfull");

           
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
