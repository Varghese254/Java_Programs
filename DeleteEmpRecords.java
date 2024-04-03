import java.sql.*;

public class DeleteEmpRecords {
    public static void main(String[] args) {
        try {
            // Establish connection to the database
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/db_employees?CharacterEncoding=utf8", "root", "");

            // Prepare the parameterized delete query
            String sql = "DELETE FROM Emp WHERE esal < ?";
            PreparedStatement pstmt = con.prepareStatement(sql);

            // Set the parameter for the query
            pstmt.setFloat(1, 10000); // Salary less than 10,000

            // Execute the delete query
            int rowsAffected = pstmt.executeUpdate();

            // Display the number of records deleted
            System.out.println(rowsAffected + " record(s) deleted.");

            // Close resources
            pstmt.close();
            con.close();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
