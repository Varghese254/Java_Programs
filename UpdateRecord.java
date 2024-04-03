import java.sql.*;

public class UpdateRecord {
    public static void main(String[] args) {
        try {
            // Establish connection to the database
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/db_employees?CharacterEncoding=utf8", "root", "");

            // Prepare the update query with parameters
            String updateQuery = "UPDATE Emp SET esal = ? WHERE ename = ?";
            PreparedStatement pst = con.prepareStatement(updateQuery);

            // Set the parameters for the query
            pst.setFloat(1, 15000); // Set the new salary to 15000
            pst.setString(2, "Rani"); // Update the record where ename is Rani

            // Execute the update query
            int rowsAffected = pst.executeUpdate();

            // Check if any rows were affected
            if (rowsAffected > 0) {
                System.out.println("Record updated successfully.");
            } else {
                System.out.println("No records updated.");
            }

            // Close resources
            pst.close();
            con.close();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
